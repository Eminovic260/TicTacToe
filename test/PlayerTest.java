import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PlayerTest {

    @Test
    public void testGetRepresentation() {
        Player playerX = new Player("X");
        assertEquals("X", playerX.getRepresentation());

        Player playerO = new Player("O");
        assertEquals("O", playerO.getRepresentation());
    }


}
