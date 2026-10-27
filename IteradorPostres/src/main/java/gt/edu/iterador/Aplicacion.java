package gt.edu.iterador;

public final class Aplicacion {
    private Aplicacion() { }

    public static void main(String[] args) {
        Menu<String> menu = new Menu<>();
        menu.agregar("Pastel");
        menu.agregar("Brownie");
        menu.agregar("Cupcake");

        Iterador<String> iterador = menu.crearIterador();
        while (iterador.tieneSiguiente()) {
            System.out.println(iterador.siguiente());
        }
    }
}
