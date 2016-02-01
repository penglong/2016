package com.example.longpeng.newsela;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by longpeng on 1/31/16.
 */
public class TestRecyclerViewAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    List<Object> contents;
    Context mContext;

    static final int TYPE_HEADER = 0;
    static final int TYPE_CELL = 1;

    private int page;

    public TestRecyclerViewAdapter(List<Object> contents, Context context) {
        this.contents = contents;
        this.mContext = context;
    }

    @Override
    public int getItemViewType(int position) {
        /*
        switch (position) {
            case 0:
                return TYPE_HEADER;
            default:
                return TYPE_CELL;
        }
        */
        return TYPE_HEADER;
    }

    @Override
    public int getItemCount() {
        return contents.size();
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        switch (viewType) {
            case TYPE_HEADER: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item_card_big, parent, false);
                return new CustomViewHolder(view) {
                };
            }
            /*
            case TYPE_CELL: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.list_item_card_small, parent, false);
                return new CustomViewHolder(view) {
                };
            }
            */
        }
        return null;
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_HEADER:
                Context context = holder.imageView.getContext();
                Uri url = Uri.parse(TestInput.urls[(position + page*2)%8]);
                Picasso.with(context).load(url).into(holder.imageView);
                holder.tv_title.setText(TestInput.titles[3]);
                holder.tv_more.setText(TestInput.date + "  " + TestInput.subject[0]);
                //holder.tv_more.setText(TestInput.author);
                holder.imageView.setTag(position);
                holder.imageView.setOnClickListener(new MyOnClickListener());

                break;
            case TYPE_CELL:
                break;
        }

    }

    class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            int pos = (int)v.getTag();
            //Log.e("Adapter", "Clicked and Position is "+pos);
            if(mContext instanceof MainActivity) {
                ((MainActivity)mContext).clickPhoto();
            }

        }
    }

    public void setPage(int page) {
        this.page = page;
    }
}