package controller;

import model.*;
import vue.*;

/**
 * Contrôleur responsable du choix du jeu et des types de joueurs.
 * Il ne contient aucune logique d'affichage directe — tout passe par InteractionUtilisateur.
 */
public class GameChoiceController {

    private final InteractionUtilisateur interaction;
    private GameController currentController;

    /**
     * Constructeur
     */
    public GameChoiceController(InteractionUtilisateur interaction) {
        this.interaction = interaction;
    }

    /**
     * Permet de choisir le jeu et les joueurs via InteractionUtilisateur.
     * Crée et renvoie le GameController correspondant.
     */
    public GameController chooseGameAndPlayers() {

        int gameChoice = interaction.askForGameChoice();
        int playerChoice = interaction.askForPlayerChoice();

        final String RED = "\u001B[31m";
        final String GREEN = "\u001B[32m";

        Player player1;
        Player player2;

        switch (playerChoice) {
            case 1 -> {
                player1 = new HumanPlayer("o", RED);
                player2 = new HumanPlayer("x", GREEN);
            }
            case 2 -> {
                player1 = new HumanPlayer("o", RED);
                player2 = new ArtificialPlayer("x", GREEN);
            }
            case 3 -> {
                player1 = new ArtificialPlayer("o", RED);
                player2 = new ArtificialPlayer("x", GREEN);
            }
            default -> {
                interaction.displayMessage("Erreur choix de joueurs invalide");
                return null;
            }
        }

        currentController = switch (gameChoice) {
            case 1 -> new TicTacToeController(new TicTacToe(player1, player2), new TicTacToeView(), interaction);
            case 2 -> new GomokuController(new Gomoku(player1, player2), new GomokuView(), interaction);
            case 3 -> new Power4Controller(new Power4(player1, player2), new Power4View(), interaction);
            default -> {
                interaction.displayMessage("Erreur choix de jeu invalide");
                yield null;
            }
        };

        return currentController;
    }

    /**
     * Getter du contrôleur courant (StatusMachine)
     */
    public GameController getCurrentController() {
        return currentController;
    }
}
