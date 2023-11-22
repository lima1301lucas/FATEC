package com.esiii.backendjogodaonca.usecase;

import com.esiii.backendjogodaonca.entities.database.Item;
import com.esiii.backendjogodaonca.entities.database.Itemporjogador;
import com.esiii.backendjogodaonca.entities.database.ItemporjogadorId;
import com.esiii.backendjogodaonca.entities.database.Jogador;
import com.esiii.backendjogodaonca.entities.request.CompraRequest;
import com.esiii.backendjogodaonca.entities.request.ItemRequest;
import com.esiii.backendjogodaonca.exceptions.ItemNotFoundException;
import com.esiii.backendjogodaonca.exceptions.PlayerNotFoundException;
import com.esiii.backendjogodaonca.repository.database.ItemRepository;
import com.esiii.backendjogodaonca.repository.database.ItemporjogadorRepository;
import com.esiii.backendjogodaonca.repository.database.JogadorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

import static org.apache.commons.lang3.ObjectUtils.isEmpty;

@Service
public class LojaUseCase {

    private final JogadorRepository jogadorRepository;
    private final ItemRepository itemRepository;
    private final ItemporjogadorRepository itemporjogadorRepository;

    public LojaUseCase(JogadorRepository jogadorRepository, ItemRepository itemRepository,
                       ItemporjogadorRepository itemporjogadorRepository) {
        this.jogadorRepository = jogadorRepository;
        this.itemRepository = itemRepository;
        this.itemporjogadorRepository = itemporjogadorRepository;
    }

    public void efetuaCompra(CompraRequest request){
        Optional<Jogador> jogador = jogadorRepository.findById(request.getIdJogador());

        if(jogador.isEmpty()){
            throw new PlayerNotFoundException("Jogador não encontrado");
        }
        Integer valorTotal = isEmpty(request.getValorTotal()) ? 0 : request.getValorTotal();
        ArrayList<Itemporjogador> itensParaCadastrar = new ArrayList<>();
        ArrayList<Integer> valores = new ArrayList<>();
        ArrayList<ItemRequest> itensRequest = request.getIdItens();

        itensRequest.forEach(itemRequest -> {
            Optional<Item> item = itemRepository.findById(itemRequest.getIdItem());
            if (item.isEmpty()) throw new ItemNotFoundException("Item não encontrado");
            if (item.get().getId().equals(1) || item.get().getId().equals(2)) {
                adicionaMoeda(jogador.get(), item.get(), itemRequest.getQntItem());
                return;
            }

            if (isEmpty(request.getValorTotal())){ //Caso não seja um pacote, o Valortotal da request não precisa estar preenchido, e é puxado o valor de registro dos itens do banco de dados
                valores.add(request.getPagamentoMoedaRara() ? item.get().getValorrara()*itemRequest.getQntItem() : item.get().getValornormal()*itemRequest.getQntItem());
            }

            Optional<Itemporjogador> itemExistente = itemporjogadorRepository.findById_IdjogadorAndId_Iditem(jogador.get().getId(), item.get().getId());
            Itemporjogador itemporjogador = new Itemporjogador();

            if(itemExistente.isEmpty()){
                itemporjogador.setQntitem(itemRequest.getQntItem());
            }else {
                itemporjogador.setQntitem(itemRequest.getQntItem()+itemExistente.get().getQntitem());
            }
            ItemporjogadorId itemporjogadorId = new ItemporjogadorId();
            itemporjogador.setId(itemporjogadorId);
            itemporjogadorId.setIditem(item.get().getId());
            itemporjogadorId.setIdjogador(jogador.get().getId());
            itemporjogador.setIditem(item.get());
            itemporjogador.setIdjogador(jogador.get());
            itemporjogador.setItemfavorito(itemRequest.getItemFavorito().toString());

            itensParaCadastrar.add(itemporjogador);
        });

        for (Integer valor : valores) valorTotal += valor;

        if(request.getPagamentoMoedaRara()){
            if(valorTotal > jogador.get().getQntmoedaespecial())throw new IllegalArgumentException(); //Caso o valor da compra for maior que o saldo, devolve erro
            jogador.get().setQntmoedaespecial(jogador.get().getQntmoedaespecial() - valorTotal);
        }else {
            if(valorTotal > jogador.get().getQntmoedanormal())throw new IllegalArgumentException(); //Caso o valor da compra for maior que o saldo, devolve erro
            jogador.get().setQntmoedanormal(jogador.get().getQntmoedanormal() - valorTotal);
        }

        itemporjogadorRepository.saveAllAndFlush(itensParaCadastrar);
        jogadorRepository.saveAndFlush(jogador.get());
    }

    public ArrayList<Item> getItensDisponiveis(Integer idJogador){
        ArrayList<Itemporjogador> itensAtuais = itemporjogadorRepository.findById_Idjogador(idJogador);
        ArrayList<Item> itensPossiveis = itemRepository.findAll();

        ArrayList<Item> itensDisponiveis = new ArrayList<>();
        itensPossiveis.removeIf(itemPossivel ->
                itensAtuais.stream().anyMatch(itemAtual ->
                        (itemPossivel.getId().equals(itemAtual.getId().getIditem())) ||
                                (itemPossivel.getTemporada() > itensAtuais.get(0).getIdjogador().getNivelatual())));

        return itensPossiveis;
    }

    private void adicionaMoeda(Jogador jogador, Item idMoeda, Integer qntMoeda){
        if(idMoeda.getTipo().equals(1)){
            jogador.setQntmoedanormal(jogador.getQntmoedanormal() + qntMoeda);
        }else{
            jogador.setQntmoedaespecial(jogador.getQntmoedaespecial() + qntMoeda);
        }
        jogadorRepository.save(jogador);
    }
}
