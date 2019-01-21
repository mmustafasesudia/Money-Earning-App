package com.mm.moneyapp.Offers;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.mm.moneyapp.R;

import java.util.ArrayList;
import java.util.List;

public class OffersFragment extends Fragment implements View.OnClickListener {


    Button btn_offer, btn_earn;
    private ViewPager viewPager;


    public OffersFragment() {
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
        final View rootView = inflater.inflate(R.layout.fragment_three, container, false);
        btn_offer = rootView.findViewById(R.id.btn_offer);
        btn_offer.setOnClickListener(this);
        btn_earn = rootView.findViewById(R.id.btn_earn);
        btn_earn.setOnClickListener(this);

        //loadData();


        viewPager = rootView.findViewById(R.id.viewPager);
        viewPager.setOffscreenPageLimit(1);
        setupViewPager(viewPager);

        return rootView;
    }


    public void setDrawable(Context context, Button button, int id) {
        final int sdk = android.os.Build.VERSION.SDK_INT;
        if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
            button.setBackgroundDrawable(ContextCompat.getDrawable(context, id));
        } else {
            button.setBackground(ContextCompat.getDrawable(context, id));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_earn:
                setDrawable(getActivity(), btn_earn, R.drawable.btn_bg_one);
                setDrawable(getActivity(), btn_offer, R.drawable.btn_bg_three);
                btn_earn.setTextColor(getResources().getColor(R.color.Blac));
                btn_offer.setTextColor(getResources().getColor(R.color.Whit));

                viewPager.setCurrentItem(0);

                break;
            case R.id.btn_offer:
                setDrawable(getActivity(), btn_earn, R.drawable.btn_bg_two);
                setDrawable(getActivity(), btn_offer, R.drawable.btn_bg_four);
                btn_earn.setTextColor(getResources().getColor(R.color.Whit));
                btn_offer.setTextColor(getResources().getColor(R.color.Blac));

                viewPager.setCurrentItem(1);

                break;

        }
    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new ViewPagerLeftOffersFragment(), "COMPLETED");
        adapter.addFragment(new ViewPagerRightOffersFragment(), "CANCELED");
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);
    }

    private int getItem(int i) {
        return viewPager.getCurrentItem() + i;
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}