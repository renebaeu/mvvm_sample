package de.r_baeumer.mvvmsample.api;

import java.util.List;

import de.r_baeumer.mvvmsample.entity.News;
import de.r_baeumer.mvvmsample.entity.NewsRelease;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HubbleSiteService {

    @GET("news")
    Single<List<News>> news();

    @GET ("news_release/{release}")
    Single<NewsRelease> newsRelease(@Path("release") String release);
}
