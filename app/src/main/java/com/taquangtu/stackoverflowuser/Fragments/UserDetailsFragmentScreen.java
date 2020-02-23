package com.taquangtu.stackoverflowuser.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import com.taquangtu.stackoverflowuser.Base.BaseFragmentScreen;
import com.taquangtu.stackoverflowuser.Dialogs.BottomNotificationDialog;
import com.taquangtu.stackoverflowuser.Helpers.ApiHelper;
import com.taquangtu.stackoverflowuser.R;
import com.taquangtu.stackoverflowuser.StackOverFlowApplication;

public class UserDetailsFragmentScreen extends BaseFragmentScreen implements ApiHelper.FetchDataListener {
    private String mUserId;
    private TextView mTvUserId, mTvDetails;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mUserId = getArguments().getString("id"); //get user id
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_screen_details,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mTvUserId =view.findViewById(R.id.tvUserId);
        mTvDetails = view.findViewById(R.id.tvDetails);
    }

    @Override
    public void fetchData() {
        ApiHelper.getInstance().fetchUserDetails(this,mUserId);
    }

    @Override
    public void presentData() {
        mTvUserId.setText("UserID: "+mUserId);
        mTvDetails.setText(StackOverFlowApplication.getAppContext().getString(R.string.sorry_message));
    }

    @Override
    public void fetchDataDidStart() {
        String message = StackOverFlowApplication.getAppContext().getString(R.string.sorry_message);
        BottomNotificationDialog bottomNotificationDialog = new BottomNotificationDialog();
        bottomNotificationDialog.setMessage(message);
        bottomNotificationDialog.setTitle("Message");
        bottomNotificationDialog.show();
    }

    @Override
    public void fetchDataDidEnd(boolean isSuccess, Object data, String message) {
        //TODO: not having time enough
    }
}
