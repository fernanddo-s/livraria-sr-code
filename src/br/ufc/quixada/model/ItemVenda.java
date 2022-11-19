package br.ufc.quixada.model;

public class ItemVenda {
    private String nome;
    private int qtd;

    public ItemVenda() {
    }

    public ItemVenda(String nome, int qtd) {
        this.nome = nome;
        this.qtd = qtd;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    @Override
    public String toString() {
        return "ItemVenda{" +
                "nome='" + nome + '\'' +
                ", qtd=" + qtd +
                '}';
    }
}
