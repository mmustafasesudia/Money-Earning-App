package com.mm.moneyapp.LuckyUser;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mm.moneyapp.Offers.WorkerJobs;
import com.mm.moneyapp.R;

import java.util.ArrayList;

public class AdapterLuckyUser extends RecyclerView.Adapter<AdapterLuckyUser.MyViewHolder> {

    private Context acontext;
    private ArrayList<WorkerJobs> arrayList;

    public AdapterLuckyUser(Context context, ArrayList<WorkerJobs> arrayList) {
        this.arrayList = arrayList;
        acontext = context;
    }

    @Override
    public AdapterLuckyUser.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_lucky_user, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        WorkerJobs current = arrayList.get(position);
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public CardView mCardView;

        public MyViewHolder(View v) {
            super(v);
            mCardView = v.findViewById(R.id.card_view_lucky_user);
        }

    }

}
