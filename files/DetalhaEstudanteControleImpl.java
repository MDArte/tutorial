package br.mdarte.exemplo.academico.web.geral
	.detalharEstudante;
import br.mdarte.exemplo.academico.ServiceLocator;
import br.mdarte.exemplo.academico.util.Constantes;
import org.andromda.presentation.bpm4struts.ViewContainer;
import br.mdarte.exemplo.academico.cd.Estudante;
import br.mdarte.exemplo.academico.cd.EstudanteImpl;
import br.mdarte.exemplo.academico.vo.EstudanteVO;

/**
 * @see br.mdarte.exemplo.academico.web.geral.detalharEstudante
 * 	.DetalhaEstudanteControle
 */
public class DetalhaEstudanteControleImpl 
	extends DetalhaEstudanteControle
	{
    /**
     * @see br.mdarte.exemplo.academico.web.geral
     * 	.detalharEstudante.DetalhaEstudanteControle#
     * 	carregaEstudante(br.mdarte.exemplo.academico.web
     * 	.geral.detalharEstudante.CarregaEstudanteForm)
     */
    public final void carregaEstudante(
    	br.mdarte.exemplo.academico.web.geral.detalharEstudante
    	.CarregaEstudanteForm form, ViewContainer container
    	) throws Exception {
    	
    	Estudante estudante = new EstudanteImpl();
    	
    	estudante.setId(form.getId());
    	
    	estudante = (Estudante) ServiceLocator.instance()
    		.getEstudanteHandlerBI().selectEstudante(estudante)
    		.get(0);
    	
    	form.setNome(estudante.getNome());
    	
    	form.setMatricula(estudante.getMatricula());
    	
    	form.setId(estudante.getId());
    	
    }
}