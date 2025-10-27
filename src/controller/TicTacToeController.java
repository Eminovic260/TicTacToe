package controller;

import model.ArtificialPlayer;
import model.Game;
import model.Player;
import model.TicTacToe;
import vue.GameView;
import vue.View;

public class TicTacToeController implements GameController {
    private TicTacToe game;
    private GameView view;
    private InteractionUtilisateur interaction;
    private int lastMoveRow = -1;
    private int lastMoveCol = -1;

    /**
     * Constructs a TicTacToeController with game, view, and interaction components.
     *
     * @param game The TicTacToe game model
     * @param view The GameView for displaying game state
     * @param interaction The InteractionUtilisateur for handling user input
     */
    public TicTacToeController(TicTacToe game, GameView view, InteractionUtilisateur interaction) {
        this.game = game;
        this.view = view;
        this.interaction = interaction;
    }

    /**
     * Starts and manages the game loop for TicTacToe
     * Controller handles: game loop, user input, and view updates
     */
    @Override
    public void startGame() {
        view.displayBoard(game.board);

        while (true) {
            Player currentPlayer = game.getCurrentPlayerTurn();

            if (!handlePlayerMove(currentPlayer)) {
                continue;
            }

            game.executeMove(lastMoveRow, lastMoveCol, currentPlayer);

            view.displayBoard(game.board);

            if (game.checkWin(lastMoveRow, lastMoveCol)) {
                view.displayWinner(currentPlayer.getRepresentation());
                break;
            }


            if (game.isBoardFull()) {
                view.displayGameDraw();
                break;
            }


            game.switchPlayerTurn();
        }
    }

    /**
     * Handles player input and validation
     * Returns true if move is valid, false otherwise
     */
    private boolean handlePlayerMove(Player currentPlayer) {
        if (currentPlayer instanceof ArtificialPlayer){
            int [] move = currentPlayer.getMove(game.board);
            lastMoveRow = move[0];
            lastMoveCol = move[1];
            view.displayBotMove(currentPlayer.getRepresentation(), move[0], move[1]);
            return true;
        }
        interaction.displayMoveRequest(currentPlayer.getRepresentation());

        if (!interaction.hasNextInt()) {
            interaction.displayInputError();
            interaction.nextLine();
            return false;
        }

        int row = interaction.nextInt() - 1;

        if (!interaction.hasNextInt()) {
            interaction.displayInputError();
            interaction.nextLine();
            return false;
        }

        int col = interaction.nextInt() - 1;
        interaction.nextLine();

        if (!game.isValidCoordinate(row, col)) {
            interaction.displayOutOfBounds();
            return false;
        }

        if (!game.getCell(row, col).isEmpty()) {
            interaction.displayCellOccupied();
            return false;
        }

        lastMoveRow = row;
        lastMoveCol = col;

        return true;
    }

    @Override
    public boolean playTurn() {
        Player currentPlayer = game.getCurrentPlayerTurn();

        if (!handlePlayerMove(currentPlayer)) {
            return false;
        }

        game.executeMove(lastMoveRow, lastMoveCol, currentPlayer);

        view.displayBoard(game.board);

        if (game.checkWin(lastMoveRow, lastMoveCol)) {
            view.displayWinner(currentPlayer.getRepresentation());
            return true;
        }

        if (game.isBoardFull()) {
            view.displayGameDraw();
            return true;
        }

        game.switchPlayerTurn();
        return false;
    }



    @Override
    public Game getGame() {
        return game;
    }

    @Override
    public void resetGame() {
        game = new TicTacToe(game.players[0], game.players[1]);
        lastMoveRow = -1;
        lastMoveCol = -1;
    }

    @Override
    public int getLastMoveCol() {
        return lastMoveCol;
    }
    @Override
    public int getLastMoveRow() {
        return lastMoveCol;
    }
}
