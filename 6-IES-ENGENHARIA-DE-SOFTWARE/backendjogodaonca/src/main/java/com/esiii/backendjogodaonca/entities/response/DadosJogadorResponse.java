package com.esiii.backendjogodaonca.entities.response;

import com.esiii.backendjogodaonca.entities.database.Emblema;
import com.esiii.backendjogodaonca.entities.database.Jogador;

import java.util.ArrayList;

public class DadosJogadorResponse {
    private Jogador jogador;
    private ArrayList<Emblema> emblemas;

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }

    public ArrayList<Emblema> getEmblemas() {
        return emblemas;
    }

    public void setEmblemas(ArrayList<Emblema> emblemas) {
        this.emblemas = emblemas;
    }
}
