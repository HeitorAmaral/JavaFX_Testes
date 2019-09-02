/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxbasico.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafxbasico.model.Categoria;

/**
 *
 * @author heitor.amaral
 */
public class FXMLComboBoxController implements Initializable {

	@FXML
	private ComboBox<Categoria> cbCategorias;

	private List<Categoria> categorias = new ArrayList<>();

	private ObservableList<Categoria> obsCategorias;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		carregarCategorias();
	}

	public void carregarCategorias() {
		Categoria cat1 = new Categoria(1, "Bebidas");
		Categoria cat2 = new Categoria(2, "Comidas");

		categorias.addAll(Arrays.asList(cat1, cat2));

		obsCategorias = FXCollections.observableArrayList(categorias);

		cbCategorias.setItems(obsCategorias);
	}

}
