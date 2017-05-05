package de.r_baeumer.mvvmsample.dao;


import java.util.List;

import de.r_baeumer.mvvmsample.api.HubbleSiteService;
import de.r_baeumer.mvvmsample.entity.News;
import de.r_baeumer.mvvmsample.network.NetworkManager;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;


public class NewsDao {

    private HubbleSiteService news;

    public NewsDao(NetworkManager networkManager) {
        news = networkManager.getHubbleSiteService();
    }



    public Single<List<News>> news() {
        return news.news()
                .subscribeOn(Schedulers.io());
    }
}
