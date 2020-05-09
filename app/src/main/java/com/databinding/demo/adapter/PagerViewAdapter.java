package com.databinding.demo.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.databinding.demo.R;
import com.databinding.demo.listener.OnItemClick;
import com.databinding.demo.listener.OnItemClickListener;
import com.databinding.demo.util.ScreenUtil;
import com.databinding.demo.view.CornerImageView;

import java.util.ArrayList;
import java.util.List;

public class PagerViewAdapter extends RecyclerView.Adapter<PagerViewAdapter.PagerViewHolder> {

    private List<Integer> listData;
    private Context context;
    private boolean canLoop;
    public static final int multipleOfItemCount = 100;
    private OnItemClickListener onItemClickListener;

    public PagerViewAdapter(Context context) {
        this.context = context;
        listData = new ArrayList<>();
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
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

        int realPosition = canLoop ? position % listData.size() : position;

        int resId = listData.get(realPosition);
        Log.e("XLog", "=============resId : " + resId);

        holder.bannerItemIcon.setBackgroundResource(resId);

        holder.onItemClick.setPosition(realPosition);
        holder.onItemClick.setEntity(resId);
    }

    @Override
    public int getItemCount() {
        int size = listData.size();
        return canLoop ? size * multipleOfItemCount * 2 : size;
    }


    class PagerViewHolder extends RecyclerView.ViewHolder {

        private CornerImageView bannerItemIcon;
        private OnItemClick onItemClick;

        public PagerViewHolder(@NonNull View itemView) {
            super(itemView);
            bannerItemIcon = itemView.findViewById(R.id.bannerItemIcon);
            bannerItemIcon.setRoundCorner(ScreenUtil.dp2px(8));

            onItemClick = new OnItemClick(onItemClickListener);
            itemView.setOnClickListener(onItemClick);
        }
    }
}




