package com.esiii.backendjogodaonca.repository.redis;

import com.esiii.backendjogodaonca.entities.redis.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Integer> {

}
