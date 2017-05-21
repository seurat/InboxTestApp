package com.localytics.ranialjondi.inboxtestapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by ranialjondi on 5/20/17.
 */
class Inbox {

    @SerializedName("rule_name")
    private String ruleName;

    @SerializedName("listing_title")
    private String listingTitle;

    @SerializedName("listing_summary")
    private String listingSummary;

    @SerializedName("thumbnail_location")
    private String thumbnailLocation;

    Inbox(String ruleName, String listingTitle, String listingSummary, String thumbnailURI) {
        this.ruleName = ruleName;
        this.listingTitle = listingTitle;
        this.listingSummary = listingSummary;
        this.thumbnailLocation = thumbnailLocation;
    }

    public String getRuleName() {
        return ruleName;
    }

    public String getListingTitle() {
        return listingTitle;
    }

    public String getListingSummary() {
        return listingSummary;
    }

    public String getThumbnailLocation() { return thumbnailLocation; }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public void setListingTitle(String listingTitle) {
        this.listingTitle = listingTitle;
    }

    public void setListingSummary(String listingSummary) {
        this.listingSummary = listingSummary;
    }

    public void setThumbnailLocation(String thumbnailLocation) {
        this.thumbnailLocation = thumbnailLocation;
    }

}
