package back;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CriarTarefa {
    public static void criarTarefa(Tarefa user) throws IOException {
        File file = new File("File");
        FileWriter aq = new FileWriter(file, true);
        BufferedWriter conexao = new BufferedWriter(aq);
        String var10001 = user.getNome();
        conexao.write(var10001 + "@" + user.getDescricao() + "@" + user.getDataDeTermino() + "@" + user.getPrioridade() + "@" + user.getCategoria() + "@" + user.getStatus());
        conexao.newLine();
        conexao.close();
    }
}
