package br.ufrn.imd.modelo;
/*
 * A interface Especial possui os metodos usados para a manutenção do especial e o posicionamento de navios no jogo.
 * */
public interface Especial {
	/*
	 * Metodo posicionar altera a coordenadas armazenada em vida de acordo com a nova posição do navio to tabuleiro.
	 * @param coord
	 * */
	public void posicionar(int coord);
	/*
	 * Metodo reiniciaEspecial reinicia o tempo de espera do especial após ele ser usado.
	 * */
	public void reiniciaEspecial();
	/*
	 * Metodo passarRodada diminui o tempo de espera do especial em 1 a cada rodada.
	 * */
	public void passarRodada();
}
