package model;

import vue.View;

public class Gomoku extends Game {
    public static final int SIZE = 15;
    private static final int WIN_LENGTH = 5;

    public Gomoku(Player player1, Player player2, View view) {
        super(new Player[]{player1, player2}, view, SIZE, SIZE);
    }

    /**
     * Executes a move on the board (Model only - no input handling)
     */
    public void executeMove(int row, int col, Player player) {
        setOwner(row, col, player);
    }

    /**
     * Switches to the next player
     */
    public void switchPlayerTurn() {
        switchPlayer();
    }

    /**
     * Gets the current player
     */
    public Player getCurrentPlayerTurn() {
        return getCurrentPlayer();
    }

    @Override
    public boolean checkWin(int myX, int myY){
        int [][] directions = {
                {-1, 0}, // haut
                {0, 1}, // droite
                {1, -1}, // diagonale bas gauche
                {1, 1}}; // diagonale bas droite
        for(int [] direction : directions){
            if(checkBothDirections(myX, myY, direction[0], direction[1])){
                return true;
            };
        }
        return false;
    }
    private boolean checkBothDirections(int myX, int myY, int deltaX, int deltaY){
        Player myPlayer = getCell(myX, myY).getOwner();
        int count = 1;
        count += countInDirection(myX, myY, deltaX, deltaY, myPlayer);
        count += countInDirection(myX, myY, -deltaX, -deltaY, myPlayer);
        return count >= WIN_LENGTH;
    }
    private int countInDirection(int myX, int myY, int deltaX, int deltaY, Player myPlayer){
        int count = 0;
        int x = myX + deltaX;
        int y = myY + deltaY;

        while(isValidCoordinate(x, y) && getCell(x, y).getOwner() == myPlayer){
            count++;
            x+=deltaX;
            y+=deltaY;
        }
        return count;
    }

    @Override
    protected boolean isValidMove(int row, int col){
        return false;
    }
}
