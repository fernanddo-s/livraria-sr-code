package br.ufc.quixada.model;

import java.util.ArrayList;
import java.util.Date;

public class Venda {

    private Date dataVenda = new Date();
    private double valorVenda;
    private ItemVenda item;

    public Venda() {
    }

    public Venda(Date dataVenda, double valorVenda, ItemVenda item) {
        this.dataVenda = dataVenda;
        this.valorVenda = valorVenda;
        this.item = item;
    }

    public Venda(double valorVenda, ItemVenda item) {
        this.valorVenda = valorVenda;
        this.item = item;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public ItemVenda getItem() {
        return item;
    }

    public void setItem(ItemVenda item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return "Venda{" +
                "dataVenda=" + dataVenda +
                ", valorVenda=" + valorVenda +
                ", item=" + item +
                '}';
    }
}
