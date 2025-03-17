import java.util.*;

public class ServicioDFS {
    private Grafo<?> grafo;
    private Set<Integer> verticesVisitados = new HashSet<>();
    private List<Integer> visitados;

    public ServicioDFS(Grafo<?> grafo){
        this.grafo=grafo;
        this.visitados = new ArrayList<>();
    }

    public List<Integer> recorridoDFS(){
        Iterator<Integer> verticesIterator = grafo.obtenerVertices();
        while(verticesIterator.hasNext()){
            Integer vertice = verticesIterator.next();
            if (!verticesVisitados.contains(vertice)){
                recorrer(vertice);
            }
        }
        return visitados;
    }

    private void recorrer (Integer vertice){
        if (!verticesVisitados.contains(vertice)){
            verticesVisitados.add(vertice);
            visitados.add(vertice);
        }
        Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(vertice);
        while(adyacentes.hasNext()){
            Integer adyacente = adyacentes.next();
            if (!verticesVisitados.contains(adyacente)){
                recorrer(adyacente);
            }
        }
    }
}
