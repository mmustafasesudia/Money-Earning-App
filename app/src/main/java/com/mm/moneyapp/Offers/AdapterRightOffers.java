package com.mm.moneyapp.Offers;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mm.moneyapp.R;

import java.util.ArrayList;

public class AdapterRightOffers extends RecyclerView.Adapter<AdapterRightOffers.MyViewHolder> {

    private Context acontext;
    private ArrayList<WorkerJobs> arrayList;

    public AdapterRightOffers(Context context, ArrayList<WorkerJobs> arrayList) {
        this.arrayList = arrayList;
        acontext = context;
    }

    @Override
    public AdapterRightOffers.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_right_offer, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        WorkerJobs current = arrayList.get(position);
        holder.tv_date.setText("" + current.getDate());
        if (current.getModePayment().equals("0")) {
            holder.tv_mode.setImageResource(R.drawable.paytm);
        }
        if (current.getModePayment().equals("1")) {
            holder.tv_mode.setImageResource(R.drawable.paypal);
        }
        holder.tv_redeem_amt_pts.setText("" + current.getPts() + " pts");
        holder.tv_redeem_amt.setText("Rs " + current.getAmt());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public CardView mCardView;
        TextView tv_date, tv_redeem_amt_pts, tv_redeem_amt;
        ImageView tv_mode;

        public MyViewHolder(View v) {
            super(v);
            mCardView = v.findViewById(R.id.card_view_order_cancel);
            tv_date = v.findViewById(R.id.tv_date);
            tv_mode = v.findViewById(R.id.tv_mode);
            tv_redeem_amt_pts = v.findViewById(R.id.tv_redeem_amt_pts);
            tv_redeem_amt = v.findViewById(R.id.tv_redeem_amt);

        }

    }

}
