package controller;

import model.Game;
import model.Player;
import model.Power4;
import vue.GameView;

public class Power4Controller implements GameController {
    private Power4 game;
    private GameView view;
    private InteractionUtilisateur interaction;
    private int lastMoveCol = -1;

    /**
     * Constructs a Power4Controller with game, view, and interaction components.
     *
     * @param game The Power4 game model
     * @param view The GameView for displaying game state
     * @param interaction The InteractionUtilisateur for handling user input
     */
    public Power4Controller(Power4 game, GameView view, InteractionUtilisateur interaction) {
        this.game = game;
        this.view = view;
        this.interaction = interaction;
    }

    /**
     * Starts and manages the game loop for Power4
     * Controller handles: game loop, user input, and view updates
     */

    /**
     * Handles player input and validation for Power4
     * In Power4, players only choose the column (pieces fall to the lowest available row)
     * Returns true if move is valid, false otherwise
     */
    private boolean handlePlayerMove(Player currentPlayer) {
        interaction.displayMessage("Player " + currentPlayer.getRepresentation() + " a choisis la colonne (1-" + game.cols + "): ");

        if (!interaction.hasNextInt()) {
            interaction.displayInputError();
            interaction.nextLine();
            return false;
        }

        int col = interaction.nextInt() - 1;
        interaction.nextLine();

        if (col < 0 || col >= game.cols) {
            interaction.displayOutOfBounds();
            return false;
        }

        if (!game.getCell(0, col).isEmpty()) {
            interaction.displayMessage("Colonne pleine !");
            return false;
        }

        if (!game.isValidMove(0, col)) {
            interaction.displayMessage("Mouvement invalide !");
            return false;
        }

        lastMoveCol = col;

        return true;
    }

    @Override
    public boolean playTurn() {
        Player currentPlayer = game.getCurrentPlayerTurn();

        if (!handlePlayerMove(currentPlayer)) {
            return false;
        }

        game.executeMove(lastMoveCol, currentPlayer);

        view.displayBoard(game.board);

        int landingRow = game.findLowestEmptyRow(lastMoveCol) + 1;
        if (landingRow < 0) landingRow = game.rows - 1;

        if (game.checkWin(landingRow, lastMoveCol)) {
            view.displayWinner(currentPlayer.getRepresentation());
            return true;
        }

        if (game.isBoardFull()) {
            view.displayGameDraw();
            return true;
        }

        game.switchPlayerTurn();
        return false;
    }

    @Override
    public Game getGame() {
        return game;
    }

    @Override
    public void resetGame() {
        game = new Power4(game.players[0], game.players[1]);
        lastMoveCol = -1;
    }
    @Override
    public void startGame() {
        view.displayBoard(game.board);
        while (true) {
            if (playTurn()) {
                break;
            }
        }
    }

    @Override
    public int getLastMoveCol() {
        return lastMoveCol;
    }
    @Override
    public int getLastMoveRow() {
        return lastMoveCol;
    }
}
