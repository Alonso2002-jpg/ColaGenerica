import org.ejemplo.Repository.ColaEjecucionImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
public class ColaTest {

    ColaEjecucionImpl<Integer> cola=new ColaEjecucionImpl<>();
     @BeforeEach
    public void setUp() {
        cola = new ColaEjecucionImpl<>();
    }

    @Test
    public void testEncolar(){
        cola.encolar(4);
        assertAll(
                ()->assertEquals(1, cola.size()),
                ()->assertFalse(cola.isEmpty())
        );
    }

    @Test
    public void testDesencolar(){
        int encolado=4;
        cola.encolar(encolado);
        Optional<Integer> desencolado = cola.desencolar();
        assertAll(
                ()->assertEquals(encolado,desencolado.get()),
                ()->assertTrue(desencolado.isPresent())
        );
    }

    @Test
    public void testFrente() {
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
        Optional<Integer> first = cola.first();
        assertAll(
                () -> assertFalse(first.isPresent())
        );
    }

    @Test
    public void testEsVacia() {
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
        cola.encolar(4);
        cola.encolar(6);
        List<Integer> col = cola.filter(x -> x >=5);
        assertAll(
                () -> assertEquals(6,col.get(0)),
                () -> assertFalse(col.contains(4))
        );
    }

    @Test
    public void testMap(){
        cola.encolar(10);
        cola.encolar(15);

        List<Integer> col = cola.map(x -> x * 10);
        assertAll(
                () -> assertEquals(10*10,col.get(0)),
                () -> assertEquals(15*10,col.get(1))
        );
    }

    @Test
    public void testFind(){
    cola.encolar(10);
    cola.encolar(15);
    cola.encolar(24);

    var val = cola.find(x -> x>10);

        assertAll(
                () -> assertEquals(15,val.get()),
                () -> assertNotEquals(24,val.get())
        );
    }

    @Test
    public void testFindIndex(){
    cola.encolar(10);
    cola.encolar(15);
    cola.encolar(24);

    var val = cola.findIndex(x -> x>10);

        assertAll(
                () -> assertEquals(1,val),
                () -> assertNotEquals(3,val)
        );
    }

    @Test
    public void testFindLast(){
    cola.encolar(10);
    cola.encolar(15);
    cola.encolar(24);

    var val = cola.findLast(x -> x>10);

        assertAll(
                () -> assertEquals(24,val.get()),
                () -> assertNotEquals(15,val.get())
        );
    }

    @Test
    public void testFindLastIndex(){
    cola.encolar(10);
    cola.encolar(15);
    cola.encolar(24);

    var val = cola.findLastIndex(x -> x>10);

        assertAll(
                () -> assertEquals(2,val),
                () -> assertNotEquals(1,val)
        );
    }

    @Test
    public void testForEach(){
         cola.encolar(10);
         cola.encolar(15);
         List<Integer> cola2=new ArrayList<>();
         cola.forEach(x -> {
            cola2.add(x);
             return null;
         });
         assertAll(
                () -> assertEquals(10,cola2.get(0)),
                () -> assertEquals(15,cola2.get(1))
        );
    }

    @Test
    public void testSort(){
         cola.encolar(10);
         cola.encolar(40);
         cola.encolar(5);
         cola.encolar(24);
         cola.encolar(2);

        List<Integer> cola2= cola.getCola();
        Collections.sort(cola2);

        List<Integer> cola3= cola.sort((x,y) -> x < y);

        assertEquals(cola2,cola3);
    }
}
