import java.util.ArrayList;
import java.util.List;

public class ArbolDeLibros {

        private Libro raiz;

        public ArbolDeLibros(Libro raiz) {
            this.raiz=raiz;
        }

        public void ArbolDeLibros(){
            this.raiz=null;
        }

        public void Insert(Libro l) {
            if (this.raiz == null) {
                this.raiz = new Libro(l.titulo,l.autor,l.genero,l.anioPublicacion,l.cantEjemplares,l.identificador);
            } else {
                this.insert(this.raiz, l);
            }
        }

        private void insert(Libro actual, Libro l) {
            if (actual.getIdentificador() > l.identificador) {
                //Inserto a la izquierda
                if (actual.getHijIzq() == null) {
                    Libro tmp = new Libro(l.titulo,l.autor,l.genero,l.anioPublicacion,l.cantEjemplares,l.identificador);
                    actual.setHijIzq(tmp);
                } else {
                    insert(actual.getHijIzq(), l);
                }
            } else if (actual.getIdentificador() < l.getIdentificador()) {
                //Inserto a la derecha
                if (actual.getHijDer() == null) {
                    Libro tmp = new Libro(l.titulo,l.autor,l.genero,l.anioPublicacion,l.cantEjemplares,l.identificador);
                    actual.setHijDer(tmp);
                } else {
                    insert(actual.getHijDer(), l);
                }
            }
        }

        private boolean isEmpty(){
            return this.raiz==null;
        }

/*
 Se desea desarrollar una aplicación para mejorar la atención de una biblioteca en cuanto a la
 búsqueda de libros dentro del catálogo disponible. Cada libro estará compuesto por un
 identificador único y datos propios de los libros (título, autor, géneros, año de publicación,
 cantidad de ejemplares, etc.)
 Se sabe, además, que los libros nuevos se agregan al catálogo en horarios fuera de la atención
 al público.
 Se desean proveer los siguientes servicios:
 ● Obtener la cantidad de ejemplares de un libro dado su identificador único.
 ● Obtener todos los libros de un género dado.
 ● Obtener todos los libros publicados entre dos años de publicación dados.
 */

    // ● Obtener la cantidad de ejemplares de un libro dado su identificador único.
    public Integer cantEjemplares(int ident){
        if (isEmpty()){
            return null;
        }
        return cant(raiz,ident);
    }
    private int cant(Libro l, int ident) {
        if (l.getIdentificador() == ident) {
            return l.getCantEjemplares();
        }
        if (l.hijIzq != null) {
            int resultadoIzq = cant(l.hijIzq, ident);
            if (resultadoIzq != -1) {
                return resultadoIzq;
            }
        }
        if (l.hijDer != null) {
            return cant(l.hijDer, ident);
        }
        return -1;
    }
    // ● Obtener todos los libros de un género dado.
    public List<Libro> librosDeUnGenero(String genero){
        if (isEmpty()){
            return null;
        }
        List<Libro> librosEncontrados = new ArrayList<>();
        burcarLibrosPorGenero(raiz,librosEncontrados,genero);
        return librosEncontrados;
    }

    private void burcarLibrosPorGenero(Libro l, List<Libro> librosEncontrados, String genero) {
        if (l.getGenero()==genero){
            librosEncontrados.add(l);
        }
        if (l.hijIzq!=null){
            burcarLibrosPorGenero(l.hijIzq,librosEncontrados,genero);
        }
        if (l.hijDer!=null){
            burcarLibrosPorGenero(l.hijDer,librosEncontrados,genero);
        }
    }

    // ● Obtener todos los libros publicados entre dos años de publicación dados.
    public List<Libro> librosPublicadosEntreLosAños(int anio1, int anio2){
        if (isEmpty()){
            return null;
        }
        List<Libro>libros = new ArrayList<>();
        buscarLibrosPorAñoPublicacion(raiz,libros,anio1,anio2);
        return libros;
    }
    private List<Libro> buscarLibrosPorAñoPublicacion(Libro l, List<Libro>libros, int a1, int a2){
        if (l.getAnioPublicacion()>a1 && l.getAnioPublicacion()<a2){
            libros.add(l);
        }
        if (l.getHijIzq()!=null){
            buscarLibrosPorAñoPublicacion(l.getHijIzq(),libros,a1,a2);
        }
        if (l.getHijDer()!=null){
            buscarLibrosPorAñoPublicacion(l.getHijDer(),libros,a1,a2);
        }
        return libros;
    }
}
