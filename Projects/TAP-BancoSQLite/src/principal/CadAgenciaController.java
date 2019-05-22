package principal;

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
import javafx.scene.input.MouseEvent;
import model.Agencia;

public class CadAgenciaController {
	
	public char acao;
	
	@FXML TextField txtNumero;
	@FXML TextField txtCidade;
	@FXML TextField txtFiltro;
	@FXML CheckBox ckInativar;
	@FXML Button btAcao;
	@FXML TableView<Agencia> tblAgencia;
	@FXML TableColumn<Agencia, Double> colId;
	@FXML TableColumn<Agencia, String> colNumero;
	@FXML TableColumn<Agencia, String> colCidade;
	
	private ArrayList<Agencia> lista;
	
	private AgenciaDAO dao = new AgenciaDAO();
	
	@FXML
	public void btAcao() {
		Agencia a = tela4Agencia();
		if (acao != 'A') {
			dao.inserir(a);
		} else {
			dao.atualizar(a);
		}
		limpaTela();
		lista = dao.listaTudo();
		tblAgencia.setItems(FXCollections.observableArrayList(lista));
		btAcao.setText("Novo");
		acao = 'N';
	}
	
	private Agencia tela4Agencia() {
		Agencia a = new Agencia();
		a.setNumero(txtNumero.getText());
		a.setCidade(txtCidade.getText());
		return a;
	}
	
	@FXML
	public void initialize() {
		//lerConfig();
		btAcao.setText("Novo");
		//TableColumn<Person, Number> ageColumn = new TableColumn<Person, Number>("Age");

		colId.setCellValueFactory(cellData -> cellData.getValue().idProperty());
		colNumero.setCellValueFactory(cellData -> cellData.getValue().numeroProperty());
		colCidade.setCellValueFactory(cellData -> cellData.getValue().cidadeProperty());
		lista = dao.listaTudo();
		tblAgencia.setItems(FXCollections.observableArrayList(lista));
	}

	private void limpaTela() {
		txtNumero.setText("");
		txtCidade.setText("");
		txtNumero.requestFocus();
	}
	
	@FXML
	public void clickLinha(MouseEvent event) throws IOException {
		btAcao.setText("Atualizar");
		@SuppressWarnings("unchecked")
		Agencia a = ((TableView<Agencia>) event.getSource()).getSelectionModel().getSelectedItem();
		a.getId();
		txtNumero.setText(a.getNumero());
        txtCidade.setText(a.getCidade());
        acao = 'A';
    }
	
}
