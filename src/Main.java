import entites.ArtificialPlayer;
import entites.HumanPlayer;
import entites.Player;
import game.tictactoe.TicTacToe;
import ui.InteractionUtilisateur;
import ui.View;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        View view = new View();
        InteractionUtilisateur interaction = new InteractionUtilisateur(scanner, view);
        Player player1 = new HumanPlayer("X", interaction);
        Player player2 = new ArtificialPlayer("O", view);
        TicTacToe game = new TicTacToe(player1, player2, view);

        game.run();
    }
}
