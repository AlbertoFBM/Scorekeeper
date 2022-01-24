package com.aserrano.scorekeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String STATE_SCORE_1 = "Team 1 Score";
    private static final String STATE_SCORE_2 = "Team 2 Score";

    TextView scoreTeam1, scoreTeam2;
    int score1, score2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scoreTeam1 = findViewById(R.id.scoreTeam1);
        scoreTeam2 = findViewById(R.id.scoreTeam2);

        if(savedInstanceState != null){
            score1 = savedInstanceState.getInt(STATE_SCORE_1);
            score2 = savedInstanceState.getInt(STATE_SCORE_2);

            scoreTeam1.setText(String.valueOf(score1));
            scoreTeam2.setText(String.valueOf(score2));
        }
    }

    public void increaseScore(View view){

        switch (view.getId()){
            case R.id.plusTeam1:
                score1++;
                scoreTeam1.setText(String.valueOf(score1));
                break;
            case R.id.plusTeam2:
                score2++;
                scoreTeam2.setText(String.valueOf(score2));
                break;
        }
    }

    public void decreaseScore(View view){

        switch(view.getId()){
            case R.id.minusTeam1:
                score1--;
                scoreTeam1.setText(String.valueOf(score1));
                break;
            case R.id.minusTeam2:
                score2--;
                scoreTeam2.setText(String.valueOf(score2));
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main_menu, menu);

        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){

            menu.findItem(R.id.nightMode).setTitle(R.string.day_mode);

        }else{
            menu.findItem(R.id.nightMode).setTitle(R.string.night_mode);
        }

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId() == R.id.nightMode){
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){

                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);

            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {

        outState.putInt(STATE_SCORE_1, score1);
        outState.putInt(STATE_SCORE_2, score2);

        super.onSaveInstanceState(outState);
    }
}