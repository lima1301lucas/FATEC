package com.esiii.backendjogodaonca.transportlayers;

import com.esiii.backendjogodaonca.entities.redis.Partida;
import com.esiii.backendjogodaonca.usecase.PartidaUseCase;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class WsExampleController {

    @Autowired
    private PartidaUseCase partidaUseCase;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/game/move")
    @SendTo("/topic/gamestate")
    public Partida processMove(@RequestBody Partida requestBody) throws JsonProcessingException {
        Partida updatedPartida = partidaUseCase.movimentar(requestBody);

        messagingTemplate.convertAndSend("/topic/gamestate", updatedPartida);

        return updatedPartida;
    }


    @MessageMapping("/game/react")
    @SendTo("/topic/gamestate")
    public String processReact(@RequestBody String reactionSound) throws JsonProcessingException {
        messagingTemplate.convertAndSend("/topic/gamestate", reactionSound);

        return reactionSound;
    }

}