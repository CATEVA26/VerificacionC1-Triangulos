package excepciones;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Excepción personalizada para Triángulos no creados.
 */
public class ExcepcionTrianguloNoCreado extends Exception {

    public ExcepcionTrianguloNoCreado(String message) {
        super(message);
        logError(message);
    }

    private void logError(String message) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(new Date());

        try (PrintWriter writer = new PrintWriter(new FileWriter("log.txt", true))) {
            writer.println(formattedDate + " - " + message);
        } catch (IOException e) {
            // Manejar la excepción de E/S si ocurre
            e.printStackTrace();
        }
    }
}


