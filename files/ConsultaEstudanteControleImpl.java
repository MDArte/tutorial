package br.mdarte.exemplo.academico.web.geral
	.consultarEstudante;

import br.mdarte.exemplo.academico
	.ServiceLocator;
import br.mdarte.exemplo.academico.action.FilterAction;
import br.mdarte.exemplo.academico.util.Constantes;
import br.mdarte.exemplo.academico.cd.Estudante;
import br.mdarte.exemplo.academico.cd.EstudanteImpl;
import br.mdarte.exemplo.academico.to.EstudanteTO;
import br.mdarte.exemplo.academico.to.EstudanteTOImpl;
import br.mdarte.exemplo.academico.action
	.DefaultFilterAction;
import java.util.Collection;

import org.andromda.presentation.bpm4struts.ViewContainer;

/**
 * @see br.mdarte.exemplo.academico.web.geral
 * 	.consultarEstudante.ConsultaEstudanteControle
 */
public class ConsultaEstudanteControleImpl extends 
	ConsultaEstudanteControle 
	{
    /**
     * @see br.mdarte.exemplo.academico.web.geral
     * 	.consultarEstudante.ConsultaEstudanteControle
     * 	#consultaEstudante(br.mdarte.exemplo.academico
     * 	.web.geral.consultarEstudante
     * .ConsultaEstudanteForm)
     */
    public final void consultaEstudante(
    		br.mdarte.exemplo.academico.web.geral
    		.consultarEstudante.ConsultaEstudanteForm form,
    		ViewContainer container ) throws Exception {

    	Integer paginacao = ((Double)container
    		.getAttribute(Constantes.PARAMETRO_PAGINA))
    		.intValue();
        // nothing to be done for this operation, 
    	//there are no properties that can be set
    	
    	EstudanteTO to = new EstudanteTOImpl();
    	to.setNome(form.getNome());
    	to.setMatricula(form.getMatricula());
    	    	
    	Collection estudantes = ServiceLocator.instance()
    		.getEstudanteHandlerBI().manipulaEstudante(
    		new EstudanteImpl(), 
    		new DefaultFilterAction(to, paginacao));
    	
    	form.setEstudantes(estudantes);
    }

}
