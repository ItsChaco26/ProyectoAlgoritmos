package cr.ac.ucr.paraiso.ie.algoritmos.fragmentos;

import cr.ac.ucr.paraiso.ie.algoritmos.utility.GestionaArchivo;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ordenamientos {
    GestionaArchivo gA = new GestionaArchivo();

    //Método para ordenar los fragmentos por longitud
    public String ordenarPorLongitud() {
        List<String> fragmentos = gA.leerArchivo("fragmentos.txt");
        if (fragmentos.isEmpty()) {
            return "No hay fragmentos disponibles.";
        } else {
            Collections.sort(fragmentos, Comparator.comparingInt(String::length));
            StringBuilder resultado = new StringBuilder();

            //Construir el resultado concatenando los fragmentos ordenados
            for (String fragmento : fragmentos) {
                resultado.append(fragmento).append("\n");
            }

            return resultado.toString();
        }
    }

    //Método para ordenar los fragmentos alfabéticamente
    public String ordenarAlfabeticamente() {
        List<String> fragmentos = gA.leerArchivo("fragmentos.txt");
        if (fragmentos.isEmpty()) {
            return "No hay fragmentos disponibles.";
        } else {
            Collections.sort(fragmentos);
            StringBuilder resultado = new StringBuilder();

            //Construir el resultado concatenando los fragmentos ordenados
            for (String fragmento : fragmentos) {
                resultado.append(fragmento).append("\n");
            }

            return resultado.toString();
        }
    }

    //Método para buscar palabras clave en los fragmentos
    public String buscarPalabrasClave(String keyword) throws IOException {
        List<String> fragmentos = gA.leerArchivo("fragmentos.txt");
        if (fragmentos.isEmpty()) {
            return "No hay fragmentos disponibles.";
        } else {
            StringBuilder resultado = new StringBuilder();

            //Buscar la palabra clave en cada fragmento y agregar los coincidentes al resultado
            for (String fragmento : fragmentos) {
                if (fragmento.contains(keyword)) {
                    resultado.append(fragmento).append("\n");
                }
            }

            return resultado.toString();
        }
    }

    //Método para filtrar los fragmentos por longitud mayor o menor que un valor dado
    public String valoresMenoresOMayores(int valorAComparar) {
        StringBuilder valoresMayores = new StringBuilder();
        StringBuilder valoresMenores = new StringBuilder();
        List<String> fragmentos = gA.leerArchivo("fragmentos.txt");

        if (fragmentos.isEmpty()) {
            return "No hay fragmentos disponibles.";
        } else {
            for (String linea : fragmentos) {
                if (linea.length() > valorAComparar) {
                    valoresMayores.append(linea).append("\n");
                } else {
                    valoresMenores.append(linea).append("\n");
                }
            }

            //Construir el resultado con las líneas mayores y menores
            return "Líneas mayores al valor " + valorAComparar + ":\n" +
                    valoresMayores.toString() + "\n" +
                    "================================\n" +
                    "Líneas menores o iguales al valor " + valorAComparar + ":\n" +
                    valoresMenores.toString();
        }
    }
}
