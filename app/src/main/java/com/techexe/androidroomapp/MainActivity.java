package com.techexe.androidroomapp;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.techexe.androidroom.Interfaces.OnResponse;
import com.techexe.androidroom.MyApplication;
import com.techexe.androidroom.AppRequest;

import org.json.JSONArray;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    AppRequest request;

    String url = "https://retail.globalgarner.com/api/sliders";
    String url1 = "http://bloombayindia.com/admin/index.php/Mobileapi/product/?name=f1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        request = MyApplication.getMyApp().getRequest();
        request.getPreferences().saveBoolean("asd",true);
        request.getPreferences().saveString("aaa","asds");

        request.getPreferences().loadBoolean("asd");



        Log.d("Response prevf",request.getPreferences().loadString("aaa"));


        request.jsonArrayRequest(MainActivity.this, url, AppRequest.METHOD_GET, new JSONArray(), new OnResponse() {
            @Override
            public void onSuccess(String response, int statusCode) {

                Log.d("Response",response);
            }

            @Override
            public void onError(String errorData, int statusCode) {
                Log.d("Error",errorData);
            }
        },"Please wait...");

        request.jsonArrayRequest(MainActivity.this, url, AppRequest.METHOD_GET, new JSONArray(), new OnResponse() {
            @Override
            public void onSuccess(String response, int statusCode) {

                Log.d("Response",response);
            }

            @Override
            public void onError(String errorData, int statusCode) {
                Log.d("Error",errorData);
            }
        },"Please wait...");

        Log.d("isOpen"," > "+hasOpenedDialogs(this));

    }

    public static boolean hasOpenedDialogs(FragmentActivity activity) {

        List<Fragment> fragments = activity.getSupportFragmentManager().getFragments();
        if (fragments != null) {
            for (Fragment fragment : fragments) {
                if (fragment instanceof DialogFragment) {
                    return true;
                }
            }
        }

        return false;
    }
}
