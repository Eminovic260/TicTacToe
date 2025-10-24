package controller;

import model.*;
import vue.*;
import model.ArtificialPlayer;
import model.HumanPlayer;
import model.Player;
import model.Power4;
import model.TicTacToe;
import model.Gomoku;
import vue.View;
import vue.GameView;
import vue.TicTacToeView;
import vue.Power4View;
import vue.GomokuView;
import java.util.Scanner;

public class GameChoiceController {

    public void gameChoice (){

    Scanner scanner = new Scanner(System.in);
    View menuView = new View();
    InteractionUtilisateur interaction = new InteractionUtilisateur(scanner, menuView);

    int choice = menuView.displayMenu();
    int playerChoice = menuView.displayChoice();
    final String RED = "\u001B[31m";
    final String GREEN = "\u001B[32m";
    Player player1;
    Player player2;

        switch (playerChoice){
        case 1:
            player1 =new HumanPlayer("o", RED);
            player2 =new HumanPlayer("x", GREEN);
            break;
        case 2:
            player1 =new HumanPlayer("o", RED);
            player2 =new ArtificialPlayer("x", GREEN);
            break;
        case 3:
            player1 =new ArtificialPlayer("o", RED);
            player2 =new ArtificialPlayer("x", GREEN);
            break;
        default:
            menuView.displayMessage("Erreur");
            return;
    }

    GameController controller;

        switch (choice) {
        case 1:
            TicTacToe ticTacToe = new TicTacToe(player1, player2);
            GameView ticTacToeView = new TicTacToeView();
            controller = new TicTacToeController(ticTacToe, ticTacToeView, interaction);
            break;
        case 2:
            Gomoku gomoku = new Gomoku(player1, player2);
            GameView gomokuView = new GomokuView();
            controller = new GomokuController(gomoku, gomokuView, interaction);
            break;
        case 3:
            Power4 power4 = new Power4(player1, player2);
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
