package br.ufrn.imd.controle;


import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/*
 * Esse é o controlador da tela inicial responsavel pelo funcionamento do menu do jogo.
 * <br>
 * A classe possui os seguintes atributos anchorIni, buttonSolo, buttonMult, buttonSair, lbBreve.
 * Todos eles referentes a aspectos do arquivo fxml feito no scene builder.
 * */

public class TelaInicialController {
	@FXML
    private AnchorPane anchorIni;
	
	@FXML
    private Button buttonSolo;
	
	@FXML
    private Button buttonMult;
	
	@FXML
    private Button buttonSair;
	
	@FXML
    private Label lbBreve;
	
	/*
	 * Metodo abrirTelaPreJogo carrega o arquivo fxml referente ao momento onde serão organizados os barcos e inicia a execução do controlador da tela pre jogo.
	 * @param event
	 * @throws IOException, InterruptedException
	 * */
	@FXML
    public void abrirTelaPreJogo(ActionEvent event) throws IOException, InterruptedException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(TelaPreJogoController.class.getResource("/br/ufrn/imd/visao/TelaPreJogo.fxml"));
    	AnchorPane page = (AnchorPane) loader.load();
    	// Criando um novo Stage
    	Stage preJogoStage = new Stage();
    	preJogoStage.setTitle("Fase pre jogo");
    	preJogoStage.setResizable(false);
    	Scene scene = new Scene(page);
    	preJogoStage.setScene(scene);
    	// Setando o Controle 
    	TelaPreJogoController controller = loader.getController();
    	controller.setPreJogoStage(preJogoStage);
    	preJogoStage.show();
    	Stage stage;
		stage = (Stage) anchorIni.getScene().getWindow();
		stage.close();
    }
	
	/*
	 * Metodo Sair fecha a janela e interrompe a execução do jogo.
	 * @param event
	 * */
	@FXML
	public void Sair(ActionEvent event) {
		Stage stage;
		stage = (Stage) anchorIni.getScene().getWindow();
		stage.close();
	}
	
	/*
	 * Metodo abrirTelaPreJogoMult carrega o arquivo fxml referente ao momento onde serão organizados os barcos no modo multiplayer e inicia a execução do controlador da tela pre jogo.
	 * @param event
	 * @throws IOException
	 * */
	@FXML
	public void abrirTelaPreJogoMult(ActionEvent event) throws IOException {}
}
