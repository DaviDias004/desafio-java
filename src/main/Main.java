package main;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Doador;
import model.Beneficiario;
import model.ItemDoacao;
import model.Solicitacao;

public class Main {

    static List<ItemDoacao> listaItens = new ArrayList<>();
    static List<Beneficiario> listaBeneficiarios = new ArrayList<>();
    static List<Doador> listaDoadores = new ArrayList<>();
    static int contadorId = 1;
    static List<Solicitacao> listaSolicitacoes = new ArrayList<>();

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE DOAÇÃO =====");
            System.out.println("1 - Cadastrar doador");
            System.out.println("2 - Listar doadores");
            System.out.println("3 - Cadastrar beneficiário");
            System.out.println("4 - Listar beneficiários");
            System.out.println("5 - Cadastrar item");
            System.out.println("6 - Listar itens");
            System.out.println("7 - Criar solicitação");
            System.out.println("8 - Listar solicitações");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarDoador(scanner);
                    break;

                case 2:
                    listarDoadores();
                    break;

                case 3:
                    cadastrarBeneficiario(scanner);
                    break;

                case 4:
                    listarBeneficiarios();
                    break;
                
                case 5:
                    cadastrarItem(scanner);
                    break;    

                case 6:
                   listarItens();
                   break;    
                
                case 7:
                   criarSolicitacao(scanner);
                   break;

                case 8:
                   listarSolicitacoes();
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

    public static void cadastrarBeneficiario(Scanner scanner) {
    System.out.println("\n--- Cadastro de Beneficiário ---");

    System.out.print("Nome: ");
    String nome = scanner.nextLine();

    System.out.print("Telefone: ");
    String telefone = scanner.nextLine();

    System.out.print("Email: ");
    String email = scanner.nextLine();

    System.out.print("Endereço: ");
    String endereco = scanner.nextLine();

    System.out.print("Tipo (ONG, família, etc): ");
    String tipo = scanner.nextLine();

    System.out.print("Prioridade (1 a 5): ");
    int prioridade = scanner.nextInt();
    scanner.nextLine();

    Beneficiario b = new Beneficiario(contadorId++, nome, telefone, email, endereco, tipo, prioridade);
    listaBeneficiarios.add(b);

    System.out.println("Beneficiário cadastrado com sucesso!");
}

  public static void listarBeneficiarios() {
    System.out.println("\n--- Lista de Beneficiários ---");

    if (listaBeneficiarios.isEmpty()) {
        System.out.println("Nenhum beneficiário cadastrado.");
    } else {
        for (Beneficiario b : listaBeneficiarios) {
            System.out.println(b);
        }
    }
}

   public static void cadastrarItem(Scanner scanner) {
    System.out.println("\n--- Cadastro de Item ---");

    System.out.print("Nome do item: ");
    String nome = scanner.nextLine();

    System.out.print("Categoria: ");
    String categoria = scanner.nextLine();

    System.out.print("Descrição: ");
    String descricao = scanner.nextLine();

    System.out.print("Quantidade: ");
    int quantidade = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Estado de conservação: ");
    String estado = scanner.nextLine();

    String status = "disponivel";

    ItemDoacao item = new ItemDoacao(contadorId++, nome, categoria, descricao, quantidade, estado, status);
    listaItens.add(item);

    System.out.println("Item cadastrado com sucesso!");
}

   public static void listarItens() {
    System.out.println("\n--- Lista de Itens ---");

    if (listaItens.isEmpty()) {
        System.out.println("Nenhum item cadastrado.");
    } else {
        for (ItemDoacao i : listaItens) {
            System.out.println(i);
        }
    }
}

public static void criarSolicitacao(Scanner scanner) {

    if (listaBeneficiarios.isEmpty()) {
        System.out.println("Nenhum beneficiário cadastrado.");
        return;
    }

    if (listaItens.isEmpty()) {
        System.out.println("Nenhum item cadastrado.");
        return;
    }

    System.out.println("\n--- Beneficiários ---");

    for (int i = 0; i < listaBeneficiarios.size(); i++) {
        System.out.println(i + " - " + listaBeneficiarios.get(i).getNome());
    }

    System.out.print("Escolha o beneficiário: ");
    int indiceBeneficiario = scanner.nextInt();
    scanner.nextLine();

    Beneficiario beneficiario = listaBeneficiarios.get(indiceBeneficiario);

    System.out.println("\n--- Itens Disponíveis ---");

    for (int i = 0; i < listaItens.size(); i++) {
        System.out.println(i + " - " + listaItens.get(i).getNome());
    }

    System.out.print("Escolha o item: ");
    int indiceItem = scanner.nextInt();
    scanner.nextLine();

    ItemDoacao item = listaItens.get(indiceItem);

    System.out.print("Quantidade solicitada: ");
    int quantidade = scanner.nextInt();
    scanner.nextLine();

    if (quantidade > item.getQuantidade()) {
        System.out.println("Quantidade indisponível.");
        return;
    }

    System.out.print("Justificativa: ");
    String justificativa = scanner.nextLine();

    Solicitacao solicitacao = new Solicitacao(
            contadorId++,
            beneficiario,
            item,
            quantidade,
            justificativa,
            "PENDENTE"
    );

    listaSolicitacoes.add(solicitacao);

    System.out.println("Solicitação criada com sucesso!");
}

public static void listarSolicitacoes() {

    System.out.println("\n--- Lista de Solicitações ---");

    if (listaSolicitacoes.isEmpty()) {
        System.out.println("Nenhuma solicitação cadastrada.");
    } else {

        for (Solicitacao s : listaSolicitacoes) {
            System.out.println(s);
            System.out.println("-------------------");
        }
    }
}

}