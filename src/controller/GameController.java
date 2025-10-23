package controller;

import model.Game;

public interface GameController {
    /**
     * Starts and manages the complete game loop.
     *
     * <p>This method handles the entire game flow including:
     * - Displaying the game board
     * - Getting and validating player moves
     * - Executing moves in the model
     * - Checking win conditions
     * - Displaying game results
     */
    void startGame();

    /**
     * Gets the current game instance.
     *
     * @return The Game model being played
     */
    Game getGame();

    /**
     * Resets the game to its initial state for a new session.
     */
    void resetGame();
}

