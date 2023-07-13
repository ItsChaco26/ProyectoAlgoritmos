package cr.ac.ucr.paraiso.ie.algoritmos.fragmentos;

import cr.ac.ucr.paraiso.ie.algoritmos.utility.GestionaArchivo;

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

        if(fragmentos.isEmpty()){
            return "No hay fragmentos disponibles.";
        }

        Collections.sort(fragmentos);

        StringBuilder resultado = new StringBuilder();

        for (String fragmento : fragmentos) {
            resultado.append(fragmento);
        }

        return resultado.toString();
    }
}








