package com.databinding.demo.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.databinding.demo.dao.StudentDao;
import com.databinding.demo.dao.TeacherDao;
import com.databinding.demo.entity.Student;
import com.databinding.demo.entity.Teacher;

@Database(entities = {Student.class, Teacher.class}, version = 3)
public abstract class AppDatabase extends RoomDatabase {

    public abstract StudentDao getStudentDao();

    public abstract TeacherDao getTeacherDao();

}
