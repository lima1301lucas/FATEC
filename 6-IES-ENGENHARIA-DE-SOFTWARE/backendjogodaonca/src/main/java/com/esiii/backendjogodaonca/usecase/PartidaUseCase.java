package com.esiii.backendjogodaonca.usecase;

import com.esiii.backendjogodaonca.entities.database.Emblemaporjogador;
import com.esiii.backendjogodaonca.entities.database.Itemporjogador;
import com.esiii.backendjogodaonca.entities.database.Jogador;
import com.esiii.backendjogodaonca.entities.enumerator.TipoJogadorEnum;
import com.esiii.backendjogodaonca.entities.redis.JogadorPartida;
import com.esiii.backendjogodaonca.entities.redis.Partida;
import com.esiii.backendjogodaonca.entities.request.FinalizaPartidaRequest;
import com.esiii.backendjogodaonca.entities.response.FinalizaPartidaResponse;
import com.esiii.backendjogodaonca.entities.response.IniciaPartidaResponse;
import com.esiii.backendjogodaonca.repository.database.EmblemaporjogadorRepository;
import com.esiii.backendjogodaonca.repository.database.ItemporjogadorRepository;
import com.esiii.backendjogodaonca.repository.database.JogadorRepository;
import com.esiii.backendjogodaonca.repository.redis.PartidaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.esiii.backendjogodaonca.exceptions.PlayerNotFoundException;
import com.esiii.backendjogodaonca.exceptions.GameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.*;

import static com.esiii.backendjogodaonca.util.MovimentacoesUtils.*;
import static org.apache.commons.lang3.ObjectUtils.isEmpty;

@Service
public class PartidaUseCase {

    @Autowired
    private JogadorRepository jogadorRepository;

    @Autowired
    private RedisTemplate<String, Partida> redisTemplate;

    @Autowired
    private PartidaRepository partidaRepository;

    @Autowired
    private EmblemaporjogadorRepository emblemaporjogadorRepository;

    @Autowired
    private ItemporjogadorRepository itemporjogadorRepository;

    @Autowired
    private MovimentacoesUseCase movimentacoesUseCase;

    public void excluiSolicitacaoPartida(Integer id){
        partidaRepository.deleteById(id);
    }
    public IniciaPartidaResponse iniciarJogo(Integer idJogador, TipoJogadorEnum tipo) throws JsonProcessingException {
        List<Partida> partidasNovas = partidaRepository.findAll();
        List<Partida> partidasLivres = partidasNovas.stream()
                .filter(partida ->
                {
                    return TipoJogadorEnum.ONCA.equals(tipo) ? isEmpty(partida.getPrimeirojogador()) : isEmpty(partida.getSegundojogador());
                }).toList();
        IniciaPartidaResponse iniciaPartidaResponse = new IniciaPartidaResponse();

        if (partidasLivres.isEmpty()){
            Partida partida = iniciarPartida(idJogador, tipo);
            iniciaPartidaResponse.setPartida(partida);
            iniciaPartidaResponse.setQntIguaisEsperando(partidasNovas.size());
            iniciaPartidaResponse.setPartidaOcupada(Boolean.FALSE);
            return iniciaPartidaResponse;
        } else {
            Partida partida = participar(idJogador, tipo, partidasLivres.get(0));
            iniciaPartidaResponse.setPartida(partida);
            iniciaPartidaResponse.setPartidaOcupada(Boolean.TRUE);

            return iniciaPartidaResponse;
        }
    }

    private Partida iniciarPartida(Integer idJogador, TipoJogadorEnum tipoJogador){
        Partida partida = new Partida().setIdpartida(geraIdPartida());

        if (TipoJogadorEnum.ONCA.equals(tipoJogador)){
            partida.setPrimeirojogador(new JogadorPartida(idJogador));
        }else{
            partida.setSegundojogador(new JogadorPartida(idJogador));
        }

        partidaRepository.save(partida);

        return partida;
    }

    private Partida participar(Integer idJogador, TipoJogadorEnum tipoJogadorEnum, Partida partida) throws JsonProcessingException {

        if(TipoJogadorEnum.ONCA.equals(tipoJogadorEnum)){
            JogadorPartida primeiro = getJogadorPartida(idJogador, TipoJogadorEnum.ONCA.getTipo());
            JogadorPartida segundo = getJogadorPartida(partida.getSegundojogador().getIdJogador(), TipoJogadorEnum.CACHORRO.getTipo());

            partida.setPrimeirojogador(primeiro);
            partida.setSegundojogador(segundo);
        }else{
            JogadorPartida primeiro = getJogadorPartida(partida.getPrimeirojogador().getIdJogador(), TipoJogadorEnum.ONCA.getTipo());
            JogadorPartida segundo = getJogadorPartida(idJogador, TipoJogadorEnum.CACHORRO.getTipo());

            partida.setPrimeirojogador(primeiro);
            partida.setSegundojogador(segundo);
        }

        partidaRepository.deleteById(partida.getIdpartida());
        redisTemplate.opsForValue().set(partida.getIdpartida().toString(), partida, Duration.ofHours(1));
        return partida;
    }

