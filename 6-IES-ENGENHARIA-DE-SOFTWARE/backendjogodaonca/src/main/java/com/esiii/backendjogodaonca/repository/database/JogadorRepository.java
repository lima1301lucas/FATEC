package com.esiii.backendjogodaonca.repository.database;

import com.esiii.backendjogodaonca.entities.database.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<Jogador, Integer> {

    Jogador findByEmailEquals(String email);
}