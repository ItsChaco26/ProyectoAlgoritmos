package cr.ac.ucr.paraiso.ie.algoritmos;



public class Main {
    public static void main(String[] args) {
        GeneraFragmentos gF = new GeneraFragmentos();
        String nombreArchivoTexto = gF.leerContenidoArchivo("archivo.txt");
        int cantidadFragmentos = 50;
        int longitudPromedio = 10;
        gF.generarFragmentos(nombreArchivoTexto, cantidadFragmentos, longitudPromedio);
    }
}