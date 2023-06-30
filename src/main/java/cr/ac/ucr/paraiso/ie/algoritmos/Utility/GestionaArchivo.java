package cr.ac.ucr.paraiso.ie.algoritmos.Utility;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class GestionaArchivo {

    public String leerContenidoArchivo(String nombreArchivo) {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo: " + e.getMessage());
        }
        return contenido.toString();
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
