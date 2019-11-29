package com.databinding.demo.model;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.library.baseAdapters.BR;


/**
 * 如果是 public 修饰符，则可以直接在成员变量上方加上 @Bindable 注解
 *     //如果是 private 修饰符，则在成员变量的 get 方法上添加 @Bindable 注解
 * @author Administrator
 */
public class UserModel extends BaseObservable {

    private String userName;
    private String password;

    public UserModel() {
    }

    @Bindable
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(BR.userName);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }
}
