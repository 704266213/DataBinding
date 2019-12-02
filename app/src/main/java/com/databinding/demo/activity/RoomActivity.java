package com.databinding.demo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.databinding.demo.R;
import com.databinding.demo.adapter.BindAdapter;
import com.databinding.demo.adapter.BookBindAdapter;
import com.databinding.demo.adapter.RoomBindAdapter;
import com.databinding.demo.dao.StudentDao;
import com.databinding.demo.dao.TeacherDao;
import com.databinding.demo.database.AppDatabase;
import com.databinding.demo.database.DatabaseInstance;
import com.databinding.demo.entity.Student;
import com.databinding.demo.entity.Teacher;
import com.databinding.demo.listener.OnItemClickListener;

import java.util.List;
import java.util.Random;

public class RoomActivity extends AppCompatActivity implements OnItemClickListener<Student>, View.OnClickListener {

    private TextView insert;
    private TextView search;
    private RecyclerView recyclerView;
    private RoomBindAdapter roomBindAdapter;
    private AppDatabase appDatabase;
    private StudentDao studentDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        initView();
    }

    private void initView() {
        insert = findViewById(R.id.insert);
        insert.setOnClickListener(this);
        search = findViewById(R.id.search);
        search.setOnClickListener(this);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        roomBindAdapter = new RoomBindAdapter();
        recyclerView.setAdapter(roomBindAdapter);

        roomBindAdapter.setBindIds(R.id.update, R.id.delete);
        roomBindAdapter.setOnItemClickListener(this);

        appDatabase = DatabaseInstance.getDatabaseInstance().getAppDatabase();
        studentDao = appDatabase.getStudentDao();

        TeacherDao teacherDao = appDatabase.getTeacherDao();
        Log.e("XLog", "============ teacherDao:" + teacherDao);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.insert:
                insert();
                break;
            case R.id.search:
                List<Student> students = studentDao.loadAll();
                roomBindAdapter.addDataToList(students);
                break;
        }
    }


    @Override
    public void onItemClick(View targetView, Student entity, int position) {
        switch (targetView.getId()) {
            case R.id.update:
                final Random random = new Random();
                int index = random.nextInt(100);
                entity.setName("张三&" + index);
                entity.setAge(index);
                entity.setSex((index > 50) ? 1 : 0);
                studentDao.update(entity);
                roomBindAdapter.notifyDataSetChanged();
                break;
            case R.id.delete:
                studentDao.delete(entity);
                roomBindAdapter.notifyDataSetChanged();
                break;
        }
    }

    private void insert() {
        final Random random = new Random();
        for (int i = 0; i < 10; i++) {
            Student student = new Student();
            int index = random.nextInt(100);
            student.setName("张三&" + index);
            student.setAge(index);

            Student student1 = new Student();
            int randomNumber = random.nextInt(100);
            student1.setName("李四&" + randomNumber);
            student1.setAge(randomNumber);

            studentDao.insertAll(student, student1);
        }
    }

}
