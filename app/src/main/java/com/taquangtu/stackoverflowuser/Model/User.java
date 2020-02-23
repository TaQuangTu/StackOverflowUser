package com.taquangtu.stackoverflowuser.Model;

import org.json.JSONObject;

public class User {
    public static final String ID = "account_id";
    public static final String DISPLAY_NAME = "display_name";
    public static final String ACCESS_DATE = "last_access_date";
    public static final String PROFILE_IMAGE = "profile_image";
    public static final String REPUTATION = "reputation";
    public static final String LOCATION = "location";

    private String mId;
    private String mName;
    private String mProfileImage;
    private int mReputation;
    private String mLocation;

    public String getmId() {
        return mId;
    }

    public void setmId(String mId) {
        this.mId = mId;
    }

    private long mAccessDate;

    public User() {
        this.mName = "";
        this.mProfileImage = "";
        this.mReputation = 0;
        this.mLocation = "unknown";
        this.mAccessDate = 0;
    }
    public User(String mName, String mProfileImage, int mReputation, String mLocation, long mAccessDate) {
        this.mName = mName;
        this.mProfileImage = mProfileImage;
        this.mReputation = mReputation;
        this.mLocation = mLocation;
        this.mAccessDate = mAccessDate;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public String getmProfileImage() {
        return mProfileImage;
    }

    public void setmProfileImage(String mProfileImage) {
        this.mProfileImage = mProfileImage;
    }

    public int getmReputation() {
        return mReputation;
    }

    public void setmReputation(int mReputation) {
        this.mReputation = mReputation;
    }

    public String getmLocation() {
        return mLocation;
    }

    public void setmLocation(String mLocation) {
        this.mLocation = mLocation;
    }

    public long getmAccessDate() {
        return mAccessDate;
    }

    public void setmAccessDate(long mAccessDate) {
        this.mAccessDate = mAccessDate;
    }
}
