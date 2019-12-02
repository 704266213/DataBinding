package com.databinding.demo.adapter;

import com.databinding.demo.R;
import com.databinding.demo.entity.Student;

import static com.databinding.demo.BR.student;

public class RoomBindAdapter extends BaseBindAdapter<Student> {
    @Override
    public int getLayoutId() {
        return R.layout.room_item;
    }

    @Override
    public int getBindId() {
        return student;
    }
}
