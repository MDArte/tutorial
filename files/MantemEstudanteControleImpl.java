public final void carregaEstudante(
		br.mdarte.exemplo.academico.web.geral.
		manterEstudante.CarregaEstudanteForm form, 
		ViewContainer container) throws Exception {

		Estudante e = new EstudanteImpl();

		e.setId(form.getId());

		e = (Estudante)ServiceLocator.instance().
				getEstudanteHandlerBI()
				.selectEstudante(e).get(0);

		form.setNome(e.getNome());
		form.setId(e.getId());
		form.setMatricula(e.getMatricula());    

	}

	public final void salvaEstudante(
			br.mdarte.exemplo.academico.web.geral
			.manterEstudante.SalvaEstudanteForm form, 
			ViewContainer container) throws Exception {

		Estudante e = new EstudanteImpl();

		e.setId(form.getId());
		e.setMatricula(form.getMatricula()); 
		e.setNome(form.getNome());

		ServiceLocator.instance().getEstudanteHandlerBI().
			insertOrUpdateEstudante(e);

	}