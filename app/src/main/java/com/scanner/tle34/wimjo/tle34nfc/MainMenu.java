package com.scanner.tle34.wimjo.tle34nfc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void toHighScore(View v){
        Intent highscore = new Intent(getBaseContext(), Highscore.class);
        startActivity(highscore);
    }

    public void toExplanation (View v) {
        Intent exp = new Intent(getBaseContext(), Explanation.class);
        startActivity(exp);
    }

    public void toGame (View v) {
        Intent game = new Intent(getBaseContext(), Game.class);
        startActivity(game);
    }




}
