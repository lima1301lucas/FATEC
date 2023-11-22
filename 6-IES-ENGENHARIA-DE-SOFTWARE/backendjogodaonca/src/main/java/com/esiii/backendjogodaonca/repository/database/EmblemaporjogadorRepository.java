package com.esiii.backendjogodaonca.repository.database;

import com.esiii.backendjogodaonca.entities.database.Emblemaporjogador;
import com.esiii.backendjogodaonca.entities.database.EmblemaporjogadorId;
import com.esiii.backendjogodaonca.entities.database.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface EmblemaporjogadorRepository extends JpaRepository<Emblemaporjogador, EmblemaporjogadorId> {

    ArrayList<Emblemaporjogador> findAllByIdjogadorEquals(Jogador Idjogador);
}