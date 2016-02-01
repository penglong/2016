package com.example.longpeng.newsela;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;

/**
 * Created by longpeng on 1/31/16.
 */
public class MainActivity extends AppCompatActivity {

    private MaterialViewPager mViewPager;

    private DrawerLayout mDrawer;
    private ActionBarDrawerToggle mDrawerToggle;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("");

        mViewPager = (MaterialViewPager) findViewById(R.id.materialViewPager);

        toolbar = mViewPager.getToolbar();
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        if (toolbar != null) {
            setSupportActionBar(toolbar);

            final ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
                actionBar.setDisplayShowHomeEnabled(true);
                actionBar.setDisplayShowTitleEnabled(true);
                actionBar.setDisplayUseLogoEnabled(false);
                actionBar.setHomeButtonEnabled(true);
            }
        }

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawer, 0, 0);
        mDrawer.setDrawerListener(mDrawerToggle);

        mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                switch (position % 4) {
                    //case 0:
                    //    return RecyclerViewFragment.newInstance();
                    //case 1:
                    //    return RecyclerViewFragment.newInstance();
                    //case 2:
                    //    return WebViewFragment.newInstance();
                    default:
                        RecyclerViewFragment fragment = RecyclerViewFragment.newInstance();
                        Bundle args = new Bundle();
                        args.putInt("page", position % 4);
                        fragment.setArguments(args);
                        return fragment;
                }
            }

            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position % 4) {
                    case 0:
                        return "Highlights";
                    case 1:
                        return "Money";
                    case 2:
                        return "Health";
                    case 3:
                        return "Sports";
                }
                return "";
            }
        });

        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.green,
                                "https://newsela-test-files-f331e.s3.amazonaws.com/article_media/2016/01/new-planet-3347721e.jpg.460x259_q90_box-2%2C0%2C1366%2C769_crop_detail.jpg");
                    case 1:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.blue,
                                "https://newsela-test-files-f331e.s3.amazonaws.com/article_media/2015/11/paris-attacks-c7fb272e.jpg.460x258_q90_box-423%2C855%2C5020%2C3440_crop_detail.jpg");
                    case 2:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.cyan,
                                "https://newsela-test-files-f331e.s3.amazonaws.com/article_media/2015/11/mars-farm-e3d2cec3.jpg.460x258_q90_box-0%2C125%2C3000%2C1812_crop_detail.jpg");
                    case 3:
                        return HeaderDesign.fromColorResAndUrl(
                                R.color.red,
                                "https://newsela-test-files-f331e.s3.amazonaws.com/article_media/2016/01/lebron-activism-b5dbfe47.jpg.460x259_q90_box-0%2C0%2C4568%2C2573_crop_detail.jpg");
                }

                //execute others actions if needed (ex : modify your header logo)

                return null;
            }
        });

        mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());

        View logo = findViewById(R.id.logo_white);
        if (logo != null)
            logo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mViewPager.notifyHeaderChanged();
                    Toast.makeText(getApplicationContext(), "Yes, the title is clickable", Toast.LENGTH_SHORT).show();
                }
            });
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mDrawerToggle.onOptionsItemSelected(item) ||
                super.onOptionsItemSelected(item);
    }

    public void clickPhoto() {
        //Intent intent = new Intent(this, DetailActivity.class);
        Intent intent = new Intent(this, ScreenSlidePagerActivity.class);
        startActivity(intent);

    }
}
