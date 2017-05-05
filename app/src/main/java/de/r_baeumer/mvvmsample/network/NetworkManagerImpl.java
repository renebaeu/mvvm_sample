package de.r_baeumer.mvvmsample.network;

import de.r_baeumer.mvvmsample.api.HubbleSiteService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class NetworkManagerImpl implements NetworkManager {

    private static NetworkManagerImpl instance;
    private final Retrofit hubbleSiteService;
    private static final String BASE_URL = "http://hubblesite.org/api/v3/";

    public NetworkManagerImpl() {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.addInterceptor(httpLoggingInterceptor);

        hubbleSiteService = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(builder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }



    @Override
    public HubbleSiteService getHubbleSiteService() {
        return hubbleSiteService.create(HubbleSiteService.class);
    }

}
