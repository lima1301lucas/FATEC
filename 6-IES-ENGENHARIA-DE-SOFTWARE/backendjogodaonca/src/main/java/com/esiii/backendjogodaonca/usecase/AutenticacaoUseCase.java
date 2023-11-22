package com.esiii.backendjogodaonca.usecase;

import com.esiii.backendjogodaonca.entities.database.Item;
import com.esiii.backendjogodaonca.entities.database.Itemporjogador;
import com.esiii.backendjogodaonca.entities.database.ItemporjogadorId;
import com.esiii.backendjogodaonca.entities.database.Jogador;
import com.esiii.backendjogodaonca.entities.request.JogadorLoginRequest;
import com.esiii.backendjogodaonca.entities.request.JogadorRequest;
import com.esiii.backendjogodaonca.repository.database.ItemRepository;
import com.esiii.backendjogodaonca.repository.database.ItemporjogadorRepository;
import com.esiii.backendjogodaonca.repository.database.JogadorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

import static org.apache.commons.lang3.StringUtils.isBlank;

@Service
public class AutenticacaoUseCase {

    private static Logger logger = LoggerFactory.getLogger(AutenticacaoUseCase.class);
    private final JogadorRepository jogadorRepository;
    private final ItemporjogadorRepository itemporjogadorRepository;

    private final ItemRepository itemRepository;

    public AutenticacaoUseCase(JogadorRepository jogadorRepository, ItemporjogadorRepository itemporjogadorRepository, ItemRepository itemRepository) {
        this.jogadorRepository = jogadorRepository;
        this.itemporjogadorRepository = itemporjogadorRepository;
        this.itemRepository = itemRepository;
    }

    public Jogador cadastraJogador(JogadorRequest request) throws IllegalAccessException, SQLIntegrityConstraintViolationException {
        validaSenha(request.getSenha());

        Jogador jogador = new Jogador();
        jogador.setNome(request.getNome());
        jogador.setUsername(request.getUsername());
        jogador.setEmail(request.getEmail());
        jogador.setSenha(formatSenha(request.getSenha()));
        jogador.setQntmoedanormal(120);
        jogador.setQntmoedaespecial(0);
        jogador.setNivelatual(0);
        jogador.setQntvitorias(0);
        jogador.setQntvitoriascachorro(0);
        jogador.setQntvitoriasonca(0);
        jogador.setQntpartidasjogadas(0);
        jogador.setExperiencia(0);

        Jogador jogadorCadastrado = jogadorRepository.saveAndFlush(jogador);

        Item itemOnca = itemRepository.findById(3).orElseThrow(() -> new RuntimeException("Item not found"));
        Item itemCachorro = itemRepository.findById(4).orElseThrow(() -> new RuntimeException("Item not found"));

        ArrayList<Itemporjogador> skinsPadrao = new ArrayList<>();

        ItemporjogadorId idSkinOnca = new ItemporjogadorId();
        idSkinOnca.setIdjogador(jogadorCadastrado.getId());
        idSkinOnca.setIditem(itemOnca.getId());

        Itemporjogador skinOnca = new Itemporjogador();
        skinOnca.setId(idSkinOnca);
        skinOnca.setIdjogador(jogadorCadastrado);
        skinOnca.setIditem(itemOnca);
        skinOnca.setItemfavorito("true");
        skinOnca.setQntitem(1);

        ItemporjogadorId idSkinCachorro = new ItemporjogadorId();
        idSkinCachorro.setIdjogador(jogadorCadastrado.getId());
        idSkinCachorro.setIditem(itemCachorro.getId());

        Itemporjogador skinCachorro = new Itemporjogador();
        skinCachorro.setId(idSkinCachorro);
        skinCachorro.setIdjogador(jogadorCadastrado);
        skinCachorro.setIditem(itemCachorro);
        skinCachorro.setItemfavorito("true");
        skinCachorro.setQntitem(1);

        skinsPadrao.add(skinOnca);
        skinsPadrao.add(skinCachorro);

        itemporjogadorRepository.saveAllAndFlush(skinsPadrao);

        return jogador;
    }

    public Jogador getAutenticacaoLogin(JogadorLoginRequest request) throws IllegalAccessException {
        Jogador jogador = jogadorRepository.findByEmailEquals(request.getEmail());
        if(jogador==null){
            logger.error("NÃO EXISTE EMAIL CADASTRADO");
            throw new IllegalArgumentException();
        }
        if(formatSenha(request.getSenha()).equals(jogador.getSenha())){
            logger.info("AUTENTICACAO FEITA COM SUCESSO");
            return jogador;
        }else{
            logger.error("SENHA INCORRETA");
            throw new IllegalAccessException();
        }
    }

    public void alteraJogador(JogadorRequest request) throws IllegalAccessException, SQLIntegrityConstraintViolationException {
        Jogador jogador = jogadorRepository.findByEmailEquals(request.getEmail());
        if(jogador==null){
            logger.error("NÃO EXISTE EMAIL CORRESPONDENTE");
            throw new IllegalArgumentException();
        }
        validaSenha(isBlank(request.getSenha()) ? jogador.getSenha() : request.getSenha());
        jogador.setSenha(formatSenha(isBlank(request.getSenha()) ? jogador.getSenha() : request.getSenha()));
        jogador.setNome(isBlank(request.getNome()) ? jogador.getNome() : request.getNome());
        jogador.setUsername(isBlank(request.getUsername()) ? jogador.getUsername() : request.getUsername());
        jogadorRepository.save(jogador);
        logger.info("DADOS ALTERADOS COM SUCESSO");
    }

    private void validaSenha(String senha) throws IllegalAccessException {
        if(!(senha.matches("^(?=.*[A-Z])(?=.*[0-9])(?=.*[a-z])(?=.*[!@#$%^&*_-]).{6,20}$"))){
            logger.error("SENHA NÃO SEGUE O ESTABELECIDO");
            throw new IllegalAccessException();
        }
    }

    private String formatSenha(String senha){
        try{
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte messageDigestBytes[] = messageDigest.digest(senha.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();
            for (int i = 0;i<messageDigestBytes.length;i++) {
                hexString.append(Integer.toHexString(0xFF & messageDigestBytes[i]));
            }
            return hexString.toString();
        }catch (Exception e){
            logger.error("NÃO FOI POSSIVEL CRIPTOGRAFAR A SENHA");
        }
        return senha;
    }


}
