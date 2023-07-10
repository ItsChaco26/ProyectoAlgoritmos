package cr.ac.ucr.paraiso.ie.algoritmos.utility;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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


    public static void escribirEnArchivo(String fragmento) {
        String nombreArchivo = "fragmentos.txt";
        try {
            File archivo = new File(nombreArchivo);


            if (!archivo.exists()) {
                archivo.createNewFile();
            }

            FileWriter writer = new FileWriter(archivo, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(fragmento + "\n");

            // Cerrar el archivo
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Error al escribir en el archivo: " + e.getMessage());
        }
    }


    //PRUEBAS DANI


    public List<String> leerArchivoDANI(String nombreArchivo) {

        List<String> lineas = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return lineas;
    }


}
