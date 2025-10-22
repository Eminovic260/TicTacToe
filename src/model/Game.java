package model;
import vue.View;

public abstract class Game {
    protected Cell[][] board;
    protected Player[] players;
    protected int currentPlayerIndex = 0;
    protected View view;
    protected int rows;
    protected int cols;

    public Game (Player[] players, View view, int rows, int cols) {
        this.players = players;
        this.view = view;
        this.rows = rows;
        this.cols = cols;
        createBoard();
    }

    protected void createBoard(){
        board = new Cell[rows][cols];
        for(int i = 0 ; i<rows; i++){
            for(int j = 0; j < cols; j++){
                board[i][j] = new Cell();
            }
        }
    }
    protected Player getCurrentPlayer(){
        return players[currentPlayerIndex];
    }
    protected void switchPlayer(){
        currentPlayerIndex = (currentPlayerIndex + 1) % players.length;
    }
    public void setOwner(int row, int col, Player player){
        if (isValidCoordinate(row, col)) {
            board[row][col].setOwner(player);
        }
    }
    public boolean isValidCoordinate(int row, int col) {
        return row >= 0 && row < rows && col >= 0 && col < cols;
    }
    public boolean isBoardFull() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }
    public Cell getCell(int row, int col) {
        if (isValidCoordinate(row, col)) {
            return board[row][col];
        }
        return null;
    }

    public abstract void run();

    protected abstract boolean checkWin(int row, int col);

    protected abstract boolean isValidMove(int row, int col);

}
