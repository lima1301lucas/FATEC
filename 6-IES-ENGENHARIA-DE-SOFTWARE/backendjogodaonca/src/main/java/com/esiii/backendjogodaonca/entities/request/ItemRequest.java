package com.esiii.backendjogodaonca.entities.request;

public class ItemRequest {
    private Integer idItem;
    private Integer qntItem;
    private Boolean itemFavorito;

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public Integer getQntItem() {
        return qntItem;
    }

    public void setQntItem(Integer qntItem) {
        this.qntItem = qntItem;
    }

    public Boolean getItemFavorito() {
        return itemFavorito;
    }

    public void setItemFavorito(Boolean itemFavorito) {
        this.itemFavorito = itemFavorito;
    }
}
