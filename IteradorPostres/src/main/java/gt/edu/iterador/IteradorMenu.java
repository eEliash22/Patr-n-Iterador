package gt.edu.iterador;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

/** Solo controla la posicion de una copia del menu. */
public final class IteradorMenu<T> implements Iterador<T> {
    private final List<T> elementos;
    private int posicion = 0;

    public IteradorMenu(List<T> elementos) {
        this.elementos = new ArrayList<>(
                Objects.requireNonNull(elementos, "Lista obligatoria"));
    }

    @Override
    public boolean tieneSiguiente() {
        return posicion < elementos.size();
    }

    @Override
    public T siguiente() {
        if (!tieneSiguiente()) {
            throw new NoSuchElementException("No hay mas elementos");
        }
        return elementos.get(posicion++);
    }
}
