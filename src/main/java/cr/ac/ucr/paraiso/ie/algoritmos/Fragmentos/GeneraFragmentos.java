package cr.ac.ucr.paraiso.ie.algoritmos.Fragmentos;

import cr.ac.ucr.paraiso.ie.algoritmos.Utility.GestionaArchivo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneraFragmentos {

    GestionaArchivo gA = new GestionaArchivo();

    public void generarFragmentos(String texto, int cantidadFragmentos, int longitudFragmento) {
        int longitudTexto = texto.length();

        for (int i = 0; i < cantidadFragmentos; i++) {
            int traslape = (int) Math.round(1 + Math.random() * (longitudFragmento / 2));
            int inicio = i * (longitudFragmento - traslape);
            int fin = Math.min(inicio + longitudFragmento, longitudTexto);
            //Verificar límites
            if (inicio < 0 || inicio >= longitudTexto || fin < 0 || fin > longitudTexto) {
                break;// Salir del bucle si los índices están fuera de los límites
            }
            String fragmento = texto.substring(inicio, fin);
            gA.escribirEnArchivo(fragmento);
        }
    }
}
