package com.esiii.backendjogodaonca.entities.redis;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Partida")
public class Partida implements Serializable {
    @Id
    private Integer idpartida;
    private JogadorPartida primeirojogador;
    private JogadorPartida segundojogador;

    public Partida() {
    }

    public Partida(Integer idpartida, JogadorPartida primeirojogador, JogadorPartida segundojogador) {
        this.idpartida = idpartida;
        this.primeirojogador = primeirojogador;
        this.segundojogador = segundojogador;
    }

    public Integer getIdpartida() {
        return idpartida;
    }

    public Partida setIdpartida(Integer idpartida) {
        this.idpartida = idpartida;
        return this;
    }

    public JogadorPartida getPrimeirojogador() {
        return primeirojogador;
    }

    public Partida setPrimeirojogador(JogadorPartida primeirojogador) {
        this.primeirojogador = primeirojogador;
        return this;
    }

    public JogadorPartida getSegundojogador() {
        return segundojogador;
    }

    public Partida setSegundojogador(JogadorPartida segundojogador) {
        this.segundojogador = segundojogador;
        return this;
    }
}
