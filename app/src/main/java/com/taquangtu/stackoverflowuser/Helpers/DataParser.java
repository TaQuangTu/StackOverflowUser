package com.taquangtu.stackoverflowuser.Helpers;

import com.taquangtu.stackoverflowuser.Model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DataParser {
    private static DataParser instance = new DataParser();
    public static DataParser getInstance(){
        return instance;
    }
    private DataParser(){

    }
    public User userFromJson(JSONObject jsonObject){
        User user = new User();
        try {
            user.setmId(jsonObject.getString(User.ID));
            user.setmName(jsonObject.getString(User.DISPLAY_NAME));
            user.setmProfileImage(jsonObject.getString(User.PROFILE_IMAGE));
            user.setmAccessDate(jsonObject.getLong(User.ACCESS_DATE));
            user.setmLocation(jsonObject.getString(User.LOCATION));
            user.setmReputation(jsonObject.getInt(User.REPUTATION));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return user;
    }
    public ArrayList<User> usersFromList(JSONObject jsonObject){
        ArrayList<User> users = new ArrayList<>();
        try {
            JSONArray jsonArray = jsonObject.getJSONArray("items");
            for(int i=0;i<jsonArray.length();i++){
                User user = userFromJson(jsonArray.getJSONObject(i));
                users.add(user);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return users;
    }
}
