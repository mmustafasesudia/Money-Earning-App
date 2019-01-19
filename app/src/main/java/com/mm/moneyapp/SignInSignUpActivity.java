package com.mm.moneyapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import com.mm.moneyapp.Utills.FragmentReplace;

public class SignInSignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_sign_up);

        Fragment fragmentName = null;
        Fragment Dashboard = new SignInFragments();
        fragmentName = Dashboard;
        FragmentReplace.replaceFragment(this, fragmentName, R.id.frame_sign_in_container);

    }
}
