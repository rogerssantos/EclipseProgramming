package principal;

import java.io.IOException;
import java.util.ArrayList;

import dao.CorrentistaDAO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Correntista;

public class CadCorrentistaController {
	
	private final int ACAO_ATUALIZAR = 1;
	private final int ACAO_NOVO = 2;
	public int acao;
	
	@FXML TextField txtNome;
	@FXML TextField txtNascimento;
	//@FXML TextField txtFiltro;
	@FXML CheckBox ckInativar;
	@FXML Button btAcao;
	@FXML Button btCancelar;
	@FXML TableView<Correntista> tblCorrentista;
	@FXML TableColumn<Correntista, Integer> colId;
	@FXML TableColumn<Correntista, String> colNome;
	@FXML TableColumn<Correntista, String> colNascimento;
	
	private int id;
	
	private ArrayList<Correntista> lista;
	
	private CorrentistaDAO dao = new CorrentistaDAO();
	
	@FXML
	public void btAcao() {
		Correntista c = tela4Correntista();
		System.out.println(" - " + c.getId());
		if (acao != ACAO_ATUALIZAR) {
			dao.inserir(c);
		} else {
			dao.atualizar(c);
			btCancelar.setDisable(true);
		}
		limpaTela();
		lista = dao.listaTudo();
		tblCorrentista.setItems(FXCollections.observableArrayList(lista));
		btAcao.setText("Novo");
		
		acao = ACAO_NOVO;
	}

	@FXML
	public void btCancelar() {
		limpaTela();
		ckInativar.setDisable(true);
		btCancelar.setDisable(true);
		acao = ACAO_NOVO;
	}
	
	private Correntista tela4Correntista() {
		Correntista c = new Correntista();
		c.setNome(txtNome.getText());
		c.setNascimento(txtNascimento.getText());
		if (ckInativar.isSelected()) {
			c.setStatus("I");
		} else {
			c.setStatus("A");
		}
		c.setId(id);
		return c;
	}
	
	@FXML
	public void initialize() {
		btAcao.setText("Novo");
		colId.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
		colNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		colNascimento.setCellValueFactory(cellData -> cellData.getValue().nascimentoProperty());
		lista = dao.listaTudo();
		tblCorrentista.setItems(FXCollections.observableArrayList(lista));
	}

	private void limpaTela() {
		txtNome.setText("");
		txtNascimento.setText("");
		txtNome.requestFocus();
		ckInativar.setDisable(true);
		btAcao.setText("Novo");
		ckInativar.setSelected(false);
	}
	
	@FXML
	public void clickLinha(MouseEvent event) throws IOException {
		btAcao.setText("Atualizar");
		@SuppressWarnings("unchecked")
		Correntista c = ((TableView<Correntista>) event.getSource()).getSelectionModel().getSelectedItem();
		id = c.getId();
		txtNome.setText(c.getNome());
		txtNascimento.setText(c.getNascimento());
        acao = ACAO_ATUALIZAR;
        ckInativar.setDisable(false);
        btCancelar.setDisable(false);
    }


}
