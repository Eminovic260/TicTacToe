import model.Cell;
import org.junit.jupiter.api.Test;
import game.tictactoe.TicTacToe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TicTacToeTest {

    @Test
    public void testSize() {
        assertEquals(3, TicTacToe.SIZE);
    }

    @Test
    public void testBoard() {
        TicTacToe board = new TicTacToe();
        Cell[][] cells = board.getCells();

        assertEquals(TicTacToe.SIZE, cells.length);
    }


    @Test
    public void testDisplay() {
        TicTacToe board = new TicTacToe();
    }






}
