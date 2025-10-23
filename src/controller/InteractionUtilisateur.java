package controller;

import vue.View;

import java.util.Scanner;

/**
 * Class InteractionUser that handle the user interaction
 * @author EminLeGoat
 * @version 1.0
 */
public class InteractionUtilisateur {
    private Scanner scanner;
    private View view;

    /**
     * Constructs an InteractionUtilisateur with a Scanner and View.
     *
     * @param scanner The Scanner instance for reading user input
     * @param view The View instance for displaying messages
     */
    public InteractionUtilisateur(Scanner scanner, View view) {
        this.scanner = scanner;
        this.view = view;
    }

    /**
     * Displays a request for the player to enter their move.
     *
     * @param representation The representation of the current player
     */
    public void displayMoveRequest(String representation) {
        view.displayMessage("Player " + representation + " enter row and column: ");
    }

    /**
     * Backward compatibility method for displaying a move request.
     *
     * @param representation The representation of the current player
     * @deprecated Use {@link #displayMoveRequest(String)} instead
     */
    @Deprecated
    public void displayDemandePlacement(String representation) {
        displayMoveRequest(representation);
    }

    /**
     * Displays an error message for invalid input type.
     */
    public void displayInputError() {
        view.displayMessage("Enter an integer");
    }

    /**
     * Backward compatibility method for displaying an input error.
     *
     * @deprecated Use {@link #displayInputError()} instead
     */
    @Deprecated
    public void displayErreurEntree() {
        displayInputError();
    }

    /**
     * Displays an error message when coordinates are out of bounds.
     */
    public void displayOutOfBounds() {
        view.displayMessage("Out of bounds!");
    }

    /**
     * Backward compatibility method for displaying an out of bounds error.
     *
     * @deprecated Use {@link #displayOutOfBounds()} instead
     */
    @Deprecated
    public void displayHorsPlateau() {
        displayOutOfBounds();
    }

    /**
     * Displays an error message when the target cell is already occupied.
     */
    public void displayCellOccupied() {
        view.displayMessage("Cell already occupied");
    }

    /**
     * Backward compatibility method for displaying a cell occupied error.
     *
     * @deprecated Use {@link #displayCellOccupied()} instead
     */
    @Deprecated
    public void displayDejaOccupee() {
        displayCellOccupied();
    }

    /**
     * Reads the next integer from the Scanner.
     *
     * @return The next integer from user input
     */
    public int nextInt(){
       return scanner.nextInt();
    }

    /**
     * Consumes the next line in the Scanner buffer.
     * Useful for clearing invalid input after attempting to read an integer.
     */
    public void nextLine(){
        scanner.nextLine();
    }

    /**
     * Checks if the next token in the Scanner is an integer.
     *
     * @return true if the next token is an integer, false otherwise
     */
    public boolean hasNextInt(){
        return scanner.hasNextInt();
    }

    /**
     * Displays a general message to the player.
     *
     * @param message The message to display
     */
    public void displayMessage(String message){
        view.displayMessage(message);
    }
}
