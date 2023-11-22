package com.esiii.backendjogodaonca.transportlayers;

import com.esiii.backendjogodaonca.entities.database.Item;
import com.esiii.backendjogodaonca.entities.request.CompraRequest;
import com.esiii.backendjogodaonca.exceptions.ItemNotFoundException;
import com.esiii.backendjogodaonca.exceptions.PlayerNotFoundException;
import com.esiii.backendjogodaonca.usecase.LojaUseCase;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/loja")
@ExternalDocumentation
public class LojaController {

    private final LojaUseCase useCase;

    public LojaController(LojaUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/compra")
    @Operation(description = "Efetua a compra")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "Jogador não tinha a quantidade de moedas para compra"),
            @ApiResponse(responseCode = "404", description = "Jogador ou Item não encontrado")
    })
    public ResponseEntity<HttpStatus> efetuaCompra(@RequestBody CompraRequest request){
        try{
            useCase.efetuaCompra(request);
            return ResponseEntity.ok().build();
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().build();
        }catch (PlayerNotFoundException | ItemNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/consulta/{idJogador}")
    @Operation(description = "Consulta os itens disponiveis para compra da loja")
    public ResponseEntity<ArrayList<Item>> getItensDisponiveis(@PathVariable("idJogador") Integer idJogador){
        return ResponseEntity.ok(useCase.getItensDisponiveis(idJogador));
    }
}
