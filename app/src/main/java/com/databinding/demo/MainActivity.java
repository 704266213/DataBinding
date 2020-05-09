package com.databinding.demo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.databinding.demo.activity.AdapterDataActivity;
import com.databinding.demo.activity.AutoUpdateUiByDataChangeActivity;
import com.databinding.demo.activity.BaseAdapterActivity;
import com.databinding.demo.activity.CameraXActivity;
import com.databinding.demo.activity.LiveDataActivity;
import com.databinding.demo.activity.RoomActivity;
import com.databinding.demo.activity.UserActivity;
import com.databinding.demo.activity.ViewPager2Activity;
import com.databinding.demo.custom.RadarDrawable;
import com.databinding.demo.model.UserModel;

/**
 * https://blog.csdn.net/willba/article/details/71552525
 *
 * @author Administrator
 */
public class MainActivity extends AppCompatActivity {


    private MainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        UserModel userModel = new UserModel();
        userModel.setUserName("jaty");
        userModel.setPassword("123456");
        binding.setUserInfo(userModel);
        binding.setMainClickListener(this);

        /**
         * getLifecycle() 获取的是 FragmentActivity 的 mFragmentLifecycleRegistry对象
         * 在FragmentActivity的生命周期中调用 mFragmentLifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_CREATE)方法
         * 切换生命周期的状态
         */
        getLifecycle().addObserver(new LifecycleEventObserver() {

            @Override
            public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {

            }
        });


    }

    public void autoUpdateUiByDataChange(UserModel userModel) {
        Log.e("XLog", "========== userName : " + userModel.getUserName());
        Log.e("XLog", "========== password : " + userModel.getPassword());
        Intent intent = new Intent(this, AutoUpdateUiByDataChangeActivity.class);
        startActivity(intent);
    }

    public void dataBindingAdapter(View view) {
        Log.e("XLog", "========== Id : " + view.getId());
        Intent intent = new Intent(this, AdapterDataActivity.class);
        startActivity(intent);
    }

    public void baseAdapterBinding(View view) {
        Log.e("XLog", "========== Id : " + view.getId());
        Intent intent = new Intent(this, BaseAdapterActivity.class);
        startActivity(intent);
    }

    public void baseActivityBinding(View view) {
        Log.e("XLog", "========== Id : " + view.getId());
        Intent intent = new Intent(this, UserActivity.class);
        startActivity(intent);
    }


    public void liveDateDemo(View view) {
        Log.e("XLog", "========== Id : " + view.getId());
        Intent intent = new Intent(this, LiveDataActivity.class);
        startActivity(intent);
    }

    public void roomDemo(View view) {
        Log.e("XLog", "========== Id : " + view.getId());
        Intent intent = new Intent(this, RoomActivity.class);
        startActivity(intent);
    }


    public void viewPager2Demo(View view) {
        Log.e("XLog", "========== Id : " + view.getId());
        Intent intent = new Intent(this, ViewPager2Activity.class);
        startActivity(intent);
    }


    public void goToCameraX(View view) {
        Log.e("XLog", "========== Id : " + view.getId());
        Intent intent = new Intent(this, CameraXActivity.class);
        startActivity(intent);
    }


}
