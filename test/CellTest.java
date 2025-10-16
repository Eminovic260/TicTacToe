import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CellTest {

    @Test
    public void testGetRepresentation() {
        Cell cell = new Cell();
        assertEquals("   ", cell.getRepresentation());
    }
}
