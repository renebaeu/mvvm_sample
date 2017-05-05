package de.r_baeumer.mvvmsample.dao;

import de.r_baeumer.mvvmsample.api.HubbleSiteService;
import de.r_baeumer.mvvmsample.entity.NewsRelease;
import de.r_baeumer.mvvmsample.network.NetworkManager;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by renebaumer on 02.05.17.
 */

public class NewsReleaseDao {

    private HubbleSiteService hubbleSiteService;

    public NewsReleaseDao(NetworkManager networkManager) {
        hubbleSiteService = networkManager.getHubbleSiteService();
    }

    public Single<NewsRelease> newsRelease(String releaseNo) {
        return hubbleSiteService.newsRelease(releaseNo)
                .subscribeOn(Schedulers.io());
    };
}
