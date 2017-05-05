package de.r_baeumer.mvvmsample.di.news;


import javax.inject.Singleton;

import dagger.Component;
import de.r_baeumer.mvvmsample.news.NewsActivity;
import de.r_baeumer.mvvmsample.news.NewsController;
import de.r_baeumer.mvvmsample.news.item.NewsItemController;
import de.r_baeumer.mvvmsample.news.item.NewsItemViewModel;

@Singleton
@Component (modules = {MainModule.class, NetworkServicesModule.class})
public interface MainComponent {

    void inject(NewsController newsController);

    void inject(NewsActivity newsActivity);

    void inject(NewsItemController newsItemController);

    void inject(NewsItemViewModel newsItemViewModel);
}
