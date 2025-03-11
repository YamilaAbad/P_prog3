public class Nodo {
    private int valorNodo;
    private Nodo hijoIzq;
    private Nodo hijoDer;

    public Nodo(){
        this.valorNodo=0;
        this.hijoIzq=null;
        this.hijoDer=null;
    }

    public Nodo(int valor){
        this.valorNodo=valor;
        this.hijoIzq=null;
        this.hijoDer=null;
    }

    public int getValorNodo() {
        return valorNodo;
    }

    public void setValorNodo(int valor){
        this.valorNodo=valor;
    }

    public Nodo getHijoIzq(){
        return this.hijoIzq;
    }

    public void setHijoIzq(Nodo nodo){
        this.hijoIzq=nodo;
    }

    public Nodo getHijoDer(){
        return this.hijoDer;
    }

    public void setHijoDer(Nodo nodo){
        this.hijoDer=nodo;
    }

    @Override
    public String toString() {
        return toString(" ", true);
    }
    private String toString(String actual, boolean esElultimo){
        String nodo = actual;
        if(esElultimo){
            nodo +="└──";
            actual += " ";
        }else{
            nodo += "├──";
            actual += "│ ";
        }
        nodo += this.valorNodo + "\n";
        if(this.getHijoIzq() != null){
            nodo += this.getHijoIzq().toString(actual, this.getHijoDer() == null);
        }
        if(this.getHijoDer() != null){
            nodo += this.getHijoDer().toString(actual, true);
        }
        return nodo;
    }
}
