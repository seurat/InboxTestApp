package com.localytics.ranialjondi.inboxtestapp;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ranialjondi on 5/20/17.
 */

public class APIClient {

        public static final String BASE_URL = "https://s3.amazonaws.com/public.localytics/challenge/inbox.JSON";
        private static Retrofit retrofit = null;

        public static Retrofit getClient() {
            if (retrofit == null) {
                retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            return retrofit;
        }

}
