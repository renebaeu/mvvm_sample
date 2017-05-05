package de.r_baeumer.mvvmsample.news;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import de.r_baeumer.mvvmsample.R;
import de.r_baeumer.mvvmsample.databinding.NewsItemBinding;
import de.r_baeumer.mvvmsample.news.item.NewsItemController;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsItemViewHolder> {

    private List<NewsItemController> items = new ArrayList<>();

    @Override
    public NewsItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_item, parent, false);
        return new NewsItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewsItemViewHolder holder, int position) {
        NewsItemBinding binding = holder.getBinding();
        binding.setController(items.get(position));
        binding.setViewModel(items.get(position).getViewModel());
        binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<NewsItemController> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    //--------------- View Holder --------------------------------
    class NewsItemViewHolder extends RecyclerView.ViewHolder{
        private final NewsItemBinding binding;

        public NewsItemViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }

        public NewsItemBinding getBinding() {
            return binding;
        }
    }

}
