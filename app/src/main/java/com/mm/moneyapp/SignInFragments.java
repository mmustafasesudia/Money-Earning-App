package com.mm.moneyapp;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mm.moneyapp.Utills.FragmentReplace;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class SignInFragments extends Fragment implements View.OnClickListener {

    private static int SPLASH_TIME_OUT = 2000;
    // ImageView img_back;
    Button btn_next;
    TextView tv_new_account, tv_forgot;
    EditText et_user_name, et_password;
    LinearLayout ll_sign_in;
    Handler handler = new Handler();
    Runnable runnable;


    public SignInFragments() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sign_in_fragments, container, false);

        //getActivity().setTitle("Sign In");
        //img_back = view.findViewById(R.id.img_back);
        //img_back.setOnClickListener(this);
        et_user_name = view.findViewById(R.id.et_user_name);
        et_password = view.findViewById(R.id.et_password);
        btn_next = view.findViewById(R.id.btn_next);
        tv_forgot = view.findViewById(R.id.tv_forgot);
        ll_sign_in = view.findViewById(R.id.ll_sign_in);
        btn_next.setOnClickListener(this);
        tv_new_account = view.findViewById(R.id.tv_new_account);
        //img_back = view.findViewById(R.id.img_back);
        tv_new_account.setOnClickListener(this);
        tv_forgot.setOnClickListener(this);
        final int images[] = {R.drawable.teal,
                R.drawable.teal1,
                R.drawable.teal2};


        handler.postDelayed(runnable = new Runnable() {
            public void run() {
                ll_sign_in.setBackgroundResource(images[getRandomNumber()]);
                handler.postDelayed(runnable, SPLASH_TIME_OUT);
            }
        }, SPLASH_TIME_OUT);

        return view;
    }


    @Override
    public void onClick(View view) {
        Fragment fragmentName = null;

        switch (view.getId()) {

            case R.id.btn_next:
                if (!et_user_name.getText().toString().isEmpty()) {

                }
                //getData();
                else {
                    Toast.makeText(getActivity(), "Phone Number Cannot Be Empty", Toast.LENGTH_SHORT).show();
                    //return;
                }
                startActivity(new Intent(getActivity(), Drawer.class));
                getActivity().finish();
                break;
/*
            case R.id.img_back:
                if (getActivity().getSupportFragmentManager().getBackStackEntryCount() == 1) {
                    getActivity().finish();
                } else {
                    getActivity().onBackPressed();
                }
                break;*/

            case R.id.tv_new_account:
                Fragment SignUpFragmen = new SignUpFragment();
                fragmentName = SignUpFragmen;
                FragmentReplace.replaceFragment(getActivity(), fragmentName, R.id.frame_sign_in_container);
                break;
            case R.id.tv_forgot:
                Fragment ForgotPassword = new ForgotPassword();
                fragmentName = ForgotPassword;
                FragmentReplace.replaceFragment(getActivity(), fragmentName, R.id.frame_sign_in_container);
                break;
        }
    }

    private int getRandomNumber() {
        return new Random().nextInt(3);
    }
}
