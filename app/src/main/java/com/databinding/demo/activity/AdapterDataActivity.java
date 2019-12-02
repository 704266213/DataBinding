package com.databinding.demo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.databinding.demo.R;
import com.databinding.demo.adapter.BindAdapter;
import com.databinding.demo.model.BookModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdapterDataActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private BindAdapter bindAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adapter_data);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        bindAdapter = new BindAdapter();
        recyclerView.setAdapter(bindAdapter);


        bindAdapter.addDataToList(initData());
    }


    private List<BookModel> initData() {
        List<BookModel> bookModels = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            BookModel bookModel = new BookModel();
            bookModel.setBookName("java语言进阶" + i);
            if (i % 3 == 0) {
                bookModel.setBookUrl("http://img3m1.ddimg.cn/29/32/26912981-1_b_4.jpg");
            } else if (i % 3 == 1) {
                bookModel.setBookUrl("http://img3m1.ddimg.cn/77/14/23259731-1_b_0.jpg");
            } else {
                bookModel.setBookUrl("http://img3m0.ddimg.cn/4/24/9317290-1_b_5.jpg");
            }
            bookModel.setBookPrice(99.99f);
            bookModel.setPublishDate(new Date());
            bookModels.add(bookModel);
        }
        return bookModels;
    }

}
