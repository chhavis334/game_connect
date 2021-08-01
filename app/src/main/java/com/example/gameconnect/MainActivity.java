package com.example.gameconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
int activeplayer = 0;
ImageView counter;
int [] gamestate = {2,2,2,2,2,2,2,2,2};
int [][] winings = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void dropin(View view) {
        ImageView counter = (ImageView) view;
        counter.setTranslationY(-1500);
        counter.setImageResource(R.drawable.blue);
        counter.animate().translationYBy(1500).rotation(3600).setDuration(1000);
        int  tappedCounter = Integer.parseInt(counter.getTag().toString());
        gamestate[tappedCounter] = activeplayer;
        for(int[] position : winings){
            if ((gamestate[position[0]] == gamestate[position[1]]) && (gamestate[position[1]] == gamestate[position[2]]) && (gamestate[position[0]] != 2)){
                if(activeplayer ==1){
                    Toast.makeText(getApplicationContext(),"BLUE WON",Toast.LENGTH_SHORT ).show();
                }
                else{
                    Toast.makeText(this, "GREEN WON", Toast.LENGTH_SHORT).show();
                }
            }
        }
        if(activeplayer == 0){
            counter.setImageResource(R.drawable.blue);
            activeplayer = 1;
        }
        else{
            counter.setImageResource(R.drawable.green);
            activeplayer = 0;
        }
    }
}