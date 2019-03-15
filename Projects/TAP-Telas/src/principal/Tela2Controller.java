package principal;

import java.util.ArrayList;

import domain.Cidade;
import domain.Estado;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class Tela2Controller {
	
	ArrayList<Estado> listaEstado = new ArrayList<Estado>();
	ArrayList<Cidade> listaCidade = new ArrayList<Cidade>();
	
	@FXML
	ComboBox<Estado> cbEstado;
	@FXML
	ComboBox<Cidade> cbCidade;
	
	private void criaEstados() {
		listaEstado.add(new Estado("SC"));
		listaEstado.add(new Estado("RS"));
	}
	
	private void criaCidades() {
		listaCidade.add(new Cidade("Tubarão", listaEstado.get(0)));
		listaCidade.add(new Cidade("Gravatal", listaEstado.get(0)));
		listaCidade.add(new Cidade("Braço do Norte", listaEstado.get(0)));
		listaCidade.add(new Cidade("Porto Alegre", listaEstado.get(1)));
		listaCidade.add(new Cidade("Guaiba", listaEstado.get(1)));
	}
	
	@FXML
	public void initialize() {
		criaEstados();
		criaCidades();
		cbEstado.setItems(FXCollections.observableArrayList(listaEstado));
		cbCidade.setItems(FXCollections.observableArrayList(listaCidade));
	}

}
