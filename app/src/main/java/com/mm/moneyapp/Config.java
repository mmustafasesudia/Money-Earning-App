package com.mm.moneyapp;

import android.content.Context;
import android.content.SharedPreferences;

public class Config {

    public static String isFirstTimeLaunch(Context context) {
        SharedPreferences prefs = context.getSharedPreferences("PREFRENCE", Context.MODE_PRIVATE);
        if (prefs.getString("LAUNCH", "").length() > 0) {
            return prefs.getString("LAUNCH", "");
        } else
            return "";
    }

    public static void clearshareprefrence(Context context) {
        SharedPreferences preferences = context.getSharedPreferences("PREFRENCE", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.commit();
    }
}
