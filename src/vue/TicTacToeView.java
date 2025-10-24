package vue;

import model.Cell;

public class TicTacToeView extends View implements GameView {

    /**
     * Displays the Tic-Tac-Toe board with 3x3 grid formatting.
     * Shows row and column numbers for player reference.
     *
     * @param cells The 2D array representing the 3x3 board state
     */
    @Override
    public void displayBoard(Cell[][] cells) {
        System.out.println("\n=== Tic Tac Toe Board (3x3) ===");
        int row = cells.length;
        int col = cells[0].length;

        System.out.print("   ");
        for (int j = 1; j <= col; j++) {
            System.out.print(" " + j + "  ");
        }
        System.out.println();

        for (int i = 0; i < row; i++) {
            System.out.print((i + 1) + "  ");

            for (int j = 0; j < col; j++) {
                System.out.print(cells[i][j].getRepresentation());
                if (j < col - 1) System.out.print("|");
            }
            System.out.println();

            if (i < row - 1) {
                System.out.print("   ");
                for (int j = 0; j < col; j++) {
                    System.out.print("--+");
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
     * Displays a winning message with celebration emoji.
     *
     * @param symbol The representation of the winning player
     */
    @Override
    public void displayWinner(String symbol) {
        System.out.println("\nWinner: Player " + symbol + " !\n");
    }

    /**
     * Displays a draw message with decorative emoji.
     */
    @Override
    public void displayGameDraw() {
        System.out.println("\nDraw!\n");
    }

    /**
     * Displays the bot's move with clear row and column information.
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
