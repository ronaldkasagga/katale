package com.grameenfoundation.katale;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import com.grameenfoundation.fragments.VendorFragment;
import com.grameenfoundation.models.Market;

import java.util.List;

public class Home extends FragmentActivity {
    private List<Market> markets;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        shiftFragment(new VendorFragment());
    }

    public void shiftFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();
    }

    public void storeMarkets(List<Market> markets){
        this.markets = markets;
    }
}
