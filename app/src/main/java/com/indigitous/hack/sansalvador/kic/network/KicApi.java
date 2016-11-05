package com.indigitous.hack.sansalvador.kic.network;

import com.indigitous.hack.sansalvador.kic.model.Token;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface KicApi {

    /**
     * Create a new token to save in preferences
     *
     * TODO: Add fields if required when endpoint ready
     *
     * @return a new Token
     */
    @FormUrlEncoded
    @POST("")
    Call<Token> login();

}
