package com.indigitous.hack.sansalvador.kic.ui.activity;

import android.support.v4.app.Fragment;
import android.view.View;

import com.indigitous.hack.sansalvador.kic.ui.fragment.LoginFragment;

/**
 * Will display the fragment from login
 */

public class LoginActivity extends BaseActivity {

    @Override
    public void initComponents() {
        hideActionBar();
    }

    @Override
    public Fragment getContentFragment() {
        return LoginFragment.getInstance();
    }

    @Override
    public void initToolbar() {

        if (toolbar != null) {
            toolbar.setVisibility(View.GONE);
        }
    }

}
