package com.localytics.ranialjondi.inboxtestapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.localytics.android.Localytics;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    protected JSONArray jsonData;
    public String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.inbox_container,
                        InboxFragment.newInstance(),
                        InboxFragment.FRAGMENT_TAG)
                .addToBackStack(InboxFragment.FRAGMENT_TAG)
                .commit();

    }

    public JSONArray getJsonData() {
        return jsonData;
    }

    @Override
    protected void onResume()
    {
        super.onResume();

        Localytics.onActivityResume(this);
    }

    @Override
    protected void onPause()
    {
        super.onPause();

        Localytics.onActivityPause(this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);

        Localytics.onNewIntent(this, intent);
    }

    @Override
    public void onBackPressed() {
        moveTaskToBack(true);
    }


}
