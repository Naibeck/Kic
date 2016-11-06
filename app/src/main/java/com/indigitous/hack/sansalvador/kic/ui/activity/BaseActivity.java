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

    /*// Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "cCkP5xYgUS9E6vykaeEsZM8nZ";
    private static final String TWITTER_SECRET = "E3Z9CjDhzCiTvXq7dNzWwwhRymgMLUXr5svp9yJpRCmXgiDZQz";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new TwitterCore(authConfig), new Digits.Builder().build());

        DigitsAuthButton digitsButton = (DigitsAuthButton) findViewById(R.id.auth_button);
        digitsButton.setCallback(new AuthCallback() {
            @Override
            public void success(DigitsSession session, String phoneNumber) {
                // TODO: associate the session userID with your user model
                Toast.makeText(getApplicationContext(), "Authentication successful for "
                        + phoneNumber + " token: " + session.getAuthToken(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void failure(DigitsException exception) {
                Log.d("Digits", "Sign in with Digits failure", exception);
            }
        });


    }*/
}
