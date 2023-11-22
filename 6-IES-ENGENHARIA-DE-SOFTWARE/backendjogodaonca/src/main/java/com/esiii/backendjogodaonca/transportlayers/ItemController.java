package com.esiii.backendjogodaonca.transportlayers;

import com.esiii.backendjogodaonca.entities.database.ItemporjogadorId;
import com.esiii.backendjogodaonca.entities.response.ItemJogadorResponse;
import com.esiii.backendjogodaonca.exceptions.ItemNotFoundException;
import com.esiii.backendjogodaonca.usecase.ItemUseCase;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
@ExternalDocumentation
public class ItemController {

    @Autowired
    private ItemUseCase itemUseCase;

    @GetMapping("/{idUsuario}/all")
    @Operation(description = "Busca os itens do jogador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "404", description = "Jogador não tem itens")
    })
    public ResponseEntity<ItemJogadorResponse> getAll(@PathVariable Integer idUsuario) {
        try{
            ItemJogadorResponse response = itemUseCase.getAll(idUsuario);
            return ResponseEntity.ok(response);
        }catch (ItemNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{idUsuario}/favorito/{idItem}")
    public ResponseEntity<ItemporjogadorId> updateItemFavorito(@PathVariable Integer idUsuario, @PathVariable Integer idItem) {
        return ResponseEntity.ok().body(itemUseCase.updateItemFavorito(idUsuario, idItem));
    }
}