    private JogadorPartida getJogadorPartida(Integer idJogador, Integer tipo) {
        Itemporjogador itemporjogador =
                itemporjogadorRepository.findById_IdjogadorAndIditem_TipoAndItemfavorito(idJogador, tipo, "true");
        JogadorPartida jogador = new JogadorPartida()
                .setIdJogador(idJogador)
                .setPosicoes(tipo.equals(3) ? getPosicoesOnca() : getPosicoesCachorro())
                .setIdSkinFavorita(itemporjogador.getIditem().getId())
                .setNomeSkinFavorita(itemporjogador.getIditem().getNome());
        return jogador;
    }

    private Integer geraIdPartida(){
        String idPartida = new String();
        Random gerador = new Random();
        for (int i = 0; i < 10; i++) {
            idPartida = idPartida + gerador.nextInt(9);
        }
        return Integer.getInteger(idPartida);
    }

    public Partida movimentar(Partida partida) throws JsonProcessingException {
        HashMap<String, String> posicoesNovasJogadorUm = new HashMap<>();
        HashMap<String, String> posicoesNovasJogadorDois = new HashMap<>();
        ArrayList<String> posicoesInvalidas = getPosicoesInvalidas();
        partida.getPrimeirojogador()
                .getPosicoes().forEach((key, value) -> {
                    posicoesInvalidas.add(key);
                });

        partida.getSegundojogador()
                .getPosicoes().forEach((key, value) -> {
                    posicoesInvalidas.add(key);
                });

        partida.getPrimeirojogador()
                .getPosicoes().forEach((key, value) -> {
                    posicoesNovasJogadorUm.put(key, movimentacoesUseCase.getPossiveisPosicoes(key, posicoesInvalidas, TipoJogadorEnum.ONCA));
                });
        partida.getPrimeirojogador().setPosicoes(posicoesNovasJogadorUm);

        partida.getSegundojogador()
                .getPosicoes().forEach((key, value) -> {
                    posicoesNovasJogadorDois.put(key, movimentacoesUseCase.getPossiveisPosicoes(key, posicoesInvalidas, TipoJogadorEnum.CACHORRO));
                });
        partida.getSegundojogador().setPosicoes(posicoesNovasJogadorDois);
        redisTemplate.opsForValue().set(partida.getIdpartida().toString(), partida, Duration.ofHours(1));
        return partida;
    }

    public FinalizaPartidaResponse finalizar(FinalizaPartidaRequest finalizaPartida) throws JsonProcessingException {
        Partida partida = redisTemplate.opsForValue().getAndDelete(finalizaPartida.getIdPartida().toString());

        if (isEmpty(partida)) {
            throw new GameNotFoundException("Partida não existente ou já finalizada");
        }

        final Jogador jogador1 = jogadorRepository.findById(partida.getPrimeirojogador().getIdJogador()).orElse(null);
        final Jogador jogador2 = jogadorRepository.findById(partida.getSegundojogador().getIdJogador()).orElse(null);
        ArrayList<Emblemaporjogador> emblemasJogador1 = new ArrayList<>();
        ArrayList<Emblemaporjogador> emblemasJogador2 = new ArrayList<>();


        if (jogador1 == null || jogador2 == null) {
            throw new PlayerNotFoundException("Jogadores não existentes");
        }

        if(finalizaPartida.getPartidaAbandonada() && finalizaPartida.getIdVencedor().equals(jogador1.getId())){
            verificaVitorias(jogador1, jogador2, 20);
            jogador2.setQntmoedanormal(jogador2.getQntmoedanormal() - 15);
            verificaEmblemasOnca(jogador1, emblemasJogador1);
            verificaEmblemasGeral(jogador1, emblemasJogador1);
        }else if (finalizaPartida.getPartidaAbandonada() && finalizaPartida.getIdVencedor().equals(jogador2.getId())){
            verificaVitorias(jogador2, jogador1, 20);
            jogador1.setQntmoedanormal(jogador1.getQntmoedanormal() - 15);
            verificaEmblemasCachorro(partida, jogador2, emblemasJogador2);
            verificaEmblemasGeral(jogador2, emblemasJogador2);
        } else if (finalizaPartida.getIdVencedor().equals(jogador1.getId())) {
            verificaVitorias(jogador1, jogador2, 15);
            verificaEmblemasOnca(jogador1, emblemasJogador1);
            verificaEmblemasGeral(jogador1, emblemasJogador1);
        } else if (finalizaPartida.getIdVencedor().equals(jogador2.getId())){
            verificaVitorias(jogador2, jogador1, 15);
            verificaEmblemasCachorro(partida, jogador2, emblemasJogador2);
            verificaEmblemasGeral(jogador2, emblemasJogador2);
        }

        jogador1.setQntpartidasjogadas(jogador1.getQntpartidasjogadas() + 1);
        jogador2.setQntpartidasjogadas(jogador2.getQntpartidasjogadas() + 1);

        jogadorRepository.save(jogador1);
        jogadorRepository.save(jogador2);
        emblemaporjogadorRepository.saveAllAndFlush(emblemasJogador1);
        emblemaporjogadorRepository.saveAllAndFlush(emblemasJogador2);

        final FinalizaPartidaResponse response = new FinalizaPartidaResponse();
        response.setEmblemasJogador1(emblemasJogador1);
        response.setEmblemasJogador2(emblemasJogador2);
        response.setNovoNivelJogador1(verificaNivel(jogador1));
        response.setNovoNivelJogador2(verificaNivel(jogador2));

        return response;
    }

