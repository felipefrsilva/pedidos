package br.com.fiap.techchallange.infrastructure.console;

import java.util.Scanner;

public class ProductManagementConsole {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Selecione uma opção:");
            System.out.println("1. Listar Produtos");
            System.out.println("2. Obter Produto por SKU");
            System.out.println("3. Obter Produto por Nome");
            System.out.println("0. Sair");
            System.out.print("Digite o número da opção desejada: ");

            // Obtém a escolha do usuário
            choice = scanner.nextInt();

            // Limpa o buffer do scanner
            scanner.nextLine();

            // Processa a escolha do usuário
            switch (choice) {
                case 1:
//                    System.out.println(main.getProducts());
                    break;
                case 2:
                    String sku = scanner.next();
//                    System.out.println(main.getProductBySku(sku));
                    break;
                case 0:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

            System.out.println(); // Adiciona uma linha em branco para melhorar a aparência do menu

        } while (choice != 0);

        scanner.close(); // Fecha o scanner quando não for mais necessário
    }
}
