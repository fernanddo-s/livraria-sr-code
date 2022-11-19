package br.ufc.quixada.model;

import java.util.ArrayList;
import java.util.Date;

public class Venda {

    private Date dataVenda;
    private double valorVenda;
    private ArrayList<Livro> itens;

    public Venda() {
    }

    public Venda(ArrayList<Livro> itens, Date dataVenda) {
        this.itens = itens;
        this.dataVenda = dataVenda;
    }

    public ArrayList<Livro> getItens() {
        return itens;
    }

    public void setItens(ArrayList<Livro> itens) {
        this.itens = itens;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    @Override
    public String toString() {
        return "dataVenda: " + dataVenda + ", itens: " + itens;
    }
}
