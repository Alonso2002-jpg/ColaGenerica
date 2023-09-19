import org.ejemplo.Repository.ColaEjecucionImpl;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
public class ColaTest {

    @Test
    public void testEncolar(){
        ColaEjecucionImpl<Integer> cola=new ColaEjecucionImpl<>();
        cola.encolar(4);
        assertAll(
                ()->assertEquals(1, cola.size()),
                ()->assertFalse(cola.isEmpty())
        );
    }

    @Test
    public void testDesencolar(){
        ColaEjecucionImpl<Integer> cola=new ColaEjecucionImpl<>();
        int encolado=4;
        cola.encolar(encolado);
        Optional<Integer> desencolado = cola.desencolar();
        assertAll(
                ()->assertEquals(encolado,desencolado),
                ()->assertTrue(desencolado.isPresent())
        );
    }

    @Test
    public void testFrente() {
        ColaEjecucionImpl<Integer> cola=new ColaEjecucionImpl<>();
        cola.encolar(5);
        cola.encolar(10);
        Optional<Integer> first = cola.first();
        assertAll(
                () -> assertTrue(first.isPresent()),
                () -> assertEquals(5, first.get())
        );
    }

    @Test
    public void testFrenteConColaVacia() {
        ColaEjecucionImpl<Integer> cola=new ColaEjecucionImpl<>();
        Optional<Integer> first = cola.first();
        assertAll(
                () -> assertFalse(first.isPresent())
        );
    }

    @Test
    public void testEsVacia() {
        ColaEjecucionImpl<Integer> cola=new ColaEjecucionImpl<>();

        assertAll(
                () -> assertTrue(cola.isEmpty()),
                () -> {
                    cola.encolar(5);
                    assertFalse(cola.isEmpty());
                }
        );
    }

    @Test
    public void testSize() {
        ColaEjecucionImpl<Integer> cola=new ColaEjecucionImpl<>();

        assertAll(
                () -> assertEquals(0, cola.size()),
                () -> {
                    cola.encolar(5);
                    assertEquals(1, cola.size());
                }
        );
    }

    @Test
    public void testVaciar() {
        ColaEjecucionImpl<Integer> cola=new ColaEjecucionImpl<>();
        assertAll(
                () -> {
                    cola.encolar(5);
                    assertFalse(cola.isEmpty());
                },
                () -> {
                    cola.vaciar();
                    assertTrue(cola.isEmpty());
                }
        );
    }

    @Test
    public void testFilter(){
        ColaEjecucionImpl<Integer> cola=new ColaEjecucionImpl<>();
        cola.encolar(4);
        cola.encolar(6);
        List<Integer> col = cola.filter(x -> x >=5);
        assertAll(
                () -> assertEquals(4,col.get(0)),
                () -> assertEquals(6,col.get(0))
        );
    }

}
