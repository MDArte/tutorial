package br.mdarte.exemplo.academico.util;

import br.mdarte.exemplo.academico.Constantes;

public abstract class PaginationStrategy {

	protected Integer paginaAtual;
	protected Integer linhas;
	protected Integer paginas;
	
	public PaginationStrategy () {
		this.paginaAtual = null;
		this.linhas = Constantes.TABLE_LINES;
		this.paginas = Constantes.TABLE_PAGES;
	}
	
	public PaginationStrategy (Integer paginaAtual) {
		this.paginaAtual = paginaAtual;
		this.linhas = Constantes.TABLE_LINES;
		this.paginas = Constantes.TABLE_PAGES;
	}
	
	public PaginationStrategy (Integer paginaAtual, Integer linhas, Integer paginas) {
		this.paginaAtual = paginaAtual;
		this.linhas = linhas;
		this.paginas = paginas;
	}
	
	public abstract void paginateResult(org.hibernate.Query res);
	
	public abstract void paginateResult(org.hibernate.Criteria res);
	
	public Integer getPaginaAtual() {
		return this.paginaAtual;
	}
	
	public void setPaginaAtual(Integer pagina) {
		this.paginaAtual = pagina;
	}
	
	public Integer getLinhas() {
		return this.linhas;
	}
	
	public void setLinhas(Integer linhas) {
		this.linhas = linhas;
	}
	
	public Integer getPaginas() {
		return this.paginas;
	}
	
	public void setPaginas(Integer paginas) {
		this.paginas = paginas;
	}

}
