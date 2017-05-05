package de.r_baeumer.mvvmsample.binding;


import android.databinding.BindingAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class RecyclerViewBinding {

    @BindingAdapter({"adapter"})
    public static void setTypeface(RecyclerView view, RecyclerView.Adapter adapter) {
        if (view == null) {
            return;
        }
        view.setAdapter(adapter);
    }

    @BindingAdapter({"layoutManager"})
    public static void setLayoutManager(RecyclerView view, LinearLayoutManager manager) {
        if (view == null) {
            return;
        }
        view.setLayoutManager(manager);
    }

}
