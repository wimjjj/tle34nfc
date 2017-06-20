package com.scanner.tle34.wimjo.tle34nfc;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Explanation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_explanation);
    }

    private void setFonts() {
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/WalterTurncoat.ttf");

        ((TextView) findViewById(R.id.title)).setTypeface(typeface);
        ((TextView) findViewById(R.id.exp_text)).setTypeface(typeface);
        ((TextView) findViewById(R.id.explanation_button)).setTypeface(typeface);
    }

    public void toMenu (View v) {
       finish();
    }
}
