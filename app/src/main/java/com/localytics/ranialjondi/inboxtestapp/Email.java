package com.localytics.ranialjondi.inboxtestapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by ranialjondi on 5/20/17.
 */
class Email  {

    @SerializedName("rule_name")
    @Expose
    private String ruleName;

    @SerializedName("listing_title")
    @Expose
    private String listingTitle;

    @SerializedName("listing_summary")
    @Expose
    private String listingSummary;

    @SerializedName("thumbnail_location")
    @Expose
    private String thumbnailLocation;

    @SerializedName("start_time")
    @Expose
    private String startTime;

    @SerializedName("expiration")
    @Expose
    private String expiration;

    @SerializedName("version")
    @Expose
    private String version;

    @SerializedName("campaign_id")
    @Expose
    private String campaignId;

    @SerializedName("sort_order")
    @Expose
    private String sortOrder;


    Email(String ruleName, String listingTitle, String listingSummary, String thumbnailURI) {
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

}
