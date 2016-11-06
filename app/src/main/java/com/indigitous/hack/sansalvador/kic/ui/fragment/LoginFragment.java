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
import com.indigitous.hack.sansalvador.kic.network.KicService;
import com.indigitous.hack.sansalvador.kic.ui.activity.QrCodeActivity;
import com.indigitous.hack.sansalvador.kic.util.Constants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import butterknife.BindView;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;

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
        postToken(token);
        /*Token token = new Token(null ,session.getAuthToken().token, Constants.DIGITS_TWITTER);
        saveToken(token);
        postToken(token);
        Log.d(Constants.APP_LOG, "Current token is: " + getPreferences().getToken().getId());
        goQrCodeActivity();
        getActivity().finish();*/
    }

    @Override
    public void failure(DigitsException error) {
        Toast.makeText(getContext(), R.string.error_get_token, Toast.LENGTH_SHORT).show();
    }

    private void postToken(final Token token) {
        /*Call<Token> responseCall = KicService.getApi().login(token.getExtId(), token.getMethod(), token.getDate().toString());
        responseCall.enqueue(new Callback<Token>() {
            @Override
            public void onResponse(Call<Token> call, retrofit2.Response<Token> response) {
                token.setId(response.body().getId());
                Log.d(Constants.APP_LOG, "token id: " + token.getId() + "token ext_id" + token.getExtId());
                goQrCodeActivity();
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                Log.d(Constants.APP_LOG, "Failed");
            }
        });*/
        Call<ResponseBody> responseCall = KicService.getApi().login(token.getExtId(), token.getMethod(), token.getDate().toString());
        responseCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, retrofit2.Response<ResponseBody> response) {
                try {
                    JSONArray object = new JSONArray(response.body().string());
                    JSONObject jsonObject = object.getJSONObject(0);
                    token.setId(jsonObject.getLong("id"));
                    saveToken(token);
                    Log.d(Constants.APP_LOG, "Token id: " + token.getId() + " token: " + token.getExtId());
                    goQrCodeActivity();
                } catch (IOException | JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.d(Constants.APP_LOG, "Failed");
            }
        });

    }

    private void saveToken(Token token) {
        getPreferences().setToken(token);
    }

    private void goQrCodeActivity() {
        Intent intent = new Intent(getContext(), QrCodeActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}
