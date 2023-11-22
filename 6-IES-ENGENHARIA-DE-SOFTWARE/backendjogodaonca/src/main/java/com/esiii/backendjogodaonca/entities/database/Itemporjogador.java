package com.esiii.backendjogodaonca.entities.database;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "itemporjogador")
public class Itemporjogador {
    @EmbeddedId
    private ItemporjogadorId id;

    @MapsId("idjogador")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idjogador", nullable = false)
    private Jogador idjogador;

    @MapsId("iditem")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "iditem", nullable = false)
    private Item iditem;

    @NotNull
    @Column(name = "qntitem", nullable = false)
    private Integer qntitem;

    @Size(max = 6)
    @NotNull
    @Column(name = "itemfavorito", nullable = false, length = 6)
    private String itemfavorito;

    public ItemporjogadorId getId() {
        return id;
    }

    public void setId(ItemporjogadorId id) {
        this.id = id;
    }

    public Jogador getIdjogador() {
        return idjogador;
    }

    public void setIdjogador(Jogador idjogador) {
        this.idjogador = idjogador;
    }

    public Item getIditem() {
        return iditem;
    }

    public void setIditem(Item iditem) {
        this.iditem = iditem;
    }

    public Integer getQntitem() {
        return qntitem;
    }

    public void setQntitem(Integer qntitem) {
        this.qntitem = qntitem;
    }

    public String getItemfavorito() {
        return itemfavorito;
    }

    public Itemporjogador setItemfavorito(String itemfavorito) {
        this.itemfavorito = itemfavorito;
        return this;
    }
}