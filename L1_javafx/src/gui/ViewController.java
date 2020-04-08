package gui;

import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;

public class ViewController {

	//  Declaraçôes do botão
	@FXML
	private Button btTest;
	
	// A ação do botão
	@FXML
	public void onBtTestAction() {
		Alerts.showAlert("Titulo do Alert", null, "Hello World!", AlertType.INFORMATION);
	}
}
