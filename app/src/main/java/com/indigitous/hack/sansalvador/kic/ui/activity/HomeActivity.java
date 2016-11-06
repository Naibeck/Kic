package com.indigitous.hack.sansalvador.kic.ui.activity;

import android.support.v4.app.Fragment;

import com.indigitous.hack.sansalvador.kic.ui.fragment.ContactFragment;

public class HomeActivity extends BaseActivity {

    @Override
    public void initComponents() {
        setContactFragment();
    }

    private void setContactFragment() {
        Fragment fragment = ContactFragment.getInstance();
        replaceFragment(fragment);
    }

    @Override
    public Fragment getContentFragment() {
        return null;
    }

    @Override
    public void initToolbar() {
        setSupportActionBar(toolbar);
    }
}
