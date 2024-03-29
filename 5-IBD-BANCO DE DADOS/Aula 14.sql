#CRIAÇÃO DO BANCO, DAS TABELAS E INSEÇÃO DE DADOS

CREATE DATABASE COMPROBEM;
USE COMPROBEM;

CREATE TABLE CENTRO_CUSTO(
	CCusto CHAR(4) NOT NULL,
	NomeCC  CHAR(10) NOT NULL,
	PRIMARY KEY (CCusto)
);

INSERT INTO CCUSTO (CCusto, NomeCC) VALUES ('10A', 'Sub-1'),
('10B', 'Mult-2'), 
('11A', 'Sub-2'),
('12A', 'Sub-3');

SELECT * FROM CENTRO_CUSTO;

CREATE TABLE SECAO (
    Secao INT(3) UNSIGNED ZEROFILL NOT NULL,
    NomeSec VARCHAR(20) NOT NULL,
    CCusto CHAR(3) NOT NULL,
    PRIMARY KEY (Secao),
    FOREIGN KEY (CCusto) REFERENCES CENTRO_CUSTO(CCusto)
);

INSERT INTO SECAO (Secao, NomeSec, CCusto) VALUES (10, 'ADM', '12A'),
(20, 'Manutenção', '10A'),
(21, 'Produção-1', '10A'),
(22, 'Reparos', '10B'),
(23, 'Produção-2', '11A'),
(24, 'Produção-3', '11A'),
(25, 'Escritório', '10B');

SELECT * FROM SECAO;

CREATE TABLE ALMOXARIFE (
    NAlmox INT(4) UNSIGNED ZEROFILL NOT NULL,
    Almoxarife VARCHAR(30) NOT NULL
);

INSERT INTO ALMOXARIFE (NAlmox, Almoxarife) VALUES (1001, 'João da Silva'),
(1002, 'Antônio Prado'),
(1003, 'Lourenço Dias'),
(1004, 'João Antônio'),
(1005, 'Silvino Torres'),
(1006, 'Antônio Sanos'),
(1007, 'Valter Souza'),
(1008, 'Sergio Melo');

SELECT * FROM ALMOXARIFE;

CREATE TABLE MATERIAL(
    CdMat INT(4) UNSIGNED ZEROFILL NOT NULL,
    DescrMatPrima VARCHAR(16) NOT NULL,
    PRIMARY KEY (CdMat)
);

INSERT INTO MATERIAL (CdMat, DescrMatPrima) VALUES (100, 'Enxofre'),
(101, 'Areia Monazítica'),
(102, 'Argila Moída');

SELECT * FROM MATERIAL;

CREATE TABLE REQUISICAO (
    NumReq INT(7) UNSIGNED ZEROFILL NOT NULL,
    DtReq DATE NOT NULL,
    Secao INT(3) UNSIGNED ZEROFILL NOT NULL,
    NAlmox INT(4) UNSIGNED ZEROFILL NOT NULL,
    PRIMARY KEY (NumReq),
);

ALTER TABLE REQUISICAO
ADD FOREIGN KEY (Secao) REFERENCES SECAO(Secao);

ALTER TABLE REQUISICAO
ADD FOREIGN KEY (NAlmox) REFERENCES ALMOXARIFE(NAlmox);

INSERT INTO REQUISICAO (NumReq, DtReq, Secao, NAlmox) VALUES (101, '2010-06-01', 20, 1001),
(102, '2010-06-01', 21, 1002),
(103, '2010-06-01', 22, 1003),
(104, '2010-06-02', 23, 1004),
(105, '2010-06-02', 24, 1005),
(106, '2010-06-02', 20, 1002),
(107, '2010-06-03', 25, 1008),
(108, '2010-06-03', 25, 1001),
(109, '2010-06-04', 21, 1006),
(110, '2010-06-04', 10, 1006),
(111, '2010-06-04', 10, 1007);

SELECT * FROM REQUISICAO;

CREATE TABLE REQ_MAT (
    NumReq INT(7) UNSIGNED ZEROFILL NOT NULL,
    CdMat INT(4) UNSIGNED ZEROFILL NOT NULL,
    QtdReq INT(7) UNSIGNED NOT NULL,
    VlrUnit DECIMAL(10,2) UNSIGNED NOT NULL,
    PRIMARY KEY (NumReq, CdMat),
    FOREIGN KEY (NumReq) REFERENCES REQUISICAO(NumReq),
    FOREIGN KEY (cdMat) REFERENCES MATERIAL(CdMat)
);

INSERT INTO REQ_MAT (NumReq, CdMat, QtdReq, VlrUnit) VALUES (101, 100, 8, 12500),
(101, 101, 5, 10000),
(106, 100, 15, 15000),
(106, 101, 4, 11000),
(102, 101, 6, 11500),
(102, 102, 25, 3400),
(109, 101, 5, 12000),
(103, 100, 5, 12800),
(103, 101, 7, 12000),
(107, 101, 7, 13000),
(108, 100, 12, 11800),
(104, 100, 12, 12000),
(104, 101, 9, 11300),
(105, 102, 20, 3460),
(110, 102, 25, 3200),
(111, 100, 15, 1300);

SELECT * FROM REQ_MAT;
