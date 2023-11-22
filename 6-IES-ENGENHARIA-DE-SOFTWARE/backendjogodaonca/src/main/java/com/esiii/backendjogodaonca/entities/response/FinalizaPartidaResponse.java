package com.esiii.backendjogodaonca.entities.response;

import com.esiii.backendjogodaonca.entities.database.Emblemaporjogador;

import java.util.ArrayList;

public class FinalizaPartidaResponse {
    private ArrayList<Emblemaporjogador> emblemasJogador1;
    private ArrayList<Emblemaporjogador> emblemasJogador2;
    private Integer novoNivelJogador1;
    private Integer novoNivelJogador2;

    public ArrayList<Emblemaporjogador> getEmblemasJogador1() {
        return emblemasJogador1;
    }

    public void setEmblemasJogador1(ArrayList<Emblemaporjogador> emblemasJogador1) {
        this.emblemasJogador1 = emblemasJogador1;
    }

    public ArrayList<Emblemaporjogador> getEmblemasJogador2() {
        return emblemasJogador2;
    }

    public void setEmblemasJogador2(ArrayList<Emblemaporjogador> emblemasJogador2) {
        this.emblemasJogador2 = emblemasJogador2;
    }

    public Integer getNovoNivelJogador1() {
        return novoNivelJogador1;
    }

    public void setNovoNivelJogador1(Integer novoNivelJogador1) {
        this.novoNivelJogador1 = novoNivelJogador1;
    }

    public Integer getNovoNivelJogador2() {
        return novoNivelJogador2;
    }

    public void setNovoNivelJogador2(Integer novoNivelJogador2) {
        this.novoNivelJogador2 = novoNivelJogador2;
    }
}
