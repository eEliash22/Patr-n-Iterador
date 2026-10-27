package gt.edu.iterador;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Menu<T> implements Coleccion<T> {
    private final List<T> elementos = new ArrayList<>();

    public void agregar(T elemento) {
        elementos.add(Objects.requireNonNull(elemento, "Elemento obligatorio"));
    }

    @Override
    public Iterador<T> crearIterador() {
        return new IteradorMenu<>(elementos);
    }
}
