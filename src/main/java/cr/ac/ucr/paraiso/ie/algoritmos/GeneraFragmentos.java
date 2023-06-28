package cr.ac.ucr.paraiso.ie.algoritmos;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

public class GeneraFragmentos {
    public static void generarFragmentos(int cantidad, int longitudPromedio, String nombreArchivo) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            Random random = new Random();
            String caracteres = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()_+-={}[]|\\:;\"'<>,.?/ ";
            for (int i = 0; i < cantidad; i++) {
                int longitud = Math.max(1, (int) (random.nextGaussian() * longitudPromedio / 2 + longitudPromedio));
                StringBuilder fragmento = new StringBuilder();
                for (int j = 0; j < longitud; j++) {
                    int index = random.nextInt(caracteres.length());
                    fragmento.append(caracteres.charAt(index));
                }
                writer.println(fragmento.toString());
            }

            System.out.println("Se generaron los fragmentos en el archivo: " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
