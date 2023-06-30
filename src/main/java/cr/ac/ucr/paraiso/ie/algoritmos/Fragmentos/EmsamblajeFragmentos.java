package cr.ac.ucr.paraiso.ie.algoritmos.Fragmentos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmsamblajeFragmentos {

    public void emsamblarFragmentos(String nombreArchivo) {
        List<String> fragmentos = new ArrayList<String>();
        try {
            java.util.Scanner scanner = new java.util.Scanner(new java.io.File(nombreArchivo));
            while (scanner.hasNextLine()) {
                String fragmento = scanner.nextLine() + "\n";
                fragmentos.add(fragmento);
            }
            scanner.close();
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo: " + e.getMessage());
        }
        System.out.println(fragmentos.toString());
    }
/// PRUEBAS
public String encontrarSuperhilera(List<String> secuencias) {
    if (secuencias == null || secuencias.isEmpty()) {
        return "";
    }

    StringBuilder superhilera = new StringBuilder(secuencias.get(0)); // Inicializar con la primera secuencia

    for (int i = 1; i < secuencias.size(); i++) {
        String secuenciaActual = secuencias.get(i);
        String superposicion = encontrarSuperposicion(superhilera.toString(), secuenciaActual);
        superhilera.append(secuenciaActual.substring(superposicion.length()));
    }

    return superhilera.toString();
}

    private String encontrarSuperposicion(String str1, String str2) {
        int longitudMaxima = 0;
        String superposicion = "";

        for (int i = 0; i < str1.length(); i++) {
            if (str2.startsWith(str1.substring(i))) {
                int longitudActual = str1.length() - i;
                if (longitudActual > longitudMaxima) {
                    longitudMaxima = longitudActual;
                    superposicion = str1.substring(i);
                }
            }
        }

        return superposicion;
    }
//MAS PRUEBAS
public  String reconstruirTexto(List<String> fragmentos) {
    StringBuilder textoReconstruido = new StringBuilder();

    if (fragmentos != null && !fragmentos.isEmpty()) {
        textoReconstruido.append(fragmentos.get(0)); // Agregar el primer fragmento completo

        for (int i = 1; i < fragmentos.size(); i++) {
            String fragmentoActual = fragmentos.get(i);
            String superposicion = encontrarSuperposicion2(textoReconstruido.toString(), fragmentoActual);
            textoReconstruido.append(fragmentoActual.substring(superposicion.length()));
        }
    }

    return textoReconstruido.toString();
}

    private static String encontrarSuperposicion2(String str1, String str2) {
        int longitudMaxima = 0;
        String superposicion = "";

        for (int i = 0; i < str1.length(); i++) {
            if (str2.startsWith(str1.substring(i))) {
                int longitudActual = str1.length() - i;
                if (longitudActual > longitudMaxima) {
                    longitudMaxima = longitudActual;
                    superposicion = str1.substring(i);
                }
            }
        }

        return superposicion;
    }
}
