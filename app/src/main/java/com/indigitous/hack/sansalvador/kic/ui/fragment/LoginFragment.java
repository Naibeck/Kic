package com.indigitous.hack.sansalvador.kic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import com.digits.sdk.android.AuthCallback;
import com.digits.sdk.android.DigitsAuthButton;
import com.digits.sdk.android.DigitsException;
import com.digits.sdk.android.DigitsSession;
import com.indigitous.hack.sansalvador.kic.R;

import butterknife.BindView;

public class LoginFragment extends BaseFragment implements AuthCallback {

    @BindView(R.id.auth_button)
    DigitsAuthButton authButton;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        authButton.setCallback(this);
    }

    public static LoginFragment getInstance() {
        return new LoginFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_login;
    }

    @Override
    public void success(DigitsSession session, String phoneNumber) {
        Toast.makeText(getContext(), "Authentication successful for "
                + phoneNumber + " token: " + session.getAuthToken(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void failure(DigitsException error) {

    }
}
