package com.esiii.backendjogodaonca.entities.database;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iditem", nullable = false)
    private Integer id;

    @NotNull
    @Column(name = "tipo", nullable = false)
    private Integer tipo;

    @Size(max = 100)
    @NotNull
    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "temporada")
    private Integer temporada;

    @Size(max = 6)
    @NotNull
    @Column(name = "ativopcompra", nullable = false, length = 6)
    private String ativopcompra;

    @Size(max = 1000)
    @NotNull
    @Column(name = "imagem", nullable = false, length = 1000)
    private String imagem;

    @Column(name = "valornormal", nullable = false)
    private Integer valornormal;

    @Column(name = "valorrara", nullable = false)
    private Integer valorrara;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTipo() {
        return tipo;
    }

    public void setTipo(Integer tipo) {
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getTemporada() {
        return temporada;
    }

    public void setTemporada(Integer temporada) {
        this.temporada = temporada;
    }

    public String getAtivopcompra() {
        return ativopcompra;
    }

    public void setAtivopcompra(String ativopcompra) {
        this.ativopcompra = ativopcompra;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Integer getValornormal() {
        return valornormal;
    }

    public Item setValornormal(Integer valornormal) {
        this.valornormal = valornormal;
        return this;
    }

    public Integer getValorrara() {
        return valorrara;
    }

    public Item setValorrara(Integer valorrara) {
        this.valorrara = valorrara;
        return this;
    }
}