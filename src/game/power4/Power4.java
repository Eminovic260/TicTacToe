package game.power4;

import entites.Player;
import game.Game;
import ui.View;

public class Power4 extends Game {
    public static final int row = 6;
    public static final int col = 7;
    private static final int WIN_LENGTH = 4;

    public Power4(Player player1, Player player2, View view) {
        super(new Player[]{player1, player2}, view, row, col);
    }

    @Override
    public void run() {

    }

    @Override
    public boolean checkWin(int x, int y){
        return false;
    }

    @Override
    protected boolean isValidMove(int row, int col){
        return false;
    }
}
