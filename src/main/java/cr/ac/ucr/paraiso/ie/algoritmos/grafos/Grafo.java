package cr.ac.ucr.paraiso.ie.algoritmos.grafos;
import java.util.*;



public class Grafo {
    private Nodo head;
    private ArrayList<Nodo> nodos;

    public Grafo() {
        nodos = new ArrayList<Nodo>();
    }

    public void agregarCabeza(String fragmento) {
        head = new Nodo(fragmento);
        nodos.add(head);
    }

    public void agregarNodo(String fragmentoRelacionado, int peso, String nuevoFragmento) {
        Nodo temp = null;
        for (Nodo nodo:
                nodos) {
            if (nodo.getFragmento().equals(nuevoFragmento)){
                temp = nodo;
            }
        }
        if (temp == null){
            temp = new Nodo(nuevoFragmento);
            nodos.add(temp);
        }
        if (fragmentoRelacionado.equals(head.getFragmento())) {
            head.agregarVecino(temp, peso);
        }
        else {
            buscarVecinos(fragmentoRelacionado, peso, temp);
        }
    }

    public void buscarVecinos(String fragmentoRelacionado, int peso, Nodo nuevoNodo){
        for (Nodo vecino:
                nodos) {
            if (vecino.getFragmento().equals(fragmentoRelacionado)){
                vecino.agregarVecino(nuevoNodo, peso);
                return;
            }
        }
    }

    public String reconstruirTexto() {
        StringBuilder textoReconstruido = new StringBuilder();
        Nodo aux = head;
        textoReconstruido.append(aux.getFragmento());
        while (!aux.getVecinos().isEmpty()) {
//        System.out.println(aux.getFragmento());
            int maxPeso = 0;
            int indexMax = 0;
            for (int i = 0; i < aux.getPesos().size(); i++) {
                if(maxPeso < aux.getPesos().get(i)){
                    maxPeso = aux.getPesos().get(i);
                    indexMax = i;
                }
            }
            textoReconstruido.append(aux.getVecinos().get(indexMax).getFragmento().substring(maxPeso));
            aux = aux.getVecinos().get(indexMax);
        }

        return textoReconstruido.toString();
    }


//    public Nodo obtenerNodoPorDatos(String fragmento) { //obtener un fragmento en Especifico
//        for (Nodo nodo : nodos) {
//            if (nodo.getFragmento().equals(fragmento)) {
//                return nodo;
//            }
//        }
//        return null;
//    }

//    public List<Nodo> getNodos() {
//        return nodos;
//    }
}

