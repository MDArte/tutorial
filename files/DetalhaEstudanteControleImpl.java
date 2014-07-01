public final void carregaEstudante(
	br.mdarte.exemplo.academico.web.geral.detalharEstudante
	.CarregaEstudanteForm form, ViewContainer container) 
	throws Exception {
	
	Estudante e = new EstudanteImpl();
    	
   	e.setId(form.getId());
    	
   	e = (Estudante) ServiceLocator.instance()
   		.getEstudanteHandlerBI().selectEstudante(e)
   		.get(0);

   	form.setNome(e.getNome());
   	form.setId(e.getId());
   	form.setMatricula(e.getMatricula());
 	
}
