package back;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import static back.Menu.menu;
import static back.MostarTarefa.mostrarTarefas;
import static back.CriarTarefa.criarTarefa;
import static back.AlteraStatus.alterarStatus;
import static back.LimparFile.limparFile;

public class Opcao{

    public static void opcao(int opcao) throws IOException {
        Scanner input = new Scanner(System.in);
        File file = new File("File");
        Scanner dig = new Scanner(file);
        switch(opcao) {
            case 1:
                mostrarTarefas();
                menu();
                break;
            case 2:
                System.out.println("Nome: ");
                String nomeX = input.nextLine();

                String descricaoX;
                while(dig.hasNextLine()) {
                    descricaoX = dig.nextLine();
                    String[] array = new String[6];

                    for(array = descricaoX.split("@"); array[0].equalsIgnoreCase(nomeX); nomeX = input.nextLine()) {
                        System.out.println(".: TAREFA JÁ EXISTENTE :.\n");
                    }
                }

                System.out.println("Descrição: ");
                descricaoX = input.nextLine();
                System.out.println("Data de Término: ");
                String dataDeTerminoX = input.nextLine();
                System.out.println("Prioridade 1-5: ");

                int prioridadeX;
                for(prioridadeX = input.nextInt(); prioridadeX == 0 || prioridadeX > 5; prioridadeX = input.nextInt()) {
                    System.out.println("Opção Inválida!");
                }

                System.out.println("Categoria: ");
                String categoriaX = input.next();
                System.out.println("Status: ");
                String statusX = input.next();
                Tarefa tarefa = new Tarefa(nomeX, descricaoX, dataDeTerminoX, prioridadeX, categoriaX, statusX);
                criarTarefa(tarefa);
                System.out.println("\n.: TAREFA CRIADA COM SUCESSO :.");
                System.exit(0);
                break;
            case 3:
                alterarStatus();
                break;
            case 4:
                Scanner x = new Scanner(System.in);
                System.out.println("Deseja resetar a sua Lista? S/N");
                String op = x.nextLine();
                if (op.equalsIgnoreCase("s")) {
                    System.out.println(".: LISTA RESETADA COM SUCESSO :.");
                    limparFile();
                } else {
                    menu();
                }
                break;
            case 5:
                System.exit(0);
        }

    }
}
