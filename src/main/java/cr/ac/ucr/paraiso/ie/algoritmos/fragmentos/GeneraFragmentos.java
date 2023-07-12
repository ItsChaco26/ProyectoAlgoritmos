package cr.ac.ucr.paraiso.ie.algoritmos.fragmentos;
import java.util.Random;
import static cr.ac.ucr.paraiso.ie.algoritmos.utility.GestionaArchivo.escribirEnArchivo;

public class GeneraFragmentos {

    public void generarFragmentos(String texto, int cantidadFragmentos, int longitudPromedioFragmento) {
        int longitudTexto = texto.length();
        int contador = 0;
        int posicionActual = 0;

        Random random = new Random();

        while (contador < cantidadFragmentos && posicionActual < longitudTexto) {
            int longitudFragmento = calcularLongitudFragmento(longitudPromedioFragmento, random);
            int traslape = Math.max(1, calcularTraslape(longitudFragmento, random));

            int inicio = posicionActual;
            int fin = inicio + longitudFragmento;

            if (fin > longitudTexto) {
                fin = longitudTexto;
            } else {
                while (fin < longitudTexto && !Character.isWhitespace(texto.charAt(fin))) {
                    fin++;
                }
}

            String fragmento = texto.substring(inicio, fin);
            escribirEnArchivo(fragmento);


            contador++;
            posicionActual = fin - traslape;
        }

        if (contador == cantidadFragmentos) {
            System.out.println("Se han generado todos los fragmentos requeridos.");
        } else {
            System.out.println("El texto se ha terminado antes de generar todos los fragmentos.");
        }
    }

    private int calcularLongitudFragmento(int longitudPromedio, Random random) {
        double desviacion = 0.2;
        double factor = random.nextGaussian() * desviacion + 1.0;
        int longitudFragmento = (int) (longitudPromedio * factor);
        return Math.max(1, longitudFragmento);
    }

    private int calcularTraslape(int longitudFragmento, Random random) {
        int maxTraslape = longitudFragmento - 1;
        return random.nextInt(maxTraslape) + 1;
    }

}



