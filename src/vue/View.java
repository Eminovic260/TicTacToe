package vue;
import model.Cell;
import java.util.Scanner;

public class View {
    Scanner scanner = new Scanner(System.in);

    public void display(Cell[][] cells) {
        int row = cells.length;
        int col = cells[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                System.out.print(cells[i][j].getRepresentation());
                if (j < col - 1) System.out.print("|");
            }
            System.out.println();
            if (i < row - 1) {
                for(int j = 0; j < col; j++) {
                    System.out.print("----");
                }
                System.out.println();
            }
            }
        }


        public int displayMenu(){
int choice = -1;

    System.out.println("Bienvenue !");
    System.out.println("Menu: ");
    System.out.println("1. Morpion");
    System.out.println("2. GOMUGOMU");
    System.out.println("3. Puissance 4");

    while (!scanner.hasNextInt()) {
        System.out.println("Erreur !");
        scanner.next();
    }
    choice = scanner.nextInt();
    scanner.nextLine();
    return choice;

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
