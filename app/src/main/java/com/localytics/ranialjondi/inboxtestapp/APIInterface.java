package com.localytics.ranialjondi.inboxtestapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ranialjondi on 5/20/17.
 */

public interface APIInterface {
    @GET("inboxes.JSON")
    Call<List<Email>> getInbox();
}
