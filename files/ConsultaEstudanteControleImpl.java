public final void consultaEstudante(
	br.mdarte.exemplo.academico.web.geral.consultarEstudante.
	ConsultaEstudanteForm form, ViewContainer container) 
	throws Exception {
    	
    Integer paginacao = 
    		((Double)container.
    		getAttribute(Constantes.PARAMETRO_PAGINA)).
    		intValue();
		
    EstudanteVO vo = new EstudanteVO();
    	
    vo.setNome(form.getNome());
    vo.setMatricula(form.getMatricula());
    	
    // nothing to be done for this operation, 
    //there are no properties that can be set 
        
    Collection estudantes =
    	ServiceLocator.instance().getEstudanteHandlerBI()
    	.manipulaEstudante(new EstudanteImpl(), 
    	new FilterAction(vo, paginacao));
    	
    form.setEstudantes(estudantes);
}