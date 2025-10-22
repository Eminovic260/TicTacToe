import model.ArtificialPlayer;
import model.HumanPlayer;
import model.Player;
import model.Game;
import model.Power4;
import model.TicTacToe;
import controller.InteractionUtilisateur;
import vue.View;
import model.Gomoku;
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
