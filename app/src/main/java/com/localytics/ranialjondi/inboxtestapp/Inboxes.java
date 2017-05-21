package com.localytics.ranialjondi.inboxtestapp;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by ranialjondi on 5/20/17.
 */

public class Inboxes {

    @SerializedName("inboxes")
    private List<Email> emails;

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }


}
