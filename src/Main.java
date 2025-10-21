import entites.ArtificialPlayer;
import entites.HumanPlayer;
import entites.Player;
import game.Game;
import game.power4.Power4;
import game.tictactoe.TicTacToe;
import ui.InteractionUtilisateur;
import ui.View;
import game.gomoku.Gomoku;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        View view = new View();
        InteractionUtilisateur interaction = new InteractionUtilisateur(scanner, view);

        int choice = view.displayMenu();

        final String RED = "\u001B[31m";
        final String GREEN = "\u001B[32m";

        Player player1 = new HumanPlayer("o", interaction, RED);
        Player player2 = new ArtificialPlayer("o", GREEN, view);

        Game game = null;

        switch (choice) {
            case 1:
                game = new TicTacToe(player1, player2, view);
                break;
                case 2:
                    game = new Gomoku(player1, player2, view);
                    break;
                    case 3:
                        game = new Power4(player1, player2, view);
                        break;
                        default:
                            view.displayMessage("Erreur");
                            return;
        }

        game.run();
    }
}
