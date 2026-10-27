package gt.edu.iterador;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import static org.junit.Assert.*;

public class SalidaTest {
    @Test public void agregarVoidPermiteRecorrerElemento() {
        ByteArrayOutputStream captura = new ByteArrayOutputStream();
        PrintStream original = System.out;
        try (PrintStream salida = new PrintStream(captura, true, StandardCharsets.UTF_8)) {
            System.setOut(salida);
            Menu<String> menu = new Menu<>();
            menu.agregar("Pastel");
            Iterador<String> it = menu.crearIterador();
            assertEquals("Pastel", it.siguiente());
            assertFalse(it.tieneSiguiente());
            assertEquals("", captura.toString(StandardCharsets.UTF_8));
        } finally { System.setOut(original); }
    }

    @Test public void agregarVoidRechazaNuloSinImprimir() {
        ByteArrayOutputStream captura = new ByteArrayOutputStream();
        PrintStream original = System.out;
        try (PrintStream salida = new PrintStream(captura, true, StandardCharsets.UTF_8)) {
            System.setOut(salida);
            Menu<String> menu = new Menu<>();
            assertThrows(NullPointerException.class, () -> menu.agregar(null));
            assertFalse(menu.crearIterador().tieneSiguiente());
            assertEquals("", captura.toString(StandardCharsets.UTF_8));
        } finally { System.setOut(original); }
    }

    @Test public void mainVoidImprimeMenuCompleto() {
        ByteArrayOutputStream captura = new ByteArrayOutputStream();
        PrintStream original = System.out;
        try (PrintStream salida = new PrintStream(captura, true, StandardCharsets.UTF_8)) {
            System.setOut(salida);
            Aplicacion.main(new String[0]);
            String salto = System.lineSeparator();
            assertEquals("Pastel" + salto + "Brownie" + salto + "Cupcake" + salto,
                    captura.toString(StandardCharsets.UTF_8));
        } finally { System.setOut(original); }
    }
}
