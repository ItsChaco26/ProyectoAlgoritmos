package cr.ac.ucr.paraiso.ie.algoritmos.grafos;


import java.util.ArrayList;
import java.util.List;
public class ConstruccionGrafo {

// los pesos se deben calcular segun los traslapes, no entran como parametros se deben calcular aca
public Grafo construirGrafo(List<String> nodosFragmento, List<List<Integer>> pesos) {
    Grafo grafo = new Grafo();

    // Crear nodos
    List<Nodo> nodos = new ArrayList<>();
    for (String nodoString : nodosFragmento) {
        Nodo nodo = new Nodo(nodoString);
        nodos.add(nodo);
        grafo.agregarNodo(nodo);
    }

    // Agregar vecinos y pesos
    for (int i = 0; i < nodosFragmento.size(); i++) {
        String nodoString = nodosFragmento.get(i);
        List<Integer> pesosVecinos = pesos.get(i);
        Nodo nodoActual = nodos.get(i);

        for (int j = 0; j < nodosFragmento.size(); j++) {
            if (i != j) {
                String vecinoString = nodosFragmento.get(j);
                Nodo vecino = nodos.get(j);
                int peso = pesosVecinos.get(j);
                nodoActual.agregarVecino(vecino, peso);
            }
        }
    }

    return grafo;
}

}
