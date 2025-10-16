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
        playerX=new Player("X");
        playerO=new Player("O");
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



    public int [] getMove() {
        Scanner scanner = new Scanner(System.in);
        int row = -1;
        int col = -1;

        while (true) {
            System.out.print("Jouer Ligne et Colonne : ");
            row = scanner.nextInt() -1;
            col = scanner.nextInt()-1;
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



    public void playOneTurn() {
        int[] move = getMove();
        setOwner(move[0], move[1], currentPlayer);
        switchPlayer();
    }
    public void setOwner(int row, int col, Player player) {
        cells[row][col].setOwner(player);
    }

    public void run() {
        while (true) {
            display();
            playOneTurn();
        }
    }

    public void winCondition() {

    }
}
