package com.techexe.androidroom.Common;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;

/**
 * Created by Jaimin patel on 31/7/17.
 */
public class Preferences {

    SharedPreferences pref_extra;
    private Context _context;
    public Preferences(Context context) {
        this._context = context;
        pref_extra = _context.getSharedPreferences("iExtra",_context.MODE_PRIVATE);
    }
    public String saveString(String key, String value) {
        // TODO Auto-generated method stub
        SharedPreferences.Editor editor = pref_extra.edit();
        // key encode
       try {
           key = Base64.encodeToString(key.getBytes(), Base64.DEFAULT );
           value = Base64.encodeToString(value.getBytes(), Base64.DEFAULT );
           editor.putString(key, value);
           editor.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return key;
    }
    public String loadString(String key) {
        // TODO Auto-generated method stub
        key = Base64.encodeToString(key.getBytes(), Base64.DEFAULT );
        String strSaved = pref_extra.getString(key, "");
        try {
            byte[] data = Base64.decode(strSaved, Base64.DEFAULT);
            strSaved = new String(data, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return strSaved;
    }
    public String saveInteger(String key, int value) {
        // TODO Auto-generated method stub
        SharedPreferences.Editor editor = pref_extra.edit();
        // key encode
       try {
           key = Base64.encodeToString(key.getBytes(), Base64.DEFAULT );
//           value = Base64.encodeToString(value.getBytes(), Base64.DEFAULT );
           editor.putInt(key, value);
           editor.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return key;
    }
    public int loadInteger(String key) {
        // TODO Auto-generated method stub
        key = Base64.encodeToString(key.getBytes(), Base64.DEFAULT );
        int strSaved = pref_extra.getInt(key, 0);
        return strSaved;
    }
    public String saveBoolean(String key, boolean value) {
        // TODO Auto-generated method stub
        SharedPreferences.Editor editor = pref_extra.edit();
        // key encode
       try {
           key = Base64.encodeToString(key.getBytes(), Base64.DEFAULT);
//           value = Base64.encodeToString(value.getBytes(), Base64.DEFAULT );
           editor.putBoolean(key, value);
           editor.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return key;
    }
    public boolean loadBoolean(String key) {
        // TODO Auto-generated method stub
        key = Base64.encodeToString(key.getBytes(), Base64.DEFAULT );
        boolean strSaved = pref_extra.getBoolean(key, false);
        return strSaved;
    }



}
