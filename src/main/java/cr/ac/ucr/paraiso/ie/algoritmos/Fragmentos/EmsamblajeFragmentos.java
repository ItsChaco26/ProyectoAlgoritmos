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
                String fragmento = scanner.nextLine();
                fragmentos.add(fragmento);
            }
            scanner.close();
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo: " + e.getMessage());
        }
        System.out.println(fragmentos.toString());
    }



}
