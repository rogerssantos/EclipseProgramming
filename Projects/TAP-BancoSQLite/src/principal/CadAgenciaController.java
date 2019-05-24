package principal;

import java.io.IOException;
import java.util.ArrayList;

import com.sun.javafx.image.impl.ByteIndexed.Getter;

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
	@FXML TableColumn<Agencia, String> colNumero;
	@FXML TableColumn<Agencia, String> colCidade;
	
	private ArrayList<Agencia> lista;
	private AgenciaDAO dao = new AgenciaDAO();
	private Agencia a = new Agencia();
	
	@FXML
	public void btAcao() {
		Agencia a = tela4Agencia();
		if (acao != ACAO_ATUALIZAR) {
			dao.inserir(a);
		} else {
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
	public void filtrarAgencia() {
		if (txtFiltro.getText().equals("")) {
			lista = dao.listaTudo();
			tblAgencia.setItems(FXCollections.observableArrayList(lista));
		} else {
			lista = dao.filtrar(txtFiltro.getText());
			tblAgencia.setItems(FXCollections.observableArrayList(lista));
		}
	}
	
	@FXML
	public void btCancelar() {
		limpaTela();
		ckInativar.setDisable(true);
		btCancelar.setDisable(true);
		acao = ACAO_NOVO;
	}
	
	private Agencia tela4Agencia() {
		a.setNumero(txtNumero.getText());
		a.setCidade(txtCidade.getText());
		if (ckInativar.isSelected()) {
			a.setStatus("I");
		} else {
			a.setStatus("A");
		}
		return a;
	}
	
	private void agencia4Tela(Agencia a) {
		txtNumero.setText(a.getNumero());
        txtCidade.setText(a.getCidade());
        ckInativar.setDisable(false);
        btCancelar.setDisable(false);
	}
	
	@FXML
	public void initialize() {
		btAcao.setText("Novo");
		colNumero.setCellValueFactory(cellData -> cellData.getValue().numeroProperty());
		colCidade.setCellValueFactory(cellData -> cellData.getValue().cidadeProperty());
		lista = dao.listaTudo();
		tblAgencia.setItems(FXCollections.observableArrayList(lista));
	}

	private void limpaTela() {
		btAcao.setText("Novo");
		txtNumero.setText("");
		txtCidade.setText("");
		txtNumero.requestFocus();
		ckInativar.setDisable(true);
		ckInativar.setSelected(false);
	}
	
	@FXML
	public void clickLinha() {
		a = tblAgencia.getSelectionModel().getSelectedItem();
		if (a != null) {
			btAcao.setText("Atualizar");
			agencia4Tela(a);
			acao = ACAO_ATUALIZAR;
		}
    }
	
}
