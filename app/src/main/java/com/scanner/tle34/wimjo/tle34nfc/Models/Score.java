package com.scanner.tle34.wimjo.tle34nfc.Models;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by wim on 21/06/17.
 */

public class Score {
    public int score;
    public String name;
    public int level;

    public Score(int score, String name, int level){
        this.score = score;
        this.name = name;
        this.level = level;
    }

    public Score(JSONObject jsonString){
        try {
            score = jsonString.getInt("score");
            name = jsonString.getString("name");
            level = jsonString.getInt("level");
        } catch (JSONException e){
            e.printStackTrace();
        }
    }
}
