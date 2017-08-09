package com.techexe.androidroom.Common;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;

import com.techexe.androidroom.R;
import com.techexe.androidroom.view.AppTextView;

/**
 * Created by Jaimin on 2017/8/3.
 */
public class LoadingView extends DialogFragment {

  Activity activity;
  public LoadingView() {
  }
  public LoadingView(Activity activity) {
    this.activity = activity;
  }

  Animation operatingAnim, eye_left_Anim, eye_right_Anim;

  Dialog mDialog;

  View mouse/*, eye_left, eye_right*/;

//  EyelidView eyelid_left, eyelid_right;

  AppTextView appTextView;

  String text;

  @Override
  public Dialog onCreateDialog(Bundle savedInstanceState) {
    if (mDialog == null) {
      Log.d("Dialog","Create");
      mDialog = new Dialog(activity, R.style.app_dialog);
      mDialog.setContentView(R.layout.layout_dialog);
      mDialog.setCanceledOnTouchOutside(true);
      mDialog.getWindow().setGravity(Gravity.CENTER);

      operatingAnim = new RotateAnimation(360f, 0f, Animation.RELATIVE_TO_SELF, 0.5f,
          Animation.RELATIVE_TO_SELF, 0.5f);
      operatingAnim.setRepeatCount(Animation.INFINITE);
      operatingAnim.setDuration(2000);

      eye_left_Anim = new RotateAnimation(360f, 0f, Animation.RELATIVE_TO_SELF, 0.5f,
          Animation.RELATIVE_TO_SELF, 0.5f);
      eye_left_Anim.setRepeatCount(Animation.INFINITE);
      eye_left_Anim.setDuration(2000);

      eye_right_Anim = new RotateAnimation(360f, 0f, Animation.RELATIVE_TO_SELF, 0.5f,
          Animation.RELATIVE_TO_SELF, 0.5f);
      eye_right_Anim.setRepeatCount(Animation.INFINITE);
      eye_right_Anim.setDuration(2000);

      LinearInterpolator lin = new LinearInterpolator();
      operatingAnim.setInterpolator(lin);
      eye_left_Anim.setInterpolator(lin);
      eye_right_Anim.setInterpolator(lin);

      View view = mDialog.getWindow().getDecorView();

      mouse = view.findViewById(R.id.dialogImageView);
/*

      eye_left = view.findViewById(R.id.eye_left);

      eye_right = view.findViewById(R.id.eye_right);

      eyelid_left = (EyelidView) view.findViewById(R.id.eyelid_left);

      eyelid_left.setColor(Color.parseColor("#d0ced1"));

      eyelid_left.setFromFull(true);

      eyelid_right = (EyelidView) view.findViewById(R.id.eyelid_right);

      eyelid_right.setColor(Color.parseColor("#d0ced1"));

      eyelid_right.setFromFull(true);
*/

      appTextView = (AppTextView) view.findViewById(R.id.dialogTextView);
      
      if (!TextUtils.isEmpty(text)) {
        appTextView.setText(text);
      }

      operatingAnim.setAnimationListener(new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {
        }

        @Override
        public void onAnimationEnd(Animation animation) {
        }

        @Override
        public void onAnimationRepeat(Animation animation) {
/*
          eyelid_left.resetAnimator();
          eyelid_right.resetAnimator();
*/
        }
      });
    }
    return mDialog;
  }

  @Override
  public void onResume() {
    super.onResume();
    Log.d("Dialog","Resume");
    mouse.setAnimation(operatingAnim);
/*
    eye_left.setAnimation(eye_left_Anim);
    eye_right.setAnimation(eye_right_Anim);
    eyelid_left.startLoading();
    eyelid_right.startLoading();
*/
    appTextView.startLoading();
  }

  @Override
  public void onPause() {
    super.onPause();
    Log.d("Dialog","Pause");

    operatingAnim.reset();
    eye_left_Anim.reset();
    eye_right_Anim.reset();

    mouse.clearAnimation();
/*

    eye_left.clearAnimation();
    eye_right.clearAnimation();

    eyelid_left.stopLoading();
    eyelid_right.stopLoading();
*/
    appTextView.stopLoading();
  }

  public void setText(String str) {
    text = str;
  }

  @Override
  public void onDismiss(DialogInterface dialog) {
    super.onDismiss(dialog);
    mDialog = null;
    System.gc();
  }

}
