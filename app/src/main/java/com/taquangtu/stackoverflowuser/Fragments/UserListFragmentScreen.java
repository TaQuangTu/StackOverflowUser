package com.taquangtu.stackoverflowuser.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.taquangtu.stackoverflowuser.Activities.UserDetailsActivity;
import com.taquangtu.stackoverflowuser.Adapters.UserListAdapter;
import com.taquangtu.stackoverflowuser.Base.BaseFragmentScreen;
import com.taquangtu.stackoverflowuser.Base.BaseListAdapter;
import com.taquangtu.stackoverflowuser.Base.BaseListAdapter.ListItemClickListner;
import com.taquangtu.stackoverflowuser.Helpers.ApiHelper;
import com.taquangtu.stackoverflowuser.Helpers.DataParser;
import com.taquangtu.stackoverflowuser.Helpers.VisualEffectHelper;
import com.taquangtu.stackoverflowuser.Model.User;
import com.taquangtu.stackoverflowuser.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class UserListFragmentScreen extends BaseFragmentScreen implements ApiHelper.FetchDataListener, ListItemClickListner {
    private static final int MAX_NUMBER = 30;
    private RecyclerView mRecyclerView;
    private UserListAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mRecyclerView  = (RecyclerView) inflater.inflate(R.layout.fragment_screen_user_list,container,false);
        return mRecyclerView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mAdapter = new UserListAdapter();
        mAdapter.setListener(this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void fetchData() {
        ApiHelper.getInstance().fetchUserList(this,MAX_NUMBER);
    }

    @Override
    public void presentData() {

    }

    @Override
    public void fetchDataDidStart() {
        VisualEffectHelper.getInstance().showLoading();
    }

    @Override
    public void fetchDataDidEnd(boolean isSuccess, Object data, String message) {
        VisualEffectHelper.getInstance().hideLoading();
        if(isSuccess){
            JSONObject jsonObject = (JSONObject) data;
            ArrayList<User> users = DataParser.getInstance().usersFromList(jsonObject);
            mAdapter.setData(users);
        }
        else{
            Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemClick(Object object, int position, View view) {
        //start new activity
        User user = (User) object;
        Toast.makeText(getContext(),user.getmName(),Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this.getContext(), UserDetailsActivity.class);
        intent.putExtra("id",user.getmId());
        getActivity().startActivity(intent);
    }
}
