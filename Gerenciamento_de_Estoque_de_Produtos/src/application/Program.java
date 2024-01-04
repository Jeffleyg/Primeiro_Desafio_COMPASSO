package application;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import entities.CauseException;
import entities.Produto;

public class Program {
    public static void main(String[] args) throws CauseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        HashSet<Produto> produtos = new HashSet<>();
        System.out.println("Seja Bem-vindo no nosso sistema!!!");
        System.out.println("Escolha a versão que você quer usar (1 ou 2): ");
        int n = sc.nextInt();

        switch (n) {
            case 1:
                try{
                    System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨Bem vindo ao nosso sistema¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨\n");
                    Produto produto = readProduct(produtos, sc);
                    produtos.add(produto);
                    printProductDetails(produto);
                    break;
                }catch(InputMismatchException e){
                    System.out.println("Error! Entrada Inválida");
                }
                break;
                
            case 2:
                try {
                    System.out.println("¨¨¨¨¨¨¨¨¨¨Bem Vindo ao nosso sistema (Atualizada)¨¨¨¨¨¨¨¨¨\n");

                    int choice;
                    do {
                        System.out.println("1. Adicionar Produto");
                        System.out.println("2. Listar Produtos");
                        System.out.println("3. Atualizar Produto");
                        System.out.println("4. Deletar Produto");
                        System.out.println("5. Sair");
                        System.out.println("Escolha a opção desejada: ");

                        choice = sc.nextInt();

                        switch (choice) {
                            case 1:
                                Produto newProduto = readProduct(produtos, sc);
                                produtos.add(newProduto);
                                break;
                            case 2:
                                listProducts(produtos);
                                break;
                            case 3:
                                updateProduct(produtos, sc);
                                break;
                            case 4:
                                deleteProduct(produtos, sc);
                                break;
                            case 5:
                                System.out.println("Encerrando o programa. Até mais!");
                                break;
                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                        }

                    } while (choice != 5);

                } catch (InputMismatchException e) {
                    System.out.println("Error! Entrada Inválida");
                } finally {
                    sc.close();
                }
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
    
    
    private static Produto readProduct(HashSet<Produto> produtos, Scanner sc) {
        System.out.println("Nome do produto: ");
        String nome = sc.next();

        int codigo;
        do {
            System.out.println("Código do produto: ");
            codigo = sc.nextInt();

            if (containsProductCode(produtos, codigo)) {
                System.out.println("Código já existe. Digite um código único. por favor!!!");
            } else {
                break;
            }
        } while (true);

        System.out.println("Preço do produto: ");
        double preco = sc.nextDouble();
        System.out.println("Quantidade de estoque: ");
        int quantidadeEstoque = sc.nextInt();

        int qtProdutosComprados, qtProdutosVendidos;
        
        do {
            System.out.println("Digite a quantidade de produtos comprados: ");
            qtProdutosComprados = sc.nextInt();
            System.out.println("Digite a quantidade de produtos vendidos: ");
            qtProdutosVendidos = sc.nextInt();

            try {
                Produto produto = new Produto(nome, codigo, preco, quantidadeEstoque);
                produto.produtosComprados(qtProdutosComprados);
                produto.produtosVendidos(qtProdutosVendidos);
                return produto;
            } catch (CauseException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
    }



    private static boolean containsProductCode(HashSet<Produto> produtos, int codigo) {
        for (Produto produto : produtos) {
            if (produto.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }


    private static void listProducts(HashSet<Produto> produtos) {
        if(produtos.isEmpty()){
            System.out.println("Não tem produtos armazenados!!!\n");
        }else{
            for (Produto p : produtos) {
            printProductDetails(p);
            }
        }
    }

    private static void updateProduct(HashSet<Produto> produtos, Scanner sc) {
        System.out.println("Digite o código do produto que deseja atualizar: ");
        int codigo = sc.nextInt();

        for (Produto p : produtos) {
            if (p.getCodigo() == codigo) {
                System.out.println("Digite o novo preço do produto: ");
                double newPreco = sc.nextDouble();
                p.setPrice(newPreco);

                System.out.println("Produto atualizado com sucesso!");
                printProductDetails(p);
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }

    private static void deleteProduct(HashSet<Produto> produtos, Scanner sc) {
        System.out.println("Digite o código do produto que deseja excluir: ");
        int codigo = sc.nextInt();

        for (Produto p : produtos) {
            if (p.getCodigo() == codigo) {
                produtos.remove(p);
                System.out.println("Produto excluído com sucesso!");
                return;
            }
        }

        System.out.println("Produto não encontrado.");
    }

    private static void printProductDetails(Produto p) {
        System.out.println("¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨¨\n");
        System.out.printf("Nome: %s\n", p.getNome());
        System.out.printf("Código: %d\n", p.getCodigo());
        System.out.printf("Preço: %.2f\n", p.getPrice());
        System.out.printf("Quantidade de estoque: %d\n", p.getQuantidadeEstoque());
    }
}
