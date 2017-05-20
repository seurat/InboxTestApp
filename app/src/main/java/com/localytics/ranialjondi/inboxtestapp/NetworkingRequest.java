package com.localytics.ranialjondi.inboxtestapp;

import android.os.Debug;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ranialjondi on 5/20/17.
 */

public class NetworkingRequest {
    public final String TAG = "NetworkingRequest";

    /**
     * Create http GET request to an instagram api endpoint.
     *
     * @param requestUri Api url
     *
     * @return Api response in json format.
     *
     * @throws Exception If error occured.
     */

    public String get(String requestUri) throws Exception {
        InputStream stream 	= null;
        URL url = new URL(requestUri);
        HttpURLConnection connection = null;
        String result = "";
        try {

            Log.i(TAG, requestUri);

            connection = (HttpURLConnection) url.openConnection();

            connection.setReadTimeout(5000);

            connection.setConnectTimeout(5000);

            connection.setRequestMethod("GET");

            connection.connect();

            int responseCode = connection.getResponseCode();

            if(responseCode != HttpURLConnection.HTTP_OK) {
                throw new IOException(TAG+"HTTP error code: " + responseCode);
            }

            stream = connection.getInputStream();

            if(stream!=null) {
                result = streamToString(stream);
            }

        } catch (Exception e) {
            throw e;
        } finally {
            if(stream != null) {
                //remember to close IO sources;
                stream.close();
            }
            if (connection != null) {
                connection.disconnect();
            }
        }

        return result;
    }

    public String streamToString(InputStream is) throws IOException {
        String str  = "";

        if (is != null) {
            StringBuilder sb = new StringBuilder();
            String line;

            try {
                BufferedReader reader 	= new BufferedReader(new InputStreamReader(is));

                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                    Log.e(TAG,line);
                }

                reader.close();
            } finally {
                is.close();
            }

            str = sb.toString();
        }

        return str;
    }


    /**
     * Converts the contents of an InputStream to a String.
     *
     * Code sourced from Android Developers website
     *
     * https://developer.android.com/training/basics/network-ops/connecting.html
     *
     */
    private  String readStream(InputStream stream) throws IOException {
        String result = null;
        int readLength = 500;
        InputStreamReader reader = new InputStreamReader(stream, "UTF-8");
        char[] buffer = new char[500];
        int numChars = 0;
        int readSize = 0;
        while (readSize != -1) {
            numChars += readSize;
            int pct = (100 * numChars) / readLength;
            readSize = reader.read(buffer, numChars, buffer.length - numChars);
            if (numChars != -1) {
                numChars = Math.min(numChars, readLength);
                result += new String(buffer, 0, numChars);
                System.out.println(result);
            }
        }
        return result;
    }


}
