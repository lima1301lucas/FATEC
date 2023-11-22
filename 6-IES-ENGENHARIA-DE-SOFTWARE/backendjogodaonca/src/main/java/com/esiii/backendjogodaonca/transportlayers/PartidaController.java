package com.esiii.backendjogodaonca.transportlayers;

import com.esiii.backendjogodaonca.entities.redis.Partida;
import com.esiii.backendjogodaonca.entities.request.FinalizaPartidaRequest;
import com.esiii.backendjogodaonca.entities.request.IniciaPartidaRequest;
import com.esiii.backendjogodaonca.entities.response.FinalizaPartidaResponse;
import com.esiii.backendjogodaonca.entities.response.IniciaPartidaResponse;
import com.esiii.backendjogodaonca.usecase.PartidaUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/partida")
@ExternalDocumentation
public class PartidaController {

    @Autowired
    private PartidaUseCase partidaUseCase;

    @PostMapping("/iniciar")
    public ResponseEntity<IniciaPartidaResponse> iniciaPartida (@RequestBody IniciaPartidaRequest request) throws JsonProcessingException {
        return ResponseEntity.ok().body(partidaUseCase.iniciarJogo(request.getIdJogador(), request.getTipo()));
    }

    @PostMapping("/movimentar")
    public Partida movimentar (@RequestBody Partida requestBody) throws JsonProcessingException {
        return partidaUseCase.movimentar(requestBody);
    }

    @PostMapping("/finalizar")
    public FinalizaPartidaResponse finalizar (@RequestBody FinalizaPartidaRequest requestBody) throws JsonProcessingException {
        return partidaUseCase.finalizar(requestBody);
    }

    @PostMapping("/excluir")
    public ResponseEntity<HttpStatus> excluiSolicitacaoPartida(@RequestBody Integer id){
        partidaUseCase.excluiSolicitacaoPartida(id);
        return ResponseEntity.ok().build();
    }
}
