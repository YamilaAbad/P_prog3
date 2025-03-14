import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GrafoDirigido<T> implements Grafo<T> {

    private Map<Integer, List<Arco<T>>> listaAdyacentes;

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

    }

    @Override
    public boolean contieneVertice(int verticeId) {
        return false;
    }

    @Override
    public boolean existeArco(int verticeId1, int verticeId2) {
        return false;
    }

    @Override
    public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
        return null;
    }

    @Override
    public int cantidadVertices() {
        return 0;
    }

    @Override
    public int cantidadArcos() {
        return 0;
    }

    @Override
    public Iterator<Integer> obtenerVertices() {
        return null;
    }

    @Override
    public Iterator<Integer> obtenerAdyacentes(int verticeId) {
        return null;
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos() {
        return null;
    }

    @Override
    public Iterator<Arco<T>> obtenerArcos(int verticeId) {
        return null;
    }
}
