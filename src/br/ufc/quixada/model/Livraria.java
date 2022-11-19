package br.ufc.quixada.model;

import java.util.ArrayList;

public class Livraria {
    private static Livraria estancia = new Livraria();

    private ArrayList<Venda> vendas;

    //Tem os livros disponiveis na livraria com quantidade de estoque
    private ArrayList<Livro> livros = new ArrayList<>();

    private double saldo = 0;

    private Livraria() {
    }

    public ArrayList<Venda> getVendas() {
        return vendas;
    }

    public void setVendas(ArrayList<Venda> vendas) {
        this.vendas = vendas;
    }

    public ArrayList<Livro> getLivros() {
        return livros;
    }

    public void setLivros(ArrayList<Livro> livros) {
        this.livros = livros;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public static Livraria getEstancia() {
        return estancia;
    }

    public void comprarLivro(Livro livro) {
        this.livros.add(livro);
    }

    //deve mostrar a lista de livros em estoque
    public void consultarEstoque() {
        for (Livro l : getLivros()) {
            System.out.println(l);
        }
    }
}
