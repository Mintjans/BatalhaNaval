package br.ufrn.imd.modelo;
/*
 * A classe Submarino é subclasse de Barco e implementa a interface Especial.
 * <br>
 * Atributos:
 * (super) todos atributos da classe herdada
 * int especial é responsavel por armazenar a contagem do tempo de espera do especial
 * */
public class Submarino extends Barco implements Especial{
	private int especial;
	
	public Submarino() {
		super();
		especial = 0;
		tam = 3;
	}
	
	@Override
	public void posicionar(int coord) {
		vida.clear();
		if (!eixo) {
			for (int i = 0; i < 3 ; i++) {
				vida.add(coord+i);
			}
		}else{
			for (int i = 0; i < 30 ; i=+10) {
				vida.add(coord+i);
			}
		}
		posicionado = true;
	}

	@Override
	public void reiniciaEspecial() {
		// TODO Auto-generated method stub
		especial = 3;
	}

	@Override
	public void passarRodada() {
		// TODO Auto-generated method stub
		especial--;
	}
}
