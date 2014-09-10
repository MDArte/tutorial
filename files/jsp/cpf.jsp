<label class="control-label col-sm-2" for="cpf">
	<bean:message 
	key="consulta.estudante.uc.preencha.
	campos.consulta.estudante.param.cpf"/>
</label>
<div class="col-xs-4">
	<s:textfield id="cpfConsultaEstudanteUC" name="cpf" 
	label="%{getText('consulta.estudante.uc.preencha
	.campos.consulta.estudante.param.cpf')}" 
	value="%{#form.$propertyValue}"  
	cssClass="form-control" title=""  
	styleId="$styleId"  />
</div>