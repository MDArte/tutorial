import br.mdarte.exemplo.academico
	.ServiceLocator;
import br.mdarte.exemplo.academico.util.Constantes;
import br.mdarte.exemplo.academico.util.Util;
import br.mdarte.exemplo.academico.cd.Curso;
import br.mdarte.exemplo.academico.cd.CursoImpl;
import br.mdarte.exemplo.academico.to.CursoTO;
import br.mdarte.exemplo.academico.to.CursoTOImpl;
import br.mdarte.exemplo.academico.action
	.DefaultFilterAction;
import java.util.Collection;
import java.util.ArrayList;
import br.mdarte.exemplo.academico.vo.CursoVO;
import org.andromda.presentation.bpm4struts.ViewContainer;

/**
 * @see br.mdarte.exemplo.academico.web.geral
 * 	.consultarCurso.ConsultaCursoControle
 */
public class ConsultaCursoControleImpl extends 
	ConsultaCursoControle 
	{
    /**
     * @see br.mdarte.exemplo.academico.web.geral
     * 	.consultarCurso.ConsultaCursoControle
     * 	#consultaCurso(br.mdarte.exemplo.academico
     * 	.web.geral.consultarCurso
     * .ConsultaCursoForm)
     */
    public final void consultaCurso(
    		br.mdarte.exemplo.academico.web.geral
    		.consultarCurso.ConsultaCursoForm form,
    		ViewContainer container ) throws Exception {
    	
    	  Integer pagina = ((Double)container
    			  .getAttribute(Constantes.PARAMETRO_PAGINA))
    			  .intValue();  
    	  
    	  br.mdarte.exemplo.academico.util.PaginationDisplaytag 
    	  	paginacao = new br.mdarte.exemplo.academico.util
    	  	.PaginationDisplaytag(pagina);
    	  
    	  CursoTO cursoTO = new CursoTOImpl();
    	  
    	  cursoTO.setNome(form.getNome());
    	  cursoTO.setCodigo(form.getCodigo());
    	
    	  Collection cursos = ServiceLocator.instance()
    			.getCursoHandlerBI().manipulaCurso(
    			new CursoImpl(), 
    			new DefaultFilterAction(cursoTO,paginacao));
          
          ArrayList<CursoVO> cursoVOs = new ArrayList<CursoVO>();
          
          if(!Util.checkEmpty(cursos)) {
          	for(Curso curso : 
          		(Collection<Curso>) cursos){
              	CursoVO cursoVO = new CursoVO();
              	cursoVO.setNome(curso.getNome());
              	cursoVO.setIdCurso(curso.getId());
              	cursoVO.setCodigo(curso.getCodigo());
              	cursoVOs.add(cursoVO);
              }
          	
          	form.setCursos(cursoVOs);
          }
    }

}