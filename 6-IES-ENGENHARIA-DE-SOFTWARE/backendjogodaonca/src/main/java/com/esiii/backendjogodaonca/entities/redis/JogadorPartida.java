package com.esiii.backendjogodaonca.entities.redis;

import java.io.Serializable;
import java.util.HashMap;

public class JogadorPartida implements Serializable {
    private Integer idJogador;
    private Integer idSkinFavorita;
    private String nomeSkinFavorita;
    private HashMap<String,String> posicoes;

    public JogadorPartida() {
    }

    public JogadorPartida(Integer idJogador, Integer idSkinFavorita, String nomeSkinFavorita, HashMap<String, String> posicoes) {
        this.idJogador = idJogador;
        this.idSkinFavorita = idSkinFavorita;
        this.nomeSkinFavorita = nomeSkinFavorita;
        this.posicoes = posicoes;
    }

    public JogadorPartida(Integer idJogador) {
        this.idJogador = idJogador;
    }

    public Integer getIdJogador() {
        return idJogador;
    }

    public JogadorPartida setIdJogador(Integer idJogador) {
        this.idJogador = idJogador;
        return this;
    }

    public HashMap<String, String> getPosicoes() {
        return posicoes;
    }

    public JogadorPartida setPosicoes(HashMap<String, String> posicoes) {
        this.posicoes = posicoes;
        return this;
    }

    public Integer getIdSkinFavorita() {
        return idSkinFavorita;
    }

    public JogadorPartida setIdSkinFavorita(Integer idSkinFavorita) {
        this.idSkinFavorita = idSkinFavorita;
        return this;
    }

    public String getNomeSkinFavorita() {
        return nomeSkinFavorita;
    }

    public JogadorPartida setNomeSkinFavorita(String nomeSkinFavorita) {
        this.nomeSkinFavorita = nomeSkinFavorita;
        return this;
    }
}
