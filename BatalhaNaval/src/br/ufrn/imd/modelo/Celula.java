package br.ufrn.imd.modelo;

/*
 * A classe Celula representa estado de uma celula no jogo.
 * <br>
 * Atributos:
 * Boolean ocupacao, false significa ocupado e true livre
 * String estado pode ser oculta, revelada, atingida e danificada
 * */
public class Celula {
	private Boolean ocupacao;
	private String estado;
	
	public Celula() {
		setOcupacao(true);
		setEstado("oculto");
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Boolean getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(Boolean ocupacao) {
		this.ocupacao = ocupacao;
	}
	
}
