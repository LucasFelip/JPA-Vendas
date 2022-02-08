INSERT INTO cliente(endereco, nome, telefone) VALUES ('Rua 1', '98900000000', 'Lucas Felipe');
INSERT INTO cliente(endereco, nome, telefone) VALUES ('Rua 2', '98911111111', 'Emanuelly Rios');
INSERT INTO cliente(endereco, nome, telefone) VALUES ('Rua 3', '98922222222', 'Luan Johannes');
INSERT INTO cliente(endereco, nome, telefone) VALUES ('Rua 4', '98933333333', 'Rafael Bastos');

INSERT INTO cidade(nome, taxa, uf) VALUES ('São Luís', 10.5, 'MA');
INSERT INTO cidade(nome, taxa, uf) VALUES ('São Jose de Ribamar', 19.5, 'MA');
INSERT INTO cidade(nome, taxa, uf) VALUES ('Raposa', 5.5, 'MA');

INSERT INTO frete(descricao, peso, valor, cidade_id, cliente_id) VALUES  ('Celular Samsung', 23.99, 250.4, 1, 1);
INSERT INTO frete(descricao, peso, valor, cidade_id, cliente_id) VALUES  ('Notebook i3', 1599.99, 250.4, 1, 1);
INSERT INTO frete(descricao, peso, valor, cidade_id, cliente_id) VALUES  ('Caderno Grande', 10.99, 250.4, 1, 2);
INSERT INTO frete(descricao, peso, valor, cidade_id, cliente_id) VALUES  ('Celular Motorola', 23.99, 250.4, 2, 3);
INSERT INTO frete(descricao, peso, valor, cidade_id, cliente_id) VALUES  ('Notebook i3', 1599.99, 250.4, 2, 3);
INSERT INTO frete(descricao, peso, valor, cidade_id, cliente_id) VALUES  ('Caderno Pegueno', 10.99, 250.4, 1, 4);