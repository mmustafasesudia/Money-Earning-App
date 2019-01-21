package com.mm.moneyapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.github.paolorotolo.appintro.AppIntro;
import com.github.paolorotolo.appintro.AppIntroFragment;

public class IntroActivity extends AppIntro {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Checking for first time launch - before calling setContentView()
        if (Config.isFirstTimeLaunch(this).length() > 0) {
            launchHome();
            finish();
        }

        // Just set a title, description,image and background. AppIntro will do the rest
        addSlide(AppIntroFragment.newInstance(getResources().getString(R.string.slide_1_title), getResources().getString(R.string.slide_1_desc), R.drawable.ic_invite_and_earn, getResources().getColor(R.color.colorPrimary)));
        addSlide(AppIntroFragment.newInstance(getResources().getString(R.string.slide_2_title), getResources().getString(R.string.slide_2_desc), R.drawable.ic_connect_icon, getResources().getColor(R.color.colorPrimary)));
        addSlide(AppIntroFragment.newInstance(getResources().getString(R.string.slide_3_title), getResources().getString(R.string.slide_3_desc), R.drawable.ic_help_icon, getResources().getColor(R.color.colorPrimary)));
        addSlide(AppIntroFragment.newInstance(getResources().getString(R.string.slide_4_title), getResources().getString(R.string.slide_4_desc), R.drawable.ic_watching_video_icon, getResources().getColor(R.color.colorPrimary)));

        // Hide Skip/Done button
        showSkipButton(true);
    }

   /* @Override
    public void init(Bundle savedInstanceState) {


        showDoneButton(true);

    }*/

    void launchHome() {
        SharedPreferences preferences = getSharedPreferences("PREFRENCE", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("LAUNCH", "YES");
        editor.commit();
        Intent skip = new Intent(this, SignInSignUpActivity.class);
        startActivity(skip);
    }


    @Override
    public void onSkipPressed() {
        launchHome();
    }

    @Override
    public void onDonePressed() {
        launchHome();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            hideSystemUI();
        }
    }

    private void hideSystemUI() {
        // Enables regular immersive mode.
        // For "lean back" mode, remove SYSTEM_UI_FLAG_IMMERSIVE.
        // Or for "sticky immersive," replace it with SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        // Set the content to appear under the system bars so that the
                        // content doesn't resize when the system bars hide and show.
                        | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        // Hide the nav bar and status bar
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN);
    }

    // Shows the system bars by removing all the flags
// except for the ones that make the content appear under the system bars.
    private void showSystemUI() {
        View decorView = getWindow().getDecorView();
        decorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }
}