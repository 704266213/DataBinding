package com.databinding.demo.listener;

import android.view.View;

public interface OnItemClickListener<T> {

    void onItemClick(View targetView,T entity,int position);

}
