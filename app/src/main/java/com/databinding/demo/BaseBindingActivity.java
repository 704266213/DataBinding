package com.databinding.demo;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import android.os.Bundle;

public abstract class BaseBindingActivity<B extends ViewDataBinding> extends AppCompatActivity {

    protected B binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, getLayoutId());

        initView();
    }

    /**
     * 获取布局LayoutId
     *
     * @return
     */
    public abstract @LayoutRes int getLayoutId();

    /**
     * 初始化布局
     */
    public abstract void initView();


    protected <T> void updateUiByData(int id, T entity) {
        binding.setVariable(id, entity);
    }


}
