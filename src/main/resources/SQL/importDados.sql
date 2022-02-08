INSERT INTO cliente(endereco, nome, telefone) VALUES ('Rua 1', '98900000000', 'Lucas Felipe');
INSERT INTO cliente(endereco, nome, telefone) VALUES ('Rua 2', '98911111111', 'Emanuelly Rios');
INSERT INTO cliente(endereco, nome, telefone) VALUES ('Rua 3', '98922222222', 'Luan Johannes');
INSERT INTO cliente(endereco, nome, telefone) VALUES ('Rua 4', '98933333333', 'Rafael Bastos');

INSERT INTO cidade(nome, taxa, uf) VALUES ('São Luís', 10.5, 'MA');
INSERT INTO cidade(nome, taxa, uf) VALUES ('São Jose de Ribamar', 19.5, 'MA');
INSERT INTO cidade(nome, taxa, uf) VALUES ('Raposa', 5.5, 'MA');

INSERT INTO frete( descricao, peso, valor, cidade_id, cliente_id) VALUES  (1, 1, 23.99, 1.30, 'Celular');
INSERT INTO frete( descricao, peso, valor, cidade_id, cliente_id) VALUES  (1, 1, 23.99, 1.30, 'Notebook');
