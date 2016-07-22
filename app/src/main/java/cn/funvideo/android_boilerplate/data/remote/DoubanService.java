package cn.funvideo.android_boilerplate.data.remote;

import java.util.List;

import cn.funvideo.android_boilerplate.data.model.HttpResult;
import cn.funvideo.android_boilerplate.data.model.Subject;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface DoubanService {
    // movie/top250?start=0&count=250

    String ENDPOINT = "https://api.douban.com/v2/";

    @GET("movie/top250")
    Observable<HttpResult<List<Subject>>> getTopMovies(@Query("start") int start,
                                                       @Query("count") int count);
}
