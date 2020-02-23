package com.taquangtu.stackoverflowuser.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.taquangtu.stackoverflowuser.Base.BaseActivity;
import com.taquangtu.stackoverflowuser.Base.BaseFragmentScreen;
import com.taquangtu.stackoverflowuser.Fragments.UserDetailsFragmentScreen;

public class UserDetailsActivity extends BaseActivity {

    @Override
    public BaseFragmentScreen createFragmentScreen() {
        return new UserDetailsFragmentScreen();
    }
}
