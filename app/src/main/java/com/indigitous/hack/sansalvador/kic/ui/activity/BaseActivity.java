package com.indigitous.hack.sansalvador.kic.ui.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.indigitous.hack.sansalvador.kic.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    public Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        Fragment fragment;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_layout);

        ButterKnife.bind(this);

        initToolbar();
        initComponents();

        if (savedInstanceState == null) {
            fragment = getContentFragment();
            if (fragment != null) {
                addFragment(fragment);
            }
        }
    }

    private void addFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.content, fragment).commit();
    }


    /**
     * Will call all components that fragment will need
     */
    public abstract void initComponents();

    /**
     *
     * @return the fragment that is going to be displayed in device
     */
    public abstract Fragment getContentFragment();

    public abstract void initToolbar();


    public void hideActionBar() {
        View decorView = getWindow().getDecorView();
// Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    public void replaceFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.content, fragment)
                .commit();
    }
}
