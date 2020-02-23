package com.taquangtu.stackoverflowuser.Dialogs;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;

import com.taquangtu.stackoverflowuser.Base.BaseActivity;
import com.taquangtu.stackoverflowuser.R;
import com.taquangtu.stackoverflowuser.StackOverFlowApplication;

public class DialogLoading extends DialogFragment {
    public DialogLoading(){
        super();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        getDialog().setCancelable(false);
        return inflater.inflate(R.layout.dialog_loading,container,false);
    }
    public void show(){
        BaseActivity activity = StackOverFlowApplication.getCurrentActivity();
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        show(fragmentManager,"dialog");
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return super.onCreateDialog(savedInstanceState);
    }

    public void hide(){
        dismiss();
    }
}
