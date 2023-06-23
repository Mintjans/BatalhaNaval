package br.ufrn.imd;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * Esta é a nossa classe principal, nela temos os métodos main e start responsáveis por iniciar o programa e carregar a tela inicial do jogo 
 * */
public class Principal extends Application {
	@Override
	public void start(Stage stage) throws Exception  {
		// caminho da Tela Inicial
		Parent root = FXMLLoader.load(getClass().getResource("visao/TelaInicial.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Batalha Naval");
		stage.setResizable(false);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
