package com.esiii.backendjogodaonca.entities.request;

import com.esiii.backendjogodaonca.entities.enumerator.TipoJogadorEnum;

public class IniciaPartidaRequest {
    private Integer idJogador;
    private TipoJogadorEnum tipo;

    public Integer getIdJogador() {
        return idJogador;
    }

    public IniciaPartidaRequest setIdJogador(Integer idJogador) {
        this.idJogador = idJogador;
        return this;
    }

    public TipoJogadorEnum getTipo() {
        return tipo;
    }

    public IniciaPartidaRequest setTipo(TipoJogadorEnum tipo) {
        this.tipo = tipo;
        return this;
    }
}
