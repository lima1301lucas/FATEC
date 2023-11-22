package com.esiii.backendjogodaonca.entities.response;

import com.esiii.backendjogodaonca.entities.redis.Partida;

public class IniciaPartidaResponse {
    private Partida partida;
    private Boolean partidaOcupada;
    private Integer qntIguaisEsperando;

    public Partida getPartida() {
        return partida;
    }

    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    public Boolean getPartidaOcupada() {
        return partidaOcupada;
    }

    public void setPartidaOcupada(Boolean partidaOcupada) {
        this.partidaOcupada = partidaOcupada;
    }

    public Integer getQntIguaisEsperando() {
        return qntIguaisEsperando;
    }

    public void setQntIguaisEsperando(Integer qntIguaisEsperando) {
        this.qntIguaisEsperando = qntIguaisEsperando;
    }
}
