package vue;

import model.Cell;

public class GomokuView extends View implements GameView {

    /**
     * Displays the Gomoku board with 15x15 grid formatting.
     * Shows row and column numbers at 5-unit intervals for readability.
     *
     * @param cells The 2D array representing the 15x15 board state
     */
    @Override
    public void displayBoard(Cell[][] cells) {
        System.out.println("\n=== Gomoku Board (15x15) ===");
        int row = cells.length;
        int col = cells[0].length;

        System.out.print("    ");
        for (int j = 1; j <= col; j++) {
            System.out.printf("  " + String.format("%2d", j) + "  ");
        }
        System.out.println();

        for (int i = 0; i < row; i++) {
            System.out.print(String.format("%2d", (i + 1)) + "  ");

            for (int j = 0; j < col; j++) {
                System.out.print(" " + cells[i][j].getRepresentation() + " ");
                if (j < col - 1) System.out.print("|");
            }
            System.out.println();

            if (i < row - 1) {
                System.out.print("    ");
                for (int j = 0; j < col; j++) {
                    System.out.print("-----+");
                }
                System.out.println();
            }
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
     * Displays a winning message with crown emoji.
     *
     * @param symbol The representation of the winning player
     */
    @Override
    public void displayWinner(String symbol) {
        System.out.println("\nWinner: Player " + symbol + " ! \n");
    }

    /**
     * Displays a draw message when board is full.
     */
    @Override
    public void displayGameDraw() {
        System.out.println("\nBoard full - Draw!\n");
    }

    /**
     * Displays the bot's move with row and column information.
     *
     * @param representation The representation of the bot player
     * @param row The row where the bot played (0-indexed internally)
     * @param col The column where the bot played (0-indexed internally)
     */
    @Override
    public void displayBotMove(String representation, int row, int col) {
        System.out.println("Bot " + representation + " plays row " + (row + 1) + ", column " + (col + 1));
    }
}
