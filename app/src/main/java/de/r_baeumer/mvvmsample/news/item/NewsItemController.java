package de.r_baeumer.mvvmsample.news.item;


import android.util.Log;
import android.view.View;

import javax.inject.Inject;

import de.r_baeumer.mvvmsample.dao.NewsReleaseDao;
import de.r_baeumer.mvvmsample.di.DaggerReferenceContainer;
import de.r_baeumer.mvvmsample.entity.NewsRelease;
import de.r_baeumer.mvvmsample.news.NewsController;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableSingleObserver;


public class NewsItemController {
    private static final String TAG = NewsItemController.class.getSimpleName();
    private NewsController mainController;
    private NewsItemViewModel newsItemViewModel;
    private UrlClickListener urlClickListener;

    @Inject
    NewsReleaseDao newsReleaseDao;

    public NewsItemController(NewsController mainController, NewsItemViewModel newsItemViewModel) {
        DaggerReferenceContainer.getComponent().inject(this);
        this.mainController = mainController;
        this.newsItemViewModel = newsItemViewModel;
        update();
    }

    private void update() {
        newsReleaseDao.newsRelease(newsItemViewModel.newsId.get())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableSingleObserver<NewsRelease>() {
                    @Override
                    public void onSuccess(@NonNull NewsRelease newsRelease) {
                        getViewModel().updateImage(newsRelease.thumbnail);
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Log.e(TAG, "onError: ", e);
                    }
                });
    }

    public NewsItemViewModel getViewModel() {
        return newsItemViewModel;
    }

    public View.OnClickListener onClickUrl() {
        return v -> {
            String url = newsItemViewModel.url.get();
            urlClickListener.onUrlClicked(url);
        };
    }

    public void setUrlClickListener(UrlClickListener urlClickListener) {
        this.urlClickListener = urlClickListener;
    }

    public static class Builder {
        NewsItemController controller;

        public Builder(NewsController mainController, NewsItemViewModel newsItemViewModel) {
            controller = new NewsItemController(mainController, newsItemViewModel);
        }

        public Builder setUrlClickListener(UrlClickListener urlClickListener) {
            controller.setUrlClickListener(urlClickListener);
            return this;
        }

        public NewsItemController build() {
            return controller;
        }
    }
}
