package javafxbasico.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class FXMLAlertController implements Initializable {

	@FXML
	private Button buttonAlert;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	@FXML
	void abrirAlert(ActionEvent event) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Título");
		alert.setHeaderText("Cabeçalho");
		alert.setContentText("Conteúdo");
		alert.show();
	}

}
