-- inserts sem os ids, para deixar o proprio mysql decidir
-- Entity: GeneratedValue (strategy = GenerationType.IDENTITY)
-- Ao usar o AUTO, acaba usando IDENTITY (que estoura excecao porque o id nao tem um valor default)
insert into contato (nome, tipo, telefone) values ('Fulano', 'Residencial', '1234-1234');
insert into contato (nome, tipo, telefone) values ('Beltrano', 'Comercial', '4321-4321');
insert into contato (nome, tipo, telefone) values ('Sicrano', 'Comercial', '5555-4321');