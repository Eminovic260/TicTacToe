package model;
import controller.InteractionUtilisateur;

public class HumanPlayer extends Player {

    private InteractionUtilisateur interaction;

    public HumanPlayer(String representation, InteractionUtilisateur interaction, String colorCode) {
        super(colorCode + representation+ "\u001B[0m");
        this.interaction = interaction;
    }

    @Override
    public int[] getMove(Cell[][] board) {
        int row = -1, col = -1;
        while (true) {
            interaction.displayDemandePlacement(representation);

            if (!interaction.hasNextInt()) {
                interaction.displayErreurEntree();
                interaction.nextLine();
                continue;
            }

            row = interaction.nextInt() - 1;

            if (!interaction.hasNextInt()) {
                interaction.displayErreurEntree();
                interaction.nextLine();
                continue;
            }
            col = interaction.nextInt() - 1;
            interaction.nextLine();
            if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
                interaction.displayHorsPlateau();
                continue;
            }
            if (!board[row][col].isEmpty()) {
                interaction.displayDejaOccupee();
                continue;

            }
            break;
        }

        return new int[]{row, col};
    }
}
