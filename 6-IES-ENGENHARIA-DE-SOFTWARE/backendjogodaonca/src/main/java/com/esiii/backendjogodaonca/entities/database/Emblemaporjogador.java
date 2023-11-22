package com.esiii.backendjogodaonca.entities.database;

import javax.persistence.*;

@Entity
@Table(name = "emblemaporjogador")
public class Emblemaporjogador {
    @EmbeddedId
    private EmblemaporjogadorId id;

    @MapsId("idjogador")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idjogador", nullable = false)
    private Jogador idjogador;

    @MapsId("idemblema")
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idemblema", nullable = false)
    private Emblema idemblema;

    public Emblemaporjogador() {
    }

    public Emblemaporjogador(Integer idJogador, Integer idEmblema) {
        EmblemaporjogadorId id = new EmblemaporjogadorId();
        id.setIdemblema(idEmblema);
        id.setIdjogador(idJogador);
        this.id = id;
    }

    public EmblemaporjogadorId getId() {
        return id;
    }

    public void setId(EmblemaporjogadorId id) {
        this.id = id;
    }

    public Jogador getIdjogador() {
        return idjogador;
    }

    public void setIdjogador(Jogador idjogador) {
        this.idjogador = idjogador;
    }

    public Emblema getIdemblema() {
        return idemblema;
    }

    public void setIdemblema(Emblema idemblema) {
        this.idemblema = idemblema;
    }

}