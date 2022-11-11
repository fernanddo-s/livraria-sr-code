package br.ufc.quixada;

import br.ufc.quixada.model.Livraria;
import br.ufc.quixada.model.Livro;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

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

        Livraria livraria = Livraria.getEstancia();
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
                    if(genero.equalsIgnoreCase("aventura")){
                        caracteristica = "ilustracoes";
                    } else if (genero.equalsIgnoreCase("drama")) {
                        caracteristica = "capa dura";
                    } else if (genero.equalsIgnoreCase("comedia")) {
                        caracteristica = "capa brochura";
                    }
                    Livro l = new Livro(nome, valor, quantidade,genero,caracteristica);
                    livraria.comprarLivro(l);
                    System.out.println("O novo livro foi adicionado ao estoque\nAperte Enter para voltar ao menu");
                    scanner.nextLine();
                    break;
                case "2":
                    //Comprar livro(alterar a quantidade de um livro já existente)
                    livraria.consultarEstoque();
                    System.out.println("Informe o id o livro que deseja comprar");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println("Agora informe quantos livros deseja comprar");
                    int qtd = Integer.parseInt(scanner.nextLine());
                    //Mudar a quantidade no estoque e mudar o valor do saldo
                    livraria.getLivros().get(id).setQuantidadeEstoque(livraria.getLivros().get(id).getQuantidadeEstoque()+qtd);
                    livraria.setSaldo(livraria.getSaldo() - (qtd*livraria.getLivros().get(id).getValor()));
                    System.out.println("Aperte Enter para voltar ao menu");
                    scanner.nextLine();
                    break;
                case "3":
                    //consultar saldo
                    System.out.println(livraria.getSaldo());
                    break;
                case "4":
                    //consultar estoque de livros
                    break;
                case "5":
                    //listar todos os livros disponiveis pra compra
                    livraria.consultarEstoque();
                    System.out.println("Aperte Enter para voltar ao menu");
                    scanner.nextLine();
                    break;
            }

        }
    }

    public static void menu(){
        System.out.println("Seja bem-vindo a livraria so Sr Code!");
        System.out.println("O que quer fazer?");
        System.out.println("0 - Fechar o sistema\n" +
                "1 - Comprar um livro novo\n" +
                "2 - Comprar um livro que já esta no estoque\n" +
                "3 - Consultar Saldo\n" +
                "4 - Consultar estoque de livros");
    }
}


        /*
        * Na livraria do Code tem três
tipos de livros, a saber: aventura, drama e comédia. Todos os livros possuem nome,
valor, quantidade em estoque e um identificador único. Os livros de aventura possuem
ilustrações; os livros de drama possuem capa dura; e os de comédia possuem capa tipo
brochura. Inicialmente, Code não quer armazenar os seus clientes, porém gostaria de
efetuar e guardar as vendas, consultar qual o seu estoque de livros, quanto dinheiro ele
tem em caixa, além de efetuar compras de novos livros.
        * */

//Livro -> Nome, valor, quantidade em estoque, id
//Genero -> aventura, drama, comédia
//Caracteristicas -> aventura-ilustrações, drama-capa dura, comédia-brochura
//fazer e gurar as vendas
//consultar o estoque
//quanto em dinheiro ele tem em caixa
//comprar novos livros

//        como eu imagino o sitema
//                10 livros de cada pra ele poder comprar
//                cada um tem um valor de compra (mais barato)
//                e um valor de venda(mais caro)
//                é preciso fazer conta se ele pode ou não comprar os livros
//                Uma lista de livros que podem ser comprados já com preço pré estabelecido