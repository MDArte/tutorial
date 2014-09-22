import java.util.ArrayList;
import java.util.Collection;

import br.mdarte.exemplo.academico.cd.EstudanteImpl;
import br.mdarte.exemplo.academico.to.EstudanteTOImpl;
import br.mdarte.exemplo.academico.util.PaginationStrategy;
import br.mdarte.exemplo.academico.web.geral.consultarEstudante.DefaultFilterAction;
import br.mdarte.exemplo.academico.web.geral.consultarEstudante.Estudante;
import br.mdarte.exemplo.academico.web.geral.consultarEstudante.EstudanteTO;
import br.mdarte.exemplo.academico.web.geral.consultarEstudante.EstudanteVO;
import br.mdarte.exemplo.academico.web.geral.consultarEstudante.ViewContainer;

 protected Integer getResultadoConsultaEstudantesTableLength(PaginationStrategy paginacao, String propriedade, Boolean desc,String nome,String matricula,ViewContainer container) throws Exception
    {
    	EstudanteTO estudanteTO = new EstudanteTOImpl();
    	
    	estudanteTO.setNome(nome);
    	estudanteTO.setMatricula(matricula);
    	
    	
    	return ServiceLocator.instance().getEstudanteHandlerBI().manipulaEstudante(new EstudanteImpl(), new DefaultFilterAction(estudanteTO, null)).size();
    }

	protected Collection loadResultadoConsultaEstudantesTable(PaginationStrategy paginacao,String propriedade,Boolean desc,String nome,String matricula,ViewContainer container) throws java.lang.Exception
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