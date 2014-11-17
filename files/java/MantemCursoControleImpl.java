import br.mdarte.exemplo.academico.ServiceLocator;
import br.mdarte.exemplo.academico.util.Constantes;
import br.mdarte.exemplo.academico.cd.CursoImpl;
import br.mdarte.exemplo.academico.cd.Curso;
import org.andromda.presentation.bpm4struts
	.ViewContainer;

/**
 * @see br.mdarte.exemplo.academico.web.geral
 * .manterCurso.MantemCursoControle
 */
public class MantemCursoControleImpl 
	extends MantemCursoControle
{
    /**
     * @see br.mdarte.exemplo.academico.web.geral
     * .manterCurso.MantemCursoControle
     * #carregaCurso(br.mdarte.exemplo.academico
     * .web.geral.manterCurso.CarregaCursoForm)
     */
    public final void carregaCurso(
    	br.mdarte.exemplo.academico.web.geral
    	.manterCurso.CarregaCursoForm form, 
    	ViewContainer container) 
    			throws Exception {
    	
    	Curso curso = new CursoImpl();
    	curso.setId(form.getIdCurso());
    	
    	curso = (Curso) ServiceLocator.instance()
    		.getCursoHandlerBI().selectCurso(curso)
    		.iterator().next();
    	
    	if(curso != null) {
	    	form.setNome(curso.getNome());
	    	form.setCodigo(curso.getCodigo());
	    	form.setIdCurso(curso.getId());
    	}
    }

    /**
     * @see br.mdarte.exemplo.academico.web.geral
     * .manterCurso.MantemCursoControle
     * #salvaCurso(br.mdarte.exemplo.academico
     * .web.geral.manterCurso.SalvaCursoForm)
     */
    public final void salvaCurso(
    	br.mdarte.exemplo.academico
    	.web.geral.manterCurso.SalvaCursoForm form,
    	ViewContainer container) 
    			throws Exception {
    	Curso curso = new CursoImpl();
    	curso.setId(form.getIdCurso());
    	
    	curso =(Curso) ServiceLocator.instance()
    		.getCursoHandlerBI().selectCurso(curso)
    		.iterator().next();
    	
    	if(curso != null) {
	    	curso.setCodigo(
	    		form.getCodigo());
	    	curso.setNome(form.getNome());
	    	
	    	ServiceLocator.instance()
	    		.getCursoHandlerBI().insertCurso(curso);
	    	
	    	this.saveSuccessMessage(
	    		"mantem.curso.inserido.sucesso",
	    		container);
    	}
    }
}
