package com.databinding.demo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.databinding.demo.R;
import com.databinding.demo.databinding.ActivityUpdateUiByDataBinding;
import com.databinding.demo.model.UserModel;

/**
 * 实现数据变化自动驱动 UI 刷新的方式有三种：BaseObservable、ObservableField、ObservableCollection
 * 原理：https://www.jianshu.com/p/8e393b97f344
 *
 * @author Administrator
 */
public class AutoUpdateUiByDataChangeActivity extends AppCompatActivity implements View.OnClickListener {


//    private EditText inputUserName;
//    private EditText inputPassword;
//    private TextView sure;
//    private TextView showUserName;
//    private TextView showPassword;


    private ActivityUpdateUiByDataBinding binding;
    private UserModel userModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Android studio会根据layout文件自动生成一个默认的Binding类，类名是根据layout文件名生成的，并有"Binding"后缀结束。
        binding = DataBindingUtil.setContentView(this, R.layout.activity_update_ui_by_data);

        userModel = new UserModel();
        userModel.setUserName("jaty");
        userModel.setPassword("123456");
        binding.setUserInfo(userModel);


//        inputUserName = findViewById(R.id.inputUserName);
//        inputPassword = findViewById(R.id.inputPassword);
//        showUserName = findViewById(R.id.showUserName);
//        showPassword = findViewById(R.id.showPassword);
//        sure = findViewById(R.id.sure);
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
