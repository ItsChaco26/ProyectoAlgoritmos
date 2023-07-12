package cr.ac.ucr.paraiso.ie.algoritmos.grafos;
import java.util.*;

public class Grafo {
    private Nodo head; //Nodo inicial del grafo
    private ArrayList<Nodo> nodos; //Lista de nodos en el grafo

    public Grafo() {
        nodos = new ArrayList<Nodo>(); //Inicializar la lista de nodos vacía
    }

    //Método para agregar un nodo como cabeza del grafo
    public void agregarCabeza(String fragmento) {
        head = new Nodo(fragmento); //Crear un nuevo nodo con el fragmento dado
        nodos.add(head); //Agregar el nodo a la lista de nodos
    }

    //Método para agregar un nodo al grafo y establecer una relación con otro nodo existente
    public void agregarNodo(String fragmentoRelacionado, int peso, String nuevoFragmento) {
        Nodo temp = null;
        for (Nodo nodo : nodos) {
            if (nodo.getFragmento().equals(nuevoFragmento)) {
                temp = nodo; //Buscar si el nuevo fragmento ya existe en el grafo
            }
        }
        if (temp == null) {
            temp = new Nodo(nuevoFragmento); //Si no existe, crear un nuevo nodo con el fragmento dado
            nodos.add(temp); //Agregar el nodo a la lista de nodos
        }
        if (fragmentoRelacionado.equals(head.getFragmento())) {
            head.agregarVecino(temp, peso); //Establecer una relación desde la cabeza del grafo al nuevo nodo
        } else {
            buscarVecinos(fragmentoRelacionado, peso, temp); //Establecer una relación desde otro nodo existente al nuevo nodo
        }
    }

    //Método para buscar un nodo existente en el grafo y establecer una relación con otro nodo
    public void buscarVecinos(String fragmentoRelacionado, int peso, Nodo nuevoNodo) {
        for (Nodo vecino : nodos) {
            if (vecino.getFragmento().equals(fragmentoRelacionado)) {
                vecino.agregarVecino(nuevoNodo, peso); //Establecer una relación desde el nodo existente al nuevo nodo
                return;
            }
        }
    }

    //Método para reconstruir el texto a partir del grafo
    public String reconstruirTexto() {
        StringBuilder textoReconstruido = new StringBuilder();
        Nodo aux = head; //Iniciar con la cabeza como nodo actual
        textoReconstruido.append(aux.getFragmento()); //Agregar el fragmento de la cabeza al texto reconstruido

        while (!aux.getVecinos().isEmpty()) {
            int maxPeso = 0;
            int indexMax = 0;

            //Encontrar el vecino con el peso máximo
            for (int i = 0; i < aux.getPesos().size(); i++) {
                if (maxPeso < aux.getPesos().get(i)) {
                    maxPeso = aux.getPesos().get(i);
                    indexMax = i;
                }
            }

            //Agregar el fragmento del vecino seleccionado al texto reconstruido
            textoReconstruido.append(aux.getVecinos().get(indexMax).getFragmento().substring(maxPeso));
            aux = aux.getVecinos().get(indexMax); //Actualizar el nodo actual con el vecino seleccionado
        }

        return textoReconstruido.toString();
    }
}
