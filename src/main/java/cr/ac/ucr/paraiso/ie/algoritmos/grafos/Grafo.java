package cr.ac.ucr.paraiso.ie.algoritmos.grafos;
import java.util.ArrayList;
import java.util.List;


public class Grafo {
    private List<Nodo> nodos;

    public Grafo() {
        this.nodos = new ArrayList<>();
    }

    public void agregarNodo(Nodo nodo) {
        nodos.add(nodo);
    }

    public Nodo obtenerNodoPorDatos(String fragmento) { //obtener un fragmento en Especifico
        for (Nodo nodo : nodos) {
            if (nodo.getFragmento().equals(fragmento)) {
                return nodo;
            }
        }
        return null;
    }

    public List<Nodo> getNodos() {
        return nodos;
    }
}

