package com.example.connect3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private GridLayout grid;
    private ImageView[][] gameHolder;
    private Integer[] idList;
    private ImageView pieceHolder;
    private Integer rows = 3, cols  = 3;
    private Button resetButton;
    private TextView victoryDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        victoryDisplay = (TextView) findViewById(R.id.victoryDisplay);

        resetButton = findViewById(R.id.resetButton);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGrid();
            }
        });



        resetGrid();

    }

    private void resetGrid(){
        victoryDisplay.setText("");
        idList = new Integer[]{//Get the list of ids for all the imageViews available
                (Integer)R.id.position00,
                (Integer)R.id.position01,
                (Integer)R.id.position02,
                (Integer)R.id.position10,
                (Integer)R.id.position11,
                (Integer)R.id.position12,
                (Integer)R.id.position20,
                (Integer)R.id.position21,
                (Integer)R.id.position22
        };

        gameHolder = new ImageView[rows][cols];//Create a new imageView array in order to hold the different imageViews

        Log.d("Game Holder ", "Rows = " + gameHolder.length);
        Log.d("Game Holder ", "Rows = " + gameHolder[0].length);

        for(int i = 0; i < gameHolder.length; i++){
            for(int j = 0; j < gameHolder[0].length;j++){
                gameHolder[i][j] = findViewById(idList[(i*cols) + j]);
            }
        }

        for(int i = 0; i < gameHolder.length; i++){
            for(int j = 0; j < gameHolder[0].length;j++){
                gameHolder[i][j].setTag((i*cols) + j);
            }
        }

        GridHandler handler = new GridHandler(9,3,3, victoryDisplay);
        for(int i = 0; i < gameHolder.length; i++){
            for(int j = 0; j < gameHolder[0].length;j++){
                gameHolder[i][j].setOnClickListener(handler);
            }
        }

        if(gameHolder != null){
            for(int i = 0; i < gameHolder.length; i++){
                for(int j = 0; j < gameHolder[0].length; j++){
                    gameHolder[i][j].setImageResource(R.drawable.player_one);
                    gameHolder[i][j].setAlpha(0f);
                }
            }
        }else{
            throw new NullPointerException("Cannot use this method until grid is set up");
        }
    }
}
