package vue;
import model.Cell;
import java.util.Scanner;

public class View {
    Scanner scanner = new Scanner(System.in);

    /**
     * Displays the game board with a default format.
     *
     * @param cells The 2D array representing the board state
     */
    public void displayBoard(Cell[][] cells) {
        int row = cells.length;
        int col = cells[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                System.out.print(cells[i][j].getRepresentation());
                if (j < col - 1) System.out.print("|");
            }
            System.out.println();
            if (i < row - 1) {
                for(int j = 0; j < col; j++) {
                    System.out.print("----");
                }
                System.out.println();
            }
            }
        }

    /**
     * Backward compatibility method for displaying the board.
     *
     * @param cells The 2D array representing the board state
     * @deprecated Use {@link #displayBoard(Cell[][])} instead
     */
    @Deprecated
    public void display(Cell[][] cells) {
        displayBoard(cells);
    }

    /**
     * Displays the main game menu and returns the user's selection.
     *
     * @return The user's menu choice (1-3 for game selection)
     */
    public int displayMenu(){
        int choice = -1;

        System.out.println("Welcome!");
        System.out.println("Menu: ");
        System.out.println("1. Tic Tac Toe");
        System.out.println("2. Gomoku");
        System.out.println("3. Power 4");

        while (!scanner.hasNextInt()) {
            System.out.println("Error!");
            scanner.next();
        }
        choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }

    /**
     * Displays a message announcing the winner.
     *
     * @param symbol The representation of the winning player
     */
    public void displayWinner(String symbol) {
        System.out.println("Winner is: Player " + symbol + " ! ");
    }

    /**
     * Displays a message indicating the game resulted in a draw.
     */
    public void displayGameDraw() {
        System.out.println("Draw!");
    }

    /**
     * Backward compatibility method for displaying a draw.
     *
     * @deprecated Use {@link #displayGameDraw()} instead
     */
    @Deprecated
    public void displayDraw() {
        displayGameDraw();
    }

    /**
     * Displays a general message to the player.
     *
     * @param message The message to display
     */
    public void displayMessage(String message) {
        System.out.println(message);
    }

    /**
     * Displays information about a bot's move.
     *
     * @param representation The representation of the bot player
     * @param row The row of the move (1-indexed for display)
     * @param col The column of the move (1-indexed for display)
     */
    public void displayBotMove(String representation, int row, int col) {
        System.out.println("Bot " + representation + " plays " +  (row + 1) + " " + (col + 1));
    }

    /**
     * Backward compatibility method for displaying bot moves.
     *
     * @deprecated Use {@link #displayBotMove(String, int, int)} instead
     */
    @Deprecated
    public void displayBotPlays(String representation, int row, int col) {
        displayBotMove(representation, row, col);
    }
}
