package com.esiii.backendjogodaonca.entities.database;

import org.hibernate.Hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ItemporjogadorId implements Serializable {
    private static final long serialVersionUID = 8143514635339192091L;
    @NotNull
    @Column(name = "idjogador", nullable = false)
    private Integer idjogador;

    @NotNull
    @Column(name = "iditem", nullable = false)
    private Integer iditem;

    public Integer getIdjogador() {
        return idjogador;
    }

    public void setIdjogador(Integer idjogador) {
        this.idjogador = idjogador;
    }

    public Integer getIditem() {
        return iditem;
    }

    public void setIditem(Integer iditem) {
        this.iditem = iditem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ItemporjogadorId entity = (ItemporjogadorId) o;
        return Objects.equals(this.iditem, entity.iditem) &&
                Objects.equals(this.idjogador, entity.idjogador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iditem, idjogador);
    }

}