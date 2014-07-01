public final void consultaCurso(
	br.mdarte.exemplo.academico.web.geral.consultarCurso
	.ConsultaCursoForm form, ViewContainer container) 
	throws Exception {
    		
    Integer paginacao = ((Double)container
    	.getAttribute(Constantes.PARAMETRO_PAGINA)).intValue();
    		
    CursoVO vo = new CursoVO();
    	
    vo.setNome(form.getNome());
    vo.setCodigo(form.getCodigo());
    	
    // nothing to be done for this operation, 
    //there are no properties that can be set
    Collection cursos = ServiceLocator.instance()
    	.getCursoHandlerBI().manipulaCurso(
    	new CursoImpl(), new FilterAction(vo, paginacao));
    	
    form.setCursos(cursos);	
}