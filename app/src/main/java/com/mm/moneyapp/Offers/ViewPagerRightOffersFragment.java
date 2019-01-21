package com.mm.moneyapp.Offers;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mm.moneyapp.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ViewPagerRightOffersFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    ArrayList<WorkerJobs> data = new ArrayList<>();
    SwipeRefreshLayout mSwipeRefreshLayout;
    RecyclerView rv;

    public ViewPagerRightOffersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_view_pager_right_offers_fragments, container, false);
        rv = rootView.findViewById(R.id.rv_order_cancel);
        rv.setHasFixedSize(true);

        mSwipeRefreshLayout = rootView.findViewById(R.id.contentView);
        mSwipeRefreshLayout.setOnRefreshListener(this);

        WorkerJobs obj = new WorkerJobs("1", "24-Jan-2018", "1000", "500");
        data.add(obj);
        WorkerJobs obj1 = new WorkerJobs("0", "04-Feb-2018", "2500", "2500");
        data.add(obj1);
        AdapterRightOffers adapter = new AdapterRightOffers(getActivity(), data);
        rv.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);
        return rootView;
    }

    @Override
    public void onRefresh() {
        //loadData();
        refreshItems();
    }

    public void refreshItems() {
        onItemsLoadComplete();
    }

    public void onItemsLoadComplete() {
        mSwipeRefreshLayout.setRefreshing(false);
    }

}
