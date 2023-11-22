package com.esiii.backendjogodaonca.entities.response;

import com.esiii.backendjogodaonca.entities.database.Item;

public class ItemResponse extends Item {
    private Integer qntItens;

    public Integer getQntItens() {
        return qntItens;
    }

    public void setQntItens(Integer qntItens) {
        this.qntItens = qntItens;
    }
}
