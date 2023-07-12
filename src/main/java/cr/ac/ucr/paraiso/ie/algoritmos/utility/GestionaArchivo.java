package cr.ac.ucr.paraiso.ie.algoritmos.utility;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestionaArchivo {

    //Método para leer el contenido de un archivo
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

    //Método para escribir en un archivo
    public static void escribirEnArchivo(String fragmento) {
        String nombreArchivo = "fragmentos.txt";
        try {
            File archivo = new File(nombreArchivo);

            //Si el archivo no existe, se crea
            if (!archivo.exists()) {
                archivo.createNewFile();
            }

            //Escribir en el archivo
            FileWriter writer = new FileWriter(archivo, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            bufferedWriter.write(fragmento + "\n");

            //Fin del buffer
            bufferedWriter.close();
        } catch (IOException e) {
            throw new RuntimeException("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    //Método para eliminar el contenido de un archivo
    public void eliminarContenidoArchivo() throws IOException {
        FileWriter writer = new FileWriter("fragmentos.txt", false);
        writer.write("");
        writer.close();
    }

    //Método para leer un archivo y almacenar sus líneas en una lista
    public List<String> leerArchivo(String nombreArchivo) {
        List<String> Fragmentos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                Fragmentos.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Fragmentos;
    }
}
