package com.databinding.demo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Build;
import android.os.Bundle;

import com.databinding.demo.R;
import com.databinding.demo.adapter.PagerViewAdapter;
import com.databinding.demo.layoutmanager.ScrollDurationManger;
import com.databinding.demo.transform.OverlapPageTransformer;
import com.databinding.demo.transform.ScaleInTransformer;

import java.util.ArrayList;
import java.util.List;


public class ViewPager2Activity extends AppCompatActivity {


    private PagerViewAdapter pagerViewAdapter;
    private ViewPager2 viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager2);

        initView();
        initData();
    }

    private void initView() {
        PagerSnapHelper snapHelper = new PagerSnapHelper();

        viewPager = findViewById(R.id.viewPager);

        //禁止滚动,true为可以滑动 false为禁止
        viewPager.setUserInputEnabled(true);
        //设置垂直滚动ORIENTATION_VERTICAL，横向的为
        viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);

        //设置滑动的时长
        ScrollDurationManger.reflectLayoutManager(viewPager, 200);

        int padding = (int) getResources().getDimension(R.dimen.dimen_30);

        //获取viewPager的RecycleView对象
        RecyclerView recyclerView = (RecyclerView) viewPager.getChildAt(0);
        //设置RecycleView对象的padding
        recyclerView.setPadding(padding, 0, padding, 0);
        recyclerView.setClipToPadding(false);

        //设置Viewpager的Item间的间距
        CompositePageTransformer mCompositePageTransformer = new CompositePageTransformer();
        int margin = (int) getResources().getDimension(R.dimen.dimen_10);
        MarginPageTransformer mMarginPageTransformer = new MarginPageTransformer(margin);
        mCompositePageTransformer.addTransformer(mMarginPageTransformer);

        ViewPager2.PageTransformer overlapPageTransformer;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            overlapPageTransformer = new OverlapPageTransformer(ViewPager2.ORIENTATION_HORIZONTAL, 0.85f, 0f, 1, 0);
        } else {
            overlapPageTransformer = new ScaleInTransformer(0.85f);
        }
        mCompositePageTransformer.addTransformer(overlapPageTransformer);

        //设置一个缩放动画
        viewPager.setPageTransformer(mCompositePageTransformer);

        pagerViewAdapter = new PagerViewAdapter(this);
        viewPager.setAdapter(pagerViewAdapter);
    }


    private void initData() {
        List<Integer> listData = new ArrayList<>();
        listData.add(R.drawable.advertise0);
        listData.add(R.drawable.advertise1);
        listData.add(R.drawable.advertise2);
        listData.add(R.drawable.advertise3);
        pagerViewAdapter.addDataToList(listData);

        pagerViewAdapter.setCanLoop(true);
        //切换到指定页，是否展示过渡中间页
        viewPager.setCurrentItem(listData.size() * PagerViewAdapter.multipleOfItemCount);
    }

}
