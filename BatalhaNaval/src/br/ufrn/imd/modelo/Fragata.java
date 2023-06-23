package br.ufrn.imd.modelo;
/*
 * A classe Fragata é subclasse de Barco e implementa a interface Especial.
 * <br>
 * Atributos:
 * (super) todos atributos da classe herdada
 * int especial é responsavel por armazenar a contagem do tempo de espera do especial
 * */
public class Fragata extends Barco implements Especial{
	private int especial;
	
	public Fragata() {
		super();
		especial = 0;
		tam = 4;
	}
	@Override
	public void posicionar(int coord) {
		vida.clear();
		if (!eixo) {
			for (int i = 0; i < 4 ; i++) {
				vida.add(coord+i);
			}
		}else{
			for (int i = 0; i < 40 ; i=+10) {
				vida.add(coord+i);
			}
		}
		
		posicionado = true;
	}
	@Override
	public void reiniciaEspecial(){
		especial = 4;
	}
	
	@Override
	public void passarRodada() {
		// TODO Auto-generated method stub
		especial--;
	}
}
