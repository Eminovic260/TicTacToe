package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import vue.View;

public class ArtificialPlayer extends Player {
    private Random random;
    private final View view;

    public ArtificialPlayer(String representation,String colorCode, View view) {
        super(colorCode + representation + "\u001B[0m");
        this.random = new Random();
        this.view = view;
    }

    @Override
    public int[] getMove(Cell[][] board) {
        List<int[]> moves = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j].isEmpty()) {
                    moves.add(new int[]{i, j});
                }
            }
        }
        if (!moves.isEmpty()) {
            int index = random.nextInt(moves.size());
            int[] move = moves.get(index);
            view.displayBotMove(representation, move[0], move[1]);
            return move;
        }

        return new int[]{-1, -1};
    }
}
