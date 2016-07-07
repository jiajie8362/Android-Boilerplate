package cn.funvideo.android_boilerplate.data;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EService;

import cn.funvideo.android_boilerplate.data.model.Ribot;
import rx.Observer;
import rx.Subscription;
import rx.schedulers.Schedulers;

@EService
public class SyncService extends Service {

    @Bean
    DataManager dataManager;

    private Subscription subscription;

    public static Intent getStartIntent(Context context) {
        return new Intent(context, SyncService_.class);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, final int startId) {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
        subscription = dataManager.syncRibots()
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Ribot>() {
                    @Override
                    public void onCompleted() {
                        stopSelf(startId);
                    }

                    @Override
                    public void onError(Throwable e) {
                        stopSelf(startId);
                    }

                    @Override
                    public void onNext(Ribot ribot) {

                    }
                });
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        if (subscription != null) subscription.unsubscribe();
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public static class SyncOnConnectionAvailable extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            context.startService(getStartIntent(context));
        }
    }
}
