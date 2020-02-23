package com.taquangtu.stackoverflowuser;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.taquangtu.stackoverflowuser.Base.BaseActivity;

import java.util.ArrayList;

public class StackOverFlowApplication extends Application {
    private static ArrayList<BaseActivity> activities = new ArrayList<>();
    ;
    private static Context sContext;

    public static void removeActivity(BaseActivity baseActivity) {
        activities.remove(baseActivity);
    }

    public static void addActivity(BaseActivity baseActivity) {
        activities.add(baseActivity);
    }
    public static BaseActivity getCurrentActivity(){
        return activities.get(activities.size()-1);
    }
    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
    }
    public static Context getAppContext(){
        return sContext;
    }
}
