package com.example.longpeng.newsela;

import android.os.Bundle;
import android.widget.TextView;

import com.klinker.android.sliding.SlidingActivity;

/**
 * Created by longpeng on 1/31/16.
 */
public class DetailActivity extends SlidingActivity {

    @Override
    public void init(Bundle savedInstanceState) {
        setTitle("Activity Title");

        setPrimaryColors(
                getResources().getColor(R.color.colorPrimary),
                getResources().getColor(R.color.colorPrimaryDark)
        );

        setContent(R.layout.article_content);

        setTitle("Science");
        setImage(R.drawable.moon);

        TextView tv_title = (TextView) findViewById(R.id.article_title);
        tv_title.setText(TestInput.titles[0]);

        TextView tv = (TextView) findViewById(R.id.article_content);
        tv.setText(TestInput.article[0]);
    }
}
