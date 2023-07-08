package cr.ac.ucr.paraiso.ie.algoritmos.grafos;

import java.util.ArrayList;
import java.util.List;

public class Nodo {
    private String fragmento;
    private List<Nodo> vecinos;
    private List<Integer> pesos;

    public Nodo(String fragmento) {
        this.fragmento = fragmento;
        this.vecinos = new ArrayList<>();
        this.pesos = new ArrayList<>();
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

    public void agregarVecino(Nodo vecino, int peso) {
        vecinos.add(vecino);
        pesos.add(peso);
    }
}





