package com.mm.moneyapp.LuckyUser;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mm.moneyapp.Offers.WorkerJobs;
import com.mm.moneyapp.R;

import java.util.ArrayList;

public class LuckyUserFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {


    ArrayList<WorkerJobs> data = new ArrayList<>();
    SwipeRefreshLayout mSwipeRefreshLayout;
    RecyclerView rv;

    public LuckyUserFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_lucky_user, container, false);
        rv = rootView.findViewById(R.id.rv_order_cancel);
        rv.setHasFixedSize(true);

        mSwipeRefreshLayout = rootView.findViewById(R.id.contentView);
        mSwipeRefreshLayout.setOnRefreshListener(this);

        loadData();

        return rootView;
    }

    public void loadData() {
        WorkerJobs obj = new WorkerJobs("");
        data.add(obj);
        AdapterLuckyUser adapter = new AdapterLuckyUser(getActivity(), data);
        rv.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);
        refreshItems();
    }

    @Override
    public void onRefresh() {
        loadData();
    }

    public void refreshItems() {
        onItemsLoadComplete();
    }

    public void onItemsLoadComplete() {
        mSwipeRefreshLayout.setRefreshing(false);
    }
}