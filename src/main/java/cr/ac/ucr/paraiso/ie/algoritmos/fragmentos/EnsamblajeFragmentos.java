package cr.ac.ucr.paraiso.ie.algoritmos.fragmentos;


import cr.ac.ucr.paraiso.ie.algoritmos.grafos.Grafo;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
public class EnsamblajeFragmentos {
    public String reconstruirTexto(List<String> fragmentos) {
//        StringBuilder textoReconstruido = new StringBuilder();
        Grafo grafo = new Grafo();

        if (fragmentos != null && !fragmentos.isEmpty()) {
            // Ordenar fragmentos en base a su posición inicial

            Collections.sort(fragmentos, Comparator.comparingInt(this::obtenerPosicionInicial));
            grafo.agregarCabeza(fragmentos.get(0));

            for (int i = 0; i < fragmentos.size(); i++) {
//              System.out.println(fragmentos.get(i));
                String fragmentoActual = fragmentos.get(i);
                for(int j = i; j < fragmentos.size(); j++) {
                    String fragmento = fragmentos.get(j);
                    if (!fragmento.equals(fragmentoActual)) {
                        String superposicion = encontrarSuperposicion(fragmentoActual, fragmento);
                        if (!superposicion.equals("")) {
                            grafo.agregarNodo(fragmentoActual, superposicion.length(), fragmento);
                            break;
                        }
                    }
                }
            }
        }

      //  System.out.println(grafo.reconstruirTexto());
        return grafo.reconstruirTexto();


    }

    private String encontrarSuperposicion(String str1, String str2) {
//        int longitudMaxima = 0;
//        String superposicion = "";

        for (int i = 0; i < str1.length(); i++) {
            int longitudActual = Math.min(str1.length() - i, str2.length());
            String subcadena1 = str1.substring(i, i + longitudActual);
            String subcadena2 = str2.substring(0, longitudActual);

            if (subcadena1.equals(subcadena2)) {
                return subcadena1;
//                if (longitudActual > longitudMaxima) {
//                    longitudMaxima = longitudActual;
//                    superposicion = subcadena1;
//                }
            }
        }

//        return superposicion;
        return "";
    }

    private int obtenerPosicionInicial(String fragmento) {
        int inicio = fragmento.indexOf("Inicio:");
        int fin = fragmento.indexOf("Fin:");
        if (inicio == -1 || fin == -1) {
            return -1;
        }

        fragmento = fragmento.trim();

        String posicionInicialStr = fragmento.substring(inicio + 7, fin);
        return Integer.parseInt(posicionInicialStr);
    }
}
