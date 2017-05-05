package de.r_baeumer.mvvmsample.news;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;

import java.util.List;

import de.r_baeumer.mvvmsample.news.item.NewsItemController;

public class NewsViewModel {
    private NewsAdapter adapter = new NewsAdapter();
    Context context;

    public NewsViewModel(Context context) {
        this.context = context;
    }

    public void update(List<NewsItemController> newsList) {
        adapter.setItems(newsList);
    }

    //binding
    public NewsAdapter getAdapter() {
        return adapter;
    }

    public LinearLayoutManager getLinearLayoutManager() {
        return new LinearLayoutManager(context);
    }

    public void notifyDataSetChangened() {
        adapter.notifyDataSetChanged();
    }
}
