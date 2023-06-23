package br.ufrn.imd.controle;

import java.io.IOException;

import br.ufrn.imd.dao.Tabela;
import br.ufrn.imd.modelo.Barco;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/*
 * Esse é o controlador da tela Pre Jogo responsavel pelo funcionamento da tela de organização do tabuleiro.
 * <br>
 * A classe possui os seguintes atributos anchorPre, grid, confirmar, corveta, submarino, fragata, destroyer.
 * Todos eles referentes a aspectos do arquivo fxml feito no scene builder.
 * */

public class TelaPreJogoController {
	
	@FXML
    private AnchorPane anchorPre;
	
	@FXML
    private GridPane grid;
	
	@FXML
    private Button confirmar;
	
	@FXML
    private  ImageView corveta;
	
	@FXML
    private ImageView submarino;
	
	@FXML
	private ImageView fragata;
	
	@FXML
    private ImageView destroyer;
	
	public void setPreJogoStage(Stage preJogoStage) throws InterruptedException {
		Tabela jogador = new Tabela();
		Thread thread = new Thread(jogador);
	    thread.start();
	    thread.join();
		mostrarBarcos(jogador);
	}

	private void mostrarBarcos(Tabela jogador) {
		int coord;
		for (Barco b : jogador.getEmbarcacoes()) {
  		  System.out.println("getClass() " + b.getClass());
  		System.out.println(b.getClass().equals("Corveta"));
  		System.out.println("Corveta".equals(b.getClass()));
			if(b.getClass() == jogador.getEmbarcacoes().get(0).getClass()) {
				if(b.getEixo()) {
					coord = b.getVida().get(0);
					corveta.setRotate(90);
					grid.setColumnIndex(corveta, jogador.calculaColuna(coord));
					grid.setRowIndex(corveta, jogador.calculaLinha(coord));
					grid.setColumnSpan(corveta, 1);
					grid.setRowSpan(corveta, b.getTam());
					System.out.println(corveta.isVisible());
				}else{
					coord = b.getVida().get(0);
					corveta.setRotate(0);
					grid.setColumnIndex(corveta, jogador.calculaColuna(coord));
					grid.setRowIndex(corveta, jogador.calculaLinha(coord));
					grid.setColumnSpan(corveta, b.getTam());
					grid.setRowSpan(corveta, 1);
				}
			}
			if(b.getClass() == jogador.getEmbarcacoes().get(3).getClass()) {
				if(b.getEixo()) {
					coord = b.getVida().get(0);
					destroyer.setRotate(90);
					grid.setColumnIndex(destroyer, jogador.calculaColuna(coord));
					grid.setRowIndex(destroyer, jogador.calculaLinha(coord));
					grid.setColumnSpan(destroyer, 1);
					grid.setRowSpan(destroyer, b.getTam());
				}else{
					coord = b.getVida().get(0);
					destroyer.setRotate(0);
					grid.setColumnIndex(destroyer, jogador.calculaColuna(coord));
					grid.setRowIndex(destroyer, jogador.calculaLinha(coord));
					grid.setColumnSpan(destroyer, b.getTam());
					grid.setRowSpan(destroyer, 1);
				}
			}
			if(b.getClass() == jogador.getEmbarcacoes().get(2).getClass()) {
				if(b.getEixo()) {
					coord = b.getVida().get(0);
					fragata.setRotate(90);
					grid.setColumnIndex(fragata, jogador.calculaColuna(coord));
					grid.setRowIndex(fragata, jogador.calculaLinha(coord));
					grid.setColumnSpan(fragata, 1);
					grid.setRowSpan(fragata, b.getTam());
				}else{
					coord = b.getVida().get(0);
					fragata.setRotate(0);
					grid.setColumnIndex(fragata, jogador.calculaColuna(coord));
					grid.setRowIndex(fragata, jogador.calculaLinha(coord));
					grid.setColumnSpan(fragata, b.getTam());
					grid.setRowSpan(fragata, 1);
				}
			}
			if(b.getClass() == jogador.getEmbarcacoes().get(1).getClass()) {
				if(b.getEixo()) {
					coord = b.getVida().get(0);
					submarino.setRotate(90);
					grid.setColumnIndex(submarino, jogador.calculaColuna(coord));
					grid.setRowIndex(submarino, jogador.calculaLinha(coord));
					grid.setColumnSpan(submarino, 1);
					grid.setRowSpan(submarino, b.getTam());
				}else{
					coord = b.getVida().get(0);
					submarino.setRotate(0);
					grid.setColumnIndex(submarino, jogador.calculaColuna(coord));
					grid.setRowIndex(submarino, jogador.calculaLinha(coord));
					grid.setColumnSpan(submarino, b.getTam());
					grid.setRowSpan(submarino, 1);
				}
			}
		}
	}

	@FXML
	private void iniciarJogo(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(TelaJogoController.class.getResource("/br/ufrn/imd/visao/TelaSolo.fxml"));
    	AnchorPane page = (AnchorPane) loader.load();
    	
    	// Criando um novo Stage
    	Stage JogoStage = new Stage();
    	JogoStage.setTitle("Jogo");
    	JogoStage.setResizable(false);
    	Scene scene = new Scene(page);
    	JogoStage.setScene(scene);
    	
    	// Setando o Controle 
    	TelaJogoController controller = loader.getController();
    	controller.setJogoStage(JogoStage);
    	JogoStage.showAndWait();
	}
	
	private void rotacionar(ImageView barcoFront, Barco back, Tabela tab) {
		if(tab.mudarEixo(back)) {
			int coord;
			if(back.getEixo()) {
				coord = back.getVida().get(0);
				barcoFront.setRotate(90);
				grid.setColumnIndex(barcoFront, tab.calculaColuna(coord));
				grid.setRowIndex(barcoFront, tab.calculaLinha(coord));
				grid.setColumnSpan(barcoFront, 1);
				grid.setRowSpan(barcoFront, back.getTam());
			}else{
				coord = back.getVida().get(0);
				barcoFront.setRotate(0);
				grid.setColumnIndex(barcoFront, tab.calculaColuna(coord));
				grid.setRowIndex(barcoFront, tab.calculaLinha(coord));
				grid.setColumnSpan(barcoFront, back.getTam());
				grid.setRowSpan(barcoFront, 1);
			}
		}
	}
}
