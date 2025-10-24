package vue;

import model.Cell;

public interface GameView {
    /**
     * Displays the game board with all current pieces.
     *
     * @param cells A 2D array representing the game board state
     */
    void displayBoard(Cell[][] cells);

    /**
     * Displays a message to the player.
     *
     * @param message The message to display
     */
    void displayMessage(String message);

    /**
     * Displays a winning message.
     *
     * @param symbol The representation of the winning player
     */
    void displayWinner(String symbol);

    /**
     * Displays a draw/tie game message.
     */
    void displayGameDraw();

    /**
     * Displays information about the bot's move.
     *
     * @param representation The representation of the bot player
     * @param row The row where the bot played (0-indexed)
     * @param col The column where the bot played (0-indexed)
     */
    void displayBotMove(String representation, int row, int col);
}
