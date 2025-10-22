package model;

import vue.View;

public class TicTacToe extends Game {
    public static final int SIZE = 3;
    private static final int WIN_LENGTH = 3;

    public TicTacToe(Player player1, Player player2, View view) {
        super(new Player[]{player1, player2}, view, SIZE, SIZE);
    }

    @Override
    public void run() {
        while (true) {
            view.display(board);
            Player currentPlayer = getCurrentPlayer();
            int[] move = currentPlayer.getMove(board);
            setOwner(move[0], move[1], currentPlayer);

            if (checkWin(move[0], move[1])) {
                view.display(board);
                String symbol = currentPlayer.getRepresentation();
                view.displayWinner(symbol);
                break;
            }
            if (isBoardFull()) {
                view.display(board);
                view.displayDraw();
                break;
            }

            switchPlayer();
        }
    }


    @Override
    public boolean checkWin(int myX, int myY) {
        int[][] directions = {
            {-1, 0}, // haut
            {0, 1}, // droite
            {1, -1}, // diagonale bas gauche
            {1, 1}}; // diagonale bas droite
        for (int[] direction : directions) {
            if (checkBothDirections(myX, myY, direction[0], direction[1])) {
                return true;
            }
            ;
        }
        return false;
    }

    private boolean checkBothDirections(int myX, int myY, int deltaX, int deltaY) {
        Player myPlayer = getCell(myX, myY).getOwner();
        int count = 1;
        count += countInDirection(myX, myY, deltaX, deltaY, myPlayer);
        count += countInDirection(myX, myY, -deltaX, -deltaY, myPlayer);
        return count >= WIN_LENGTH;
    }

    private int countInDirection(int myX, int myY, int deltaX, int deltaY, Player myPlayer) {
        int count = 0;
        int x = myX + deltaX;
        int y = myY + deltaY;

        while (isValidCoordinate(x, y) && getCell(x, y).getOwner() == myPlayer) {
            count++;
            x += deltaX;
            y += deltaY;
        }
        return count;
    }

    @Override
    protected boolean isValidMove(int row, int col) {
        return isValidCoordinate(row, col) && board[row][col].isEmpty();
    }

}
