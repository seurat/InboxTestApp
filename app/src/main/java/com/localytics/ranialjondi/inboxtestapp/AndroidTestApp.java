package com.localytics.ranialjondi.inboxtestapp;
import android.app.Application;

import com.localytics.android.*;

import java.util.Map;

/**
 * Created by ranialjondi on 5/20/17.
 */

public class AndroidTestApp extends Application {

    @Override
    public void onCreate()
    {
        super.onCreate();

        Localytics.integrate(this);
    }





}
