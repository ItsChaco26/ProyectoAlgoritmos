package cr.ac.ucr.paraiso.ie.algoritmos;


import cr.ac.ucr.paraiso.ie.algoritmos.fragmentos.EnsamblajeFragmentos;
import cr.ac.ucr.paraiso.ie.algoritmos.fragmentos.GeneraFragmentos;
import cr.ac.ucr.paraiso.ie.algoritmos.utility.GestionaArchivo;
import cr.ac.ucr.paraiso.ie.algoritmos.utility.Menu;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        Menu mn = new Menu();
        GeneraFragmentos gF = new GeneraFragmentos();
        GestionaArchivo gA = new GestionaArchivo();
        EnsamblajeFragmentos eF = new EnsamblajeFragmentos();
        String textoOriginal = gA.leerContenidoArchivo("archivo.txt");
        int cantidadFragmentos = 55;
        int longitudPromedio = 10;
        mn.menuPrincipal();
//         gF.generarFragmentos(textoOriginal, cantidadFragmentos, longitudPromedio);
//         System.out.println(eF.reconstruirTexto(gA.leerArchivoDANI("fragmentos.txt")));


    }

}