package cr.ac.ucr.paraiso.ie.algoritmos.fragmentos;

import cr.ac.ucr.paraiso.ie.algoritmos.utility.GestionaArchivo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ordenamientos {
    GestionaArchivo gA = new GestionaArchivo();

    List<String> fragmentos = gA.leerArchivoDANI("fragmentos.txt");

  public String ordenarPorLongitud() {

      if(fragmentos.isEmpty()){
          return "No hay fragmentos disponibles.";
      }

      Collections.sort(fragmentos, Comparator.comparingInt(String::length));

      StringBuilder resultado = new StringBuilder();


      for (String fragmento : fragmentos) {
          resultado.append(fragmento);
      }

      return resultado.toString();
  }


    public String ordenarAlfabeticamente() {
        StringBuilder resultado = new StringBuilder();
        if(fragmentos.isEmpty()){
            return "No hay fragmentos disponibles.";
        }else {
            Collections.sort(fragmentos);
            for (String fragmento : fragmentos) {
                resultado.append(fragmento);
            }
        }
        return resultado.toString();
    }

    private static List<String> readLinesFromFile(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }

        reader.close();
        return lines;
    }

    public static void buscarPalabrasClave(String filePath, String keyword) throws IOException {
        List<String> lineas = readLinesFromFile(filePath);
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String linea;

        while ((linea = reader.readLine()) != null) {
            lineas.add(linea);
        }
        reader.close();

        for (String lineaActual : lineas) {
            if (lineaActual.contains(keyword)) {
                System.out.println(lineaActual);
            }
        }
    }


}








