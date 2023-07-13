package cr.ac.ucr.paraiso.ie.algoritmos.utility;

import cr.ac.ucr.paraiso.ie.algoritmos.fragmentos.EnsamblajeFragmentos;
import cr.ac.ucr.paraiso.ie.algoritmos.fragmentos.GeneraFragmentos;
import cr.ac.ucr.paraiso.ie.algoritmos.fragmentos.Ordenamientos;

import java.util.Scanner;


public class Menu {
    public void menuPrincipal(){

        GeneraFragmentos gF = new GeneraFragmentos();
        GestionaArchivo gA = new GestionaArchivo();
        Ordenamientos ordenamientos = new Ordenamientos();
        EnsamblajeFragmentos eF = new EnsamblajeFragmentos();
        Scanner sn = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 5) {
            StringBuilder sb = new StringBuilder("Menu Principal"); //StringBuilder donde se almacena el contenido del Menú Principal
            sb.append("\nSeleccione una opción válida: \n")
                    .append("1): ").append("Generar fragmentos\n")
                    .append("2): ").append("Ordenar fragmentos, orden alfabético\n")
                    .append("3): ").append("Ordenar fragmentos, longitud\n")
                    .append("4): ").append("Ordenar fragmentos mayores o menores a un valor dado\n")
                    .append("5): ").append("Buscar palabras claves en los fragmentos\n")
                    .append("6): ").append("Reconstruir fragmentos\n")
                    .append("7): ").append("Salir\n");
            System.out.println(sb);
            try {
                opcion = sn.nextInt(); //Se asigna un dato tipo int a la variable opción para proceder a eveluarla en el switch y ejecutar un método o acciones especificas
                switch (opcion) {
                    case 1:
                        System.out.println("Digite el número de fragmentos a generar:");

                        int cantidadFragmentos = sn.nextInt();

                        System.out.println("Digite la longitud promedio de los fragmentos:");

                        int longitudPromedio = sn.nextInt();

                        String textoOriginal = gA.leerContenidoArchivo("archivo.txt");

                        gF.generarFragmentos(textoOriginal, cantidadFragmentos, longitudPromedio);

                        System.out.println("Fragmentos generados y guardados en el archivo.");

                        break;
                    case 2:
                        System.out.println(ordenamientos.ordenarAlfabeticamente());
                        break;
                    case 3:
                        System.out.println(ordenamientos.ordenarPorLongitud());
                        break;
                    case 4:
                        System.out.println("En proceso...");
                        break;
                    case 5:
                        System.out.println("En proceso...");
                        break;
                    case 6:
                        System.out.println(eF.reconstruirTexto(gA.leerArchivoDANI("fragmentos.txt")));
                        break;
                    case 7:
                        System.exit(0); //Se termina la ejecución del programa.
                        break;
                    default:
                        System.out.println("Se digitó un número incorrecto");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error. Debe ingresar números."); //Se arroja la excepción en caso de que ingrese un dato erróneo
                sn.nextLine();
            }

    }

}}
