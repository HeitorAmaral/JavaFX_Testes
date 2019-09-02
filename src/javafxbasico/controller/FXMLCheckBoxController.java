package javafxbasico.controller;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;

public class FXMLCheckBoxController {

	@FXML
	private CheckBox checkBoxJava;

	@FXML
	private CheckBox checkBoxPHP;

	@FXML
	public void pegarValores() {
		System.out.println(checkBoxJava.selectedProperty().getValue());
		System.out.println(checkBoxPHP.selectedProperty().getValue());
	}

}
