package com.scanner.tle34.wimjo.tle34nfc;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.scanner.tle34.wimjo.tle34nfc.Http.GetScoreTask;
import com.scanner.tle34.wimjo.tle34nfc.Http.ScoreListCallback;
import com.scanner.tle34.wimjo.tle34nfc.Models.Score;

import java.util.ArrayList;

public class Highscore extends AppCompatActivity implements ScoreListCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_highscore);

        setFonts();

        GetScoreTask task = new GetScoreTask();
        task.setCallback(this);
        task.execute();
    }

    @Override
    public void onScoreLoaded(ArrayList<Score> scores) {
        String[] content = new String[scores.size()];

        int  i = 0;
        for(Score score : scores){
            String text = score.name + ": " + String.valueOf(score.score);
            content[i] = text;
            i++;
        }

        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.score_listview, content);

        ListView listView = (ListView) findViewById(R.id.scores_list);
        listView.setAdapter(adapter);
    }

    private void setFonts(){
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/WalterTurncoat.ttf");

        ((TextView)findViewById(R.id.top)).setTypeface(typeface);
    }
}
