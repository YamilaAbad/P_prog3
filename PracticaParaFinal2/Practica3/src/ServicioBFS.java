import java.util.*;

public class ServicioBFS {
    private Grafo<?> grafo;
    private List<Integer> visitados;
    private Set<Integer> verticesVisitados;

    public ServicioBFS(Grafo<?> grafo){
        this.grafo=grafo;
        this.visitados = new ArrayList<>();
        this.verticesVisitados = new HashSet<>();
    }

    public List<Integer> recorridoBFS(){
        Queue<Integer> cola = new LinkedList<>();
        Iterator<Integer> verticesIterator = grafo.obtenerVertices();
        while(verticesIterator.hasNext()){
            int vertice = verticesIterator.next();
            if (!verticesVisitados.contains(vertice)){
                verticesVisitados.add(vertice);
                visitados.add(vertice);
                cola.add(vertice);
                int i=0;
                while(i<cola.size()){
                    Integer verticeActual = cola.poll();
                    Iterator<Integer> adyacentes = grafo.obtenerAdyacentes(verticeActual);
                    while(adyacentes.hasNext()){
                        Integer adyacente = adyacentes.next();
                        if (!verticesVisitados.contains(adyacente)){
                            verticesVisitados.add(adyacente);
                            visitados.add(adyacente);
                            cola.add(adyacente);
                        }
                    }
                    i++;
                }
            }
        }
        return visitados;
    }

}
