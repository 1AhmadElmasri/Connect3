package com.example.connect3;

import android.util.Log;

public class GameHandler {
    private int rows;
    private int cols;
    private int[][] positionsSelected;
    private final int NO_PLAYER = 0, PLAYER_ONE = 1, PLAYER_TWO = 2;

    public GameHandler(int rows, int cols){
        positionsSelected = new int[rows][cols];
        this.rows = rows;
        this.cols = cols;
    }

    public void setPosition(int pos, int val){
        positionsSelected[(int)(pos / 3)][pos%3] = val;
        displayGame();
    }

    public int checkVictory(){
        boolean gameWon = false;
        boolean valid = false;
        int winningPlayer = 0;

        //Check the Horizontals
        for(int i = 0; i < positionsSelected.length;i++){
            valid = true;
            if(!gameWon){
                for(int j = 0; j < positionsSelected[0].length; j++){
                    if(positionsSelected[i][j] != positionsSelected[i][0] || positionsSelected[i][j] == 0){
                        valid = false;
                    }
                    if(j == 2){
                        if(valid){
                            Log.i("a","fuck" + positionsSelected[i][0]);
                            gameWon = true;
                            winningPlayer = positionsSelected[i][0];
                        }
                    }
                }

            }

        }

        //Check the Verticals
        for(int j = 0; j < positionsSelected[0].length; j++){
            valid = true;
            if(!gameWon) {
                for (int i = 0; i < positionsSelected.length; i++) {
                        if (positionsSelected[i][j] == 0 || (positionsSelected[i][j] != positionsSelected[0][j])) {
                            valid = false;
                        }

                        if(i == 2){
                            if(valid){
                                Log.i("a","fuck" + positionsSelected[0][j]);
                                gameWon = true;
                                winningPlayer = positionsSelected[0][j];

                            }
                        }
                }

            }
        }


        //Check Diagonals


        if(!gameWon){
            valid = true;
            for (int i = 0,  j = 0; i < positionsSelected.length; i++, j++){
                    if (positionsSelected[i][j] == 0 || (positionsSelected[i][j] != positionsSelected[0][0])) {
                        Log.i("a", "fuck" + i + j);
                        valid = false;
                    }
            }
            if (valid) {
                Log.i("a", "fuck" + positionsSelected[0][0]);
                gameWon = true;
                winningPlayer = positionsSelected[0][0];

            }
        }

      if(!gameWon){
            valid = true;
            for (int i = positionsSelected.length - 1,  j = 0; i >= 0 ; i--, j++){
                    if (positionsSelected[i][j] == 0 || (positionsSelected[i][j] != positionsSelected[0][positionsSelected.length - 1])) {
                        Log.i("b", "fuck" + i + j);
                        valid = false;
                    }
            }
            if (valid) {
                Log.i("a", "fuck" + positionsSelected[0][positionsSelected.length-1]);
                gameWon = true;
                winningPlayer = positionsSelected[0][positionsSelected.length - 1];

            }
        }


        //Check the diagonals
        return winningPlayer;
    }

    public void displayGame(){
        String holder = "\n\n";

        for(int i = 0; i < positionsSelected.length; i++){
            if(i > 0) {
                for (int k = 0; k < 65; k++) {
                    holder += " ";
                }
            }
            for(int j = 0; j < positionsSelected[0].length; j++){
                holder += "" + positionsSelected[i][j] + " ";
            }
            holder += "\n";
        }

        Log.i("POSITION",holder);
    }
}
