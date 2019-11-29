package com.databinding.demo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;


import com.databinding.demo.listener.OnItemClick;
import com.databinding.demo.listener.OnItemClickListener;

import java.util.ArrayList;
import java.util.List;


public abstract class BaseBindAdapter<T> extends RecyclerView.Adapter<BaseBindAdapter.BaseBindHolder> {

    private List<T> listData;
    private OnItemClickListener<T> onItemClickListener;

    private @IdRes
    int[] bindIds;

    public BaseBindAdapter() {
        listData = new ArrayList<>();
    }

    public void setBindIds(int... bindIds) {
        this.bindIds = bindIds;
    }

    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void addDataToList(List<T> listData) {
        this.listData.addAll(listData);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    @NonNull
    @Override
    public BaseBindAdapter.BaseBindHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), getLayoutId(), parent, false);
        BaseBindAdapter.BaseBindHolder holder = new BaseBindAdapter.BaseBindHolder(binding.getRoot());
        holder.setBinding(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BaseBindAdapter.BaseBindHolder holder, int position) {
        T entity = listData.get(position);
        holder.getBinding().setVariable(getBindId(), entity);
        holder.getBinding().executePendingBindings();

        if (onItemClickListener != null) {
            holder.onItemClick.setPosition(position);
            holder.onItemClick.setEntity(entity);
        }

    }

    /**
     * 绑定的布局
     *
     * @return
     */
    public abstract int getLayoutId();

    /**
     * 绑定的变量ID
     *
     * @return
     */
    public abstract int getBindId();


    public class BaseBindHolder extends RecyclerView.ViewHolder {

        private ViewDataBinding binding;
        private OnItemClick<T> onItemClick;

        public BaseBindHolder(@NonNull View itemView) {
            super(itemView);
            if (onItemClickListener != null) {
                onItemClick = new OnItemClick<>(onItemClickListener);
                if (bindIds != null && bindIds.length > 0) {
                    int length = bindIds.length;
                    for (int i = 0; i < length; i++) {
                        View view = itemView.findViewById(bindIds[i]);
                        view.setOnClickListener(onItemClick);
                    }
                } else {
                    itemView.setOnClickListener(onItemClick);
                }
            }
        }

        public void setBinding(ViewDataBinding binding) {
            this.binding = binding;
        }

        public ViewDataBinding getBinding() {
            return this.binding;
        }
    }
}
