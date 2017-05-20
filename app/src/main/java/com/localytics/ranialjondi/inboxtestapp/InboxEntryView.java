package com.localytics.ranialjondi.inboxtestapp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;


public class InboxEntryView
        extends
        LinearLayout
        implements
        //GestureDetector.OnGestureListener,
        View.OnClickListener {

    private static final String TAG = "InboxEntryView";
    private ImageLoader mImageLoader;
    ImageView thumbnail = (ImageView) ((MainActivity) getContext()).findViewById(R.id.thumbnail);

    DisplayImageOptions displayOptions = new DisplayImageOptions.Builder()
            .showImageOnLoading(R.drawable.icon_portrait_lg)
            .showImageForEmptyUri(R.drawable.icon_portrait_lg)
            .showImageOnFail(R.drawable.icon_portrait_lg)
            .cacheInMemory(true)
            .cacheOnDisc(false)
            .considerExifParams(true)
            .build();

    ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder((MainActivity)getContext())
            .writeDebugLogs()
            .defaultDisplayImageOptions(displayOptions)
            .build();

    protected Email email;

    //private GestureDetectorCompat gestureDetector;
    //        boolean hasDisallowed = false;


    public InboxEntryView(ViewGroup parent) {
        this(parent.getContext(), null);
        mImageLoader = ImageLoader.getInstance();
        mImageLoader.init(config);
    }

    public InboxEntryView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public InboxEntryView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        load();
    }

    protected void load() {
        //gestureDetector = new GestureDetectorCompat(getContext(), this);

    }


    public void setData(Email email) {
        this.email = email;
        setName();
        setTitle();
        setSummary();
        setThumbnail();

    }

    private void setName() {
        TextView nameText = (TextView) findViewById(R.id.rule_name);
        nameText.setText(email.getRuleName());

    }

    private void setTitle() {
        TextView nameText = (TextView) findViewById(R.id.listing_title);
        nameText.setText(email.getListingTitle());

    }

    private void setSummary() {
        TextView nameText = (TextView) findViewById(R.id.listing_summary);
        nameText.setText(email.getListingSummary());

    }

    private void setThumbnail() {
        thumbnail = (ImageView) ((MainActivity) getContext()).findViewById(R.id.thumbnail);
        mImageLoader.displayImage(email.getThumbnailURI(), thumbnail);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            default:
        }
    }

}
