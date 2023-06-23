package br.ufrn.imd.modelo;

import java.util.ArrayList;

/*
 * A classe Barco serve como super classe para os navios do tabuleiro.
 * <br>
 * Atributos:
 * Boolean eixo armazena o sentido em que o barco está posicionado, false significa horizontal e true vertical;
 * ArrayList<Integer> vida armazena as coordenadas de cada pedaço do navio;
 * Boolean posicionado, informa se o navio está no tabuleiro ou não;
 * int tam se refere ao espaço que o navio ocupa em campo
 * */
public class Barco{
	protected Boolean eixo;
	protected ArrayList<Integer> vida;
	protected Boolean posicionado;
	protected int tam;
	
	public Barco() {
		vida = new ArrayList<Integer>();
		posicionado = false;
	}
	/*
	 * Metodo addVida recebe um inteiro temp que representa uma coordenada ocupada pelo navio, esse inteiro é adicionado ao arraylist que representa o conjunto de espaços ocupados pelo navio e sua vida.
	 * @param temp
	 * */
	public void addVida(int temp){
		vida.add(temp);
    }
	/*
	 * Metodo removeVida recebe um inteiro temp que representa uma coordenada ocupada pelo navio, esse inteiro é usado para remover essa coordenada do arraylist que representa o conjunto de espaços ocupados pelo navio e sua vida.
	 * @param temp
	 * */
    public void removeVida(int temp){
    	vida.remove(temp);
    }
	
	public Boolean getEixo() {
		return eixo;
	}
	public void setEixo(Boolean eixo) {
		this.eixo = eixo;
	}
	
	public Boolean getPosicionado() {
		return posicionado;
	}
	public void setPosicionado(Boolean posicionado) {
		this.posicionado = posicionado;
	}
	
	/*
	 * Metodo mudaEixo altera o sentido em que o navio está alocado.
	 * */
	public void mudaEixo() {
		if(eixo) {
			eixo = false;
		}else {
			eixo = true;
		}
	}
	
	public void setTam(int t) {
		this.tam = t;
	}
	
	public int getTam() {
		return tam;
	}
	
	public boolean estaMorto() {
		return vida.isEmpty();
	}
	public ArrayList<Integer> getVida() {
		return vida;
	}
	public void setVida(ArrayList<Integer> vida) {
		this.vida = vida;
	}
}
