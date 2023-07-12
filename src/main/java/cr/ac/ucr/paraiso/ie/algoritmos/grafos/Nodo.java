package cr.ac.ucr.paraiso.ie.algoritmos.grafos;

import java.util.ArrayList;
import java.util.List;

public class Nodo {
    private String fragmento; //Fragmento de texto representado por el nodo
    private List<Nodo> vecinos; //Lista de nodos vecinos
    private List<Integer> pesos; //Lista de pesos correspondientes a los vecinos

    public Nodo(String fragmento) {
        this.fragmento = fragmento; //Inicializar el fragmento con el valor dado
        this.vecinos = new ArrayList<>(); //Inicializar la lista de vecinos vacía
        this.pesos = new ArrayList<>(); //Inicializar la lista de pesos vacía
    }

    public String getFragmento() {
        return fragmento;
    }

    public List<Nodo> getVecinos() {
        return vecinos;
    }

    public List<Integer> getPesos() {
        return pesos;
    }

    //Método para agregar un nodo vecino y su peso correspondiente al nodo actual
    public void agregarVecino(Nodo vecino, int peso) {
        vecinos.add(vecino); // Agregar el nodo vecino a la lista de vecinos
        pesos.add(peso); // Agregar el peso correspondiente al nodo vecino a la lista de pesos
    }
}
