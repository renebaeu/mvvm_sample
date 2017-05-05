package de.r_baeumer.mvvmsample.news.item;


import android.content.Context;
import android.databinding.ObservableField;

import javax.inject.Inject;

import de.r_baeumer.mvvmsample.di.DaggerReferenceContainer;
import de.r_baeumer.mvvmsample.entity.News;

public class NewsItemViewModel {
    public ObservableField<String> newsId = new ObservableField<>();
    public ObservableField<String> name = new ObservableField<>();
    public ObservableField<String> url = new ObservableField<>();
    public ObservableField<String> imageUrl = new ObservableField<>();

    @Inject
    Context context;

    public NewsItemViewModel(News news) {
        DaggerReferenceContainer.getComponent().inject(this);
        update(news);
    }

    private void update(News news) {
        newsId.set(news.newsId);
        name.set(news.name);
        url.set(news.url);
    }

    public void updateImage(String thumbnail) {
        imageUrl.set(thumbnail);
    }
}
