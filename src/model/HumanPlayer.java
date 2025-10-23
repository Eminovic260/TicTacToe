package model;

public class HumanPlayer extends Player {

    public HumanPlayer(String representation, String colorCode) {
        super(colorCode + representation + "\u001B[0m");
    }

    /**
     * HumanPlayer no longer handles input
     * Input handling is now done in the Controller layer
     * This method is deprecated - controllers handle human moves
     */
    @Override
    public int[] getMove(Cell[][] board) {
        // Deprecated - controllers handle human input
        return new int[]{-1, -1};
    }
}
