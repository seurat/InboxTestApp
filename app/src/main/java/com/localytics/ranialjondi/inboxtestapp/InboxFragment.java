package com.localytics.ranialjondi.inboxtestapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
    private LinearLayoutManager layoutManager;
    private InboxAdapter inboxAdapter;
    private ArrayList<Inbox> emailList;
    public static String FRAGMENT_TAG = "InboxFragment";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_inbox, container, false);
        emailList = new ArrayList<>();
        inboxRecyclerView = (RecyclerView) mView.findViewById(R.id.rv_inbox);
        getInboxOther();

        return mView;
    }

    public void getInboxOther() {


        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);


        Call<Inboxes> call = apiService.getInboxOther();

        call.enqueue(new Callback<Inboxes>() {
            @Override
            public void onResponse(Call<Inboxes> call, Response<Inboxes> response) {

                emailList.clear();
                if(!response.isSuccessful()) {
                    Log.e("Inbox", "why not");
                }
                List<Inbox> emails = response.body().getEmails();
                for (Inbox email : emails) {
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
