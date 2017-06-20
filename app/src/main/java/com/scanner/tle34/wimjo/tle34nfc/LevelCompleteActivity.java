package com.scanner.tle34.wimjo.tle34nfc;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class LevelCompleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_level_complete);

        playSound(R.raw.level_complete);

        setFonts();

        Intent intent = getIntent();
        showScore(intent.getIntExtra("SCORE", 1));

    }

    private void showScore(int score){
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
