package com.mm.moneyapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.mm.moneyapp.Utills.FragmentReplace;

public class SignUpFragment extends Fragment implements View.OnClickListener {


    TextView tv_forgot_pass;
    EditText et_input_full_name, et_input_email, et_input_password;
    Button btn_next;

    ImageView img_back;

    public SignUpFragment() {
        // Required empty public constructor
    }

    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.starter_pack_sign_up_fragment, container, false);

        getActivity().setTitle("Sign Up");


        img_back = view.findViewById(R.id.img_back);
        et_input_full_name = view.findViewById(R.id.et_user_name);
        et_input_email = view.findViewById(R.id.et_email);
        et_input_password = view.findViewById(R.id.et_password);

        tv_forgot_pass = view.findViewById(R.id.tv_forgot);
        tv_forgot_pass.setOnClickListener(this);
        btn_next = view.findViewById(R.id.btn_next);
        btn_next.setOnClickListener(this);
        img_back.setOnClickListener(this);

        return view;
    }

    public void submit() {

        if (et_input_full_name.getText().toString().isEmpty()) {
            et_input_full_name.setError("Full Name Cannot Be Empty");
            requestFocus(et_input_full_name);
            return;
        }
        if (et_input_full_name.getText().toString().startsWith(" ")) {
            et_input_full_name.setError("Space In Start And End Is Not Allowed");
            requestFocus(et_input_full_name);
            return;
        }

        if (et_input_email.getText().toString().isEmpty() || !isValidEmail(et_input_email.getText().toString())) {
            et_input_email.setError("Invalid Email");
            requestFocus(et_input_email);
            return;
        }
        if (et_input_password.getText().toString().isEmpty()) {
            et_input_password.setError("Password Cannot Be Empty");
            requestFocus(et_input_password);
            return;
        }
        if (et_input_password.getText().toString().length() < 8) {
            et_input_password.setError("Password cannot be less then 8 character");
            requestFocus(et_input_password);
            return;
        }

    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        Fragment fragmentName = null;
        Fragment ForgotInputNewPasswordFragment = new SignUpFragment();
        Fragment SignUpVerificatio = new SignUpVerification();

        switch (v.getId()) {
            case R.id.btn_next:
                submit();
                fragmentName = SignUpVerificatio;
                FragmentReplace.replaceFragment(getActivity(), fragmentName, R.id.frame_sign_in_container);
                break;
            case R.id.tv_forgot:
                fragmentName = ForgotInputNewPasswordFragment;
                FragmentReplace.replaceFragment(getActivity(), fragmentName, R.id.frame_sign_in_container);
                break;
            case R.id.img_back:
                if (getActivity().getSupportFragmentManager().getBackStackEntryCount() == 1) {
                    getActivity().finish();
                } else {
                    getActivity().onBackPressed();
                }
                break;
        }
    }
}
