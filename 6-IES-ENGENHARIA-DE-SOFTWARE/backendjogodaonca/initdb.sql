CREATE TABLE IF NOT EXISTS `jogador` (
  `idjogador` INT NOT NULL auto_increment,
  `nome` VARCHAR(300) NOT NULL,
  `username` VARCHAR(45) NOT NULL,
  `email` VARCHAR(300) NOT NULL,
  `senha` VARCHAR(100) NOT NULL,
  `qntmoedanormal` INT NOT NULL,
  `qntmoedaespecial` INT NOT NULL,
  `nivelatual` INT NOT NULL,
  `qntvitorias` INT NOT NULL,
  qntvitoriascachorro INT NOT NULL,
  qntvitoriasonca INT NOT NULL,
  `qntpartidasjogadas` INT NOT NULL,
  experiencia INT NOT NULL,
  PRIMARY KEY (`idjogador`),
  UNIQUE INDEX `idjogador_UNIQUE` (`idjogador` ASC),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC)
);
 
CREATE TABLE IF NOT EXISTS `item` (
  `iditem` INT NOT NULL auto_increment,
  `tipo` INT NOT NULL,
  `nome` VARCHAR(100) NOT NULL,
  `temporada` INT NULL,
  `ativopcompra` VARCHAR(6) NOT NULL DEFAULT 'True',
  `imagem` VARCHAR(1000) NOT NULL,
  valorrara int,
  valornormal int,
  PRIMARY KEY (`iditem`),
  UNIQUE INDEX `iditem_UNIQUE` (`iditem` ASC)
);


CREATE TABLE IF NOT EXISTS `emblema` (
  `idemblema` INT NOT NULL auto_increment,
  `imagem` VARCHAR(1000) NOT NULL,
  `descricao` VARCHAR(200) NULL,
  `nome` VARCHAR(50) NOT NULL,
  `importancia` INT NOT NULL,
  PRIMARY KEY (`idemblema`),
  UNIQUE INDEX `idemblema_UNIQUE` (`idemblema` ASC) 
);

