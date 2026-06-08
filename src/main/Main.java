package main;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;
import util.ArquivoUtil;

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
            System.out.println("9 - Atualizar status da solicitação");
            System.out.println("10 - Listar solicitações pendentes");
            System.out.println("11 - Listar itens disponíveis");
            System.out.println("12 - Listar beneficiários prioritários");

            try {

             opcao = scanner.nextInt();
             scanner.nextLine();

         }  catch (InputMismatchException e) {

             System.out.println("Digite apenas números.");
            scanner.nextLine();
            opcao = -1;
}

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
                
                case 9:
                  atualizarStatusSolicitacao(scanner);
                  break;

                case 10:
                  listarSolicitacoesPendentes();
                  break;

                case 11:
                  listarItensDisponiveis();
                  break;

                case 12:
                  listarBeneficiariosPrioritarios();
                  break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        scanner.close();
    }

    // METODOS CADASTRAR E LISTAR
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

        ArquivoUtil.salvarDoador(
         nome + ";" +
         telefone + ";" +
         email + ";" +
         endereco);

        System.out.println("Doador cadastrado com sucesso!");
    }

    
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

public static void atualizarStatusSolicitacao(Scanner scanner) {

    if (listaSolicitacoes.isEmpty()) {
        System.out.println("Nenhuma solicitação cadastrada.");
        return;
    }

    System.out.println("\n--- Solicitações ---");

    for (int i = 0; i < listaSolicitacoes.size(); i++) {

        System.out.println(
            i + " - " + listaSolicitacoes.get(i)
        );

        System.out.println("----------------");
    }

    System.out.print("Escolha a solicitação: ");

    int indice;

    try {

        indice = scanner.nextInt();
        scanner.nextLine();

    } catch (Exception e) {

        System.out.println("Digite um número válido.");
        scanner.nextLine();
        return;
    }

    if (indice < 0 || indice >= listaSolicitacoes.size()) {

        System.out.println("Solicitação inválida.");
        return;
    }

    Solicitacao solicitacao = listaSolicitacoes.get(indice);

    System.out.println("""
1 - APROVADA
2 - RECUSADA
3 - ENTREGUE
""");

    System.out.print("Novo status: ");

    int opcao;

    try {

        opcao = scanner.nextInt();
        scanner.nextLine();

    } catch (Exception e) {

        System.out.println("Digite um número válido.");
        scanner.nextLine();
        return;
    }

    switch (opcao) {

        case 1:
            solicitacao.setStatus("APROVADA");
            break;

        case 2:
            solicitacao.setStatus("RECUSADA");
            break;

        case 3:
            solicitacao.setStatus("ENTREGUE");
            break;

        default:
            System.out.println("Opção inválida.");
            return;
    }

    System.out.println("Status atualizado com sucesso!");
}

public static void listarSolicitacoesPendentes() {

    System.out.println("\n--- Solicitações Pendentes ---");

    boolean encontrou = false;

    for (Solicitacao s : listaSolicitacoes) {

        if (s.getStatus().equalsIgnoreCase("PENDENTE")) {

            System.out.println(s);
            System.out.println("----------------");

            encontrou = true;
        }
    }

    if (!encontrou) {
        System.out.println("Nenhuma solicitação pendente.");
    }
}

public static void listarItensDisponiveis() {

    System.out.println("\n--- Itens Disponíveis ---");

    boolean encontrou = false;

    for (ItemDoacao i : listaItens) {

        if (i.getStatus().equalsIgnoreCase("disponivel")) {

            System.out.println(i);
            encontrou = true;
        }
    }

    if (!encontrou) {
        System.out.println("Nenhum item disponível.");
    }
}

public static void listarBeneficiariosPrioritarios() {

    System.out.println("\n--- Beneficiários Prioritários ---");

    boolean encontrou = false;

    for (Beneficiario b : listaBeneficiarios) {

        if (b.getPrioridade() >= 4) {

            System.out.println(b);

            encontrou = true;
        }
    }

    if (!encontrou) {
        System.out.println("Nenhum beneficiário prioritário.");
    }
}

}