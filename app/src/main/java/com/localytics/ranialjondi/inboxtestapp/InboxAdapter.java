package com.localytics.ranialjondi.inboxtestapp;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

public class InboxAdapter
        extends
        RecyclerView.Adapter<InboxAdapter.ViewHolder>  {

    //if it looks like we are going to re-use this adapter, make an interface to send cart changes
    // up to the fragment for updating the other elements of the display
    private ArrayList<Email> emails;

    public InboxAdapter(ArrayList<Email> emails) {
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
        Email email = emails.get(position);
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
            itemView = itemLayoutView;
        }

        public void setSearchResult(Email email) {
            itemView.setData(email);

        }
    }
}
