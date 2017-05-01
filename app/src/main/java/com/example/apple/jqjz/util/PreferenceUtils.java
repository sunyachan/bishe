package com.example.apple.jqjz.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by apple on 17/5/1.
 */

public class PreferenceUtils {
    private static SharedPreferences sp;

    private static SharedPreferences getSharedPreference(Context context) {
        if (sp==null){
            sp=context.getSharedPreferences("config", Context.MODE_PRIVATE);
        }
        return sp;
    }

    public static boolean getBoolean(Context context, String key, boolean defValue) {
        sp = getSharedPreference(context);
        return sp.getBoolean(key,defValue);

    }

    public static void putBoolean(Context context, String key, boolean value) {
        sp=getSharedPreference(context);
        sp.edit().putBoolean(key,value).commit();
    }
}
