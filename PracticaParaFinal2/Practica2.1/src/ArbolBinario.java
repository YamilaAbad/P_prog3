import java.util.*;

public class ArbolBinario {
    private Nodo raiz;

    public ArbolBinario(Nodo raiz) {
        this.raiz=raiz;
    }

    public void ArbolBinario(){
        this.raiz=null;
    }



    /**
     * Integer getRoot(), boolean hasElem(Integer), boolean isEmpty(), void insert(Integer),
     * boolean delete(Integer), int getHeight(), void printPosOrder(), void printPreOrder(), void
     * printInOrder(), List getLongestBranch(), List getFrontera(), Integer getMaxElem(), List
     * getElemAtLevel(int)
     */

    //devuelvo la raiz como tal
    public Nodo getRoot(){
        return this.raiz;
    }
    //devuelvo el valor especifico de la raiz
    public int getValorRoot(){
        return this.raiz.getValorNodo();
    }

    //devuelve verdadero si el elemento buscado existe en el arbol, devuelve falso en caso contrario
    public boolean hasElem(int elemento){
        if (isEmpty()){
            return false;
        }
        return buscarElemento(raiz,elemento);
    }

    private boolean buscarElemento(Nodo nodo, int elemento){
        if (nodo.getValorNodo()==elemento){
            return true;
        }
        if (nodo.getValorNodo()<elemento){
            return (buscarElemento(nodo.getHijoIzq(),elemento));
        }else {
            return (buscarElemento(nodo.getHijoDer(),elemento));
        }
    }

    public boolean isEmpty(){
        return this.raiz==null;
    }

    public void Insert(int value) {
        if (this.raiz == null) {
            this.raiz = new Nodo(value);
        } else {
            this.insert(this.raiz, value);
        }
    }

    private void insert(Nodo actual, int valor) {
        if (actual.getValorNodo() > valor) {
            //Inserto a la izquierda
            if (actual.getHijoIzq() == null) {
                Nodo tmp = new Nodo(valor);
                actual.setHijoIzq(tmp);
            } else {
                insert(actual.getHijoIzq(), valor);
            }
        } else if (actual.getValorNodo() < valor) {
            //Inserto a la derecha
            if (actual.getHijoDer() == null) {
                Nodo tmp = new Nodo(valor);
                actual.setHijoDer(tmp);
            } else {
                insert(actual.getHijoDer(), valor);
            }
        }
    }

    //Borro un elemento del arbol
    public boolean delete(int valor) {
        raiz = deleteRecursivo(raiz, valor);
        return true; // Se encontró y eliminó el nodo
    }

    private Nodo deleteRecursivo(Nodo nodo, int valor) {
        if (nodo == null) {
            return nodo; // Nodo no encontrado
        }

        if (valor < nodo.getValorNodo()) {
            /*nodo.getHijoIzq() =*/ deleteRecursivo(nodo.getHijoIzq(), valor);
        } else if (valor > nodo.getValorNodo()) {
            /*nodo.getHijoDer() =*/ deleteRecursivo(nodo.getHijoDer(), valor);
        } else { // Nodo encontrado
            // Caso 1: Nodo Hoja
            if (nodo.getHijoIzq() == null && nodo.getHijoDer() == null) {
                return null;
            }

            // Caso 2: Nodo con un Hijo
            if (nodo.getHijoIzq() == null) {
                return nodo.getHijoDer();
            } else if (nodo.getHijoDer() == null) {
                return nodo.getHijoIzq();
            }

            // Caso 3: Nodo con Dos Hijos
            Nodo sucesor = minValor(nodo.getHijoDer());
            nodo.setValorNodo(sucesor.getValorNodo());
            nodo.setHijoDer( deleteRecursivo(nodo.getHijoDer(), sucesor.getValorNodo()));
        }
        return nodo;
    }
    // Encuentra el nodo con el valor mínimo en un subárbol
    Nodo minValor(Nodo nodo) {
        while (nodo.getHijoIzq() != null) {
            nodo = nodo.getHijoIzq();
        }
        return nodo;
    }

    public int getHeight(Nodo nodo) {
        if (nodo == null) {
            return 0;
        } else {
            int alturaIzquierda = getHeight(nodo.getHijoIzq());
            int alturaDerecha = getHeight(nodo.getHijoDer());
            return Math.max(alturaIzquierda, alturaDerecha) + 1;
        }
    }
    //ORDENAMIENTOS
    public void printInOrden() {
        this.inOrden(this.raiz);
    }

    private void inOrden(Nodo nodo) {
        if (nodo != null) {
            inOrden(nodo.getHijoIzq());
            System.out.print(nodo.getValorNodo() + " ");
            inOrden(nodo.getHijoDer());
        }
    }

    public void printPosOrden() {
        this.posOrden(this.raiz);
    }

    private void posOrden(Nodo nodo) {
        if (nodo != null) {
            posOrden(nodo.getHijoIzq());
            posOrden(nodo.getHijoDer());
            System.out.print(nodo.getValorNodo() + " ");
        }
    }

