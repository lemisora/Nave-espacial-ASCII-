package generaCadena;
import java.util.Random;

public class GeneradorNombresAleatorios {
    private static final String CARACTERES_PERMITIDOS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String generarNombreAleatorio(int longitud) {
        Random random = new Random();
        StringBuilder builder = new StringBuilder(longitud);

        for (int i = 0; i < longitud; i++) {
            builder.append(CARACTERES_PERMITIDOS.charAt(random.nextInt(CARACTERES_PERMITIDOS.length())));
        }

        return builder.toString();
    }
}