package de.r_baeumer.mvvmsample.news;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import de.r_baeumer.mvvmsample.R;
import de.r_baeumer.mvvmsample.databinding.NewsActivityBinding;
import de.r_baeumer.mvvmsample.di.DaggerReferenceContainer;
import de.r_baeumer.mvvmsample.di.news.DaggerMainComponent;
import de.r_baeumer.mvvmsample.di.news.MainModule;

public class NewsActivity extends AppCompatActivity {

    private NewsActivityBinding binding;

    @Inject
    NewsController controller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDi();

        binding = DataBindingUtil.setContentView(this, R.layout.news_activity);
        binding.setViewModel(controller.getViewModel());
        binding.setController(controller);
    }

    @Override
    protected void onResume() {
        super.onResume();
        controller.updateNews();
    }


    private void initDi() {
        DaggerReferenceContainer.setComponent(
                DaggerMainComponent.builder()
                        .mainModule(new MainModule(getApplicationContext()))
                        .build());
        DaggerReferenceContainer.getComponent().inject(this);
    }

    @Override
    protected void onDestroy() {
        DaggerReferenceContainer.setComponent(null);
        super.onDestroy();
    }


}
