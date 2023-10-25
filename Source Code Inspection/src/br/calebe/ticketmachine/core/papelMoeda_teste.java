import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PapelMoedaTest {

    @Test
    public void testGetValor() {
        PapelMoeda papelMoeda = new PapelMoeda(10, 5);
        assertEquals(10, papelMoeda.getValor());
    }

    @Test
    public void testGetQuantidade() {
        PapelMoeda papelMoeda = new PapelMoeda(10, 5);
        assertEquals(5, papelMoeda.getQuantidade());
    }
}
