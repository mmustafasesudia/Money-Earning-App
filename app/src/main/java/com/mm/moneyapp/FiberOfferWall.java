package com.mm.moneyapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.heyzap.sdk.ads.HeyzapAds;
import com.heyzap.sdk.ads.OfferWall;


/**
 * A simple {@link Fragment} subclass.
 */
public class FiberOfferWall extends Fragment {

    View view;

    public FiberOfferWall() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fiber_offer_wall, container, false);
        HeyzapAds.start("3788a80cce0e08c6fb2b15820cc29876", getActivity());
        OfferWall.fetch("default");
        OfferWall.isAvailable("default");
        OfferWall.OfferWallOptions offerWallOptions = new OfferWall.OfferWallOptions();
        offerWallOptions.closeOnRedirect = false; // auto-close after first offer interaction?
        OfferWall.display(getActivity(), "default", offerWallOptions);

        OfferWall.VirtualCurrencyCallback callback = new OfferWall.VirtualCurrencyCallback() {
            @Override
            public void onError(OfferWall.VirtualCurrencyErrorResponse virtualCurrencyErrorResponse) {
            }

            @Override
            public void onSuccess(OfferWall.VirtualCurrencyResponse virtualCurrencyResponse) {
                double newCoinsToAward = virtualCurrencyResponse.getDeltaOfCoins();
                String currencyIdOfNewCoins = virtualCurrencyResponse.getCurrencyId();
                // Reward your user the `newCoinsToAward`
            }
        };

        OfferWall.requestVirtualCurrencyUpdate(callback, "gold_coin"); // pass the currency ID you configured on Fyber's dashboard
        return view;
    }

}
