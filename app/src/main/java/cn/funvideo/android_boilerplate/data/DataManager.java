package cn.funvideo.android_boilerplate.data;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.List;

import cn.funvideo.android_boilerplate.data.local.DatabaseHelper;
import cn.funvideo.android_boilerplate.data.model.HttpResult;
import cn.funvideo.android_boilerplate.data.model.Ribot;
import cn.funvideo.android_boilerplate.data.model.Subject;
import cn.funvideo.android_boilerplate.data.remote.RemoteService;
import rx.Observable;
import rx.functions.Func1;

@EBean
public class DataManager {

    @Bean
    DatabaseHelper databaseHelper;

    @Bean
    RemoteService service;

    public Observable<Ribot> syncRibots() {
        return service.newRibotsService().getRibots()
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

    public Observable<HttpResult<List<Subject>>> getTopMovies() {
        return service.newDoubanService().getTopMovies(0, 10);
    }
}