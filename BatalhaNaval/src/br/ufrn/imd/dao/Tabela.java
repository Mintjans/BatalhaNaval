package br.ufrn.imd.dao;

import java.util.ArrayList;
import java.util.Random;

import br.ufrn.imd.controle.CalculaCoord;
import br.ufrn.imd.modelo.Barco;
import br.ufrn.imd.modelo.Celula;
import br.ufrn.imd.modelo.Corveta;
import br.ufrn.imd.modelo.Destroyer;
import br.ufrn.imd.modelo.Fragata;
import br.ufrn.imd.modelo.Submarino;
/*
 * A classe Tabela representa o tabuleiro do jogo.
 * <br>
 * Atributos:
 * ArrayList<Celula> tabela uma arraylist com 100 celulas, representa a tabela do jogo;
 * ArrayList<Barco> embarcacoes, armazena os barcos do jogador;
 * */
public class Tabela implements Runnable, CalculaCoord{
	private ArrayList<Celula> tabela;
	private ArrayList<Barco> embarcacoes;
	
		public Tabela(){
			tabela = new ArrayList<Celula>(100);
			
			for(int i=0;i<100;i++) {
				Celula c = new Celula();
				tabela.add(c);
			}
			
			Barco temp;
			
			embarcacoes = new ArrayList<Barco>();
			
			temp = new Corveta();
			embarcacoes.add(temp);
			
			temp = new Submarino();
			embarcacoes.add(temp);
			
			temp = new Fragata();
			embarcacoes.add(temp);
			
			temp = new Destroyer();
			embarcacoes.add(temp);
	    }
		
		
		
		/*
		 * Metodo cel_aleatorio gera um inteiro aleatorio de 0 a 99 e retorna ele.
		 * @param rand, upperbound, int_random
		 * rand gera valores aleatorios
		 * upperbound define um limite nos valores a serem gerados de 0 a 99 no caso
		 * int_random armazena um inteiro aleatorio de 0 a 99
		 * @return int
		 * */
		public int celAleatorio()
		{
			Random rand = new Random();
		    int upperbound = 99;
		    int int_random = rand.nextInt(upperbound);
		    return int_random;
		}
		/*
		 * Metodo checkEspacos gera um inteiro aleatorio de 0 a 100 e retorna ele.
		 * @param eixo, coord, tam
		 * Boolean eixo, referente ao eixo que o navio será colocado false significa horizontal e true vertical
		 * int coord, a posição inicial de onde o barco será colocado
		 * int tam, o tamanho do navio
		 * @return boolean
		 * Se o valor retornado for true então há espaço para armazenar o navio, caso não haja será retornado false.
		 * */
		private boolean checkEspacos(Boolean eixo, int coord, int tam){
			if(eixo) {
		    	if(tam + (coord / 10) < 10) {
		    		for (int i = 0; i < tam; i++) {
		    			if(!tabela.get(coord).getOcupacao()) {
		    				return false;
		    			}
		    			coord = coord + 10;
		    		}
		    	}else {
		    		return false;
		    	}
		    }else {
		    	//System.out.println("tam + coord % 10 " + (tam + coord) % 10);
		    	if((tam + coord) % 10 < 10) {
		    		for (int i = 0; i < tam; i++) {
		    			if(!tabela.get(coord).getOcupacao()) {
		    				return false;
		    			}
		    			coord = coord + 1;
		    		}
		    	}else {
		    		return false;
		    	}
		    }
			
			return true;
		}
		
		/*
		 * Metodo posicionarNavio chama checkEspacos, caso o retorno seja true posiciona o navio no espaço vago.
		 * @param eixo, coord, tam, barco
		 * Boolean eixo, false significa horizontal e true vertical
		 * int coord, a posição a ser encaixado o barco
		 * int tam, o tamanho do navio
		 * Barco barco, o navio sendo posicionado
		 * @return boolean
		 * Se o valor retornado for true então o navio foi alocado, caso não tenhasido possivel será retornado false.
		 * */
		public boolean posicionarNavio(Boolean eixo, int coord, int tam, Barco barco){
			if(this.checkEspacos(eixo, coord, tam)) {
				if(eixo) {
			    	for (int i = 0; i < tam; i++) {
			    		//aqui vai ter que ter uma execeção para negar o posicionamento
			    		barco.setEixo(eixo);
			    		barco.addVida(coord);
			    		tabela.get(coord).setOcupacao(false);
			    		coord = coord + 10;
			    	}
			    	return true;
			    }else {
			    	for (int i = 0; i < tam; i++) {
			    		barco.setEixo(eixo);
			    		barco.addVida(coord);
			    		tabela.get(coord).setOcupacao(false);
			    		coord = coord + 1;
			    	}
			    	return true;
			    }
			}else {//indicar que não é possivel realizar a operação
				return false;
			}
		}
		
		public boolean mudarEixo(Barco barco){
			for (Barco b : embarcacoes) {
				if(b.getClass() == barco.getClass()) {
					int coord = b.getVida().get(0);
					if (checkEspacos(!b.getEixo(), coord, b.getTam())) {
						b.getVida().clear();
						posicionarNavio(!b.getEixo(), coord, b.getTam(), b);
						return true;
					}
				}
			}
			return false;
		}
		/*
		 * Metodo iniciarTabela inicia o tabuleiro do jogo posicionando os navios de forma aleatoria.
		 * */
		public void iniciarTabela(){
		      int navio_posicionado = 0;
		      Random rd = new Random();
		      while (navio_posicionado < 4) {
		    	  if(posicionarNavio(rd.nextBoolean(), celAleatorio(), embarcacoes.get(navio_posicionado).getTam(), embarcacoes.get(navio_posicionado))) {
		    		  navio_posicionado++;
		    	  }
		      }
	    }
		
		public void tabelaVisivel(){
			for(Celula a : tabela) {
				a.setEstado("revelada");
			}
	    }


		@Override
		public int calculaLinha(int coord) {
			int linha;
	    	linha = coord / 10;
			return linha;
		}

		@Override
		public int calculaColuna(int coord) {
			int coluna;
	    	coluna = coord % 10;
			return coluna;
		}



		public ArrayList<Celula> getTabela() {
			return tabela;
		}

		public ArrayList<Barco> getEmbarcacoes() {
			return embarcacoes;
		}

		@Override
		public void run() {
			iniciarTabela();
			tabelaVisivel();
		}
}
