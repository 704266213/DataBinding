package com.databinding.demo.listener;

import android.view.View;

public class OnItemClick<T> implements View.OnClickListener {

    private int position;
    private T entity;

    private OnItemClickListener<T> onItemClickListener;

    public OnItemClick(OnItemClickListener<T> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setEntity(T entity) {
        this.entity = entity;
    }


    @Override
    public void onClick(View view) {
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(view, entity, position);
        }
    }
}
