insert into usuario(id,login,senha,situacao) 
	values(nextval('usuario_seq'),'su',md5('su'),1);

insert into sistema(id,nome) values (nextval('sistema_seq')
	,'sistemaacademico');

insert into perfil(id,nome,super_usuario,sistema_fk)
	values (nextval('perfil_seq'),'Administrador',true,
	(select id from sistema where nome='sistemaacademico'));


insert into pf_usr values ((select id from usuario where login='su'),
	(select id from perfil where nome='Administrador'))