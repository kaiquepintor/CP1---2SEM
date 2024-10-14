package br.com.fiap.view;

import br.com.fiap.model.Cliente;
import br.com.fiap.model.ClienteDAO;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClienteDAO clienteDAO = new ClienteDAO();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Listar Clientes");
            System.out.println("3. Pesquisar Cliente por Código");
            System.out.println("4. Editar Cliente");
            System.out.println("5. Remover Cliente");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    // Cadastrar Cliente
                    System.out.print("Nome: ");
                    String nome = scanner.next();
                    System.out.print("Email: ");
                    String email = scanner.next();
                    System.out.print("Telefone: ");
                    String telefone = scanner.next();
                    Cliente cliente = new Cliente(0, nome, email, telefone);
                    clienteDAO.cadastrar(cliente);
                    break;

                case 2:
                    // Listar Clientes
                    clienteDAO.listar().forEach(System.out::println);
                    break;

                case 3:
                    // Pesquisar Cliente por Código
                    System.out.print("Informe o código do cliente: ");
                    int idPesquisa = scanner.nextInt();
                    Cliente clientePesquisado = clienteDAO.pesquisarPorCodigo(idPesquisa);
                    if (clientePesquisado != null) {
                        System.out.println(clientePesquisado);
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 4:
                    // Editar Cliente
                    System.out.print("Informe o código do cliente a ser editado: ");
                    int idEditar = scanner.nextInt();
                    Cliente clienteEditar = clienteDAO.pesquisarPorCodigo(idEditar);
                    if (clienteEditar != null) {
                        System.out.print("Novo Nome: ");
                        clienteEditar.setNome(scanner.next());
                        System.out.print("Novo Email: ");
                        clienteEditar.setEmail(scanner.next());
                        System.out.print("Novo Telefone: ");
                        clienteEditar.setTelefone(scanner.next());
                        clienteDAO.editar(clienteEditar);
                        System.out.println("Cliente atualizado com sucesso.");
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 5:
                    // Remover Cliente
                    System.out.print("Informe o código do cliente a ser removido: ");
                    int idRemover = scanner.nextInt();
                    Cliente clienteRemover = clienteDAO.pesquisarPorCodigo(idRemover);
                    if (clienteRemover != null) {
                        clienteDAO.remover(idRemover);
                        System.out.println("Cliente removido com sucesso.");
                    } else {
                        System.out.println("Cliente não encontrado.");
                    }
                    break;

                case 6:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 6);
    }
}
