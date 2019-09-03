package javafxbasico.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafxbasico.model.Categoria;

public class FXMLListViewController implements Initializable {

	@FXML
	private ListView<Categoria> listViewCategoria;

	@FXML
	private TextField textFieldTexto;

	@FXML
	private Label labelTexto;

	@FXML
	private Button buttonAdicionar;

	@FXML
	private Button buttonRemover;

	private List<Categoria> listCategoria = new ArrayList<>();

	private ObservableList<Categoria> obsCategoria;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		carregarCategorias();
		listViewCategoria.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> selecionarCategoria(newValue));
	}

	@FXML
	public void selecionarCategoria(Categoria categoria) {
		if (categoria != null) {
			textFieldTexto.setText(categoria.getNome());
			System.out.println(categoria.getNome());
		}
	}

	@FXML
	public void adicionarCategoria() {
		if (textFieldTexto.getText().trim().equals(null) || textFieldTexto.getText().trim().equals("")) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Erro");
			alert.setHeaderText("Escreva algo para inserir uma nova categoria!");
			alert.setContentText("O texto não deve estar vazio e nem conter espaços em branco!");
			alert.show();
		} else {
			Categoria categoria = new Categoria();
			categoria.setNome(textFieldTexto.getText());
			listCategoria.add(categoria);
		}
		carregarCategorias();
		textFieldTexto.clear();
	}

	@FXML
	public void removerCategoria() {
		Categoria categoria = listViewCategoria.getSelectionModel().getSelectedItem();

		if (categoria == null) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Erro");
			alert.setHeaderText("Escolha um item na lista para remover!");
			alert.setContentText("Clique e selecione o ítem para poder remover!");
			alert.show();
		} else {

			listCategoria.remove(categoria);
		}
		carregarCategorias();
		textFieldTexto.clear();
	}

	@FXML
	public void carregarCategorias() {
		obsCategoria = FXCollections.observableArrayList(listCategoria);
		listViewCategoria.setItems(obsCategoria);
	}

}
