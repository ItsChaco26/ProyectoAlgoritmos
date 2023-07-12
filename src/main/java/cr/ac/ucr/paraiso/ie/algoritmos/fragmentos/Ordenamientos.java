package cr.ac.ucr.paraiso.ie.algoritmos.fragmentos;

import cr.ac.ucr.paraiso.ie.algoritmos.utility.GestionaArchivo;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ordenamientos {
    GestionaArchivo gA = new GestionaArchivo();

    public String ordenarPorLongitud() {
        List<String> fragmentos = gA.leerArchivoDANI("fragmentos.txt");
        if(fragmentos.isEmpty()){
            return "No hay fragmentos disponibles.";
        }
        else{
            Collections.sort(fragmentos, Comparator.comparingInt(String::length));
            StringBuilder resultado = new StringBuilder();

            for (String fragmento : fragmentos) {
                resultado.append(fragmento + "\n");
            }

            return resultado.toString();}
    }


    public String ordenarAlfabeticamente() {
        List<String> fragmentos = gA.leerArchivoDANI("fragmentos.txt");
        if (fragmentos.isEmpty()) {
            return "No hay fragmentos disponibles.";
        } else {
            Collections.sort(fragmentos);
            StringBuilder resultado = new StringBuilder();

            for (String fragmento : fragmentos) {
                resultado.append(fragmento + "\n");
            }

            return resultado.toString();
        }
    }

    public String buscarPalabrasClave(String filePath, String keyword) throws IOException {
        List<String> fragmentos = gA.leerArchivoDANI(filePath);
        if (fragmentos.isEmpty()) {
            return "No hay fragmentos disponibles.";
        } else {
            StringBuilder resultado = new StringBuilder();
            for (String fragmento : fragmentos) {
                if (fragmento.contains(keyword)) {
                    resultado.append(fragmento + "\n");
                }
            }
            return resultado.toString();
        }
    }


}








