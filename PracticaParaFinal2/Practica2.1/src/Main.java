import java.util.List;

public class Main {

    public static void main(String[] args) {
        /**************************************************************************************************************
         * ************************************************************************************************************
         * MAIN  PARA ARBOL DE INTEGERS
         * ************************************************************************************************************
         * ************************************************************************************************************
         */
       /* ArbolBinario arbol = new ArbolBinario();

        arbol.Insert(15);
        arbol.Insert(6);
        arbol.Insert(18);
        arbol.Insert(3);
        arbol.Insert(7);
        arbol.Insert(17);
        arbol.Insert(20);
        arbol.Insert(2);
        arbol.Insert(4);
        arbol.Insert(13);
        arbol.Insert(9);
        arbol.Insert(44);
        int k = 49;
        System.out.print("PreOrden: ");
        arbol.printPreOrden();
        System.out.println();
        System.out.print("PosOrden: ");
        arbol.printPosOrden();
        System.out.println();
        System.out.print("InOrden: ");
        arbol.printInOrden();
        System.out.println();
        System.out.println("Número maximo del arbol: "+arbol.getMaxElem());
        System.out.println("elementos en un nivel: "+ arbol.getElemAtLevel(2));
        System.out.println();
        System.out.println("suma total de los elementos del arbol: "+arbol.sumaDeValoresDelArbol());
        System.out.println();
        System.out.println("Hojas que superan el numero "+k+": "+ arbol.hojasQueSuperanElNumero(k));*/

        /**************************************************************************************************************
         * ************************************************************************************************************
         * MAIN  PARA ARBOL DE CHARS
         * ************************************************************************************************************
         * ************************************************************************************************************
         */
       /* Nodo hoja1 = new Nodo(5);  // Nodo con valor 5
        Nodo hoja2 = new Nodo(3);  // Nodo con valor 3
        Nodo hoja3 = new Nodo(8);  // Nodo con valor 8
        Nodo hoja4 = new Nodo(2);  // Nodo con valor 2

        // Creamos nodos internos vacíos
        Nodo nodoInterno1 = new Nodo();  // Nodo sin valor
        Nodo nodoInterno2 = new Nodo();  // Nodo sin valor
        Nodo nodoInterno3 = new Nodo();  // Nodo sin valor

        // Establecemos las relaciones entre los nodos (formando el árbol)
        nodoInterno1.setHijoIzq(hoja1);
        nodoInterno1.setHijoDer(hoja2);

        nodoInterno2.setHijoIzq(hoja3);
        nodoInterno2.setHijoDer(hoja4);

        nodoInterno3.setHijoIzq(nodoInterno1);
        nodoInterno3.setHijoDer(nodoInterno2);

        Nodo raiz = new Nodo();  // Raíz vacía
        raiz.setHijoIzq(nodoInterno3);

        // Creamos el árbol
        ArbolBinario arbol = new ArbolBinario(raiz);

        // Imprimimos el árbol antes de llenar los nodos internos
        System.out.println("Árbol antes de llenar los nodos internos:");
        arbol.imprimirArbol(arbol.getRoot(), "");

        // Llamamos al método para llenar los nodos internos
        arbol.llenarArbolInterno();

        // Imprimimos el árbol después de llenar los nodos internos
        System.out.println("\nÁrbol después de llenar los nodos internos:");
        arbol.imprimirArbol(arbol.getRoot(), ""); */

        /**************************************************************************************************************
         * ************************************************************************************************************
         * MAIN  PARA ARBOL DE LIBROS
         * ************************************************************************************************************
         * ************************************************************************************************************
         */

        // Crear algunos libros
        Libro libro1 = new Libro("Cien años de soledad", "Gabriel García Márquez", "Ficción", 1967, 3, 1);
        Libro libro2 = new Libro("El Quijote", "Miguel de Cervantes", "Ficción", 1605, 5, 2);
        Libro libro3 = new Libro("1984", "George Orwell", "Ficción", 1949, 4, 3);
        Libro libro4 = new Libro("El Principito", "Antoine de Saint-Exupéry", "Fantasía", 1943, 2, 4);
        Libro libro5 = new Libro("Sapiens", "Yuval Noah Harari", "No Ficción", 2011, 6, 5);

        // Crear el árbol de libros
        ArbolDeLibros arbol = new ArbolDeLibros(libro1);
        arbol.Insert(libro2);
        arbol.Insert(libro3);
        arbol.Insert(libro4);
        arbol.Insert(libro5);

        // Obtener la cantidad de ejemplares de un libro por identificador
        int identificadorBuscado = 2;
        System.out.println("Cantidad de ejemplares del libro con ID " + identificadorBuscado + ": " + arbol.cantEjemplares(identificadorBuscado));

        // Obtener todos los libros de un género dado
        String generoBuscado = "Ficción";
        List<Libro> librosGenero = arbol.librosDeUnGenero(generoBuscado);
        System.out.println("Libros de género " + generoBuscado + ":");
        for (Libro libro : librosGenero) {
            System.out.println("- " + libro.getTitulo() + " de " + libro.getAutor());
        }

        // Obtener libros publicados entre dos años
        int anioInicio = 1940;
        int anioFin = 2000;
        List<Libro> librosEntreAnios = arbol.librosPublicadosEntreLosAños(anioInicio, anioFin);
        System.out.println("Libros publicados entre " + anioInicio + " y " + anioFin + ":");
        for (Libro libro : librosEntreAnios) {
            System.out.println("- " + libro.getTitulo() + " (Año: " + libro.getAnioPublicacion() + ")");
        }
    }


}
