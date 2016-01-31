package com.example.longpeng.newsela;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by longpeng on 1/31/16.
 */
public class CustomViewHolder extends RecyclerView.ViewHolder {
    protected ImageView imageView;
    protected TextView tv_title;
    protected TextView tv_more;

    public CustomViewHolder(View view) {
        super(view);
        this.imageView = (ImageView) view.findViewById(R.id.card_image);
        this.tv_title = (TextView) view.findViewById(R.id.card_title);
        this.tv_more = (TextView) view.findViewById(R.id.card_more);
    }
}

