package com.esiii.backendjogodaonca.entities.enumerator;

public enum TipoJogadorEnum {
    ONCA(3),
    CACHORRO(4);

    private Integer tipo;

    TipoJogadorEnum(Integer tipo) {
        this.tipo = tipo;
    }

    public Integer getTipo() {
        return tipo;
    }
}
