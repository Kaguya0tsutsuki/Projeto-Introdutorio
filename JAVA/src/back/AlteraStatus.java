package back;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

import static back.MostarTarefa.mostrarTarefas;

public class AlteraStatus {
    public static void alterarStatus() throws IOException {
        File file = new File("File");
        Scanner input = new Scanner(file);
        Scanner dig = new Scanner(System.in);
        int i = 0;
        boolean w = true;
        mostrarTarefas();
        System.out.println("Nome da tarefa: ");
        String verStatus = dig.nextLine();
        System.out.println("Novo status: ");

        for(String novoStatus = dig.nextLine(); w; w = false) {
            for(; input.hasNextLine(); ++i) {
                String linha = input.nextLine();
                String[] atributo = new String[6];
                atributo = linha.split("@");
                if (verStatus.equalsIgnoreCase(atributo[0])) {
                    String a = atributo[0];
                    String b = atributo[1];
                    String c = atributo[2];
                    String d = atributo[3];
                    String e = atributo[4];
                    Path path = Paths.get("File");
                    List<String> lines = Files.readAllLines(path);
                    lines.remove(i);
                    lines.add(i, a + "@" + b + "@" + c + "@" + d + "@" + e + "@" + novoStatus);
                    Files.write(path, lines);
                    System.out.println("\n.: STATUS ALTERADO COM SUCESSO :.");
                    System.exit(0);
                }
            }
        }

        System.out.println("\n.: TAREFA NÃO ENCONTRADA :.");
        System.out.println("  .: SAINDO DO PROGRAMA :.");
        System.exit(0);
        input.close();
    }
}
