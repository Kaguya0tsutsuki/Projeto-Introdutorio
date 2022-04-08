package back;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MostarTarefa {
    public static void mostrarTarefas() throws FileNotFoundException {
        int y = 5;

        while(y >= 0) {
            File file = new File("File");
            Scanner input = new Scanner(file);

            while(input.hasNextLine()) {
                String linha = input.nextLine();
                String[] atributos = new String[6];
                atributos = linha.split("@");
                if (atributos[3].equals(Integer.toString(y))) {
                    System.out.println("\n---------TAREFA---------\nNome: " + atributos[0] + "\nDescrição: " + atributos[1] + "\nData de Termino: " + atributos[2] + "\nPrioridade: " + atributos[3] + "\nCategoria: " + atributos[4] + "\nStatus: " + atributos[5] + "\n");
                }
            }

            --y;
            input.close();
        }

    }
}
