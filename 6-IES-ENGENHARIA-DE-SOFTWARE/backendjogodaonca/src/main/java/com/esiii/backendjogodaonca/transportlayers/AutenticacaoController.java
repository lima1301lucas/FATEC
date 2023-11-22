package com.esiii.backendjogodaonca.transportlayers;

import com.esiii.backendjogodaonca.entities.database.Jogador;
import com.esiii.backendjogodaonca.entities.request.JogadorLoginRequest;
import com.esiii.backendjogodaonca.entities.request.JogadorRequest;
import com.esiii.backendjogodaonca.usecase.AutenticacaoUseCase;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLIntegrityConstraintViolationException;

@RestController
@RequestMapping("/autenticacao")
@ExternalDocumentation
public class AutenticacaoController {

    private final AutenticacaoUseCase useCase;

    public AutenticacaoController(AutenticacaoUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/cadastra")
    @Operation(description = "Cadastra o jogador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "400", description = "Senha não preenche os requisitos minimos"),
            @ApiResponse(responseCode = "500", description = "Username ou email ja existentes no banco")
    })
    public ResponseEntity<Jogador> cadastraJogador(@RequestBody JogadorRequest request){
        try{
            return ResponseEntity.ok(useCase.cadastraJogador(request));
        }catch (IllegalAccessException e){
            return ResponseEntity.badRequest().build();
        }catch (SQLIntegrityConstraintViolationException ex){
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/verifica")
    @Operation(description = "Valida o login")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "404", description = "Email não cadastrado"),
            @ApiResponse(responseCode = "400", description = "Senha incorreta")
    })
    public ResponseEntity<Jogador> verificaJogador(@RequestBody JogadorLoginRequest request){
        System.out.println(request.toString());
        try {
            return ResponseEntity.ok(useCase.getAutenticacaoLogin(request));
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }catch (IllegalAccessException e){
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/altera")
    @Operation(description = "Altera dados do jogador")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Sucesso"),
            @ApiResponse(responseCode = "404", description = "Email não cadastrado"),
            @ApiResponse(responseCode = "400", description = "Senha não preenche os requisitos minimos"),
            @ApiResponse(responseCode = "500", description = "Username ou email ja existentes no banco")
    })
    public ResponseEntity<HttpStatus> alteraJogador(@RequestBody JogadorRequest request){
        try {
            useCase.alteraJogador(request);
            return ResponseEntity.ok().build();
        }catch (IllegalArgumentException e){
            return ResponseEntity.notFound().build();
        }catch (IllegalAccessException e){
            return ResponseEntity.badRequest().build();
        }catch (SQLIntegrityConstraintViolationException ex){
            return ResponseEntity.internalServerError().build();
        }
    }
}
