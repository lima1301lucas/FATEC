package com.esiii.backendjogodaonca.transportlayers;

import com.esiii.backendjogodaonca.entities.response.DadosJogadorResponse;
import com.esiii.backendjogodaonca.usecase.ConsultaDadosUseCase;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consulta")
@ExternalDocumentation
public class ConsultaDadosController {

    private final ConsultaDadosUseCase useCase;

    public ConsultaDadosController(ConsultaDadosUseCase useCase) {
        this.useCase = useCase;
    }

    @GetMapping("/jogador/{idJogador}")
    @Operation(description = "Busca as informações do jogador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "404", description = "Jogador não encontrado")
    })
    public ResponseEntity<DadosJogadorResponse> consultadadosJogador(@PathVariable("idJogador") Integer idJogador){
        try{
            DadosJogadorResponse dadosJogadorResponse = useCase.consultaDadosJogador(idJogador);
            return ResponseEntity.ok().body(dadosJogadorResponse);
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }

    }
}
