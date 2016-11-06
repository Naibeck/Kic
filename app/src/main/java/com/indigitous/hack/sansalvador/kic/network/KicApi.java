package com.indigitous.hack.sansalvador.kic.network;

import com.indigitous.hack.sansalvador.kic.model.Token;

import okhttp3.Response;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface KicApi {

    /**
     *
     * @param extId
     * @param extDescId
     * @param createTimestamp
     * @return a response to know if the user was successful logged in
     */
    @FormUrlEncoded
    @POST("insertNewUser.php")
    Call<Response> login(@Field("ext_id") String extId, @Field("ext_desc_id")
            String extDescId, @Field("create_timestamp") String createTimestamp);

}
