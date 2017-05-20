package com.localytics.ranialjondi.inboxtestapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    protected String testAppKey = "612e9800bb0be3e350102e5-39e59fa6-3cd1-11e7-3a27-007aaba25c2c";
    protected String endpointURL = "https://s3.amazonaws.com/public.localytics/challenge/inbox.JSON";
    protected JSONArray jsonData;
    protected ArrayList<Email> mEmailList = new ArrayList<>();
    protected DownloadTask downloadTask;
    public String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        downloadTask = new DownloadTask();
        downloadTask.execute();

    }

    public JSONArray getJsonData() {
        return jsonData;
    }

    public class DownloadTask extends AsyncTask<URL, Integer, Long> {
        ArrayList<Email> emailList = new ArrayList<>();

        protected void onCancelled() {

        }

        protected void onPreExecute() {

        }

        protected Long doInBackground(URL... urls) {
            long result = 0;

            try {
                NetworkingRequest request = new NetworkingRequest();
                String response = request.get(endpointURL);


                if (!response.equals("")) {
                    JSONObject jsonObj = (JSONObject) new JSONTokener(response).nextValue();
                    jsonData = jsonObj.getJSONArray("inboxes");
                    Log.e(TAG, ""+jsonData.length());
                }

            }
            catch (JSONException je) {
                je.printStackTrace();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
            return result;
        }

        protected void onProgressUpdate(Integer... progress) {
        }

        protected void onPostExecute(Long result) {
            //mLoadingPb.setVisibility(View.GONE);
            if (emailList.isEmpty()) {
                Toast.makeText(getApplicationContext(), "No Emails Available", Toast.LENGTH_LONG).show();
            } else {
                mEmailList = emailList;
            }

            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.inbox_container,
                            InboxFragment.newInstance(),
                            InboxFragment.FRAGMENT_TAG)
                    .addToBackStack(InboxFragment.FRAGMENT_TAG)
                    .commit();

        }
    }

}
