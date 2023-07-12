package cr.ac.ucr.paraiso.ie.algoritmos.utility;

import cr.ac.ucr.paraiso.ie.algoritmos.fragmentos.EnsamblajeFragmentos;
import cr.ac.ucr.paraiso.ie.algoritmos.fragmentos.GeneraFragmentos;
import cr.ac.ucr.paraiso.ie.algoritmos.fragmentos.Ordenamientos;

import java.util.List;
import java.util.Scanner;

public class Menu {
    public void menuPrincipal() {

        //Creación de objetos para utilizar en el menú
        GeneraFragmentos gF = new GeneraFragmentos();
        GestionaArchivo gA = new GestionaArchivo();
        Ordenamientos ordenamientos = new Ordenamientos();
        EnsamblajeFragmentos eF = new EnsamblajeFragmentos();
        Scanner sn = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 8) {
            //Mostrar el menú principal
            StringBuilder sb = new StringBuilder("Menu Principal");
            sb.append("\nSeleccione una opción válida: \n")
                    .append("1): ").append("Generar fragmentos\n")
                    .append("2): ").append("Ordenar fragmentos, orden alfabético\n")
                    .append("3): ").append("Ordenar fragmentos, longitud\n")
                    .append("4): ").append("Ordenar fragmentos mayores o menores a un valor dado\n")
                    .append("5): ").append("Buscar palabras claves en los fragmentos\n")
                    .append("6): ").append("Reconstruir fragmentos\n")
                    .append("7): ").append("Comparar el contenido del texto original y el texto reconstruido\n")
                    .append("8): ").append("Salir");
            System.out.println(sb);

            try {
                opcion = sn.nextInt(); //Leer la opción ingresada por el usuario
                switch (opcion) {
                    case 1:
                        //Generar fragmentos
                        System.out.println("Generar Fragmentos:\n");
                        gA.eliminarContenidoArchivo();
                        System.out.println("Digite el número de fragmentos a generar:");
                        int cantidadFragmentos = sn.nextInt();
                        System.out.println("Digite la longitud promedio de los fragmentos:");
                        int longitudPromedio = sn.nextInt();
                        String textoOriginal = gA.leerContenidoArchivo("archivo.txt");
                        gF.generarFragmentos(textoOriginal, cantidadFragmentos, longitudPromedio);
                        System.out.println("Fragmentos generados y guardados en el archivo.");
                        break;
                    case 2:
                        //Ordenar fragmentos por orden alfabético
                        System.out.println("Ordenamiento por orden alfabético:\n");
                        System.out.println(ordenamientos.ordenarAlfabeticamente());
                        break;
                    case 3:
                        //Ordenar fragmentos por longitud
                        System.out.println("Ordenamiento por longitud:\n");
                        System.out.println(ordenamientos.ordenarPorLongitud());
                        break;
                    case 4:
                        //Ordenar fragmentos por valor dado por el usuario
                        System.out.println("Digite el valor con el que desea filtrar el archivo");
                        int valor = sn.nextInt();
                        System.out.println("Ordenamiento por valor:\n");
                        System.out.println(ordenamientos.valoresMenoresOMayores(valor));
                        break;
                    case 5:
                        //Buscar palabras clave en los fragmentos
                        System.out.println("Digite el texto con el que desea filtrar el archivo");
                        String texto = sn.next();
                        System.out.println("Ordenamiento por palabra clave:\n");
                        System.out.println(ordenamientos.buscarPalabrasClave(texto));
                        break;
                    case 6:
                        //Reconstruir los fragmentos
                        System.out.println("Reconstrucción del texto:\n");
                        System.out.println(eF.reconstruirTexto(gA.leerArchivo("fragmentos.txt")));
                        break;
                    case 7:
                        //Comparar el contenido del texto original y el reconstruido
                        System.out.println("Comparación de los textos:\n");
                        String archivoOriginal = gA.leerContenidoArchivo("archivo.txt");
                        System.out.println("Archivo Original: \n" + archivoOriginal.toString() +
                                "\nArchivo Fragmentos Reconstruido: \n" + eF.reconstruirTexto(gA.leerArchivo("fragmentos.txt")));
                        break;
                    case 8:
                        System.exit(0); //Terminar la ejecución del programa
                        break;
                    default:
                        System.out.println("Se digitó un número incorrecto");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error. Debe ingresar números."); //Capturar excepciones en caso de ingreso incorrecto
                sn.nextLine();
            }
        }
    }
}
