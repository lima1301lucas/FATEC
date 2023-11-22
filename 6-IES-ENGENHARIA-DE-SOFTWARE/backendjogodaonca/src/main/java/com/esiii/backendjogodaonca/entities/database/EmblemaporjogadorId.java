package com.esiii.backendjogodaonca.entities.database;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmblemaporjogadorId implements Serializable {
    private static final long serialVersionUID = -953550112416568335L;
    @NotNull
    @Column(name = "idjogador", nullable = false)
    private Integer idjogador;

    @NotNull
    @Column(name = "idemblema", nullable = false)
    private Integer idemblema;

    public Integer getIdjogador() {
        return idjogador;
    }

    public void setIdjogador(Integer idjogador) {
        this.idjogador = idjogador;
    }

    public Integer getIdemblema() {
        return idemblema;
    }

    public void setIdemblema(Integer idemblema) {
        this.idemblema = idemblema;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        EmblemaporjogadorId entity = (EmblemaporjogadorId) o;
        return Objects.equals(this.idjogador, entity.idjogador) &&
                Objects.equals(this.idemblema, entity.idemblema);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idjogador, idemblema);
    }

}