import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TicketMachineTest {

    @Test
    public void testInserirQuantiaValida() {
        TicketMachine ticketMachine = new TicketMachine(10);
        try {
            ticketMachine.inserir(10);
            assertEquals(10, ticketMachine.getSaldo());
        } catch (PapelMoedaInvalidaException e) {
            fail("Uma exceção não esperada foi lançada");
        }
    }

    @Test
    public void testInserirQuantiaInvalida() {
        TicketMachine ticketMachine = new TicketMachine(10);
        try {
            ticketMachine.inserir(7);
            fail("Uma exceção deveria ter sido lançada");
        } catch (PapelMoedaInvalidaException e) {
            // Espera-se que uma exceção seja lançada, portanto, o teste passará se a exceção for capturada.
        }
    }

    @Test
    public void testImprimirComSaldoSuficiente() {
        TicketMachine ticketMachine = new TicketMachine(10);
        try {
            ticketMachine.inserir(20);
            String expected = "*****************\n*** R$ 10,00 ****\n*****************\n";
            assertEquals(expected, ticketMachine.imprimir());
        } catch (PapelMoedaInvalidaException | SaldoInsuficienteException e) {
            fail("Uma exceção não esperada foi lançada");
        }
    }

    @Test
    public void testImprimirComSaldoInsuficiente() {
        TicketMachine ticketMachine = new TicketMachine(10);
        try {
            ticketMachine.inserir(5);
            ticketMachine.imprimir();
            fail("Uma exceção deveria ter sido lançada");
        } catch (PapelMoedaInvalidaException e) {
            fail("Uma exceção não esperada foi lançada");
        } catch (SaldoInsuficienteException e) {
            // Espera-se que uma exceção seja lançada, portanto, o teste passará se a exceção for capturada.
        }
    }
}
