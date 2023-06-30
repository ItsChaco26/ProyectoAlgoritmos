package cr.ac.ucr.paraiso.ie.algoritmos.Utility;

import cr.ac.ucr.paraiso.ie.algoritmos.Fragmentos.GeneraFragmentos;

import java.util.Scanner;

public class Menu {
    public void menu(){
        GeneraFragmentos gF = new GeneraFragmentos();
        GestionaArchivo gA = new GestionaArchivo();
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
                    .append("6): ").append("Salir\n");
            System.out.println(sb);
            try {
                opcion = sn.nextInt(); //Se asigna un dato tipo int a la variable opción para proceder a eveluarla en el switch y ejecutar un método o acciones especificas
                switch (opcion) {
                    case 1:
                        System.out.println("Digite el número de fragmentos a generar:");
                        int cantidadFragmentos = sn.nextInt();
                        System.out.println("Digite la longitud promedio de los fragmentos:");
                        int longitudPromedio = sn.nextInt();
                        //gF.generarFragmentos(gA.leerContenidoArchivo("archivo.txt"), cantidadFragmentos, longitudPromedio);
                        System.out.println("Fragmentos generados y guardados en el archivo.");
                        break;
                    case 2:
                        System.out.println("En proceso...");
                        break;
                    case 3:
                        System.out.println("En proceso...");
                        break;
                    case 4:
                        System.out.println("En proceso...");
                        break;
                    case 5:
                        System.out.println("En proceso...");
                        break;
                    case 6:
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