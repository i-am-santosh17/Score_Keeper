package com.example.scorekeeper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int mscore1 = 0;
    private int mscore2 = 0;
    private TextView mscoreTextView1;
    private TextView mscoreTextview2;
    static final String STATE_SCORE_1 = "Team 1 Score";
    static final String STATE_SCORE_2 = "Team 2 Score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mscoreTextView1 = findViewById(R.id.score1);
        mscoreTextview2 = findViewById(R.id.score2);
        if (savedInstanceState != null) {
            mscore1 = savedInstanceState.getInt(STATE_SCORE_1);
            mscore2 = savedInstanceState.getInt(STATE_SCORE_2);

            //Set the score text views
            mscoreTextView1.setText(String.valueOf(mscore1));
            mscoreTextview2.setText(String.valueOf(mscore2));
        }
    }

    public void decreaseteam2(View view) {
        mscore2--;
        String m = Integer.toString(mscore2);
        mscoreTextview2.setText(m);
    }

    public void increaseteam2(View view) {
        mscore2++;
        String m = Integer.toString(mscore2);
        mscoreTextview2.setText(m);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        // Change the label of the menu based on the state of the app.
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    public void decreaseteam1(View view) {
        mscore1--;
        String m = Integer.toString(mscore1);
        mscoreTextView1.setText(m);
    }

    public void increaseteam1(View view) {
        mscore1++;
        String m = Integer.toString(mscore1);
        mscoreTextView1.setText(m);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Check if the correct item was clicked
        if (item.getItemId() == R.id.night_mode) {
        }
        // TODO: Get the night mode state of the app.
        if (item.getItemId() == R.id.night_mode) {
            // Get the night mode state of the app.
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            //Set the theme mode for the restarted activity
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode
                        (AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode
                        (AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
        }

        return true;
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        // Save the scores.
        outState.putInt(STATE_SCORE_1, mscore1);
        outState.putInt(STATE_SCORE_2, mscore2);
        super.onSaveInstanceState(outState);
    }
}
