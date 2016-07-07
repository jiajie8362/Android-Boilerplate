package cn.funvideo.android_boilerplate.data.remote;

import java.util.List;

import cn.funvideo.android_boilerplate.data.model.Ribot;
import retrofit2.http.GET;
import rx.Observable;

public interface RibotsService {
    String ENDPOINT = "https://api.ribot.io/";

    @GET("ribots")
    Observable<List<Ribot>> getRibots();
}
