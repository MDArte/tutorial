INSERT INTO CURSO (ID, HIBERNATE_VERSION, CODIGO, NOME) VALUES
	(nextval('curso_seq'), 0, '001', 'Curso 1'),
	(nextval('curso_seq'), 0, '002', 'Curso 2');

INSERT INTO ESTUDANTE (ID, MATRICULA, NOME, CURSO_FK) VALUES
	(nextval('estudante_seq'), '0001', 'Estudante 1', 1),
	(nextval('estudante_seq'), '0002', 'Estudante 2', 2),
	(nextval('estudante_seq'), '0003', 'Estudante 3', 1),
	(nextval('estudante_seq'), '0004', 'Estudante 4', 1);