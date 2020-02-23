package com.taquangtu.stackoverflowuser.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.taquangtu.stackoverflowuser.Base.BaseActivity;
import com.taquangtu.stackoverflowuser.Base.BaseFragmentScreen;
import com.taquangtu.stackoverflowuser.Fragments.UserListFragmentScreen;
import com.taquangtu.stackoverflowuser.R;

public class UserListActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public BaseFragmentScreen createFragmentScreen() {
        return new UserListFragmentScreen();
    }
}
