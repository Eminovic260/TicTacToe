package ui;
import model.Cell;

public class View {
    public void display(Cell[][] cells) {
        int size = cells.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {

                System.out.print(cells[i][j].getRepresentation());
                if (j < size - 1) System.out.print("|");
            }
            System.out.println();
            if (i < size - 1) System.out.println(" --------------------------------------------------------");
        }
    }

    public void displayWinner(String symbol) {
        System.out.println("Le Gagnant est : Joueur " + symbol + " ! ");
    }

    public void displayDraw() {
        System.out.println("MAtch nul !");
    }



    public void displayMessage(String message) {
        System.out.println(message);
    }

    public void displayBotPlays(String representation, int row, int col) {
        System.out.println("Le bot  " + representation + " joue " +  (row + 1) + " " + (col + 1));
    }
}
