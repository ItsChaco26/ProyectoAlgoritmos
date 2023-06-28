package cr.ac.ucr.paraiso.ie.algoritmos.Fragmentos;

import cr.ac.ucr.paraiso.ie.algoritmos.Utility.GestionaArchivo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneraFragmentos {

    GestionaArchivo gA = new GestionaArchivo();
    public void generarFragmentos(String texto, int cantidadFragmentos, int longitudPromedio) {
        int textoLength = texto.length();
        for (int i = 0; i < cantidadFragmentos; i++) {
            int inicio = (int) (Math.random() * (textoLength - longitudPromedio));
            int fin = inicio + longitudPromedio;
            String fragmento = texto.substring(inicio, fin);
            gA.escribirEnArchivo(fragmento);
        }
    }


}
