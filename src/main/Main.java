package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Doador;

public class Main {

    static List<Doador> listaDoadores = new ArrayList<>();
    static int contadorId = 1;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE DOAÇÃO =====");
            System.out.println("1 - Cadastrar doador");
            System.out.println("2 - Listar doadores");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarDoador(scanner);
                    break;

                case 2:
                    listarDoadores();
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

    // MÉTODO CADASTRAR
    public static void cadastrarDoador(Scanner scanner) {
        System.out.println("\n--- Cadastro de Doador ---");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        Doador doador = new Doador(contadorId++, nome, telefone, email, endereco);
        listaDoadores.add(doador);

        System.out.println("Doador cadastrado com sucesso!");
    }

    // MÉTODO LISTAR
    public static void listarDoadores() {
        System.out.println("\n--- Lista de Doadores ---");

        if (listaDoadores.isEmpty()) {
            System.out.println("Nenhum doador cadastrado.");
        } else {
            for (Doador d : listaDoadores) {
                System.out.println(d);
            }
        }
    }
}