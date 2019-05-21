package principal;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import dao.AgenciaDAO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Agencia;

public class CadAgenciaController {
	
	@FXML TextField txtNumero;
	@FXML TextField txtCidade;
	@FXML TextField txtFiltro;
	@FXML CheckBox ckInativar;
	@FXML Button btAcao;
	@FXML TableView<Agencia> tblAgencia;
	@FXML TableColumn<Agencia, String> colNumero;
	@FXML TableColumn<Agencia, String> colCidade;
	
	private ArrayList<Agencia> lista;
	
	private AgenciaDAO dao = new AgenciaDAO();
	
	@FXML
	public void inserir() {
		Agencia a = tela4Agencia();
		dao.inserir(a);
		limpaTela();
		lista = AgenciaDAO.listaTudo();
		tblAgencia.setItems(FXCollections.observableArrayList(lista));
	}
	
	private Agencia tela4Agencia() {
		Agencia a = new Agencia();
		a.setNumero(txtNumero.getText());
		a.setCidade(txtCidade.getText());
		return a;
	}
	
	private void agencia4Tela(Agencia a) {
		txtNumero.setText(a.getNumero());
		txtCidade.setText(a.getCidade());
		
	}
	
	@FXML
	public void initialize() {
		//lerConfig();
		colNumero.setCellValueFactory(cellData -> cellData.getValue().numeroProperty());
		colCidade.setCellValueFactory(cellData -> cellData.getValue().cidadeProperty());
		lista = AgenciaDAO.listaTudo();
		tblAgencia.setItems(FXCollections.observableArrayList(lista));
	}

	private void limpaTela() {
		txtNumero.setText("");
		txtCidade.setText("");
		txtNumero.requestFocus();
	}
}
