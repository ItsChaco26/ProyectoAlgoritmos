package cr.ac.ucr.paraiso.ie.algoritmos.fragmentos;

import java.util.Random;
import static cr.ac.ucr.paraiso.ie.algoritmos.utility.GestionaArchivo.escribirEnArchivo;

public class GeneraFragmentos {



    public void generarFragmentos(String texto, int cantidadFragmentos, int longitudFragmento) {
        int longitudTexto = texto.length();
        Random random = new Random();

        for (int i = 0; i < cantidadFragmentos; i++) {
            int traslape = random.nextInt(longitudFragmento / 2) + 1;
            int inicio = i * (longitudFragmento - traslape);
            int fin = inicio + longitudFragmento;

            if (fin > longitudTexto) {
                fin = longitudTexto;
                inicio = fin - longitudFragmento;
            }

            String fragmento = texto.substring(inicio, fin);
            escribirEnArchivo(fragmento);
        }
    }

}
