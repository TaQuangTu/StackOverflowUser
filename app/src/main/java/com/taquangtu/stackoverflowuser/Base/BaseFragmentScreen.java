package com.taquangtu.stackoverflowuser.Base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragmentScreen extends Fragment {
    public BaseFragmentScreen(){
        super();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
    abstract public void fetchData();
    abstract public void presentData();
    public void setScreenData(Bundle data){
        Bundle args = getArguments();
        if(args==null){
            args = new Bundle();
            setArguments(args);
        }
        args.putAll(data);
    }
}
