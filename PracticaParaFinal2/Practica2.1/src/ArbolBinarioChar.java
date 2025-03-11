import java.util.ArrayList;
import java.util.List;

public class ArbolBinarioChar {
    private NodoChar raiz;

    public ArbolBinarioChar(NodoChar raiz) {
        this.raiz=raiz;
    }

    public void ArbolBinario(){
        this.raiz=null;
    }

    public void Insert(char value) {
        if (this.raiz == null) {
            this.raiz = new NodoChar(value);
        } else {
            this.insert(this.raiz, value);
        }
    }

    private void insert(NodoChar actual, char valor) {
        if (actual.getCharNodo() > valor) {
            //Inserto a la izquierda
            if (actual.getHijoIzq() == null) {
                NodoChar tmp = new NodoChar(valor);
                actual.setHijoIzq(tmp);
            } else {
                insert(actual.getHijoIzq(), valor);
            }
        } else if (actual.getCharNodo() < valor) {
            //Inserto a la derecha
            if (actual.getHijoDer() == null) {
                NodoChar tmp = new NodoChar(valor);
                actual.setHijoDer(tmp);
            } else {
                insert(actual.getHijoDer(), valor);
            }
        }
    }

    private boolean isEmpty(){
        return this.raiz==null;
    }

    /*EJERCICIO 5
Dado un árbol binario donde todos los nodos poseen un carácter, de manera que cada rama del
árbol contiene una palabra, implementar un algoritmo que busque y retorne todas las palabras
que posea exactamente N vocales (ni más ni menos). Por ejemplo, para el siguiente árbol, con
una entrada de N = 1, el algoritmo debería retornar [“MAL”]. En cambio, para un N = 2, debería
retornar [“MANA”, “MANO”, “MISA”].
 */
    public List<String> formarPalabras(int n){
        if (isEmpty()){
            return null;
        }
        List<String> palabrasEncontradas= new ArrayList<>();
        String palabraActual= "";
        palabras (raiz,palabrasEncontradas,palabraActual,n,0);
        return palabrasEncontradas;
    }

    private void palabras(NodoChar nodo,List<String>palabrasEncontradas,String palabraActual, int cantVocales, int cantActual){
        if (cantActual==cantVocales && esHoja(nodo)){
            palabrasEncontradas.add(palabraActual);
            cantActual=0;
            palabraActual = "";
        }
        if (cantActual<cantVocales){
            if(esVocal(nodo.getCharNodo())){
                cantActual++;
            }
            palabraActual = palabraActual + nodo.getCharNodo();
        }
        if (nodo.getHijoIzq()!=null){
            palabras(nodo.getHijoIzq(),palabrasEncontradas,palabraActual,cantVocales,cantActual);
        }
        if (nodo.getHijoDer()!=null){
            palabras(nodo.getHijoDer(),palabrasEncontradas,palabraActual,cantVocales,cantActual);
        }
    }
    private boolean esVocal(char c){
        if (c == 'a'||c =='e'||c =='i'||c =='o'||c =='u')
            return true;
        else return false;
    }

    private boolean esHoja(NodoChar nodo){
        return nodo.getHijoDer()==null && nodo.getHijoIzq()==null;
    }
}
