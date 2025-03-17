public class Main {
    public static void main(String[] args) {
        GrafoDirigido<String> grafo = new GrafoDirigido<>();

        // Agregando vértices
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);

        // Agregando arcos (creando un ciclo entre 1, 2 y 3)
        grafo.agregarArco(1, 2, "A");
        grafo.agregarArco(2, 3, "B");
        grafo.agregarArco(3, 1, "C"); // Esto crea un ciclo
        grafo.agregarArco(3, 4, "D");

        System.out.println("El grafo tiene ciclo? "+grafo.tieneCiclo());
        grafo.caminoSimple(2,1);
        grafo.exiteCaminoQueTermineEn(2);
        // Verificando si el grafo tiene un ciclo
       /* if (grafo.tieneCiclo()) {
            System.out.println("El grafo tiene un ciclo.");
        } else {
            System.out.println("El grafo no tiene un ciclo.");
        }

        // Creamos un grafo sin ciclos
        GrafoDirigido<String> grafoSinCiclo = new GrafoDirigido<>();

        // Agregando vértices
        grafoSinCiclo.agregarVertice(1);
        grafoSinCiclo.agregarVertice(2);
        grafoSinCiclo.agregarVertice(3);

        // Agregando arcos sin crear ciclos
        grafoSinCiclo.agregarArco(1, 2, "E");
        grafoSinCiclo.agregarArco(2, 3, "F");

        // Verificando si el grafo tiene un ciclo
        if (grafoSinCiclo.tieneCiclo()) {
            System.out.println("El grafo sin ciclo tiene un ciclo.");
        } else {
            System.out.println("El grafo sin ciclo no tiene un ciclo.");
        }

        */
    }
}

