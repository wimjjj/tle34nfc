package com.scanner.tle34.wimjo.tle34nfc.Http;

import com.scanner.tle34.wimjo.tle34nfc.Models.Score;

import java.util.ArrayList;

/**
 * Created by wim on 21/06/17.
 */

public interface ScoreListCallback {
    public void onScoreLoaded(ArrayList<Score> scores);
}
