package cr.ac.ucr.paraiso.ie.algoritmos.fragmentos;

import cr.ac.ucr.paraiso.ie.algoritmos.grafos.Grafo;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EnsamblajeFragmentos {

    //Método para reconstruir el texto
    public String reconstruirTexto(List<String> fragmentos) {
        Grafo grafo = new Grafo();

        //Verificar si la lista de fragmentos no es nula ni está vacía
        if (fragmentos != null && !fragmentos.isEmpty()) {
            //Ordenar los fragmentos por su posición inicial
            Collections.sort(fragmentos, Comparator.comparingInt(this::obtenerPosicionInicial));

            //Agregar el primer fragmento como cabeza del grafo
            grafo.agregarCabeza(fragmentos.get(0));

            //Recorrer la lista de fragmentos
            for (int i = 0; i < fragmentos.size(); i++) {
                String fragmentoActual = fragmentos.get(i);
                //Buscar una superposición con los fragmentos restantes
                for (int j = i; j < fragmentos.size(); j++) {
                    String fragmento = fragmentos.get(j);
                    if (!fragmento.equals(fragmentoActual)) {
                        String superposicion = encontrarSuperposicion(fragmentoActual, fragmento);
                        if (!superposicion.equals("")) {
                            //Agregar un nodo al grafo con la superposición encontrada
                            grafo.agregarNodo(fragmentoActual, superposicion.length(), fragmento);
                            break;
                        }
                    }
                }
            }
        }

        //Reconstruir el texto a partir del grafo
        return grafo.reconstruirTexto();
    }

    //Método para encontrar la superposición entre dos fragmentos
    private String encontrarSuperposicion(String str1, String str2) {
        for (int i = 0; i < str1.length(); i++) {
            int longitudActual = Math.min(str1.length() - i, str2.length());
            String subcadena1 = str1.substring(i, i + longitudActual);
            String subcadena2 = str2.substring(0, longitudActual);

            if (subcadena1.equals(subcadena2)) {
                return subcadena1;
            }
        }
        return "";
    }

    //Método para obtener la posición inicial de un fragmento
    private int obtenerPosicionInicial(String fragmento) {
        int inicio = fragmento.indexOf("Inicio:");
        int fin = fragmento.indexOf("Fin:");

        //Verificar si el fragmento tiene las marcas de inicio y fin
        if (inicio == -1 || fin == -1) {
            return -1;
        }

        fragmento = fragmento.trim();

        //Obtener la posición inicial como una cadena y convertirla a entero
        String posicionInicialStr = fragmento.substring(inicio + 7, fin);
        return Integer.parseInt(posicionInicialStr);
    }
}
