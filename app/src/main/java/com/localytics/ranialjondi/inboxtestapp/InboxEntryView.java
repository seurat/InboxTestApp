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
    ImageView thumbnail = (ImageView) findViewById(R.id.thumbnail);

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

    protected Inbox email;

    public InboxEntryView(ViewGroup parent) {
        this(parent.getContext(), null);

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


    public void setData(Inbox email) {
        this.email = email;
        mImageLoader = ImageLoader.getInstance();
        mImageLoader.init(config);
        setTitle();
        setSummary();
        setThumbnail();

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
        thumbnail = (ImageView) findViewById(R.id.thumbnail);
        mImageLoader.displayImage(email.getThumbnailLocation(), thumbnail);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            default:
        }
    }

}
