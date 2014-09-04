public final void consultaEstudante(br.mdarte.exemplo.academico.web.geral.consultarEstudante.ConsultaEstudanteForm form, ViewContainer container) throws Exception {        
    form.setNome(form.getNome());
    form.setMatricula(form.getMatricula());
    form.setIdEstudante(form.getIdEstudante());
}

protected Integer getResultadoConsultaEstudantesTableLength(PaginationStrategy paginacao, String propriedade, Boolean desc,String nome,Long idEstudante,String matricula,ViewContainer container) throws Exception
{
    	EstudanteTO estudanteTO = new EstudanteTOImpl();
    	
    	estudanteTO.setNome(nome);
    	estudanteTO.setMatricula(matricula);
    	
    	
    	return ServiceLocator.instance().getEstudanteHandlerBI().manipulaEstudante(new EstudanteImpl(), new DefaultFilterAction(estudanteTO, null)).size();
}

protected Collection loadResultadoConsultaEstudantesTable(PaginationStrategy paginacao,String propriedade,Boolean desc,String nome,Long idEstudante,String matricula,ViewContainer container) throws java.lang.Exception
{
	EstudanteTO estudanteTO = new EstudanteTOImpl();
	
	estudanteTO.setNome(nome);
	estudanteTO.setMatricula(matricula);
	
	Collection estudantes = ServiceLocator.instance().getEstudanteHandlerBI().manipulaEstudante(new EstudanteImpl(), new DefaultFilterAction(estudanteTO, paginacao));
	
	ArrayList<EstudanteVO> estudantesVO = new ArrayList<EstudanteVO>();
			
	for(Object object : estudantes) {
		EstudanteVO estudanteVO = new EstudanteVO();
		
		estudanteVO.setNome(((Estudante)object).getNome());
		estudanteVO.setMatricula(((Estudante)object).getMatricula());
		estudanteVO.setIdEstudante(((Estudante)object).getId());
		
		estudantesVO.add(estudanteVO);
	}
	
	return estudantesVO;
}