package game.tictactoe;
import ui.View;
import model.Cell;
import entites.Player;

public class TicTacToe {

    private View view;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    private Cell[][] cells;
    public static final int SIZE = 15;

    public TicTacToe(Player player1, Player player2, View view) {
        this.playerX = player1;
        this.playerO = player2;
        this.currentPlayer = playerX;
        this.view = view;


        cells = new Cell[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j] = new Cell();
            }
        }
    }
    public Cell[][] getAllCells() {return cells;}

    public Cell getCell(int x, int y) {
        if(isValidCoordinate(x, y)){
            return cells[x][y];
        }
        return null;
    }
    public boolean isValidCoordinate(int x, int y) {
        return x >= 0 && x < SIZE && y >= 0 && y < SIZE;
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }


    public void setOwner(int row, int col, Player player) {
        cells[row][col].setOwner(player);
    }

    public void run() {
        while (true) {
            view.display(cells);
            int[] move = currentPlayer.getMove(cells);
            setOwner(move[0], move[1], currentPlayer);

            if (checkWinConditions(move[0], move[1])) {
                view.display(cells);
                String symbol = currentPlayer.getRepresentation();
                view.displayWinner(symbol);

                break;
            }
            if (isBoardFull()){
                view.display(cells);
                view.displayDraw();
                break;
            }

            switchPlayer();
        }
    }







    public boolean checkWinConditions(int myX, int myY){
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
        Player myPlayer = currentPlayer;
        int count = 1;
        count += countInDirection(myX, myY, deltaX, deltaY, myPlayer);
        count += countInDirection(myX, myY, -deltaX, -deltaY, myPlayer);
        return count >=5;
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











    /*public boolean checkWin(Player player) {
        String symbol = player.getRepresentation();

        for (int i = 0; i < SIZE; i++) {
            boolean win = true;
            for (int j = 0; j < SIZE; j++) {
                if (!symbol.equals(cells[i][j].getRepresentation().trim())) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        for (int j = 0; j < SIZE; j++) {
            boolean win = true;
            for (int i = 0; i < SIZE; i++) {
                if (!symbol.equals(cells[i][j].getRepresentation().trim())) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

        boolean win = true;
        for (int i = 0; i < SIZE; i++) {
            if (!symbol.equals(cells[i][i].getRepresentation().trim())) {
                win = false;
                break;
            }
        }
        if (win) return true;

        win = true;
        for (int i = 0; i < SIZE; i++) {
            if (!symbol.equals(cells[i][SIZE - 1 - i].getRepresentation().trim())) {
                win = false;
                break;
            }
        }
        return win;
    }*/


    public boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (cells[i][j].isEmpty()) {
                    return false;
            }
        }
    }
        return true;

}
}
