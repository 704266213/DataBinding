package com.databinding.demo.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.databinding.demo.R;
import com.databinding.demo.util.ScreenUtil;
import com.databinding.demo.view.CornerImageView;

import java.util.ArrayList;
import java.util.List;

public class PagerViewAdapter extends RecyclerView.Adapter<PagerViewAdapter.PagerViewHolder> {

    private List<Integer> listData;
    private Context context;
    private boolean canLoop;
    public static final int multipleOfItemCount = 100;

    public PagerViewAdapter(Context context) {
        this.context = context;
        listData = new ArrayList<>();
    }

    public void setCanLoop(Boolean canLoop) {
        this.canLoop = canLoop;
    }

    public void addDataToList(List<Integer> listData) {
        this.listData.addAll(listData);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PagerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.banner_item, parent, false);
        return new PagerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PagerViewHolder holder, int position) {

        int resId;
        if (canLoop) {
            int realPosition = position % listData.size();
            resId = listData.get(realPosition);
        } else {
            resId = listData.get(position);
        }

        Log.e("XLog", "=============resId : " + resId);
        holder.bannerItemIcon.setBackgroundResource(resId);
    }

    @Override
    public int getItemCount() {
        int size = listData.size();
        if (canLoop) {
            return size * multipleOfItemCount * 2;
        } else {
            return size;
        }
    }


    class PagerViewHolder extends RecyclerView.ViewHolder {

        private CornerImageView bannerItemIcon;

        public PagerViewHolder(@NonNull View itemView) {
            super(itemView);
            bannerItemIcon = itemView.findViewById(R.id.bannerItemIcon);
            bannerItemIcon.setRoundCorner(ScreenUtil.dp2px(8));
        }
    }
}




