package com.localytics.ranialjondi.inboxtestapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ranialjondi on 5/20/17.
 */

public interface ApiInterface {
    @GET("inbox.JSON")
    Call<Inboxes> getInboxOther();
}
