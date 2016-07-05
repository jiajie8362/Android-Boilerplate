package cn.funvideo.android_boilerplate.data;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.List;

import cn.funvideo.android_boilerplate.data.local.DatabaseHelper;
import cn.funvideo.android_boilerplate.data.model.Ribot;
import cn.funvideo.android_boilerplate.data.remote.RibotsService;
import rx.Observable;
import rx.functions.Func1;

import static org.androidannotations.annotations.EBean.Scope.Singleton;

@EBean(scope = Singleton)
public class DataManager {

    @Bean
    DatabaseHelper databaseHelper;


    public Observable<Ribot> syncRibots() {
        return RibotsService.Creator.newRibotsService().getRibots()
                .concatMap(new Func1<List<Ribot>, Observable<Ribot>>() {
                    @Override
                    public Observable<Ribot> call(List<Ribot> ribots) {
                        return databaseHelper.setRibots(ribots);
                    }
                });
    }

    public Observable<List<Ribot>> getRibots() {
        return databaseHelper.getRibots().distinct();
    }

}