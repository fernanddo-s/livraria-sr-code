package br.ufc.quixada.model;

public class Livro {
    private static int gerador_de_id = 0;

    private int id;
    private String nome;
    private double valor;
    private int quantidadeEstoque;
    private String genero;
    private String caracteristica;

    public Livro(String nome, double valor, int quantidadeEstoque, String genero, String caracteristica) {
        this.id = gerador_de_id++;
        this.nome = nome;
        this.valor = valor;
        this.quantidadeEstoque = quantidadeEstoque;
        this.genero = genero;
        this.caracteristica = caracteristica;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", nome: " + nome +
                ", valor: " + valor +
                ", estoque: " + quantidadeEstoque +
                ", genero: " + genero +
                ", tem: " + caracteristica;
    }
}
