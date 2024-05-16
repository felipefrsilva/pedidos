//package br.com.fiap.techchallange.infrastructure.adapters.in;
//
//import br.com.fiap.techchallange.orders.domain.service.ProductApplication;
//import br.com.fiap.techchallange.infrastructure.ports.in.http.ProductManagement;
//import br.com.fiap.techchallange.orders.domain.entity.Product;
//
//import java.util.List;
//import java.util.Scanner;
//
//public class ProductManagementConsole implements ProductManagement {
//
//    private final ProductApplication productApplication;
//
//    public ProductManagementConsole(){
//        productApplication =  new ProductApplication();
//    }
//
//    public static void main(String[] args) {
//        ProductManagementConsole main = new ProductManagementConsole();
//        Scanner scanner = new Scanner(System.in);
//        int choice;
//
//        do {
//            System.out.println("Selecione uma opção:");
//            System.out.println("1. Listar Produtos");
//            System.out.println("2. Obter Produto por SKU");
//            System.out.println("3. Obter Produto por Nome");
//            System.out.println("0. Sair");
//            System.out.print("Digite o número da opção desejada: ");
//
//            // Obtém a escolha do usuário
//            choice = scanner.nextInt();
//
//            // Limpa o buffer do scanner
//            scanner.nextLine();
//
//            // Processa a escolha do usuário
//            switch (choice) {
//                case 1:
//                    System.out.println(main.getProducts());
//                    break;
//                case 2:
//                    String sku = scanner.next();
//                    System.out.println(main.getProductBySku(sku));
//                    break;
//                case 3:
//                    String name = scanner.next();
//                    System.out.println(main.getProductByName(name));
//                    break;
//                case 0:
//                    System.out.println("Saindo do programa...");
//                    break;
//                default:
//                    System.out.println("Opção inválida! Tente novamente.");
//            }
//
//            System.out.println(); // Adiciona uma linha em branco para melhorar a aparência do menu
//
//        } while (choice != 0);
//
//        scanner.close(); // Fecha o scanner quando não for mais necessário
//    }
//
//    @Override
//    public List<Product> getProducts() {
//        return productApplication.getProducts();
//    }
//
//    @Override
//    public Product getProductBySku(String sku) {
//        return productApplication.getProductBySku(sku);
//    }
//
//    @Override
//    public Product getProductByName(String name) {
//        return productApplication.getProductByName(name);
//    }
//}
