package com.databinding.demo.activity;

import android.view.View;

import com.databinding.demo.R;
import com.databinding.demo.activity.BaseBindingActivity;
import com.databinding.demo.databinding.ActivityUserBindingImpl;
import com.databinding.demo.model.UserModel;

import static com.databinding.demo.BR.userInfo;

public class UserActivity extends BaseBindingActivity<ActivityUserBindingImpl> implements View.OnClickListener {

    private UserModel userModel;

    @Override
    public int getLayoutId() {
        return R.layout.activity_user;
    }

    @Override
    public void initView() {
        userModel = new UserModel();
        userModel.setUserName("jaty");
        userModel.setPassword("123456");

        updateUiByData(userInfo, userModel);
        binding.sure.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.sure:
                String inputUserNameStr = binding.inputUserName.getText().toString();
                String inputPasswordStr = binding.inputPassword.getText().toString();

                userModel.setUserName(inputUserNameStr);
                userModel.setPassword(inputPasswordStr);
                break;
        }
    }
}
