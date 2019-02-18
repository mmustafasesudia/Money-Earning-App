package com.mm.moneyapp;


import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.mm.moneyapp.Utills.ProgressDialogClass;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class DashboardEarning extends Fragment {


    private static int SPLASH_TIME_OUT = 2000;
    Handler handler = new Handler();
    Runnable runnable;
    ImageView img_slider;
    View fiber_wall_offer;
    RelativeLayout rewarded_video, check_in_task, shake_and_earn;

    private InterstitialAd mInterstitialAd;
    private RewardedVideoAd mRewardedVideoAd;


    public DashboardEarning() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard_earning_card, container, false);
        getActivity().setTitle("Dashboard");

        img_slider = view.findViewById(R.id.img_slider);

        //*************************************** Rewarded Video Deceleration ****************************************************************//

        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(getActivity());

        //*************************************** Shake and Earn ****************************************************************//

        shake_and_earn = view.findViewById(R.id.shake_and_earn);
        shake_and_earn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        //*************************************** Check In Task ****************************************************************//
        check_in_task = view.findViewById(R.id.check_in_task);
        check_in_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Please wait while we are getting ready ..!", Toast.LENGTH_SHORT).show();
                ProgressDialogClass.showProgress(getActivity());
                setInterstitialAdsPage();
            }
        });

        //*************************************** Rewarded Video ****************************************************************//

        rewarded_video = view.findViewById(R.id.rewarded_video);
        rewarded_video.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Please wait while we are getting ready ..!", Toast.LENGTH_SHORT).show();
                ProgressDialogClass.showProgress(getActivity());
                setVideoRewardedPage();
            }
        });

        //*************************************** Top Slider ****************************************************************//

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

    private void loadRewardedVideoAd() {
        mRewardedVideoAd.loadAd("ca-app-pub-3940256099942544/5224354917",
                new AdRequest.Builder().build());
    }

    public void setVideoRewardedPage() {
        /*Fragment fragmentName = null;
        Fragment FiberOfferWall = new RewardedVideo();
        fragmentName = FiberOfferWall;
        FragmentReplace.replaceFragment(getActivity(), fragmentName, R.id.frame_container);*/

        mRewardedVideoAd.setRewardedVideoAdListener(new RewardedVideoAdListener() {
            @Override
            public void onRewarded(RewardItem reward) {
                Toast.makeText(getActivity(), "onRewarded! currency: " + reward.getType() + "  amount: " +
                        reward.getAmount(), Toast.LENGTH_SHORT).show();
                // Reward the user.
            }

            @Override
            public void onRewardedVideoAdLeftApplication() {
                Toast.makeText(getActivity(), "onRewardedVideoAdLeftApplication",
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedVideoAdClosed() {
                Toast.makeText(getActivity(), "onRewardedVideoAdClosed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedVideoAdFailedToLoad(int errorCode) {
                ProgressDialogClass.hideProgress();
                Toast.makeText(getActivity(), "onRewardedVideoAdFailedToLoad", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedVideoAdLoaded() {
                ProgressDialogClass.hideProgress();
                Toast.makeText(getActivity(), "onRewardedVideoAdLoaded", Toast.LENGTH_SHORT).show();
                mRewardedVideoAd.show();
            }

            @Override
            public void onRewardedVideoAdOpened() {
                Toast.makeText(getActivity(), "onRewardedVideoAdOpened", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedVideoStarted() {
                Toast.makeText(getActivity(), "onRewardedVideoStarted", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRewardedVideoCompleted() {
                Toast.makeText(getActivity(), "onRewardedVideoCompleted", Toast.LENGTH_SHORT).show();
            }

        });
        loadRewardedVideoAd();


    }

    public void setInterstitialAdsPage() {
        /*Fragment fragmentName = null;
        Fragment FiberOfferWall = new RewardedVideo();
        fragmentName = FiberOfferWall;
        FragmentReplace.replaceFragment(getActivity(), fragmentName, R.id.frame_container);*/


        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }

     /*   mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                // Load the next interstitial.
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }

        });
*/
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                ProgressDialogClass.hideProgress();
                Log.v("InterstitialAd", "Ads Loaded");
                // Code to be executed when an ad finishes loading.
                mInterstitialAd.show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                ProgressDialogClass.hideProgress();
                Log.v("InterstitialAd", "Failed To Load");
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                Log.v("InterstitialAd", "Ads Opened");
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdLeftApplication() {
                Log.v("InterstitialAd", "Ads Left Application");
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                Log.v("InterstitialAd", "Ads Closed");
                // Code to be executed when the interstitial ad is closed.
            }
        });

    }

    @Override
    public void onResume() {
        if (mRewardedVideoAd.isLoaded())
            mRewardedVideoAd.resume(getActivity());
        super.onResume();
    }

    @Override
    public void onPause() {
        if (mRewardedVideoAd.isLoaded())
            mRewardedVideoAd.pause(getActivity());
        super.onPause();
    }

    @Override
    public void onDestroy() {
        if (mRewardedVideoAd.isLoaded())
            mRewardedVideoAd.destroy(getActivity());
        super.onDestroy();
    }
}
