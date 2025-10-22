package model;

import vue.View;


public class Power4 extends Game {
    public static final int ROWS = 6;
    public static final int COLS = 7;
    private static final int WIN_LENGTH = 4;

    public Power4(Player player1, Player player2, View view) {
        super(new Player[]{player1, player2}, view, ROWS, COLS);
    }


    private int findLowestEmptyRow(int col) {
        for (int i = ROWS - 1; i >= 0; i--) {
            if (board[i][col].isEmpty()) {
                return i;
            }
        }
        return -1;
    }


    @Override
    public void run() {
        view.display(board);
        while (!isBoardFull()) {
            Player currentPlayer = getCurrentPlayer();
            int[] move = currentPlayer.getMove(board);
            if (move == null || move.length < 2) {
                continue;
            }

            int col = move[1];
            if (!isValidMove(0, col)) {
                view.displayMessage("Mouvement invalide");
                continue;
            }

            int landingRow = findLowestEmptyRow(col);
            if (landingRow >= 0) {
                setOwner(landingRow, col, currentPlayer);
                view.display(board);
            }
            if (checkWin(landingRow, col)) {
                view.displayWinner(currentPlayer.getRepresentation());
                return;
            }

            switchPlayer();
        }
        view.displayDraw();
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
    return count >=WIN_LENGTH;
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
    protected boolean isValidMove(int row, int col) {
        if (!isValidCoordinate(0, col)) {
            return false;
        }
        return board[0][col].isEmpty();
    }


}

