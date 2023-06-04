#Cadastrar os dados de todas tabelas do caso Comprobem.

INSERT INTO CCUSTO (CCusto, NomeCC) VALUES ('10A', 'Sub-1'),
('10B', 'Mult-2'),
('11A', 'Sub-2'),
('12A', 'Sub-3');

INSERT INTO SECAO (Secao, NomeSec, CCusto) VALUES (10, 'ADM', '12A'),
(20, 'Manutenção', '10A'),
(21, 'Produção-1', '10A'),
(22, 'Reparos', '10B'),
(23, 'Produção-2', '11A'),
(24, 'Produção-3', '11A'),
(25, 'Escritório', '10B');

INSERT INTO ALMOXARIFE (NAlmox, Almoxarife) VALUES (1001, 'João da Silva'),
(1002, 'Antônio Prado'),
(1003, 'Lourenço Dias'),
(1004, 'João Antônio'),
(1005, 'Silvino Torres'),
(1006, 'Antônio Sanos'),
(1007, 'Valter Souza'),
(1008, 'Sergio Melo');

INSERT INTO MATERIAL (CdMat, DescrMatPrima) VALUES (100, 'Enxofre'),
(101, 'Areia Monazítica'),
(102, 'Argila Moída');

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

#Cadastrar um novo registro de Centro de Custo, Seção, Almoxarife e Material.
INSERT INTO CENTRO_CUSTO(CCusto, NomeCC) VALUES ('13L', 'Log-1');
INSERT INTO SECAO (Secao, NomeSec, CCusto) VALUES ('013', 'Qualidade', '13L');
INSERT INTO ALMOXARIFE (NAlmox, Almoxarife) VALUES ('1013', 'Lucas Lima');
INSERT INTO MATERIAL (CdMat, DescrMatPrima) VALUES (103, 'Pedra');

#Alterar o nome da seção que você criou na questão anterior para "Seção Teste 001" e o Centro de Custo para "11A".
UPDATE SECAO SET NomeSec = 'Seção Teste 001', CCusto = '11A' WHERE Secao = 013;

#Escrever o comando para excluir o centro de custo "10C".
DELETE FROM CENTRO_CUSTO WHERE CCUSTO = '10C';

#Adicionar o campo valor unitário na tabela de material com as mesmas características do campo valor un02) itário da
tabela Req_Mat.
ALTER TABLE MATERIAL ADD VlrUnit DECIMAL(10,2);

#Excluir o campo valor unitário da tabela de material.
ALTER TABLE MATERIAL DROP COLUMN VlrUnit;

#Exercícios de Consulta

#Mostre todas as seções ordenadas pelo nome em ordem crescente.
SELECT * FROM SECAO ORDER BY NomeSec ASC;

#Mostre todos os Almoxarifes cujo primeiro nome seja 'João'.
SELECT * FROM ALMOXARIFE WHERE ALMOXARIFE LIKE 'João %';

#Mostre quando as seções fizeram requisições. Mostrar o código da seção e a data da requisição sem repetição.
SELECT DISTINCT Secao, DtReq FROM REQUISICAO;

#Mostre todas as seções do centro de custo '10B' e '12A'.
SELECT * FROM SECAO WHERE CCusto IN ('10B', '12A');

#Mostre as requisições feitas no período de 03/06/2020 a 08/06/2020.
SELECT * FROM REQUISICAO WHERE DtReq BETWEEN '2010-06-03' AND '2010-06-08';

#Mostre as requisições feitas pela seção 20 antes do dia 02/06/2020.
SELECT * FROM REQUISICAO WHERE Secao = '20' AND DtReq <= '2010-06-02';

#Mostre os almoxarifes cujos números sejam maiores que 1005.
SELECT * FROM ALMOXARIFE WHERE NAlmox >= '1005';

#Mostre as primeiras 3 requisições feitas a partir de 03/06/2020.
SELECT * FROM REQUISICAO WHERE DtReq >= '2010-06-03' ORDER BY DtReq LIMIT 3;

#Mostre as requisições feitas pelos almoxarifes 1004,1005,1007 e 1008 ordenados pelo código da seção em ordem
decrescente.
SELECT * FROM REQUISICAO WHERE NAlmox IN (1004, 1005, 1007, 1008) ORDER BY SECAO DESC;

#Mostre as seções de código ímpar.
SELECT * FROM SECAO WHERE SECAO % 2 <> 0