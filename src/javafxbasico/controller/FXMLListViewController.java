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
import javafx.scene.control.MultipleSelectionModel;
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

	}

	public void adicionarCategorias() {
		Categoria categoria = new Categoria();
		categoria.setNome(textFieldTexto.getText());
		listCategoria.add(categoria);
		textFieldTexto.clear();
		carregarCategorias();
	}

	public void editarCategoria() {
		MultipleSelectionModel<Categoria> categoriaSelected = listViewCategoria.getSelectionModel();
		textFieldTexto.setText(categoriaSelected.getSelectedItem().getNome());
		categoriaSelected.getSelectedItem().setNome(textFieldTexto.getText());
		textFieldTexto.clear();
		System.out.println(categoriaSelected.getSelectedIndex());
	}

	public void removerCategoria() {
		int selectedIndex = listViewCategoria.getSelectionModel().getSelectedIndex();

		if (selectedIndex < 0) {
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Erro");
			alert.setHeaderText("Escolha um item na lista para remover!");
			alert.setContentText("Clique e selecione o ítem para poder remover!");
			alert.show();
		} else {
			listCategoria.remove(selectedIndex);
			carregarCategorias();
		}

	}

	public void carregarCategorias() {
		obsCategoria = FXCollections.observableArrayList(listCategoria);
		listViewCategoria.setItems(obsCategoria);
	}

}
