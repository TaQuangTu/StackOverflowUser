package com.taquangtu.stackoverflowuser.Base;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.taquangtu.stackoverflowuser.R;
import com.taquangtu.stackoverflowuser.StackOverFlowApplication;

public abstract class BaseActivity extends AppCompatActivity {
    private BaseFragmentScreen mFragmentScreen;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity);
        if(mFragmentScreen==null){
            mFragmentScreen=createFragmentScreen();
        }
        StackOverFlowApplication.addActivity(this);
    }
    public abstract BaseFragmentScreen createFragmentScreen();

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        if(intent!=null){
            Bundle bundle = new Bundle();
            if(intent.getExtras()!=null){
                bundle.putAll(intent.getExtras());
                mFragmentScreen.setScreenData(bundle);
            }
        }
        loadScreen();
        mFragmentScreen.presentData();
        mFragmentScreen.fetchData();
    }
    public void loadScreen(){
        getSupportFragmentManager().beginTransaction().replace(R.id.lnMainLayout,mFragmentScreen).commitNowAllowingStateLoss();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        StackOverFlowApplication.removeActivity(this);
    }
}
