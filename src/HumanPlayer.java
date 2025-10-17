import java.util.Scanner;
public class HumanPlayer extends Player {
    private Scanner scanner;
    public HumanPlayer(String representation, Scanner scanner) {
        super(representation);
        this.scanner = scanner;
    }

@Override
public int[] getMove(Cell[][] board){
    int row=-1, col =-1;
    while(true){
        System.out.print("Joueur " + representation + " joue ligne et colonne : ");

        if (!scanner.hasNextInt()){
            System.out.println("entrez un entier");
            scanner.nextLine();
            continue;
        }

        row = scanner.nextInt() -1;

        if (!scanner.hasNextInt()) {
            System.out.println("entrez un entier");
            scanner.nextLine();
            continue;
        }
        col = scanner.nextInt() -1;
        scanner.nextLine();
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length){
            System.out.println("vous sortez du terrain !");
            continue;
        }
        if (!board[row][col].isEmpty()){
            System.out.println("deja occupée");
            continue;

        }
        break;
    }

    return new int[]{row, col};
}
}