package com.indigitous.hack.sansalvador.kic.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.digits.sdk.android.AuthCallback;
import com.digits.sdk.android.DigitsAuthButton;
import com.digits.sdk.android.DigitsException;
import com.digits.sdk.android.DigitsSession;
import com.indigitous.hack.sansalvador.kic.R;
import com.indigitous.hack.sansalvador.kic.model.Token;
import com.indigitous.hack.sansalvador.kic.ui.activity.QrCodeActivity;
import com.indigitous.hack.sansalvador.kic.util.Constants;

import butterknife.BindView;

public class LoginFragment extends BaseFragment implements AuthCallback {

    @BindView(R.id.auth_button)
    DigitsAuthButton authButton;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        authButton.setCallback(this);

        if (getPreferences().getToken() != null) {
            goQrCodeActivity();
        }
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
        Token token = new Token(session.getAuthToken().token, Constants.DIGITS_TWITTER);

        saveToken(token);
        Log.d(Constants.APP_LOG, "Current token is: " + getPreferences().getToken().getId());

        goQrCodeActivity();
        getActivity().finish();
    }

    @Override
    public void failure(DigitsException error) {
        Toast.makeText(getContext(), R.string.error_get_token, Toast.LENGTH_SHORT).show();
    }

    private void saveToken(Token token) {
        getPreferences().setToken(token);
    }

    private void goQrCodeActivity() {
        Intent intent = new Intent(getContext(), QrCodeActivity.class);
        startActivity(intent);
    }
}
