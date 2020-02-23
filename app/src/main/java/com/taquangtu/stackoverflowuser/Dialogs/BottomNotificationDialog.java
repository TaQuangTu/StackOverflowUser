package com.taquangtu.stackoverflowuser.Dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.taquangtu.stackoverflowuser.Base.BaseActivity;
import com.taquangtu.stackoverflowuser.R;
import com.taquangtu.stackoverflowuser.StackOverFlowApplication;

public class BottomNotificationDialog extends BottomSheetDialogFragment {
    String mTitle, mMessage;
    TextView mTextViewTitle, mTextViewMessage;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.dialog_bottom_noti, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        viewCreated();
    }

    @Override
    public void onResume() {
        super.onResume();
        presentData();
    }

    protected void viewCreated() {
        mTextViewTitle = getView().findViewById(R.id.textViewTitle);
        mTextViewMessage = getView().findViewById(R.id.textViewMessage);
    }

    protected void presentData() {
        mTextViewTitle.setText(mTitle);
        mTextViewMessage.setText(mMessage);
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public void setMessage(String message) {
        mMessage = message;
    }
    public void show(){
        BaseActivity activity = StackOverFlowApplication.getCurrentActivity();
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        show(fragmentManager,"dialog");
    }

    public void hide(){
        dismiss();
    }
}
