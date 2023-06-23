module BatalhaNaval {
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires java.desktop;
	requires javafx.base;
	
	opens br.ufrn.imd to javafx.graphics, javafx.fxml;
	
	exports br.ufrn.imd.controle;
	opens br.ufrn.imd.controle to javafx.graphics, javafx.fxml;
}
