package de.r_baeumer.mvvmsample.news;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import de.r_baeumer.mvvmsample.dao.NewsDao;
import de.r_baeumer.mvvmsample.di.DaggerReferenceContainer;
import de.r_baeumer.mvvmsample.entity.News;
import de.r_baeumer.mvvmsample.news.item.NewsItemController;
import de.r_baeumer.mvvmsample.news.item.NewsItemViewModel;
import de.r_baeumer.mvvmsample.news.item.UrlClickListener;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

import static android.content.ContentValues.TAG;

public class NewsController implements UrlClickListener, ControllerLiveCycleMethods {

    private Context context;
    private Disposable newsDaoDisposable;

    @Inject
    NewsDao newsDao;

    @Inject
    NewsViewModel viewModel;

    public NewsController(Context context) {
        this.context = context;
        DaggerReferenceContainer.getComponent().inject(this);
    }

    public void updateNews() {
        if (newsDaoDisposable != null) newsDaoDisposable.dispose();
        newsDaoDisposable = newsDao.news()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::updateAdapterItems,
                        this::logError);
    }

    private int logError(Throwable error) {
        return Log.e(TAG, "updateNews: ", error);
    }

    private void updateAdapterItems(List<News> newsList) {
        newsList.remove(0);
        List<NewsItemController> controllers = new ArrayList<>();
        for (News news : newsList) {
            NewsItemController controller = new NewsItemController.Builder(NewsController.this, new NewsItemViewModel(news))
                    .setUrlClickListener(NewsController.this)
                    .build();
            controllers.add(controller);
        }
        viewModel.update(controllers);
        viewModel.notifyDataSetChangened();
    }


    public NewsViewModel getViewModel() {
        return viewModel;
    }

    @Override
    public void onUrlClicked(String url) {
        Uri uri = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uri);
        context.startActivity(launchBrowser);
    }


    @Override
    public void init() {
        //nothing to init
    }

    @Override
    public void deInit() {
        newsDaoDisposable.dispose();
    }
}
