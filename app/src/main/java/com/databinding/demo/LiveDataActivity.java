package com.databinding.demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.databinding.demo.model.BookModel;
import com.databinding.demo.viewModel.BookViewModel;

import java.util.Date;
import java.util.Random;

public class LiveDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);

        initView();
    }

    private TextView showUpdateData;
    private TextView updateData;
    private BookViewModel bookViewModel;

    private void initView() {
        showUpdateData = findViewById(R.id.showUpdateData);
        updateData = findViewById(R.id.updateData);

//        bookViewModel = ViewModelProviders.of(this).get(BookViewModel.class);

        bookViewModel = ViewModelProviders.of(this, new BookViewModel.BookFactory()).get(BookViewModel.class);
        bookViewModel.getBookLiveData().observe(this, new Observer<BookModel>() {
            @Override
            public void onChanged(BookModel bookModel) {
                showUpdateData.setText(bookModel.getBookName());
            }
        });


        final BookModel bookModel = new BookModel();
        final Random random = new Random();
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = random.nextInt(1000);
                bookModel.setBookName("java语言进阶" + index);
                //postValue与setValue的区别是,postValue回调的是主线程,setValue则是当前线程.
                bookViewModel.getBookLiveData().postValue(bookModel);
            }
        });

    }
}
