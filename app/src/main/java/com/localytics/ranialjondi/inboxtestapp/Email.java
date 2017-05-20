package com.localytics.ranialjondi.inboxtestapp;

/**
 * Created by ranialjondi on 5/20/17.
 */

class Email {

    private String ruleName;
    private String listingTitle;
    private String listingSummary;
    private String thumbnailURI;

    Email(String ruleName, String listingTitle, String listingSummary, String thumbnailURI) {
        this.ruleName = ruleName;
        this.listingTitle = listingTitle;
        this.listingSummary = listingSummary;
        this.thumbnailURI = thumbnailURI;
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

    public String getThumbnailURI() { return thumbnailURI; }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public void setListingTitle(String listingTitle) {
        this.listingTitle = listingTitle;
    }

    public void setListingSummary(String listingSummary) {
        this.listingSummary = listingSummary;
    }

    public void setThumbnailURI(String thumbnailURI) {
        this.thumbnailURI = thumbnailURI;
    }


}
