package controller;

import model.Game;
import model.Player;
import model.Power4;
import vue.GameView;
import vue.View;

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
    @Override
    public void startGame() {
        view.displayBoard(game.board);

        while (!game.isBoardFull()) {
            Player currentPlayer = game.getCurrentPlayerTurn();

            // Get and validate player move
            if (!handlePlayerMove(currentPlayer)) {
                continue; // Invalid move, ask again
            }

            // Execute the move in the model (piece falls)
            game.executeMove(lastMoveCol, currentPlayer);

            // Display the board after move
            view.displayBoard(game.board);

            // Find the row where the piece landed to check win
            int landingRow = game.findLowestEmptyRow(lastMoveCol) + 1; // +1 because it returns one row above
            if (landingRow < 0) landingRow = game.rows - 1;

            // Check if current player won
            if (game.checkWin(landingRow, lastMoveCol)) {
                view.displayWinner(currentPlayer.getRepresentation());
                return;
            }

            // Switch to next player
            game.switchPlayerTurn();
        }

        // Board is full - draw
        view.displayGameDraw();
    }

    /**
     * Handles player input and validation for Power4
     * In Power4, players only choose the column (pieces fall to the lowest available row)
     * Returns true if move is valid, false otherwise
     */
    private boolean handlePlayerMove(Player currentPlayer) {
        interaction.displayMessage("Player " + currentPlayer.getRepresentation() + " choose a column (1-" + game.cols + "): ");

        // Check if input is an integer
        if (!interaction.hasNextInt()) {
            interaction.displayInputError();
            interaction.nextLine();
            return false;
        }

        int col = interaction.nextInt() - 1; // Convert to 0-indexed
        interaction.nextLine();

        // Validate column is within bounds
        if (col < 0 || col >= game.cols) {
            interaction.displayOutOfBounds();
            return false;
        }

        // Check if column is already full (top cell occupied)
        if (!game.getCell(0, col).isEmpty()) {
            interaction.displayMessage("Column full!");
            return false;
        }

        // Check if move is valid for Power4 rules
        if (!game.isValidMove(0, col)) {
            interaction.displayMessage("Invalid move");
            return false;
        }

        // Store the column
        lastMoveCol = col;

        return true;
    }

    @Override
    public Game getGame() {
        return game;
    }

    @Override
    public void resetGame() {
        // Reset Power4 game state
        game = new Power4(game.players[0], game.players[1], (View) view);
        lastMoveCol = -1;
    }
}
