package com.example.connect3;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GridHandler implements View.OnClickListener {
    private int maxMoves;
    private int moveNumber;
    private int rows, cols;
    private ImageView holder;
    private GameHandler gameHandler = null;
    private int winningPlayer;
    private TextView winningDisplay;

    public GridHandler(int maxMoves, int rows, int cols, TextView winningDisplay){
        this.maxMoves = maxMoves;
        moveNumber = 0;
        gameHandler = new GameHandler(rows, cols);
        this.rows = rows;
        this.cols = cols;
        this.winningDisplay = winningDisplay;
        winningDisplay.setText("HELLO!");

    }

    @Override
    public void onClick(View v) {
        Log.i("Button : ", v.getTag() + "");
        setElement(v);
        v.setOnClickListener(null);
    }

    public void setElement(View v){
        if(moveNumber < maxMoves){
            holder = (ImageView) v;
            int playerNumber = 0;
            if(moveNumber % 2 == 0){
                playerNumber = 1;
            }else{
                playerNumber = 2;
            }
            gameHandler.setPosition((int) v.getTag(),playerNumber);
            if(playerNumber == 1){
                holder.setImageResource(R.drawable.player_one);
            }else{
                holder.setImageResource(R.drawable.player_two);
            }
            holder.setAlpha(1f);

            holder.animate().alpha(1).setDuration(500);
            moveNumber++;

            winningPlayer = gameHandler.checkVictory();
            if(winningPlayer != 0){
                Log.i("Game", "won");
                String value = "";
                if(winningPlayer == 1){
                    value = "RED";
                }else{
                    value = "BLUE";
                }
                winningDisplay.setText("Player " + winningPlayer + " (" + value + ") " + "has won the game!");
            }

        }
    }



}
