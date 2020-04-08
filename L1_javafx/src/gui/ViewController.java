package gui;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class ViewController {

	//  Declara��es do bot�o
	@FXML
	private Button btTest;
	
	// A a��o do bot�o
	@FXML
	public void onBtTestAction() {
		Alerts.showAlert("Titulo do Alert", null, "Hello World!", AlertType.INFORMATION);
	}
}
