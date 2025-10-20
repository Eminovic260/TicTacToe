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
    public static final int SIZE = 3;

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
    public Cell[][] getCells() {
        return cells;
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

            if (checkWin(currentPlayer)) {
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


    public boolean checkWin(Player player) {
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
    }


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
