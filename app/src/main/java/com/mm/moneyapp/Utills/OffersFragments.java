package com.mm.moneyapp.Utills;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mm.moneyapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OffersFragments extends Fragment {


    public OffersFragments() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_offers_fragments, container, false);
        getActivity().setTitle("Offer Wall");
        return view;
    }

}
