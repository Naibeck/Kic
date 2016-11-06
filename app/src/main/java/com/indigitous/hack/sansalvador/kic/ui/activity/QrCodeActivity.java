package com.indigitous.hack.sansalvador.kic.ui.activity;

import android.support.v4.app.Fragment;
import android.view.View;

import com.indigitous.hack.sansalvador.kic.ui.fragment.QrCodeFragment;

/**
 * Created by Trainee-Dev on 11/5/2016.
 */
public class QrCodeActivity extends BaseActivity {

    @Override
    public void initComponents() {
        hideActionBar();
    }

    @Override
    public Fragment getContentFragment() {
        return QrCodeFragment.getInstance();
    }

    @Override
    public void initToolbar() {
        if (toolbar != null) {
            toolbar.setVisibility(View.GONE);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
