package com.scanner.tle34.wimjo.tle34nfc.Http;

import android.os.AsyncTask;

import com.scanner.tle34.wimjo.tle34nfc.Models.DataHolder;

import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;

/**
 * Created by wim on 21/06/17.
 */

public class PostScoreTask extends AsyncTask<String, Void,  Void> {
    final private String url = "http://tle34.wimjongeneel.nl/api/score.php";

    @Override
    protected Void doInBackground(String... params) {
        String s = params[0];
        try {
            HttpClient client = new DefaultHttpClient();

            HttpPost httpPost = new HttpPost(url);

            ArrayList<NameValuePair> pairs = new ArrayList<NameValuePair>();

            NameValuePair score = new BasicNameValuePair("score", s);
            NameValuePair name = new BasicNameValuePair("name", DataHolder.name);
            NameValuePair level = new BasicNameValuePair("level", "0");

            pairs.add(score);
            pairs.add(name);
            pairs.add(level);

            httpPost.setEntity(new UrlEncodedFormEntity(pairs));

            client.execute(httpPost);

        } catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
