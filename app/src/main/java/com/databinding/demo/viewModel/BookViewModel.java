package com.databinding.demo.viewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.databinding.demo.model.BookModel;

public class BookViewModel extends ViewModel {

    private MutableLiveData<BookModel> bookLiveData = new MutableLiveData<>();

    public MutableLiveData<BookModel> getBookLiveData() {
        return bookLiveData;
    }

    public static class BookFactory implements ViewModelProvider.Factory {

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return (T) new BookViewModel();
        }
    }
}
