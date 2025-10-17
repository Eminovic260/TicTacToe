import java.util.Scanner;

public class TicTacToe {

    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    public static final int SIZE = 3;
    private Cell[][] cells;

    public TicTacToe(Player player1, Player player2) {
        this.playerX = player1;
        this.playerO = player2;
        this.currentPlayer = playerX;

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

    public void display() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {

                System.out.print(cells[i][j].getRepresentation());
                if (j < SIZE - 1) System.out.print("|");
            }
            System.out.println();
            if (i < SIZE - 1) System.out.println(" ---------");
        }
    }



    public void switchPlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }


    public void setOwner(int row, int col, Player player) {
        cells[row][col].setOwner(player);
    }

    public void run() {
        while (true) {
            display();
            int[] move = currentPlayer.getMove(cells);
            setOwner(move[0], move[1], currentPlayer);

            if (checkWin(currentPlayer)) {
                display();
                System.out.println("Le Gagnant est : Joueur " + currentPlayer.getRepresentation() + " ! ");
                break;
            }
            if (isBoardFull()){
                display();
                System.out.println("MAtch nul !");
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
