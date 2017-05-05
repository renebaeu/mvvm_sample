package de.r_baeumer.mvvmsample.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class NewsRelease {
    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("news_id")
    @Expose
    public String newsId;

    @SerializedName("url")
    @Expose
    public String url;

    @SerializedName("publication")
    @Expose
    public String publication;

    @SerializedName("abstract")
    @Expose
    public String abstractText;

    @SerializedName("credits")
    @Expose
    public String credits;

    @SerializedName("thumbnail")
    @Expose
    public String thumbnail;

    @SerializedName("thumbnail_retina")
    @Expose
    public String thumbnailRetina;

    @SerializedName("release_images")
    @Expose
    public List<Integer> releaseImages = null;

    @SerializedName("release_videos")
    @Expose
    public List<Integer> releaseVideos = null;
}
