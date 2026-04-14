package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE DOAÇÃO =====");
            System.out.println("1 - Cadastrar doador");
            System.out.println("2 - Cadastrar beneficiário");
            System.out.println("3 - Cadastrar item");
            System.out.println("4 - Listar dados");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.println("Cadastro de doador (em construção)");
                    break;

                case 2:
                    System.out.println("Cadastro de beneficiário (em construção)");
                    break;

                case 3:
                    System.out.println("Cadastro de item (em construção)");
                    break;

                case 4:
                    System.out.println("Listagem (em construção)");
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }
}