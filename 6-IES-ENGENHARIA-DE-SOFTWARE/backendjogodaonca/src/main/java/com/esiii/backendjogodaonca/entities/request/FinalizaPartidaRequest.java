package com.esiii.backendjogodaonca.entities.request;

public class FinalizaPartidaRequest {
    private Integer idPartida;
    private Integer idVencedor;
    private Boolean partidaAbandonada;

    public Integer getIdPartida() {
        return idPartida;
    }

    public void setIdPartida(Integer idPartida) {
        this.idPartida = idPartida;
    }

    public Integer getIdVencedor() {
        return idVencedor;
    }

    public void setIdVencedor(Integer idVencedor) {
        this.idVencedor = idVencedor;
    }

    public Boolean getPartidaAbandonada() {
        return partidaAbandonada;
    }

    public FinalizaPartidaRequest setPartidaAbandonada(Boolean partidaAbandonada) {
        this.partidaAbandonada = partidaAbandonada;
        return this;
    }
}