    public void printPreOrden() {
        this.preOrden(this.raiz);
    }
    private void preOrden(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.getValorNodo() + " ");
            preOrden(nodo.getHijoIzq());
            preOrden(nodo.getHijoDer());
        }
    }
 //DEVUELVO EL ELEMENTO MAXIMO QUE SE ENCUENTRA EN EL ARBOL.
    public Integer getMaxElem(){
        if (isEmpty()){
            return null;
        }else
            return elementoMaximoDelArbol(raiz,0);
    }

    private int elementoMaximoDelArbol(Nodo nodo, int n){
        if(nodo.getValorNodo()>n){
            n= nodo.getValorNodo();
        }
        if (nodo.getHijoDer()!=null){
           return elementoMaximoDelArbol(nodo.getHijoDer(),n);
        }
        return n;
    }
//DEVUELVO UNA LISTA CON EL NIVEL QUE SE PASA POR PARAMETRO
    public List<Integer> getElemAtLevel(int n){
        if(isEmpty()){
            return null;
        }
        List<Integer> nodos = new ArrayList<>();
        return buscarNodos(nodos,raiz, n,0);
    }

    private List<Integer> buscarNodos(List<Integer> nodos, Nodo nodo, int nivel, int nivelActual){
        if (nodo == null) {
            return nodos;
        }
        if (nivelActual == nivel) {
            nodos.add(nodo.getValorNodo());
        }
        if (nivelActual < nivel) {
            buscarNodos(nodos, nodo.getHijoIzq(), nivel, nivelActual + 1);
            buscarNodos(nodos, nodo.getHijoDer(), nivel, nivelActual + 1);
        }
        return nodos;
    }
//IMPRIMIR ARBOL
    public void imprimirArbol(Nodo nodo, String indent) {
        if (nodo == null) return;
        Integer valor = nodo.getValorNodo();
        System.out.println(indent + (valor != null ? valor : "null"));
        imprimirArbol(nodo.getHijoIzq(), indent + "   ");
        imprimirArbol(nodo.getHijoDer(), indent + "   ");
    }
    /****************************************************************************************************************************************************************************/
 /*Ejercicio 2
Dado un árbol binario de búsquedas que almacena números enteros, implementar un algoritmo
que retorne la suma de todos los nodos internos del árbol.*/
    public Integer sumaDeValoresDelArbol(){
        if (isEmpty()){
            return -1;
        }
        return sumar(raiz,0);
    }
    private Integer sumar(Nodo nodo, int sumaActual){
        sumaActual = sumaActual + nodo.getValorNodo();
        if (nodo.getHijoIzq()!=null){
            sumaActual = sumar(nodo.getHijoIzq(),sumaActual);
        }
        if (nodo.getHijoDer()!=null){
            sumaActual = sumar(nodo.getHijoDer(),sumaActual);
        }
        return sumaActual;
    }
/*EJERCICIO 3
Dado un árbol binario de búsqueda que almacena
números enteros y un valor de entrada K, implementar un
algoritmo que permita obtener un listado con los valores
de todas las hojas cuyo valor supere K. Por ejemplo, para
el árbol de la derecha, con un valor K = 8, el resultado
debería ser [9, 11].
*/
    public List<Integer> hojasQueSuperanElNumero(int k){
        if (isEmpty()){
            return null;
        }
        List<Integer> hojas = new ArrayList<>();
        return buscarHojasMayoresAk(raiz,hojas,k);
    }
    private List<Integer> buscarHojasMayoresAk(Nodo nodo, List<Integer> hojas, int k){
        if (esHoja(nodo) && nodo.getValorNodo()>k){
            hojas.add(nodo.getValorNodo());
        }
        if (nodo.getHijoIzq()!=null){
            buscarHojasMayoresAk(nodo.getHijoIzq(),hojas,k);
        }
        if (nodo.getHijoDer()!=null){
            buscarHojasMayoresAk(nodo.getHijoDer(),hojas,k);
        }
        return hojas;
    }
    private boolean esHoja(Nodo nodo){
        return nodo.getHijoDer()==null && nodo.getHijoIzq()==null;
    }

/*EJERCICIO 4
Se posee un árbol binario (no de búsqueda), donde los nodos internos están vacíos, mientras
que las hojas tienen valores enteros. Se debe implementar un método que recorra el árbol y
coloque valores en los nodos vacíos (los nodos internos). El valor de cada nodo interno debe
ser igual al valor de su hijo derecho, menos el valor de su hijo izquierdo. En caso de que el
nodo tenga un solo hijo, el valor del hijo faltante se reemplaza por un 0. Por ejemplo, tomando
como entrada el árbol de la izquierda, el árbol resultante debería quedar con los mismos
valores que el de la derecha.
 */
    public void llenarArbolInterno() {
        if (raiz != null) {
            rellenar(raiz);
        }
    }

    private void rellenar(Nodo nodoActual) {
        if (nodoActual == null) return;
        Nodo hijoIzq = nodoActual.getHijoIzq();
        Nodo hijoDer = nodoActual.getHijoDer();

        if (hijoIzq != null && hijoDer != null) {
            nodoActual.setValorNodo(hijoDer.getValorNodo() - hijoIzq.getValorNodo());
        } else if (hijoIzq != null) {
            nodoActual.setValorNodo(0 - hijoIzq.getValorNodo());
        } else if (hijoDer != null) {
            nodoActual.setValorNodo(hijoDer.getValorNodo() - 0);
        }

        if (hijoIzq != null) {
            rellenar(hijoIzq);
        }
        if (hijoDer != null) {
            rellenar(hijoDer);
        }
    }

}
