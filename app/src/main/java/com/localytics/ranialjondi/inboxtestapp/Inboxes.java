package com.localytics.ranialjondi.inboxtestapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ranialjondi on 5/20/17.
 */

public class Inboxes {

    @SerializedName("inboxes")
    private List<Inbox> emails;

    public List<Inbox> getEmails() {
        return emails;
    }

    public void setEmails(List<Inbox> emails) {
        this.emails = emails;
    }


}
