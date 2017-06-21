package com.scanner.tle34.wimjo.tle34nfc.Http;

import android.os.AsyncTask;
import android.util.Log;

import com.scanner.tle34.wimjo.tle34nfc.Models.Score;

import java.io.InputStream;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by wim on 21/06/17.
 */

public class GetScoreTask extends AsyncTask<Void, Void, ArrayList<Score>> {

    final String url = "http://tle34.wimjongeneel.nl/api/topscore.php?level=0&limit=5";
    private ScoreListCallback callback = null;


    public void setCallback(ScoreListCallback callback){
        this.callback = callback;
    }

    @Override
    protected ArrayList<Score> doInBackground(Void... params) {
        InputStream inputStream = null;
        String result = "";

        try {
            HttpClient httpclient = new DefaultHttpClient();
            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));
            inputStream = httpResponse.getEntity().getContent();

            if (inputStream != null)
                result = HttpHelpers.convertInputStreamToString(inputStream);
            else
                Log.d(this.getClass().getName(), "inputstream == null");

        } catch (Exception e) {
            Log.d(this.getClass().getName(), e.getLocalizedMessage());
        }

        String[] jsonStrings = strings(result);

        ArrayList<Score> scores = new ArrayList<Score>();

        for(String s : jsonStrings){
            try {
                JSONObject jsonObject = new JSONObject(s);
                scores.add(new Score(jsonObject));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        return scores;
    }

    protected void onPostExecute(ArrayList<Score> scores){
        if(callback != null){
            callback.onScoreLoaded(scores);
        } else {
            Log.i(this.getClass().getSimpleName(), "no callback");
        }
    }

    private String[] strings(String s){
        String[] strings = s.split("\\[");
        s = strings[1];

        strings = s.split("\\]");
        s = strings[0];

        strings =  s.split("\\},");

        for(int i = 0; i < strings.length; i++){
            strings[i] += "}";
        }

        return strings;
    }
}
