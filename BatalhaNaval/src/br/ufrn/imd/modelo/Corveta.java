package br.ufrn.imd.modelo;
/*
 * A classe Corveta é subclasse de Barco e implementa a interface Especial.
 * <br>
 * Atributos:
 * (super) todos atributos da classe herdada
 * int especial é responsavel por armazenar a contagem do tempo de espera do especial
 * */
public class Corveta extends Barco implements Especial{
	private int especial;
	
	public Corveta() {
		super();
		especial = 0;
		tam = 2;
	}
	@Override
	public void posicionar(int coord) {
		vida.clear();
		if (!eixo) {
			for (int i = 0; i < 2 ; i++) {
				vida.add(coord+i);
			}
		}else{
			for (int i = 0; i < 20 ; i=+10) {
				vida.add(coord+i);
			}
		}
		
		posicionado = true;
	}
	@Override
	public void reiniciaEspecial(){
		especial = -1;
	}
	
	@Override
	public void passarRodada() {
		// TODO Auto-generated method stub
		especial--;
	}
}
