package com.scanner.tle34.wimjo.tle34nfc;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LevelCompleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_complete);
        playSound(R.raw.level_complete);

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
}
