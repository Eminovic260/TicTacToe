package vue;

import model.Cell;

public class Power4View extends View implements GameView {

    /**
     * Displays the Power 4 board with 6x7 grid formatting.
     * Uses bracket notation [X] for pieces and shows column numbers.
     *
     * @param cells The 2D array representing the 6x7 board state
     */
    @Override
    public void displayBoard(Cell[][] cells) {
        System.out.println("\n=== Power 4 Board (6x7) ===");
        int row = cells.length;
        int col = cells[0].length;

        // Display numbers for columns
        System.out.print("   ");
        for (int j = 1; j <= col; j++) {
            System.out.print("  " + j + "  ");
        }
        System.out.println();

        for (int i = 0; i < row; i++) {
            System.out.print("   ");
            for (int j = 0; j < col; j++) {
                System.out.print("[" + cells[i][j].getRepresentation() + "]");
            }
            System.out.println();
        }

        // Bottom border
        System.out.print("   ");
        for (int j = 0; j < col; j++) {
            System.out.print("-----");
        }
        System.out.println();
    }

    /**
     * Displays a message to the player.
     *
     * @param message The message to display
     */
    @Override
    public void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * Displays a winning message with trophy emoji.
     *
     * @param symbol The representation of the winning player
     */
    @Override
    public void displayWinner(String symbol) {
        System.out.println("\n🏆 Winner: Player " + symbol + " ! 🏆\n");
    }

    /**
     * Displays a draw message when board is full.
     */
    @Override
    public void displayGameDraw() {
        System.out.println("\n🤝 Board full - Draw! 🤝\n");
    }

    /**
     * Displays the bot's column selection with clear notation.
     *
     * @param representation The representation of the bot player
     * @param row Unused for Power4 (column selection only)
     * @param col The column where the bot played (0-indexed internally)
     */
    @Override
    public void displayBotMove(String representation, int row, int col) {
        System.out.println("Bot " + representation + " plays column " + (col + 1));
    }
}
