public final void carregaCurso(
	br.mdarte.exemplo.academico.web.geral.detalharCurso
	.CarregaCursoForm form, ViewContainer container) 
	throws Exception {
	
	Curso c = new CursoImpl();
    	
    c.setId(form.getId());
    	
    c = (Curso)ServiceLocator.instance().getCursoHandlerBI()
    	.selectCurso(c).get(0);

    form.setNome(c.getNome());
    form.setId(c.getId());
    form.setCodigo(c.getCodigo());	
}