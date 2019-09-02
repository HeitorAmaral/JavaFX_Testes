package javafxbasico.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class FXMLRadioButtonController implements Initializable {

	@FXML
	private ToggleGroup grupo;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	@FXML
	void pegarSelecionado() {

		RadioButton radioButton = (RadioButton) grupo.getSelectedToggle();

		System.out.println(radioButton.getText());
	}

}
