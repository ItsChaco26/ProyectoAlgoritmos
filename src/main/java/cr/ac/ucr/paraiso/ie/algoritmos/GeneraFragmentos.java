package cr.ac.ucr.paraiso.ie.algoritmos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GeneraFragmentos {
    public void generarFragmentos(String texto, int cantidadFragmentos, int longitudPromedio) {
        int textoLength = texto.length();

        for (int i = 0; i < cantidadFragmentos; i++) {
            int inicio = (int) (Math.random() * (textoLength - longitudPromedio));
            int fin = inicio + longitudPromedio;
            String fragmento = texto.substring(inicio, fin);
            escribirEnArchivo(fragmento);
        }
    }
    public void escribirEnArchivo(String fragmento) {
        String nombreArchivo = "fragmentos.txt";
        try {
            FileWriter writer = new FileWriter(nombreArchivo, true); // true para que agregue al archivo existente
            writer.write(fragmento + "\n");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
