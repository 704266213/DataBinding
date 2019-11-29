package com.databinding.demo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

import com.databinding.demo.R;
import com.databinding.demo.model.BookModel;

import java.util.ArrayList;
import java.util.List;

import static com.databinding.demo.BR.bookModel;

public class BindAdapter extends RecyclerView.Adapter<BindAdapter.BindAdapterHolder> {

    private List<BookModel> bookModelList;

    public BindAdapter() {
        bookModelList = new ArrayList<>();
    }

    public void addDataToList(List<BookModel> bookModels) {
        bookModelList.addAll(bookModels);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return bookModelList.size();
    }

    @NonNull
    @Override
    public BindAdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewDataBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.bind_item, parent, false);
        BindAdapterHolder holder = new BindAdapterHolder(binding.getRoot());
        holder.setBinding(binding);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull BindAdapterHolder holder, int position) {
        holder.getBinding().setVariable(bookModel, bookModelList.get(position));
        holder.getBinding().executePendingBindings();
    }


    public class BindAdapterHolder extends RecyclerView.ViewHolder {

        private ViewDataBinding binding;

        public BindAdapterHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void setBinding(ViewDataBinding binding) {
            this.binding = binding;
        }

        public ViewDataBinding getBinding() {
            return this.binding;
        }
    }
}
