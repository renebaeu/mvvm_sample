package de.r_baeumer.mvvmsample.entity;

import com.google.gson.annotations.SerializedName;

public class News {
    @SerializedName("news_id")
    public String newsId;
    public String name;
    public String url;
}
