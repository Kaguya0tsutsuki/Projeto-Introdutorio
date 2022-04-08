package back;

import java.io.IOException;
import java.util.Scanner;

import static back.Opcao.opcao;

public class Menu {
    public static void menu() throws IOException {
        System.out.println("\n-----------MENU-----------");
        System.out.println("1 - Visualizar tarefas");
        System.out.println("2 - Criar tarefa");
        System.out.println("3 - Mudar status");
        System.out.println("4 - Limpar");
        System.out.println("5 - Sair");
        Scanner input = new Scanner(System.in);

        int opcao;
        for(opcao = input.nextInt(); opcao == 0 || opcao > 5; opcao = input.nextInt()) {
            System.out.println("Opção Inválida!");
        }

        opcao(opcao);
    }

}
