package com.taquangtu.stackoverflowuser.Base;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public abstract class BaseListAdapter<DataType> extends RecyclerView.Adapter {
    protected ArrayList<DataType> mData;
    protected ListItemClickListner mListener;

    public ListItemClickListner getListener() {
        return mListener;
    }

    public void setListener(ListItemClickListner mListener) {
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return newViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        bindData((BaseViewHolder) holder,position);
    }

    @Override
    public int getItemCount() {
        if(mData==null) return 0;
        return mData.size();
    }
    public void setData(ArrayList<DataType> data){
        this.mData = data;
        notifyDataSetChanged();
    }
    public ArrayList<DataType> getData(){
       return mData;
    }
    public interface ListItemClickListner{
        void onItemClick(Object object, int position, View view);
    }
    public abstract BaseViewHolder newViewHolder(View parent);
    public abstract void bindData(BaseViewHolder holder, int position);
}
