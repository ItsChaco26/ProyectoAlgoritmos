package cr.ac.ucr.paraiso.ie.algoritmos.fragmentos;

import java.util.Random;
import static cr.ac.ucr.paraiso.ie.algoritmos.utility.GestionaArchivo.escribirEnArchivo;

public class GeneraFragmentos {

    //Método para generar los fragmentos en un archivo de texto
    public void generarFragmentos(String texto, int cantidadFragmentos, int longitudPromedioFragmento) {
        Random random = new Random();
        int longitudTexto = texto.length();
        int contador = 0;
        int posicionActual = 0;

        //Generar los fragmentos hasta alcanzar la cantidad deseada o el final del texto
        while (contador < cantidadFragmentos && posicionActual < longitudTexto) {
            // Calcular la longitud y el traslape del fragmento actual
            int longitudFragmento = calcularLongitudFragmento(longitudPromedioFragmento, random);
            int traslape = Math.max(1, calcularTraslape(longitudFragmento, random));

            //Determinar el inicio y fin del fragmento actual
            int inicio = posicionActual;
            int fin = inicio + longitudFragmento;

            //Ajustar el fin si excede la longitud total del texto
            if (fin > longitudTexto) {
                fin = longitudTexto;
            } else {
                //Asegurarse de no cortar una palabra a la mitad
                while (fin < longitudTexto && !Character.isWhitespace(texto.charAt(fin))) {
                    fin++;
                }
            }

            // Obtener el fragmento y escribirlo en el archivo
            String fragmento = texto.substring(inicio, fin);
            escribirEnArchivo(fragmento);

            contador++;
            posicionActual = fin - traslape;
        }

        //Verificar si se generaron todos los fragmentos requeridos
        if (contador == cantidadFragmentos) {
            System.out.println("Se han generado todos los fragmentos requeridos.");
        } else {
            System.out.println("El texto se ha terminado antes de generar todos los fragmentos.");
        }
    }

    //Método para calcular la longitud del fragmento con una desviación aleatoria
    private int calcularLongitudFragmento(int longitudPromedio, Random random) {
        double desviacion = 0.2;
        double factor = random.nextGaussian() * desviacion + 1.0;
        int longitudFragmento = (int) (longitudPromedio * factor);
        return Math.max(1, longitudFragmento); // Asegurarse de que la longitud sea al menos 1
    }

    //Método para calcular el traslape del fragmento actual
    private int calcularTraslape(int longitudFragmento, Random random) {
        int maxTraslape = longitudFragmento - 1;
        return random.nextInt(maxTraslape) + 1; // Generar un traslape entre 1 y la longitud del fragmento - 1
    }

}