CREATE TABLE IF NOT EXISTS `itemporjogador` (
  `idjogador` INT NOT NULL,
  `iditem` INT NOT NULL,
  `qntitem` INT NOT NULL,
  itemfavorito VARCHAR(6) NOT NULL default 'false',
  PRIMARY KEY (`idjogador`, `iditem`),
  INDEX `fk_jogador_has_item_item1_idx` (`iditem` ASC) ,
  INDEX `fk_jogador_has_item_jogador1_idx` (`idjogador` ASC) ,
  CONSTRAINT `fk_jogador_has_item_jogador1`
    FOREIGN KEY (`idjogador`)
    REFERENCES `jogador` (`idjogador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_jogador_has_item_item1`
    FOREIGN KEY (`iditem`)
    REFERENCES `item` (`iditem`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS `emblemaporjogador` (
  `idjogador` INT NOT NULL,
  `idemblema` INT NOT NULL,
  PRIMARY KEY (`idjogador`, `idemblema`),
  INDEX `fk_jogador_has_emblema_emblema1_idx` (`idemblema` ASC) ,
  INDEX `fk_jogador_has_emblema_jogador_idx` (`idjogador` ASC) ,
  CONSTRAINT `fk_jogador_has_emblema_jogador`
    FOREIGN KEY (`idjogador`)
    REFERENCES `jogador` (`idjogador`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_jogador_has_emblema_emblema1`
    FOREIGN KEY (`idemblema`)
    REFERENCES `emblema` (`idemblema`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

-- Valores de exemplo pra testar partidas
insert into jogador(idjogador, nome, username, email, senha, qntmoedanormal, qntmoedaespecial, nivelatual, qntvitorias, qntvitoriascachorro, qntvitoriasonca, qntpartidasjogadas, experiencia)
values (1, 'Julia', 'juju', 'julia@emailgenerico.com', 'julinha123', 1000, 3000, 1, 1, 1, 1, 1, 0),
       (2, 'Julia', 'jujuzinha', 'juliateste@emailgenerico.com', 'julinha123', 2, 2, 1, 1, 1, 1, 1, 0),
       (3, 'Lucas', 'lucaslima', 'lima1301lucas@gmail.com', '#Lucas1301', 1000, 3000, 3, 1, 10, 5, 5, 10, 99);


select * from jogador;

-- Inserir dados na tabela 'item'
insert into item (tipo, nome, temporada, ativopcompra, imagem, valorRara, valorNormal)
values
    (1, 'Moeda', 1, 'True', 'moeda.jpg', 0, 0),
    (2, 'Moeda Rara', 1, 'True', 'moedarara.jpg', 0, 0),
    (3, 'SKIN AMAZÔNIA', 1, 'False', 'onca_amazonia.png', 0, 0),
    (4, 'SKIN AMAZÔNIA', 1, 'False', 'cachorro_amazonia.png', 0, 0),
    (3, 'Skin onca Halloween', 1, 'True', 'skinoncaHalloween.jpg', 0, 900),
    (4, 'Skin cachorro Halloween', 1, 'True', 'skincachorroHalloween.jpg', 0, 900),
    (3, 'Skin onca Natal', 1, 'True', 'skinoncaNatal.jpg', 0, 900),
    (4, 'Skin cachorro Natal', 1, 'True', 'skincachorroNatal.jpg', 0, 900),
    (3, 'Skin onca Caatinga', 2, 'True', 'skinoncaCaatinga.jpg', 105, 250),
    (4, 'Skin cachorro Caatinga', 2, 'True', 'skincachorroCaatinga.jpg', 105, 250),
    (3, 'Skin onca Mata Atlantica', 3, 'True', 'skinoncaMataAtlantica.jpg', 155, 300),
    (4, 'Skin cachorro Mata Atlantica', 3, 'True', 'skincachorroMataAtlantica.jpg', 155, 300),
    (3, 'Skin onca Caatinga', 2, 'True', 'skinoncaCaatinga.jpg', 205, 350),
    (4, 'Skin cachorro Caatinga', 2, 'True', 'skincachorroCaatinga.jpg', 205, 350);


-- Inserir dados na tabela 'itemporjogador'
insert into itemporjogador (idjogador, iditem, qntitem, itemfavorito)
values
    (1, 3, 1, 'true'),
    (1, 4, 1, 'true'),
    (2, 3, 1, 'true'),
    (2, 4, 1, 'true');

-- Inserir dados na tabela 'emblema'
insert into emblema (imagem, descricao, nome, importancia)
values
    ('emblema1.jpg', 'Execute uma captura dupla', 'Astúcia Felina', 1),
    ('emblema2.jpg', 'Vença sua primeira partida como cachorro', 'Bem-vindo a matilha', 2), --foi 2
    ('emblema3.jpg', 'Vença sua primeira partida como onça', 'Realeza da Floresta', 2), --foi 3
    ('emblema1.jpg', 'Ganhe 3 partidas', 'Dominando a Selva', 3), -- foi 4
    ('emblema2.jpg', 'Ganhe 3 partidas como onça', 'Onça Invicta', 4), -- 5
    ('emblema3.jpg', 'Ganhe 3 partidas como cachorro', 'Latido Imbatível', 4), --6
    ('emblema2.jpg', 'Sobreviva a 30 movimentos', 'Sobrevivente', 5), --7
    ('emblema1.jpg', 'Jogue sua primeira partida', 'Bem-vindo a Floresta', 6), --8
    ('emblema2.jpg', 'Ganhe 5 partidas', 'Estrategista Habilidoso', 6), --9
    ('emblema3.jpg', 'Capture a onça sem perder nenhum cachorro', 'Matilha Unida', 7), --10
    ('emblema1.jpg', 'Vença 10 partidas', 'Topo da cadeia', 8), --11
    ('emblema3.jpg', 'Vença 50 partidas', 'Rei da selva', 9); --12

-- Inserir dados na tabela 'emblemaporjogador'
insert into emblemaporjogador (idjogador, idemblema)
values
    (1, 1),
    (1, 2),
    (2, 3);

-- Verificar os dados inseridos
select * from item;
select * from itemporjogador;
select * from emblema;
select * from emblemaporjogador;
