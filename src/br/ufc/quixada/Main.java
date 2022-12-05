package br.ufc.quixada;

import br.ufc.quixada.model.Livraria;
import br.ufc.quixada.model.Livro;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int id;
        int qtdCompra;
        int qtdVenda;

        ArrayList<Livro> bd_livros = new ArrayList<>();
        bd_livros.add(new Livro("Harry Potter e a Pedra Filosofal", 50, 7, "aventura", "ilustracoes"));
        bd_livros.add(new Livro("Robison Crusoe", 55, 10, "aventura", "ilustracoes"));
        bd_livros.add(new Livro("Dom Quixote", 48, 12, "aventura", "ilustracoes"));
        bd_livros.add(new Livro("Romeu e Julieta", 29, 2, "drama", "capa dura"));
        bd_livros.add(new Livro("A paciente silenciosa", 35, 5, "drama", "capa dura"));
        bd_livros.add(new Livro("Hamlet", 25, 8, "drama", "capa dura"));
        bd_livros.add(new Livro("Divina Comédia", 25, 9, "comedia", "capa brochura"));
        bd_livros.add(new Livro("Paraíso", 30, 10, "comedia", "capa brochura"));
        bd_livros.add(new Livro("Até o Fim do Mundo", 15, 4, "comedia", "capa brochura"));

        Livraria livraria = Livraria.getInstancia();
        livraria.setLivros(bd_livros);

        while (true) {
            menu();
            Scanner scanner = new Scanner(System.in);
            String op = scanner.nextLine();
            switch (op) {
                case "0":
                    return;
                case "1":
                    //Comprar livro(adicionar um novo livro no estoque - com quantidade)
                    System.out.println("Qual o nome do livro?");
                    String nome = scanner.nextLine();
                    System.out.println("Qual o valor do livro?");
                    double valor = Double.parseDouble(scanner.nextLine());
                    System.out.println("Qual a quantidade de livros?");
                    int quantidade = Integer.parseInt(scanner.nextLine());
                    System.out.println("Qual o genero do livro?(Aventura, drama ou comedia)");
                    String genero = scanner.nextLine();
                    String caracteristica = "";
                    if (genero.equalsIgnoreCase("aventura")) {
                        caracteristica = "ilustracoes";
                    } else if (genero.equalsIgnoreCase("drama")) {
                        caracteristica = "capa dura";
                    } else if (genero.equalsIgnoreCase("comedia")) {
                        caracteristica = "capa brochura";
                    }
                    Livro l = new Livro(nome, valor, quantidade, genero, caracteristica);
                    if(livraria.comprarNovoLivro(l)){
                        System.out.println("O novo livro foi adicionado ao estoque");
                    } else {
                        System.out.println("Saldo insuficiente :(\nTente vender alguns livros para depois comprar mais");
                    }
                    System.out.println("Aperte Enter para voltar ao menu");
                    scanner.nextLine();
                    break;
                case "2":
                    //Comprar livro(alterar a quantidade de um livro já existente e o saldo)
                    livraria.consultarEstoque();
                    System.out.println("Informe o id o livro que deseja comprar");
                    id = Integer.parseInt(scanner.nextLine());
                    System.out.println("Agora informe quantos livros deseja comprar");
                    qtdCompra = Integer.parseInt(scanner.nextLine());
                    //passar esses parametros pro metodo
                    livraria.comprarLivro(id, qtdCompra);
                    System.out.println("Aperte Enter para voltar ao menu");
                    scanner.nextLine();
                    break;
                case "3":
                    //Vender livro(alterar a quantidade de um livro já existente e o saldo)
                    boolean vendendo = true;
                    while (vendendo) {
                        livraria.consultarEstoque();
                        System.out.println("Qual o id do livro que deseja vender?");
                        id = Integer.parseInt(scanner.nextLine());
                        System.out.println("Qual a quantidade que deseja vender?");
                        qtdVenda = Integer.parseInt(scanner.nextLine());
                        livraria.venderLivro(id, qtdVenda);
                        System.out.println("deseja vender mais um livro?S/N");
                        if (scanner.nextLine().equals("N"))
                            vendendo = false;
                    }
                    System.out.println("Aperte Enter para voltar ao menu");
                    scanner.nextLine();
                    break;
                case "4":
                    //consultar saldo
                    System.out.println(livraria.getSaldo());
                    System.out.println("Aperte Enter para voltar ao menu");
                    scanner.nextLine();
                    break;
                case "5":
                    //consultar vendas
                    livraria.consultarVendas();
                    System.out.println("Aperte Enter para voltar ao menu");
                    scanner.nextLine();
                    break;
                case "6":
                    //consultar estoque de livros
                    livraria.consultarEstoque();
                    System.out.println("Aperte Enter para voltar ao menu");
                    scanner.nextLine();
                    break;
                default:
                    System.out.println("Escolha uma opção válida!Ok?:)");
                    System.out.println("Aperte Enter para voltar ao menu");
                    scanner.nextLine();
            }
        }
    }

    public static void menu() {
        System.out.println("Seja bem-vindo a livraria so Sr Code!\n" +
                "O que quer fazer?\n" +
                "0 - Fechar o sistema\n" +
                "1 - Comprar um novo livro\n" +
                "2 - Comprar mais unidades de um livro que já esta no estoque\n" +
                "3 - Vender livros\n" +
                "4 - Consultar Saldo\n" +
                "5 - Consultar Vendas\n" +
                "6 - Consultar estoque de livros");
    }
}