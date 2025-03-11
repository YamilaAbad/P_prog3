public class Main {

    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();

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
        System.out.println("Hojas que superan el numero "+k+": "+ arbol.hojasQueSuperanElNumero(k));
    }
}
