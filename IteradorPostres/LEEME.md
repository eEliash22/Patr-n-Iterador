# Ejemplo sencillo: menú de postres

## Abrir en IntelliJ IDEA
1. Descomprime el ZIP. File > Open > selecciona la carpeta IteradorPostres o su pom.xml.
2. Selecciona JDK 17. Acepta cargar el proyecto Maven y espera la descarga de JUnit 4.13.2 (requiere Internet).
3. Abre Aplicacion.java y pulsa el triángulo verde junto a main.
4. Haz clic derecho en src/test/java > Run All Tests. También puedes ejecutar `mvn test`.

Salida: Pastel, Brownie y Cupcake, cada uno en su propia línea.

## Diseño y responsabilidad única
- Coleccion<T>: abstracción para crear recorridos.
- Iterador<T>: abstracción con tieneSiguiente y siguiente.
- Menu<T>: administra elementos y fabrica iteradores.
- IteradorMenu<T>: conserva una copia y controla la posición.
- Aplicacion: configura el ejemplo y muestra el resultado.
- Genericidad: T permite reutilizar el recorrido; en el ejemplo se usa String.
- Encapsulamiento: atributos privados (-), operaciones públicas (+); no se expone la lista interna. No se requiere visibilidad protegida.
- Modularidad: cada clase está en su propio archivo, paquete gt.edu.iterador, producción y pruebas separadas.
- Jerarquía: Menu realiza Coleccion; IteradorMenu realiza Iterador. Son interfaces, no se necesita una superclase artificial.
- Excepciones: siguiente lanza NoSuchElementException al terminar; agregar y constructor rechazan null con NullPointerException y mensaje.
- La copia permite que agregar después no modifique un recorrido existente. Los elementos genéricos no se clonan en profundidad.

## Relaciones del diagrama
Realización: línea discontinua con triángulo vacío hacia la interfaz.
Dependencia: línea discontinua con flecha abierta hacia el tipo utilizado o creado; sin multiplicidad porque no es asociación estructural.
Los atributos elementos: List<T> representan una asociación navegable hacia 0..* elementos T; cada lista pertenece a una instancia propietaria. Se expresan dentro de las clases para evitar añadir un nodo T redundante.
Aplicacion utiliza Menu e Iterador como variables locales; no mantiene asociaciones persistentes.

## Pruebas
12 pruebas JUnit 4: orden, avance, consulta sin consumo, menú vacío, agotamiento, recorridos independientes, copia, validaciones y salida de consola.
Se cubren todos los métodos públicos de los contratos base: crearIterador, tieneSiguiente y siguiente; además agregar, constructor y main.
No se comprueban tipos en ejecución. ByteArrayOutputStream captura System.out en las pruebas de los métodos void; se restaura la salida en finally. En agregar también se verifica el estado observable, porque no imprime nada.
Mockito no es necesario: no hay servicios externos, base de datos ni colaboradores que simular. Consulta al docente si exige integración adicional; la prueba de main ya ejercita las clases conjuntamente sin Mockito.

## Diagramas y evidencias pendientes
Abre diagramas/Implementacion.dia con DIA (gratuito). Cada caja, texto y relación se puede editar. El PNG muestra el mismo diseño. Es un dibujo digital con figuras editables; no son objetos UML semánticos.
Conceptual_guia.png es una guía digital sencilla: cópiala A MANO, escanéala o fotografíala y guarda tu propia imagen. No es un escaneo real.
Para completar la evidencia exigida, toma capturas REALES en tu IntelliJ:
1. Interfaces y Menu (código legible).
2. IteradorMenu y Aplicacion.
3. IteradorTest y SalidaTest (varias capturas si hace falta).
4. Panel de pruebas con los resultados y los nombres de las pruebas.
No se incluyen capturas inventadas de IntelliJ ni fotografías simuladas.
