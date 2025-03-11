public class NodoChar {

    private char charNodo;
    private NodoChar hijoIzq;
    private NodoChar hijoDer;

    public NodoChar(){
        this.charNodo =0;
        this.hijoIzq=null;
        this.hijoDer=null;
    }

    public NodoChar(char valor){
        this.charNodo =valor;
        this.hijoIzq=null;
        this.hijoDer=null;
    }

    public char getCharNodo() {
        return charNodo;
    }

    public void setCharNodo(char valor){
        this.charNodo =valor;
    }

    public NodoChar getHijoIzq(){
        return this.hijoIzq;
    }

    public void setHijoIzq(NodoChar nodo){
        this.hijoIzq=nodo;
    }

    public NodoChar getHijoDer(){
        return this.hijoDer;
    }

    public void setHijoDer(NodoChar nodo){
        this.hijoDer=nodo;
    }

}
