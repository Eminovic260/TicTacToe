package controller;

import model.Game;
import vue.*;
import java.util.Scanner;

public class StatusMachine {
    private GameState gameState;
    private GameChoiceController gameChoiceController;
    private GameController gameController;


    public StatusMachine() {
        this.gameState = GameState.MENU;
        Scanner scanner = new Scanner(System.in);
        View view = new View();
        InteractionUtilisateur interaction = new InteractionUtilisateur(scanner, view);

        this.gameChoiceController = new GameChoiceController(interaction);
    }

    public void update() {
        switch (gameState) {
            case MENU -> handleMenuState();
            case PLAYING -> handlePlayingState();
            case VICTORY -> handleVictoryState();
            case GAME_OVER -> handleGameOverState();
        }
    }

    private void handleMenuState() {
        gameController = gameChoiceController.chooseGameAndPlayers();
        if (gameController != null){
            gameState = GameState.PLAYING;
        }
    }

    private void handlePlayingState() {
        boolean finished = gameController.playTurn();

        if (finished) {

            Game game = gameController.getGame();
            int lastRow= gameController.getLastMoveRow();
            int lastCol = gameController.getLastMoveCol();

            if (game.checkWin(lastRow, lastCol)) {
                gameState = GameState.VICTORY;
            } else {
                gameState = GameState.GAME_OVER;
            }
        }
    }
private void handleVictoryState() {
    gameState = GameState.MENU;
    }
    private void handleGameOverState() {
        gameState = GameState.MENU;
    }
    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }
}
