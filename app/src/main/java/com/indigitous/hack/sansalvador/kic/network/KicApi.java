package com.indigitous.hack.sansalvador.kic.network;

import com.indigitous.hack.sansalvador.kic.model.Contact;
import com.indigitous.hack.sansalvador.kic.model.Token;

import org.json.JSONObject;

import java.util.List;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
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
    Call<ResponseBody> login(@Field("ext_id") String extId, @Field("ext_desc_id")
            String extDescId, @Field("create_timestamp") String createTimestamp);

    @FormUrlEncoded
    @POST("selectContactList.php")
    Call<List<Contact>> getContact(@Field("kic_user_id") String userId);

}
