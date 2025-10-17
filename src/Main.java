import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Player player1 = new HumanPlayer("X", scanner);
        Player player2 = new ArtificialPlayer("O");

        TicTacToe game = new TicTacToe(player1, player2);

        game.run();
        scanner.close();
    }
}
