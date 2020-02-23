package com.taquangtu.stackoverflowuser.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.taquangtu.stackoverflowuser.Base.BaseFragmentScreen;
import com.taquangtu.stackoverflowuser.R;

public class MainActivity extends AppCompatActivity {
    private BaseFragmentScreen mFragmentScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
