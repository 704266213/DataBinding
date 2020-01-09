package com.databinding.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

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
