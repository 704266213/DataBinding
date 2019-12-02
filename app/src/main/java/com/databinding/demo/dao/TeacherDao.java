package com.databinding.demo.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;


import com.databinding.demo.entity.Teacher;

import java.util.List;

@Dao
public interface TeacherDao {

    @Query("SELECT * FROM teacher")
    LiveData<List<Teacher>> loadAll();

}

