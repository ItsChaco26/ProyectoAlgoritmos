package cr.ac.ucr.paraiso.ie.algoritmos;


import cr.ac.ucr.paraiso.ie.algoritmos.Fragmentos.EmsamblajeFragmentos;
import cr.ac.ucr.paraiso.ie.algoritmos.Fragmentos.GeneraFragmentos;
import cr.ac.ucr.paraiso.ie.algoritmos.Utility.GestionaArchivo;

public class Main {
    public static void main(String[] args) {
        GeneraFragmentos gF = new GeneraFragmentos();
        GestionaArchivo gA = new GestionaArchivo();
        EmsamblajeFragmentos eF = new EmsamblajeFragmentos();

        String textoOriginal = gA.leerContenidoArchivo("archivo.txt");
        int cantidadFragmentos = 50;
        int longitudPromedio = 10;
        gF.generarFragmentos(textoOriginal, cantidadFragmentos, longitudPromedio);;

        System.out.println(eF.reconstruirTexto(gA.leerArchivoDANI("fragmentos.txt")));
    }

}