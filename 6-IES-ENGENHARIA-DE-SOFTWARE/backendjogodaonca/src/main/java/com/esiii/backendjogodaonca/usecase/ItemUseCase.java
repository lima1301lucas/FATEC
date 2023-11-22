package com.esiii.backendjogodaonca.usecase;

import com.esiii.backendjogodaonca.entities.database.Item;
import com.esiii.backendjogodaonca.entities.database.Itemporjogador;
import com.esiii.backendjogodaonca.entities.database.ItemporjogadorId;
import com.esiii.backendjogodaonca.entities.database.Jogador;
import com.esiii.backendjogodaonca.entities.response.ItemJogadorResponse;
import com.esiii.backendjogodaonca.entities.response.ItemResponse;
import com.esiii.backendjogodaonca.exceptions.ItemNotFoundException;
import com.esiii.backendjogodaonca.repository.database.ItemporjogadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemUseCase {

    @Autowired
    private ItemporjogadorRepository itemporjogadorRepository;

    public ItemJogadorResponse getAll(Integer idUsuario) {
        ArrayList<Itemporjogador> itemporjogadorList = itemporjogadorRepository.findById_Idjogador(idUsuario);
        if(itemporjogadorList.isEmpty()) throw new ItemNotFoundException("Jogador não tem itens");

        ArrayList<ItemResponse> itens = new ArrayList<>();

        itemporjogadorList.forEach(itemporjogador -> {
            ItemResponse item = new ItemResponse();
            item.setAtivopcompra(itemporjogador.getIditem().getAtivopcompra());
            item.setId(itemporjogador.getIditem().getId());
            item.setImagem(itemporjogador.getIditem().getImagem());
            item.setNome(itemporjogador.getIditem().getNome());
            item.setTipo(itemporjogador.getIditem().getTipo());
            item.setTemporada(itemporjogador.getIditem().getTemporada());
            item.setValornormal(itemporjogador.getIditem().getValornormal());
            item.setValorrara(itemporjogador.getIditem().getValorrara());
            item.setQntItens(itemporjogador.getQntitem());
            itens.add(item);
        });
        ItemJogadorResponse itemJogadorResponse = new ItemJogadorResponse();
        itemJogadorResponse.setItens(itens);
        return itemJogadorResponse;
    }

    public ItemporjogadorId updateItemFavorito(Integer idUsuario, Integer idItem) {
        Optional<Itemporjogador> item = itemporjogadorRepository.findById_IdjogadorAndId_Iditem(
                idUsuario,
                idItem
        );

        if (item.isEmpty()) {
            throw new ItemNotFoundException("Item não encontrado para esse usuário");
        }

        // atualizar todos os itens do mesmo tipo que sejam favoritos para false
        List<Itemporjogador> itens = itemporjogadorRepository.findById_IdjogadorAndIditem_Tipo(
                idUsuario, item.get().getIditem().getTipo()
        );
        for (Itemporjogador itemporjogador : itens) {
            itemporjogador.setItemfavorito("false");
            itemporjogadorRepository.save(itemporjogador);
        }

        // atualizar o item encontrado 
        item.get().setItemfavorito("true");
        itemporjogadorRepository.save(item.get());

        return item.get().getId();
    }
}
