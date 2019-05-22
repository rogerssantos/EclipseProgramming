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
	
	private final int ACAO_ATUALIZAR = 1;
	private final int ACAO_NOVO = 2;
	public int acao;
	
	@FXML TextField txtNumero;
	@FXML TextField txtCidade;
	@FXML TextField txtFiltro;
	@FXML CheckBox ckInativar;
	@FXML Button btAcao;
	@FXML Button btCancelar;
	@FXML TableView<Agencia> tblAgencia;
	@FXML TableColumn<Agencia, Integer> colId;
	@FXML TableColumn<Agencia, String> colNumero;
	@FXML TableColumn<Agencia, String> colCidade;
	@FXML TableColumn<Agencia, String> colStatus;
	
	private int id;
	private String status;
	
	private ArrayList<Agencia> lista;
	
	private AgenciaDAO dao = new AgenciaDAO();
	
	@FXML
	public void btAcao() {
		Agencia a = tela4Agencia();
		if (acao != ACAO_ATUALIZAR) {
			dao.inserir(a);
		} else {
			if (!ckInativar.isSelected()) {
				a.setStatus("A");
			}
			dao.atualizar(a);
			btCancelar.setDisable(true);
		}
		limpaTela();
		lista = dao.listaTudo();
		tblAgencia.setItems(FXCollections.observableArrayList(lista));
		btAcao.setText("Novo");
		
		acao = ACAO_NOVO;
	}

	@FXML
	public void btCancelar() {
		limpaTela();
		btCancelar.setDisable(true);
		acao = ACAO_NOVO;
	}
	
	private Agencia tela4Agencia() {
		Agencia a = new Agencia();
		a.setNumero(txtNumero.getText());
		a.setCidade(txtCidade.getText());
		if (status != "A") {
			ckInativar.setSelected(false);
		}
		a.setId(id);
		return a;
	}
	
	@FXML
	public void initialize() {
		//lerConfig();
		btAcao.setText("Novo");
		colId.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
		colNumero.setCellValueFactory(cellData -> cellData.getValue().numeroProperty());
		colCidade.setCellValueFactory(cellData -> cellData.getValue().cidadeProperty());
		colStatus.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
		lista = dao.listaTudo();
		tblAgencia.setItems(FXCollections.observableArrayList(lista));
	}

	private void limpaTela() {
		txtNumero.setText("");
		txtCidade.setText("");
		txtNumero.requestFocus();
		ckInativar.setDisable(true);
		btAcao.setText("Novo");
	}
	
	@FXML
	public void clickLinha(MouseEvent event) throws IOException {
		btAcao.setText("Atualizar");
		@SuppressWarnings("unchecked")
		Agencia a = ((TableView<Agencia>) event.getSource()).getSelectionModel().getSelectedItem();
		id = a.getId();
		status = a.getStatus();
		txtNumero.setText(a.getNumero());
        txtCidade.setText(a.getCidade());
        acao = ACAO_ATUALIZAR;
        ckInativar.setDisable(false);
        btCancelar.setDisable(false);
    }
	
}
