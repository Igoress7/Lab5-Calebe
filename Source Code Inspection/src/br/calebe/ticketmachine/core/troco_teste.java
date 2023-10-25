import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Iterator;

public class TrocoTest {

    @Test
    public void testTrocoIterator() {
        Troco troco = new Troco(275);
        Iterator<PapelMoeda> iterator = troco.getIterator();
        int count = 0;
        while (iterator.hasNext()) {
            PapelMoeda papelMoeda = iterator.next();
            if (papelMoeda != null) {
                count++;
            }
        }
        assertEquals(4, count); // ajuste o valor esperado de acordo com o comportamento do Troco
    }
}
