package cr.ac.ucr.paraiso.ie.algoritmos;


import cr.ac.ucr.paraiso.ie.algoritmos.fragmentos.EmsamblajeFragmentos;
import cr.ac.ucr.paraiso.ie.algoritmos.fragmentos.GeneraFragmentos;
import cr.ac.ucr.paraiso.ie.algoritmos.utility.GestionaArchivo;


import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
    
        GeneraFragmentos gF = new GeneraFragmentos();
        GestionaArchivo gA = new GestionaArchivo();
        EmsamblajeFragmentos eF = new EmsamblajeFragmentos();

        String textoOriginal = gA.leerContenidoArchivo("archivo.txt");
        int cantidadFragmentos = 55;
        int longitudPromedio = 10;

        gF.generarFragmentos(textoOriginal, cantidadFragmentos, longitudPromedio);;
        System.out.println(eF.reconstruirTexto(gA.leerArchivoDANI("fragmentos.txt")));
    }

       gF.generarFragmentos(textoOriginal, cantidadFragmentos, longitudPromedio);;

    //   System.out.println(eF.reconstruirTexto(gA.leerArchivoDANI("fragmentos.txt")));


    }}