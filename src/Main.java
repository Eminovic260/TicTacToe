import model.ArtificialPlayer;
import model.HumanPlayer;
import model.Player;
import model.Game;
import model.Power4;
import model.TicTacToe;
import model.Gomoku;
import controller.GameController;
import controller.TicTacToeController;
import controller.Power4Controller;
import controller.GomokuController;
import controller.InteractionUtilisateur;
import vue.View;
import vue.GameView;
import vue.TicTacToeView;
import vue.Power4View;
import vue.GomokuView;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        View menuView = new View(); // For menu only
        InteractionUtilisateur interaction = new InteractionUtilisateur(scanner, menuView);

        int choice = menuView.displayMenu();

        final String RED = "\u001B[31m";
        final String GREEN = "\u001B[32m";

        Player player1 = new HumanPlayer("o", RED);
        Player player2 = new ArtificialPlayer("o", GREEN, menuView);

        GameController controller = null;

        switch (choice) {
            case 1:
                TicTacToe ticTacToe = new TicTacToe(player1, player2, menuView);
                GameView ticTacToeView = new TicTacToeView();
                controller = new TicTacToeController(ticTacToe, ticTacToeView, interaction);
                break;
            case 2:
                Gomoku gomoku = new Gomoku(player1, player2, menuView);
                GameView gomokuView = new GomokuView();
                controller = new GomokuController(gomoku, gomokuView, interaction);
                break;
            case 3:
                Power4 power4 = new Power4(player1, player2, menuView);
                GameView power4View = new Power4View();
                controller = new Power4Controller(power4, power4View, interaction);
                break;
            default:
                menuView.displayMessage("Erreur");
                return;
        }

        controller.startGame();
    }
}
