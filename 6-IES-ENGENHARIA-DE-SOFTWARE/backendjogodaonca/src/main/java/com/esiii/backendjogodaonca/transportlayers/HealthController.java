package com.esiii.backendjogodaonca.transportlayers;


import com.esiii.backendjogodaonca.entities.redis.Partida;

import com.esiii.backendjogodaonca.repository.database.*;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/health")
@ExternalDocumentation
public class HealthController {

    private final EmblemaRepository emblemaRepository;
    private final EmblemaporjogadorRepository emblemaporjogadorRepository;
    private final ItemporjogadorRepository itemporjogadorRepository;
    private final ItemRepository itemRepository;
    private final JogadorRepository jogadorRepository;
    private final RedisTemplate<String, String> redisTemplate;

    public HealthController(EmblemaRepository emblemaRepository, EmblemaporjogadorRepository emblemaporjogadorRepository, ItemporjogadorRepository itemporjogadorRepository, ItemRepository itemRepository, JogadorRepository jogadorRepository, RedisTemplate<String, String> redisTemplate) {
        this.emblemaRepository = emblemaRepository;
        this.emblemaporjogadorRepository = emblemaporjogadorRepository;
        this.itemporjogadorRepository = itemporjogadorRepository;
        this.itemRepository = itemRepository;
        this.jogadorRepository = jogadorRepository;
        this.redisTemplate = redisTemplate;
    }

    @GetMapping("/get")
    @Operation(description = "Verifica funcionamento do swagger")
    public ResponseEntity getHealth(){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/getdb")
    @Operation(description = "Verifica se repository foi iniciado corretamente")
    public Object getEstruturaDb(){
        List<Object> estruturaBd = new ArrayList<>();
        estruturaBd.add(emblemaporjogadorRepository.getClass());
        estruturaBd.add(emblemaRepository.getClass());
        estruturaBd.add(itemporjogadorRepository.getClass());
        estruturaBd.add(itemRepository.getClass());
        estruturaBd.add(jogadorRepository.getClass());
        return estruturaBd;

    }
    @GetMapping("/getredis")
    @Operation(description = "Verifica se repository foi iniciado corretamente")
    public Object getRedis(){
        Partida partida = new Partida();
        partida.setIdpartida(1);
        redisTemplate.opsForValue().set(partida.getIdpartida().toString(), partida.toString(), Duration.ofMinutes(60));
        var resultget = redisTemplate.opsForValue().get("1");
        return resultget;
    }

}
