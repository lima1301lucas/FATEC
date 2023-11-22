package com.esiii.backendjogodaonca.repository.database;

import com.esiii.backendjogodaonca.entities.database.Itemporjogador;
import com.esiii.backendjogodaonca.entities.database.ItemporjogadorId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Optional;

public interface ItemporjogadorRepository extends JpaRepository<Itemporjogador, ItemporjogadorId> {
    ArrayList<Itemporjogador> findById_Idjogador(Integer idjogador);
    Optional<Itemporjogador> findById_IdjogadorAndId_Iditem(Integer idjogador, Integer iditem);

    ArrayList<Itemporjogador> findById_IdjogadorAndIditem_Tipo(Integer idjogador, Integer tipo);

    Itemporjogador findById_IdjogadorAndIditem_TipoAndItemfavorito(Integer idjogador, Integer tipo, String itemfavorito);
}