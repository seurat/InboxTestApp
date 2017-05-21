package com.localytics.ranialjondi.inboxtestapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.localytics.android.Localytics;

import java.util.ArrayList;

public class InboxAdapter
        extends
        RecyclerView.Adapter<InboxAdapter.ViewHolder>  {

    //if it looks like we are going to re-use this adapter, make an interface to send cart changes
    // up to the fragment for updating the other elements of the display
    private ArrayList<Inbox> emails;

    public InboxAdapter(ArrayList<Inbox> emails) {
        this.emails = emails;
    }

    @Override
    public InboxAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            InboxEntryView view = (InboxEntryView) LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.view_inbox_item, parent, false);
            return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Inbox email = emails.get(position);
        viewHolder.setSearchResult(email);

    }

    @Override
    public int getItemCount() {
        return emails.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public InboxEntryView itemView;

        public ViewHolder(InboxEntryView itemLayoutView) {
            super(itemLayoutView);
            Localytics.tagEvent("Inbox item displayed.");
            itemView = itemLayoutView;
        }

        public void setSearchResult(Inbox email) {
            itemView.setData(email);

        }
    }
}
