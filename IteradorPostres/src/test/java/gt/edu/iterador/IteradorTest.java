package gt.edu.iterador;

import org.junit.Test;
import java.util.Arrays;
import java.util.NoSuchElementException;
import static org.junit.Assert.*;

public class IteradorTest {
    private Menu<String> menu() {
        Menu<String> menu = new Menu<>();
        menu.agregar("Pastel");
        menu.agregar("Brownie");
        return menu;
    }

    @Test public void tieneSiguienteNoConsumeElementos() {
        Iterador<String> it = menu().crearIterador();
        assertTrue(it.tieneSiguiente());
        assertTrue(it.tieneSiguiente());
        assertEquals("Pastel", it.siguiente());
    }

    @Test public void siguienteRespetaOrdenYAvanza() {
        Iterador<String> it = menu().crearIterador();
        assertEquals("Pastel", it.siguiente());
        assertEquals("Brownie", it.siguiente());
        assertFalse(it.tieneSiguiente());
    }

    @Test public void menuVacioNoTieneSiguiente() {
        assertFalse(new Menu<String>().crearIterador().tieneSiguiente());
    }

    @Test public void siguienteVacioLanzaExcepcion() {
        Iterador<String> it = new Menu<String>().crearIterador();
        assertThrows(NoSuchElementException.class, () -> it.siguiente());
    }

    @Test public void siguienteAgotadoLanzaExcepcion() {
        Iterador<String> it = menu().crearIterador();
        it.siguiente();
        it.siguiente();
        assertThrows(NoSuchElementException.class, () -> it.siguiente());
    }

    @Test public void crearIteradorProduceRecorridosIndependientes() {
        Menu<String> menu = menu();
        Iterador<String> primero = menu.crearIterador();
        primero.siguiente();
        Iterador<String> segundo = menu.crearIterador();
        assertEquals("Pastel", segundo.siguiente());
        assertEquals("Brownie", primero.siguiente());
    }

    @Test public void iteradorConservaCopiaDelMenu() {
        Menu<String> menu = menu();
        Iterador<String> it = menu.crearIterador();
        menu.agregar("Cupcake");
        it.siguiente();
        it.siguiente();
        assertFalse(it.tieneSiguiente());
        Iterador<String> nuevo = menu.crearIterador();
        nuevo.siguiente(); nuevo.siguiente();
        assertEquals("Cupcake", nuevo.siguiente());
    }

    @Test public void constructorCopiaListaRecibida() {
        java.util.List<String> lista = new java.util.ArrayList<>(Arrays.asList("Pastel"));
        Iterador<String> it = new IteradorMenu<>(lista);
        lista.clear();
        assertEquals("Pastel", it.siguiente());
    }

    @Test public void constructorRechazaListaNula() {
        assertThrows(NullPointerException.class, () -> new IteradorMenu<String>(null));
    }
}
