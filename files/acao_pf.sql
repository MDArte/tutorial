insert into acao_pf 
	select id , 
	(Select id from perfil where 
	perfil.sistema_fk=
		(select id from 
		sistema where 
		sistema.nome='sistemaacademico'
		)
	) from acao a