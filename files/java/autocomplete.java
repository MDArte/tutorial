protected String[] matriculaPreenchaCamposAutoComplete(
		String query, ViewContainer container) throws 
		Exception {
    
	EstudanteTO estudanteTO = new EstudanteTOImpl();
    	
    estudanteTO.setMatricula(query);
    	
    Collection estudantes = ServiceLocator.instance()
    		.getEstudanteHandlerBI().manipulaEstudante(
    		new EstudanteImpl(), 
    		new DefaultFilterAction(estudanteTO,0));
    	
    String[] matriculas = new String[10];
    	
    int i =0;
    	
    if(!Util.checkEmpty(estudantes)) {
    	Iterator iterator = estudantes.iterator();
	   	while(i<10 ){
	    		matriculas[i++] = iterator.hasNext() ? 
	    				((Estudante)iterator.next())
	    				.getMatricula() : "";
	   	}
    } 
    	
    return matriculas;
}