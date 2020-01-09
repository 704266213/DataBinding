package com.databinding.demo.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.databinding.demo.R;

import dalvik.system.DexClassLoader;
import dalvik.system.PathClassLoader;

public class ViewPager2Activity extends AppCompatActivity {

    private ViewPager2 viewPager2Demo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager2);

//        PathClassLoader pathClassLoader = new PathClassLoader("",getClassLoader());
//        pathClassLoader.loadClass("");

        Handler handler = new Handler();

        PagerSnapHelper snapHelper = new PagerSnapHelper();

        viewPager2Demo = findViewById(R.id.viewPager2Demo);
//        viewPager2Demo.setOrientation(ViewPager2.ORIENTATION_VERTICAL);
        viewPager2Demo.setAdapter(new RecyclerView.Adapter<ViewHolder>() {
            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewpager_item_view, parent, false);
                return new ViewHolder(view) {
                };
            }

            @Override
            public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
                TextView textView = (TextView) holder.itemView;
                if (position == 0) {
                    textView.setBackgroundColor(ContextCompat.getColor(ViewPager2Activity.this, android.R.color.holo_purple));
                } else if (position == 1) {
                    textView.setBackgroundColor(ContextCompat.getColor(ViewPager2Activity.this, android.R.color.holo_blue_dark));
                } else if (position == 2) {
                    textView.setBackgroundColor(ContextCompat.getColor(ViewPager2Activity.this, android.R.color.holo_green_light));
                }
                textView.setText("position:" + position);
            }

            @Override
            public int getItemCount() {
                return 4;
            }
        });
    }
}
