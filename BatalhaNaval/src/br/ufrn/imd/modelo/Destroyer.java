package br.ufrn.imd.modelo;
/*
 * A classe Destroyer é subclasse de Barco e implementa a interface Especial.
 * <br>
 * Atributos:
 * (super) todos atributos da classe herdada
 * int especial é responsavel por armazenar a contagem do tempo de espera do especial
 * */
public class Destroyer extends Barco implements Especial{
	private int especial;
	
	public Destroyer() {
		super();
		especial = 0;
		tam = 5;
	}
	@Override
	public void posicionar(int coord) {
		vida.clear();
		if (!eixo) {
			for (int i = 0; i < 5 ; i++) {
				vida.add(coord+i);
			}
		}else{
			for (int i = 0; i < 50 ; i=+10) {
				vida.add(coord+i);
			}
		}
		posicionado = true;
	}
	
	@Override
	public void passarRodada() {
		// TODO Auto-generated method stub
		especial--;
	}
	@Override
	public void reiniciaEspecial() {
		// TODO Auto-generated method stub
		especial = 5;
	}
}
