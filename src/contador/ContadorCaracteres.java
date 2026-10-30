package contador;

public class ContadorCaracteres {
    public static void main(String[] args) {
        // Debe recibir un sólo parámetro.
        if (args.length != 1) {
            System.err.println("Uso: java contador.ContadorCaracteres <palabra>");
            System.exit(1);
        }
        // Escribimos sólo el número de caracteres.
        System.out.println(args[0].length());
    }
}
