package com.example.android.courtcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;

    int scoreTeamB = 0;

    String winner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        //inflates the menu, this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
        }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //Handle action click here, the action bar will automatically handles click on the
        //home/up button, so long as you specify a parent activity in manifest.xml .
        int id = item.getItemId();

        //non inspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
        }

        public void addFiveForTeamA(View v){
        scoreTeamA= scoreTeamA +5;
        displayForTeamA(scoreTeamA);
        }

        public void addThreeForTeamA(View v){
            scoreTeamA= scoreTeamA +3;
            displayForTeamA(scoreTeamA);
        }

        public void addTwoForTeamA(View v){
            scoreTeamA= scoreTeamA +2;
            displayForTeamA(scoreTeamA);
        }

        public void addFiveForTeamB(View v){
            scoreTeamB= scoreTeamB +5;
            displayForTeamB(scoreTeamB);
        }

        public void addThreeForTeamB(View v){
            scoreTeamB= scoreTeamB +3;
            displayForTeamB(scoreTeamB);
        }

        public void addTwoForTeamB(View v){
            scoreTeamB= scoreTeamB +2;
            displayForTeamB(scoreTeamB);
        }

        /**
         * Resets the scores for both teams when clicked
         */
        public void resetScore(View v) {
            if (scoreTeamA < scoreTeamB) {
                winner = "Team B" ;
            }

            if (scoreTeamB < scoreTeamA) {
                winner = "Team A" ;
            }

            if (scoreTeamA == scoreTeamB) {
                winner = "draw game" ;
            }
            scoreTeamA = 0;
            scoreTeamB = 0;
            displayForTeamA(scoreTeamA);
            displayForTeamB(scoreTeamB);
            Toast.makeText (this, "The winner is: " + winner , Toast.LENGTH_LONG).show();
            Toast.makeText (this, "Thanks for keeping track of the scores, the scores have been saved; kindly take another play." , Toast.LENGTH_LONG).show();
        }


        /**
         * Displays the given score for Team A.
         */
        public void displayForTeamA(int score) {
            TextView scoreView= (TextView) findViewById(R.id.team_a_score);
            scoreView.setText(String.valueOf(score)) ;
        }


        /**
         * Displays the given score for Team B.
         */
        public void displayForTeamB(int score) {
            TextView scoreView= (TextView) findViewById(R.id.team_b_score);
            scoreView.setText(String.valueOf(score)) ;
        }
    }
