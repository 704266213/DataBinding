package com.databinding.demo.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.databinding.demo.R;
import com.databinding.demo.adapter.BindAdapter;
import com.databinding.demo.adapter.BookBindAdapter;
import com.databinding.demo.listener.OnItemClickListener;
import com.databinding.demo.model.BookModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseAdapterActivity extends AppCompatActivity implements OnItemClickListener<BookModel> {

    private RecyclerView recyclerView;
    private BookBindAdapter bookBindAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_adapter);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false));
        bookBindAdapter = new BookBindAdapter();
        recyclerView.setAdapter(bookBindAdapter);

        bookBindAdapter.setBindIds(R.id.itemView, R.id.bookUrl, R.id.bookName);
        bookBindAdapter.setOnItemClickListener(this);
        bookBindAdapter.addDataToList(initData());
    }

    @Override
    public void onItemClick(View targetView, BookModel entity, int position) {
        switch (targetView.getId()) {
            case R.id.bookUrl:
                Toast.makeText(this, "当前的图片地址：" + entity.getBookUrl(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.bookName:
                Toast.makeText(this, "当前的书名：" + entity.getBookName(), Toast.LENGTH_SHORT).show();
                break;
            default:
                Toast.makeText(this, "当前的Position：" + position, Toast.LENGTH_SHORT).show();
                break;
        }
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
