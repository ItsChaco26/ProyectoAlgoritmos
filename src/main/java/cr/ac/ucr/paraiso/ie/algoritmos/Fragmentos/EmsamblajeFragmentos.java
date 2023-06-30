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
// PRUEBAS
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
