package de.r_baeumer.mvvmsample.binding;

import android.content.Context;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class ImageBindings {

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Context context = imageView.getContext();
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .into(imageView);
    }
}
