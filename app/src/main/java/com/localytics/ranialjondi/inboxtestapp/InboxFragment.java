package com.localytics.ranialjondi.inboxtestapp;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.*;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by ranialjondi on 5/20/17.
 */

public class InboxFragment extends Fragment {
    View mView;
    private RecyclerView inboxRecyclerView;
    private JSONArray mJsonData;
    private LinearLayoutManager layoutManager;
    private InboxAdapter inboxAdapter;
    private ArrayList<Email> emailList;
    public static String FRAGMENT_TAG = "InboxFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_inbox, container, false);
        emailList = new ArrayList<>();
        inboxRecyclerView = (RecyclerView) mView.findViewById(R.id.rv_inbox);
        //mJsonData = ((MainActivity) getActivity()).getJsonData();

        getInboxOther();


        return mView;
    }

    private void initInbox() {
        try {

        int length = mJsonData.length();
        if (length > 0) {
            String ruleName;
            String listingTitle;
            String listingSummary;
            String thumbnailLocation;

            for (int i = 0; i < length; i++) {
                JSONObject inboxItem = mJsonData.getJSONObject(i);

                if(inboxItem.has("rule_name"))
                    ruleName = inboxItem.getString("rule_name") != JSONObject.NULL ?
                        inboxItem.getString("rule_name") :
                        "";
                else ruleName = "";

                if(inboxItem.has("listing_title"))
                    listingTitle = inboxItem.getString("listing_title") != JSONObject.NULL ?
                        inboxItem.getString("listing_title") :
                        "";
                else listingTitle = "";

                if(inboxItem.has("listing_summary"))
                     listingSummary = inboxItem.getString("listing_summary") != JSONObject.NULL ?
                        inboxItem.getString("listing_summary") :
                        "";
                else listingSummary = "";

                if(inboxItem.has("thumbnail_location"))
                    thumbnailLocation = inboxItem.getString("thumbnail_location") != JSONObject.NULL ?
                            inboxItem.getString("thumbnail_location") :
                            "";
                else thumbnailLocation = "";



                emailList.add(new Email(ruleName, listingTitle, listingSummary, thumbnailLocation));
            }
        }
        }catch (JSONException je) {
                je.printStackTrace();
            }
            catch(Exception e) {
                e.printStackTrace();

            }


        layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        inboxRecyclerView.setLayoutManager(layoutManager);
        inboxAdapter = new InboxAdapter(emailList);
        inboxRecyclerView.setAdapter(inboxAdapter);

    }

    public void getInboxOther() {


        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);


        Call<Inboxes> call = apiService.getInboxOther();

        call.enqueue(new Callback<Inboxes>() {
            @Override
            public void onResponse(Call<Inboxes> call, Response<Inboxes> response) {
                Log.d("Call request", call.request().toString());
                Log.d("Call request header", call.request().headers().toString());
                Log.d("Response raw header", response.headers().toString());
                Log.d("Response raw", String.valueOf(response.raw().body()));
                Log.d("Response code", String.valueOf(response.code()));

                // clear the inbox
                emailList.clear();
                if(!response.isSuccessful()) {
                    Log.e("Inbox", "why not");
                }
                List<Email> emails = response.body().getEmails();
                // the loop was performed to add colors to each message
                for (Email email : emails) {
                    // generate a random color
                    emailList.add(email);
                }

                inboxAdapter = new InboxAdapter(emailList);
                inboxAdapter.notifyDataSetChanged();
                layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
                inboxRecyclerView.setLayoutManager(layoutManager);
                inboxRecyclerView.setAdapter(inboxAdapter);

            }

            @Override
            public void onFailure(Call<Inboxes> call, Throwable t) {
                Log.e("Inboxes", "Couldn't get json " +  t.getMessage());
                Toast.makeText(mView.getContext(), "Unable to fetch json: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }



    public static InboxFragment newInstance() {
        return new InboxFragment();
    }

    public InboxFragment() {
        super();
    }




}
