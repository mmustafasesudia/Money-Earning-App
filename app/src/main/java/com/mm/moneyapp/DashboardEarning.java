package com.mm.moneyapp;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardEarning extends Fragment {


    private static int SPLASH_TIME_OUT = 2000;
    Handler handler = new Handler();
    Runnable runnable;

    ImageView img_slider;

    public DashboardEarning() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard_earning, container, false);
        getActivity().setTitle("Dashboard");
        img_slider = view.findViewById(R.id.img_slider);

        final int images[] = {R.drawable.congrtz,
                R.drawable.congrtz,
                R.drawable.congrtz};
        handler.postDelayed(runnable = new Runnable() {
            public void run() {
                img_slider.setVisibility(View.VISIBLE);
                img_slider.setBackgroundResource(images[getRandomNumber()]);
                handler.postDelayed(runnable, SPLASH_TIME_OUT);
            }
        }, SPLASH_TIME_OUT);


        return view;
    }

    private int getRandomNumber() {
        return new Random().nextInt(3);
    }

}
