package principal;

import java.util.ArrayList;

import domain.Cidade;
import domain.Estado;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class Tela2Controller {
	
	ArrayList<Estado> listaEstado = new ArrayList<Estado>();
	ArrayList<Cidade> listaCidade = new ArrayList<Cidade>();
	
	@FXML
	ComboBox<Estado> cbEstado;
	@FXML
	ComboBox<Cidade> cbCidade;
	
	
	@FXML
	public void initialize() {
		criaEstados();
		criaCidades();
		cbEstado.setItems(FXCollections.observableArrayList(listaEstado));
		eventoChangeComboUF();
		cbEstado.getSelectionModel().select(0);
		filtraCidades();
	}
	
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
	
	private void filtraCidades() {
		Estado ufSelecionada = cbEstado.getSelectionModel().getSelectedItem();
		ArrayList<Cidade> nova = new ArrayList<Cidade>();
		for (Cidade c : listaCidade) {
			if(c.getEstado().getNome().equals(ufSelecionada.getNome()))
				nova.add(c);
		}
		cbCidade.setItems(FXCollections.observableArrayList(nova));
	}
	
	private void eventoChangeComboUF() {
		cbEstado.valueProperty().addListener(new ChangeListener<Estado>() {
			public void changed(javafx.beans.value.ObservableValue<? extends Estado> observable, Estado oldValue, Estado newValue) {
				filtraCidades();
			};
		});
	}

}
