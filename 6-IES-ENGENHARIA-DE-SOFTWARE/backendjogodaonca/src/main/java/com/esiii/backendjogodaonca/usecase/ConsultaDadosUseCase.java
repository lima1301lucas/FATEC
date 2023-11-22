package com.esiii.backendjogodaonca.usecase;

import com.esiii.backendjogodaonca.entities.database.Emblema;
import com.esiii.backendjogodaonca.entities.database.Emblemaporjogador;
import com.esiii.backendjogodaonca.entities.database.Jogador;
import com.esiii.backendjogodaonca.entities.response.DadosJogadorResponse;
import com.esiii.backendjogodaonca.repository.database.EmblemaporjogadorRepository;
import com.esiii.backendjogodaonca.repository.database.JogadorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ConsultaDadosUseCase {

    private final EmblemaporjogadorRepository emblemaporjogadorRepository;
    private final JogadorRepository jogadorRepository;

    public ConsultaDadosUseCase(EmblemaporjogadorRepository emblemaporjogadorRepository, JogadorRepository jogadorRepository) {
        this.emblemaporjogadorRepository = emblemaporjogadorRepository;
        this.jogadorRepository = jogadorRepository;
    }

    public DadosJogadorResponse consultaDadosJogador(Integer idJogador){
        Optional<Jogador> jogador = jogadorRepository.findById(idJogador);

        if(jogador.isEmpty()){
            throw new IllegalArgumentException();
        }else{
            DadosJogadorResponse dadosJogadorResponse = new DadosJogadorResponse();
            dadosJogadorResponse.setJogador(jogador.get());
            ArrayList<Emblemaporjogador> emblemaporjogadores = emblemaporjogadorRepository.findAllByIdjogadorEquals(jogador.get());
            ArrayList<Emblema> emblemasDadosResponse = new ArrayList<>();

            emblemaporjogadores.forEach(emblemaporjogador -> {
                Emblema emblema = new Emblema();
                emblema.setId(emblemaporjogador.getId().getIdemblema());
                emblema.setDescricao(emblemaporjogador.getIdemblema().getDescricao());
                emblema.setImagem(emblemaporjogador.getIdemblema().getImagem());
                emblema.setNome(emblemaporjogador.getIdemblema().getNome());
                emblema.setImportancia(emblemaporjogador.getIdemblema().getImportancia());
                emblemasDadosResponse.add(emblema);
            });
            dadosJogadorResponse.setEmblemas(emblemasDadosResponse);
            return dadosJogadorResponse;
        }
    }
}
