import java.util.Scanner;

public class TicTacToe {

    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    public static final int SIZE = 3;
    private Cell[][] cells;

    public TicTacToe() {
        cells = new Cell[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                cells[i][j] = new Cell();
            }
        }
        playerX = new Player("X");
        playerO = new Player("O");
        currentPlayer = playerX;
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


    public int[] getMove() {
        Scanner scanner = new Scanner(System.in);
        int row = -1;
        int col = -1;

        while (true) {
            System.out.print("Jouer Ligne et Colonne : ");
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
            if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
                System.out.println("La colonne n'est pas valide !");
                continue;
            }
            if (!cells[row][col].isEmpty()) {
                System.out.println("La cellule est deja prise !");
                continue;
            }
            break;
        }
        scanner.nextLine();
        return new int[]{row, col};
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
            int[] move = getMove();
            setOwner(move[0], move[1], currentPlayer);

            if (checkWin(currentPlayer)) {
                display();
                System.out.println("Le Gagnat est : Joueur " + currentPlayer.getRepresentation() + " ! ");
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
