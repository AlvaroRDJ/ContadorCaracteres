package contador;

import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
public class LanzadorContador {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Repetir hasta que escribamos "fin":
        while (true) {
            System.out.println("Escribe una palabra (fin para terminar): ");
            String palabra = sc.nextLine().trim();

            if (palabra.isEmpty()) {
                System.out.println("No has escrito ninguna palabra");
                continue;
            }
            if (palabra.equals("fin")) {
                break;
            }
            contarCaracteres(palabra);
        }
        sc.close();
        System.out.println("Programa finalizado.");
    }
    // Lanzamos el proceso hijo para una palabra y muestra del resultado:
    private static void contarCaracteres(String palabra) {
        String rutaJava = System.getProperty("java.home") + File.separator + "bin" +
                          File.separator + "java";
        String classpath = System.getProperty("java.class.path");

        ProcessBuilder pb = new ProcessBuilder(rutaJava, "-cp", classpath,
                            "contador.ContadorCaracteres", palabra);
        try {
            Process proceso = pb.start();
            String salida = leer(proceso.getInputStream());
            String error = leer(proceso.getErrorStream());
            int codigo = proceso.waitFor();

            if (codigo == 0) {
                System.out.println("La palabra \"" + palabra + "\" tiene " + salida + " caracteres");
            } else {
                System.err.println("ERROR: El proceso hijo terminó con código " + codigo + ": " + error);
            }
        } catch (IOException e) {
            System.err.println("No se pudo lanzar el proceso hijo: " + e.getMessage());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Se interrumpió la espera del proceso hijo");
        }
    }
    // Aquí se lee todo el contenido de un flujo del hijo
    private static String leer(InputStream flujo) throws IOException {
        StringBuilder texto = new StringBuilder();
        try (BufferedReader lector = new BufferedReader(new InputStreamReader(flujo,
                                     StandardCharsets.UTF_8))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                if (texto.length() > 0) {
                    texto.append(System.lineSeparator());
                }
                texto.append(linea);
            }
        }
        return texto.toString();
    }
}