    private static void verificaVitorias(Jogador vencedor, Jogador perdedor, Integer xpAPerder) {
        vencedor.setQntvitorias(vencedor.getQntvitorias() + 1);
        vencedor.setQntvitoriasonca(vencedor.getQntvitoriasonca() + 1);
        vencedor.setQntmoedanormal(vencedor.getQntmoedanormal() + 30);
        vencedor.setExperiencia(vencedor.getExperiencia() + 25);
        perdedor.setExperiencia(perdedor.getExperiencia() - xpAPerder);
    }

    private static void verificaEmblemasCachorro(Partida partida, Jogador jogador2, ArrayList<Emblemaporjogador> emblemasJogador2) {
        if (jogador2.getQntvitoriascachorro().equals(1)){
            emblemasJogador2.add(new Emblemaporjogador(jogador2.getId(), 2));
            jogador2.setQntmoedanormal(jogador2.getQntmoedanormal() + 50);
        }else if (jogador2.getQntvitoriascachorro().equals(3)){
            emblemasJogador2.add(new Emblemaporjogador(jogador2.getId(), 6));
            jogador2.setQntmoedanormal(jogador2.getQntmoedanormal() + 75);
        }
        if(partida.getSegundojogador().getPosicoes().size() == 14){
            emblemasJogador2.add(new Emblemaporjogador(jogador2.getId(), 10));
            jogador2.setQntmoedanormal(jogador2.getQntmoedanormal() + 150);
        }
    }

    private static void verificaEmblemasOnca(Jogador jogador1, ArrayList<Emblemaporjogador> emblemasJogador1) {
        if (jogador1.getQntvitoriasonca().equals(1)){
            emblemasJogador1.add(new Emblemaporjogador(jogador1.getId(), 3));
            jogador1.setQntmoedanormal(jogador1.getQntmoedanormal() + 50);
        }else if(jogador1.getQntvitoriasonca().equals(3)) {
            emblemasJogador1.add(new Emblemaporjogador(jogador1.getId(), 5));
            jogador1.setQntmoedanormal(jogador1.getQntmoedanormal() + 75);
        }
    }

    private static void verificaEmblemasGeral(Jogador jogador, ArrayList<Emblemaporjogador> emblemasJogador) {
        if(jogador.getQntvitorias().equals(3)){
            emblemasJogador.add(new Emblemaporjogador(jogador.getId(), 4));
            jogador.setQntmoedanormal(jogador.getQntmoedanormal() + 55);
        }else if(jogador.getQntvitorias().equals(5)){
            emblemasJogador.add(new Emblemaporjogador(jogador.getId(), 9));
            jogador.setQntmoedanormal(jogador.getQntmoedanormal() + 100);
        }else if(jogador.getQntvitorias().equals(10)){
            emblemasJogador.add(new Emblemaporjogador(jogador.getId(), 11));
            jogador.setQntmoedanormal(jogador.getQntmoedanormal() + 250);
        }else if(jogador.getQntvitorias().equals(50)){
            emblemasJogador.add(new Emblemaporjogador(jogador.getId(), 12));
            jogador.setQntmoedanormal(jogador.getQntmoedanormal() + 500);
        }

        if(jogador.getQntpartidasjogadas().equals(0)){
            emblemasJogador.add(new Emblemaporjogador(jogador.getId(), 8));
            jogador.setQntmoedanormal(jogador.getQntmoedanormal() + 100);
        }
    }

    private Integer verificaNivel(Jogador jogador){
        if(jogador.getExperiencia() >= 1000 && jogador.getNivelatual() < 4){
            return 4;
        } else if(jogador.getExperiencia() >= 600 && jogador.getNivelatual() < 3){
            return 3;
        } else if(jogador.getExperiencia() >= 300 && jogador.getNivelatual() < 2){
            return 2;
        } else if(jogador.getExperiencia() >= 100 && jogador.getNivelatual() < 1){
            return 1;
        }
        return null;
    }

}
