package com.esiii.backendjogodaonca.entities.request;

import java.util.ArrayList;

public class CompraRequest {
    private Integer idJogador;
    private ArrayList<ItemRequest> idItens;
    private Boolean pagamentoMoedaRara;
    private Integer valorTotal;

    public Integer getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(Integer idJogador) {
        this.idJogador = idJogador;
    }

    public ArrayList<ItemRequest> getIdItens() {
        return idItens;
    }

    public void setIdItens(ArrayList<ItemRequest> idItens) {
        this.idItens = idItens;
    }

    public Boolean getPagamentoMoedaRara() {
        return pagamentoMoedaRara;
    }

    public void setPagamentoMoedaRara(Boolean pagamentoMoedaRara) {
        this.pagamentoMoedaRara = pagamentoMoedaRara;
    }

    public Integer getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Integer valorTotal) {
        this.valorTotal = valorTotal;
    }
}
