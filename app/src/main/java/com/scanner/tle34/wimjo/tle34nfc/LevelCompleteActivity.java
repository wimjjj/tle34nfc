package com.scanner.tle34.wimjo.tle34nfc;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.scanner.tle34.wimjo.tle34nfc.Http.PostScoreTask;

public class LevelCompleteActivity extends AppCompatActivity {

    private int score = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_level_complete);

        playSound(R.raw.level_complete);

        setFonts();

        Intent intent = getIntent();

        score = intent.getIntExtra("SCORE", 1);

        drawScore();

        new PostScoreTask().execute(String.valueOf(score));
    }

    private void drawScore(){
        ((TextView) findViewById(R.id.score)).setText(String.valueOf(score));
    }

    private void playSound(int id){
        MediaPlayer.create(getApplicationContext(), id).start();
    }

    public void toMainMenu(View v){
        finish();
    }

    public void toHighScore(View v){
        Intent highscore = new Intent(getBaseContext(), Highscore.class);
        startActivity(highscore);
        finish();
    }

    private void setFonts() {
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/WalterTurncoat.ttf");

        ((TextView) findViewById(R.id.score)).setTypeface(typeface);
        ((TextView) findViewById(R.id.msg)).setTypeface(typeface);
    }
}
