package com.mm.moneyapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.mm.moneyapp.LuckyUser.LuckyUserFragment;
import com.mm.moneyapp.NotificationFragment.NotifyFragment;
import com.mm.moneyapp.Offers.OffersFragment;
import com.mm.moneyapp.Utills.FragmentReplace;
import com.mm.moneyapp.Utills.OffersFragments;

import static com.mm.moneyapp.Config.clearshareprefrence;

public class Drawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        MobileAds.initialize(this, "ca-app-pub-3940256099942544~3347511713");


        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("ca-app-pub-3940256099942544/6300978111");

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


       /* Fragment fragmentName = null;
        Fragment Dashboard = new DashboardEarning();
        fragmentName = Dashboard;
        FragmentReplace.replaceFragment(this, fragmentName, R.id.frame_container);
*/
        Fragment fragment = new DashboardEarning();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fragment);
        fragmentTransaction.commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
            Fragment fragmentName = null;
            Fragment Dashboard = new DashboardEarning();
            fragmentName = Dashboard;
            FragmentReplace.replaceFragment(this, fragmentName, R.id.frame_container);

        }
        if (id == R.id.nav_my_earning) {
            // Handle the camera action
            Fragment fragmentName = null;
            Fragment Dashboard = new OffersFragment();
            fragmentName = Dashboard;
            FragmentReplace.replaceFragment(this, fragmentName, R.id.frame_container);

        } else if (id == R.id.nav_notification) {
            Fragment fragmentName = null;
            Fragment Dashboard = new NotifyFragment();
            fragmentName = Dashboard;
            FragmentReplace.replaceFragment(this, fragmentName, R.id.frame_container);

        } else if (id == R.id.nav_profile) {
            Fragment fragmentName = null;
            Fragment Dashboard = new ProfileFragment();
            fragmentName = Dashboard;
            FragmentReplace.replaceFragment(this, fragmentName, R.id.frame_container);

        } else if (id == R.id.nav_lucky_user) {
            Fragment fragmentName = null;
            Fragment Dashboard = new LuckyUserFragment();
            fragmentName = Dashboard;
            FragmentReplace.replaceFragment(this, fragmentName, R.id.frame_container);

        } else if (id == R.id.nav_privacy_policy) {

        } else if (id == R.id.nav_how_its_works) {
            Fragment fragmentName = null;
            Fragment Dashboard = new OffersFragments();
            fragmentName = Dashboard;
            FragmentReplace.replaceFragment(this, fragmentName, R.id.frame_container);

        } else if (id == R.id.nav_log_out) {
            startActivity(new Intent(Drawer.this, SignInSignUpActivity.class));
            finish();
            clearshareprefrence(getApplication());
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
