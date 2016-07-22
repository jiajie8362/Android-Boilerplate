package cn.funvideo.android_boilerplate.ui.main;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.List;

import cn.funvideo.android_boilerplate.data.DataManager;
import cn.funvideo.android_boilerplate.data.model.HttpResult;
import cn.funvideo.android_boilerplate.data.model.Ribot;
import cn.funvideo.android_boilerplate.data.model.Subject;
import cn.funvideo.android_boilerplate.ui.base.BasePresenter;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

@EBean
public class MainPresenter extends BasePresenter<MainMvpView> {
    @Bean
    DataManager dataManager;
    private Subscription ribotSubscription;
    private Subscription doubanSubscription;

    @Override
    public void attachView(MainMvpView mvpView) {
        super.attachView(mvpView);
    }

    @Override
    public void detachView() {
        super.detachView();
        if (ribotSubscription != null) {
            ribotSubscription.unsubscribe();
        }

        if (doubanSubscription != null) {
            doubanSubscription.unsubscribe();
        }
    }

    public void loadRibots() {
        checkViewAttached();
        ribotSubscription = dataManager.getRibots()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<List<Ribot>>() {
                    @Override
                    public void onCompleted() {
                    }

                    @Override
                    public void onError(Throwable e) {
                        getMvpView().showError();
                    }

                    @Override
                    public void onNext(List<Ribot> ribots) {
                        if (ribots.isEmpty()) {
                            getMvpView().showRibotsEmpty();
                        } else {
                            getMvpView().showRibots(ribots);
                        }
                    }
                });
    }

    public void loadMovides() {
        checkViewAttached();
        doubanSubscription = dataManager.getTopMovies()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Subscriber<HttpResult<List<Subject>>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(HttpResult<List<Subject>> listHttpResult) {
                        getMvpView().showSubjects(listHttpResult.getSubjects());
                    }
                });
    }
}
