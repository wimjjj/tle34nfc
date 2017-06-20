package com.scanner.tle34.wimjo.tle34nfc;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main_menu);

        setFonts();
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


    private void setFonts() {
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/WalterTurncoat.ttf");

        ((TextView) findViewById(R.id.msg)).setTypeface(typeface);
        ((TextView) findViewById(R.id.game_button)).setTypeface(typeface);
        ((TextView) findViewById(R.id.highscore_button)).setTypeface(typeface);
        ((TextView) findViewById(R.id.explanation_button)).setTypeface(typeface);
    }

}
