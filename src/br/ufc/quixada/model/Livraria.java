package br.ufc.quixada.model;

import java.util.ArrayList;

public class Livraria {
    private static Livraria instancia = new Livraria();

    private ArrayList<Venda> vendas;

    //Tem os livros disponiveis na livraria com quantidade de estoque
    private ArrayList<Livro> livros = new ArrayList<>();

    private double saldo = 100;

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

    public static Livraria getInstancia() {
        return instancia;
    }

    public boolean comprarNovoLivro(Livro livro) {
        if (livro.getValor() * livro.getQuantidadeEstoque() < this.getSaldo()) {
            this.livros.add(livro);
            return true;
        }
        return false;
    }

    public void comprarLivro(int id, int qtdCompra) {
        double saldoAtual = this.getSaldo();
        double valorCompra = qtdCompra * this.getLivros().get(id).getValor();
        if (saldoAtual >= valorCompra) {
            this.getLivros().get(id).setQuantidadeEstoque(this.getLivros().get(id).getQuantidadeEstoque() + qtdCompra);
            this.setSaldo(saldoAtual - valorCompra);
        } else {
            System.out.println("Saldo insuficiente :(\nTente vender alguns livros para depois comprar mais");
        }
    }

    //deve mostrar a lista de livros em estoque
    public void consultarEstoque() {
        for (Livro l : getLivros()) {
            System.out.println(l);
        }
    }

    public void consultarVendas() {
        for (Venda v : getVendas()) {
            System.out.println(v);
        }
    }

    ArrayList<Venda> vds = new ArrayList<>();

    public void venderLivro(int id, int qtdVenda) {
        this.consultarEstoque();
        double saldoAtual = this.getSaldo();
        double valorCompra = qtdVenda * this.getLivros().get(id).getValor();
        int estoqueAtual = this.getLivros().get(id).getQuantidadeEstoque();
        if (estoqueAtual >= qtdVenda) {
            this.getLivros().get(id).setQuantidadeEstoque(estoqueAtual - qtdVenda);
            this.setSaldo(saldoAtual + (valorCompra * 0.25));
            ItemVenda iv = new ItemVenda(livros.get(id).getNome(), qtdVenda);
            Venda v = new Venda((valorCompra * 0.25), iv);
            vds.add(v);
            this.setVendas(vds);
        } else {
            System.out.println("Não temos todos esses livros :(\nTente comprar uma quantidade menor desse livro");
        }
    }
}