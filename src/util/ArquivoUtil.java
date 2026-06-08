package util;

import java.io.FileWriter;
import java.io.IOException;

public class ArquivoUtil {

    public static void salvarDoador(String texto) {

        try {

            FileWriter writer = new FileWriter("doadores.txt", true);

            writer.write(texto + "\n");

            writer.close();

        } catch (IOException e) {

            System.out.println("Erro ao salvar arquivo.");
        }
    }
}