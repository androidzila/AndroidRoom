package com.techexe.androidroomapp.permissions;

/**
 * request permission callback
 * Created by jaimin on 2017/8/3.
 */

public interface OnRequestPermissionsCallBack {

    void onGrant();

    void onDenied(String permission);
}
