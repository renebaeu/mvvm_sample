package de.r_baeumer.mvvmsample.di.news;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.r_baeumer.mvvmsample.dao.NewsDao;
import de.r_baeumer.mvvmsample.dao.NewsReleaseDao;
import de.r_baeumer.mvvmsample.network.NetworkManager;
import de.r_baeumer.mvvmsample.network.NetworkManagerImpl;

@Module
class NetworkServicesModule {

    @Provides
    @Singleton
    NetworkManager networkManager() {return new NetworkManagerImpl();}

    @Provides
    @Singleton
    NewsDao provideNewsDao(NetworkManager networkManager) {
        return new NewsDao(networkManager);
    }

    @Provides
    @Singleton
    NewsReleaseDao provideNewsReleaseDao(NetworkManager networkManager) {
        return new NewsReleaseDao(networkManager);
    }

}
