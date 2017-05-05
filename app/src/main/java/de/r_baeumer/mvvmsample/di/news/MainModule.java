package de.r_baeumer.mvvmsample.di.news;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import de.r_baeumer.mvvmsample.news.NewsController;
import de.r_baeumer.mvvmsample.news.NewsViewModel;

@Module
public class MainModule {

    private Context context;

    public MainModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    NewsViewModel provideNewsViewModel(Context context) {
        return new NewsViewModel(context);
    }

    @Provides
    @Singleton
    NewsController provideNewsController(Context context) {
        return new NewsController(context);
    }
}
