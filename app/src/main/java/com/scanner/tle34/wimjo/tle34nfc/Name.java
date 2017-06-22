package com.scanner.tle34.wimjo.tle34nfc;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.scanner.tle34.wimjo.tle34nfc.Http.GetScoreTask;
import com.scanner.tle34.wimjo.tle34nfc.Models.DataHolder;

public class Name extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        setFonts();
    }

    public void lauchGame(View view){
        EditText input = (EditText) findViewById(R.id.name_input);

        String name = input.getText().toString();

        if(name.length() == 0 || name.equals(""))
            return;

        DataHolder.name = name;

        Intent game = new Intent(getBaseContext(), Game.class);
        startActivity(game);
    }

    private void setFonts() {
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/WalterTurncoat.ttf");

        ((TextView) findViewById(R.id.header)).setTypeface(typeface);
        ((TextView) findViewById(R.id.name_input)).setTypeface(typeface);
        ((TextView) findViewById(R.id.start_button)).setTypeface(typeface);
    }

}
