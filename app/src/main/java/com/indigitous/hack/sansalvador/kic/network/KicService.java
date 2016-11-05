package com.indigitous.hack.sansalvador.kic.network;

import android.util.Log;

import com.indigitous.hack.sansalvador.kic.KicApplication;
import com.indigitous.hack.sansalvador.kic.util.Constants;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class KicService {

    private static KicApi mKicApi;

    /**
     *
     * @return the service to call kic endpoints
     */
    public static synchronized KicApi getApi() {
        return getApi(Constants.Network.API_BASE_URL);
    }

    /**
     *
     * @param url the endpoint that is going to be requested
     * @return the service to call kic endpoints
     */
    public static synchronized KicApi getApi(String url) {
        if (mKicApi == null) {

            Interceptor errorInterceptor = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Response response = chain.proceed(chain.request());

                    if (response.code() != Constants.Web.OK_RESPONSE_CODE ) {

                        Log.d(Constants.Web.LOG, response.code() + ": " + response.message());
                        throw new IOException(response.body().string());
                    }

                    return response;
                }
            };

            Interceptor tokenInterceptor = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    //TODO: Set KicApplication.getInstance().getPreference().getToken()
                    if (KicApplication.getInstance().getPreferences().getToken() != null) {

                        Request realRequest = chain.request();
                        Request.Builder requestBuilder = realRequest.newBuilder()
                                .header("Accept", "application/json")
                                .header("Authorization",
                                        KicApplication.getInstance().getPreferences().getToken().getId())
                                .method(realRequest.method(), realRequest.body());

                        Request request = requestBuilder.build();

                        return chain.proceed(request);
                    } else {

                        return chain.proceed(chain.request());
                    }
                }
            };

            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
                    .addInterceptor(errorInterceptor)
                    .addInterceptor(tokenInterceptor)
                    .addInterceptor(loggingInterceptor);

            OkHttpClient client = clientBuilder.build();

            Retrofit retrofit = new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create(
                            KicApplication.getInstance().getGson()))
                    .baseUrl(Constants.Network.API_BASE_URL)
                    .client(client)
                    .build();

            mKicApi = retrofit.create(KicApi.class);
        }
        return mKicApi;
    }
}
