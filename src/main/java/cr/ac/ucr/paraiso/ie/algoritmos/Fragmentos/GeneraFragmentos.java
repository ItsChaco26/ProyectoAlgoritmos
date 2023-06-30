package cr.ac.ucr.paraiso.ie.algoritmos.Fragmentos;

import cr.ac.ucr.paraiso.ie.algoritmos.Utility.GestionaArchivo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneraFragmentos {

    public static void generarFragmentos(String texto, int cantidadFragmentos, int longitudFragmento) {
        GestionaArchivo gA = new GestionaArchivo();
        int longitudTexto = texto.length();
        int traslape = longitudFragmento / 2; // Traslape de la mitad de la longitud del fragmento
        int indiceInicio = 0;
        int indiceFin = Math.min(longitudFragmento, longitudTexto);

        for (int i = 0; i < cantidadFragmentos; i++) {
            if (indiceInicio >= longitudTexto) {
                break; // Salir si se ha alcanzado el final del texto
            }

            String fragmento = texto.substring(indiceInicio, indiceFin);
            gA.escribirEnArchivo(fragmento);

            // Actualizar índices para el siguiente fragmento
            indiceInicio += longitudFragmento - traslape;
            indiceFin = Math.min(indiceInicio + longitudFragmento, longitudTexto);
        }

        System.out.println("Fragmentos generados y guardados en el archivo.");
    }
}
