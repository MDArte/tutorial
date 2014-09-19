package br.mdarte.exemplo.academico.util;

public class PaginationSimple extends PaginationStrategy {
	
	public PaginationSimple(Integer paginaAtual) {
		super(paginaAtual);
	}
	
	public PaginationSimple(Integer paginaAtual, Integer linhas) {
		super(paginaAtual);
		this.linhas = linhas;
	}
	
	public PaginationSimple(Integer paginaAtual, Integer linhas, Integer paginas) {
		super(paginaAtual, linhas, paginas);
	}
	
	public void paginateResult(org.hibernate.Query res) {
	
		if (paginaAtual != null){
			res.setFirstResult(((paginaAtual)/paginas)*linhas*paginas);
			res.setMaxResults(linhas*paginas);
		}
		
	}
	
	public void paginateResult(org.hibernate.Criteria res) {
	
		if (paginaAtual != null){
			res.setFirstResult(((paginaAtual)/paginas)*linhas*paginas);
			res.setMaxResults(linhas*paginas);
		}

	}

}