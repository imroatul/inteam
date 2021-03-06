package com.tolahtoleh.tolahtolehbeta;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by KING on 30/05/2017.
 */

public class SharedPrefManager {
    private static SharedPrefManager mInstance;
    private static Context mCtx;

    private static final String SHARED_PREF_NAME = "mysharedpref12";
    private static final String KEY_USERNAME = "namamember";
    private static final String KEY_PASSWORD = "passwordmember";
    private static final String KEY_USER_EMAIL = "emailmember";
    private static final String KEY_USER_ID = "id";

    private SharedPrefManager(Context context){
        mCtx = context;
    }
    public static synchronized SharedPrefManager getInstance(Context context){
        if (mInstance == null){
            mInstance = new SharedPrefManager(context);
        }
        return mInstance;
    }
    public boolean userLogin(int id, String emailmember, String namamember, String passwordmember){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor =  sharedPreferences.edit();

        editor.putInt(KEY_USER_ID, id);
        editor.putString(KEY_USER_EMAIL, emailmember);
        editor.putString(KEY_USERNAME,namamember);
        editor.putString(KEY_PASSWORD,passwordmember);


        editor.apply();

        return true;
    }
    public boolean isLoggedIn(){
        SharedPreferences sharedPreferences= mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        if (sharedPreferences.getString(KEY_USERNAME,null) != null){
            return true;
        }
        return false;
    }
    public boolean Logout(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;
    }
    public String getUsername(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_PASSWORD, null);
    }
    public String getUserEmail(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(KEY_USER_EMAIL, null);
    }
}
