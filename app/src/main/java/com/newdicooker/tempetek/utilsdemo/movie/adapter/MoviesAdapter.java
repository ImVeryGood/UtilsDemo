package com.newdicooker.tempetek.utilsdemo.movie.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.newdicooker.tempetek.utilsdemo.R;
import com.newdicooker.tempetek.utilsdemo.bean.MovieBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by SPC
 * on 2018/9/18
 * 邮箱：13027699936@163.com.
 * version 2.0.4
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesHolder> {
    private List<MovieBean.SubjectsBean> list;
    private LayoutInflater inflater;
    private Context mContext;

    public MoviesAdapter(List<MovieBean.SubjectsBean> list, Context mContext) {
        this.list = list;
        this.mContext = mContext;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public MoviesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.movie_item, null);
        MoviesHolder holder = new MoviesHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MoviesHolder holder, int position) {
        Glide.with(mContext).load(list.get(position)
                .getImages().getLarge())
                .placeholder(R.mipmap.guide1)
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    class MoviesHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.image)
        ImageView image;

        public MoviesHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
