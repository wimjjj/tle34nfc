package com.scanner.tle34.wimjo.tle34nfc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Highscore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_highscore);
    }
}
