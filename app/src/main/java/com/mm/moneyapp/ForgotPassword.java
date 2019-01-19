package com.mm.moneyapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mm.moneyapp.Utills.FragmentReplace;


public class ForgotPassword extends Fragment {

    Button btn_next;

    public ForgotPassword() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_forgot_password, container, false);
        btn_next = view.findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragmentName = null;

                Fragment ForgotPassword = new SignUpVerification();
                fragmentName = ForgotPassword;
                FragmentReplace.replaceFragment(getActivity(), fragmentName, R.id.frame_sign_in_container);

            }
        });
        return view;
    }

}
