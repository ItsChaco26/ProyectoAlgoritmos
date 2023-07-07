package cr.ac.ucr.paraiso.ie.algoritmos.fragmentos;

import static cr.ac.ucr.paraiso.ie.algoritmos.utility.GestionaArchivo.escribirEnArchivo;

public class GeneraFragmentos {

    public void generarFragmentos(String texto, int cantidadFragmentos, int longitudFragmento) {
        int longitudTexto = texto.length();
        int traslape = longitudFragmento / 2; // Valor de traslape (50% de la longitud del fragmento)

        for (int i = 0; i < cantidadFragmentos; i++) {
            int inicio = i * (longitudFragmento - traslape);
            int fin = Math.min(inicio + longitudFragmento, longitudTexto);
            String fragmento = texto.substring(inicio, fin);
            escribirEnArchivo(fragmento);
        }
    }
}
