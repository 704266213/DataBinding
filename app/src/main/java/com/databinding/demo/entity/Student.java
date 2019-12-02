package com.databinding.demo.entity;


import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "student")
public class Student {

    @PrimaryKey(autoGenerate = true)
    private int studentId;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "age")
    private int age;
    @ColumnInfo(name = "sex")
    private int sex;

    public Student() {
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }


//    @NonNull
//    @Override
//    public String toString() {
//        return "学生ID：" + studentId + "\n" +
//                "学生姓名：" + name + "\n" +
//                "学生年龄：" + age ;
//    }

    @NonNull
    @Override
    public String toString() {
        return "学生ID：" + studentId + "\n" +
                "学生姓名：" + name + "\n" +
                "学生年龄：" + age + "\n" +
                "学生性别：" + sex;
    }
}
