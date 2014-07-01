public final void carregaCurso(
 	br.mdarte.exemplo.academico.web.geral.manterCurso
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

public final void salvaCurso(
	br.mdarte.exemplo.academico.web.geral.manterCurso
	.SalvaCursoForm form, ViewContainer container)
	throws Exception {

   	Curso c = new CursoImpl();
    	
   	c.setId(form.getId());
    	
   	c = (Curso)ServiceLocator.instance().getCursoHandlerBI()
   		.selectCurso(c).get(0);
    	
	c.setCodigo(form.getCodigo()); 
	c.setNome(form.getNome());

	ServiceLocator.instance().getCursoHandlerBI()
		.insertOrUpdateCurso(c);
}