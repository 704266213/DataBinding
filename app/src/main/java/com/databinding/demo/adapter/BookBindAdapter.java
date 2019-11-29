package com.databinding.demo.adapter;

import com.databinding.demo.R;
import com.databinding.demo.model.BookModel;

import static com.databinding.demo.BR.bookModel;

public class BookBindAdapter extends BaseBindAdapter<BookModel> {

    @Override
    public int getLayoutId() {
        return R.layout.book_item;
    }

    @Override
    public int getBindId() {
        return bookModel;
    }
}
