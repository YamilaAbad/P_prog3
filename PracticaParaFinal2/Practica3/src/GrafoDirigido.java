import java.util.*;

public class GrafoDirigido<T> implements Grafo<T> {

    private Map<Integer, List<Arco<T>>> listaAdyacentes;

    public GrafoDirigido() {
        listaAdyacentes = new HashMap<>();
    }

    @Override
    public void agregarVertice(int verticeId) {
        if (!listaAdyacentes.containsKey(verticeId)){
            listaAdyacentes.put(verticeId,new ArrayList<>());
        }
    }

    @Override
    public void borrarVertice(int verticeId) {
        listaAdyacentes.remove(verticeId);
        for(List<Arco<T>> arcos: listaAdyacentes.values()){
            arcos.removeIf(arco -> arco.getVerticeDestino() == verticeId);
        }
    }

    @Override
    public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
        Arco<T> arco = new Arco<>(verticeId1, verticeId2, etiqueta);
        if (!listaAdyacentes.containsKey(verticeId1)){
            listaAdyacentes.put(verticeId1, new ArrayList<>());
        }
        listaAdyacentes.get(verticeId1).add(arco);
    }

    @Override
    public void borrarArco(int verticeId1, int verticeId2) {
        List<Arco<T>> listaArcos = listaAdyacentes.get(verticeId1);
        if(listaArcos!=null){
            listaArcos.removeIf(arco-> arco.getVerticeDestino()==verticeId2);
        }
    }

    @Override
    public boolean contieneVertice(int verticeId) {
        return listaAdyacentes.containsKey(verticeId);
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        List<Arco<T>> listaArcos = listaAdyacentes.get(verticeId1);
        for(Arco<T> arco: listaArcos){
            if (arco.getVerticeDestino()==verticeId2){
                return true;
            }
        }
        return false;
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        List<Arco<T>> listaArcos = listaAdyacentes.get(verticeId1);
        if(listaArcos==null){
            return null;
        }
        for (Arco<T> arco:listaArcos){
            if (arco.getVerticeDestino()==verticeId2){
                return arco;
            }
        }
        return null;
    }

    @Override
    public int cantidadVertices() {
        return listaAdyacentes.size();
    }

    @Override
    public int cantidadArcos() {
        int cant=0;
        for (int listAd : listaAdyacentes.keySet()){
            List<Arco<T>> listArc = listaAdyacentes.get(listAd);
            cant = cant + listArc.size();
        }
        return cant;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        ArrayList<Integer> vertices = new ArrayList<>(listaAdyacentes.keySet());
        return vertices.iterator();
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        List<Arco<T>> listaAdy= listaAdyacentes.get(verticeId);
        List<Integer> listAdyInt = new ArrayList<Integer>();
        for(Arco<T> vertice : listaAdy){
            listAdyInt.add(vertice.getVerticeDestino());
        }
        return listAdyInt.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        List<Arco<T>> listArcos = new ArrayList<Arco<T>>();
        for(List<Arco<T>> listAdy : listaAdyacentes.values()){
            listArcos.addAll(listAdy);
        }
        return listArcos.iterator();
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        List<Arco<T>> arcos = listaAdyacentes.get(verticeId);
        if (arcos == null){
            arcos = new ArrayList<>();
        }
        return arcos.iterator();
    }

    /**
     * EJERCICIO 3
     * *Implemente un algoritmo que determine si un grafo dirigido tiene algún ciclo.
     */
    public boolean tieneCiclo() {
        Set<Integer> visitados = new HashSet<>();
        Set<Integer> caminoActual = new HashSet<>();
        Iterator<Integer> vertices = this.obtenerVertices();

        while (vertices.hasNext()) {
            Integer vertice = vertices.next();
            if (!visitados.contains(vertice)) {
                if (buscar(vertice, visitados, caminoActual)) {
                    imprimir(caminoActual);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean buscar(Integer actual, Set<Integer> visitados, Set<Integer> caminoActual) {
        if (caminoActual.contains(actual)) {
            return true;
        }
        if (visitados.contains(actual)) {
            return false;
        }

        visitados.add(actual);
        caminoActual.add(actual);

        Iterator<Integer> adyacentes = this.obtenerAdyacentes(actual);
        while (adyacentes.hasNext()) {
            Integer adyacente = adyacentes.next();
            if (buscar(adyacente, visitados, caminoActual)) {
                return true;
            }
        }

        caminoActual.remove(actual); // Retirar el vértice del camino actual
        return false;
    }
    private void imprimir(Set<Integer> camino){
        for (Integer dato: camino){
            System.out.print("["+dato+"]->");
        }
    }

    /**EJERCICIO 4
     * *Escribir un algoritmo que, dado un grafo dirigido y dos vértices i, j de este grafo, devuelva el
     * *camino simple (sin ciclos) de mayor longitud del vértice i al vértice j. Puede suponerse que
     * *el grafo de entrada es acíclico.
     */

    public void caminoSimple(int vertice1, int vertice2){
        Set<Integer> visitados = new HashSet<>();
        List<Integer> caminoMasLargo = new ArrayList<>();
        List<Integer> caminoActual = new ArrayList<>();
        buscarCaminoLargo(visitados,caminoActual,caminoMasLargo,vertice1,vertice2);

        if (caminoMasLargo.size()>0){
            imprimirLista(caminoMasLargo);
        }else System.out.println("No se encontro camino");

    }
    private void buscarCaminoLargo(Set<Integer> visitados, List<Integer> caminoActual, List<Integer> caminoMasLargo, int actual, int fin){
        if (actual==fin){
            caminoActual.add(actual);
            if (caminoActual.size()>caminoMasLargo.size()){
                caminoMasLargo.clear();
                caminoMasLargo.addAll(caminoActual);
            }
            caminoActual.remove(caminoActual.size()-1);
            return;
        }
        if (visitados.contains(actual)){
            return;
        }
        visitados.add(actual);
        caminoActual.add(actual);
        Iterator<Integer> adyacentes = obtenerAdyacentes(actual);
        while (adyacentes.hasNext()){
            Integer ady = adyacentes.next();
            buscarCaminoLargo(visitados,caminoActual,caminoMasLargo,ady,fin);
        }
        visitados.remove(actual);
        caminoActual.remove(caminoActual.size()-1);
    }
    private void imprimirLista(List<Integer> list){
        System.out.println("camino mas largo encontrado: "+list);
    }

    /**EJERCICIO 5
     * *Escriba un algoritmo que dado un grafo G y un vértice v de dicho grafo, devuelva una lista
     * *con todos los vértices a partir de los cuales exista un camino en G que termine en v.
     */

    public void exiteCaminoQueTermineEn(int v){
        Set<Integer> visitados = new HashSet<>();
        List<Integer> caminoActual = new ArrayList<>();
        List<List<Integer>> caminosTotales = new ArrayList<>();

        Iterator<Integer> vertices = this.obtenerVertices();
        while (vertices.hasNext()){
            Integer vertice = vertices.next();
            if (!visitados.contains(vertice)){
                buscarCaminos(visitados,caminoActual,caminosTotales,vertice,v);
            }
        }
        if (caminosTotales.size()>0){
            imprimirListaDeLista(caminosTotales);
        }else{
            System.out.println("No hubo caminos encontrados que terminen en: "+v);
        }
    }

    private void imprimirListaDeLista(List<List<Integer>> caminosTotales) {
        for (List<Integer> lista : caminosTotales){
            System.out.println("camino: "+lista+" ");
        }
    }

    private void buscarCaminos(Set<Integer> visitados, List<Integer> caminoActual, List<List<Integer>> caminosTotales, int actual, int fin){
        if (actual == fin) {
            caminoActual.add(actual);
            if (!caminoActual.isEmpty()) {
                List<Integer> caminoCopia = new ArrayList<>(caminoActual);
                caminosTotales.add(caminoCopia);
            }
            caminoActual.remove(caminoActual.size() - 1);
            return;
        }

        visitados.add(actual);
        caminoActual.add(actual);
        Iterator<Integer> adyacentes = obtenerAdyacentes(actual);
        while (adyacentes.hasNext()){
            Integer ady = adyacentes.next();
            buscarCaminos(visitados,caminoActual,caminosTotales,ady,fin);
        }
        caminoActual.remove(caminoActual.size()-1);
        visitados.remove(actual);

    }
}
