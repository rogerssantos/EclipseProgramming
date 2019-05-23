package principal;

import java.io.IOException;
import java.util.ArrayList;

import dao.ContaDAO;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Conta;

public class CadContaController {
	
	private final int ACAO_ATUALIZAR = 1;
	private final int ACAO_NOVO = 2;
	public int acao;
	
	@FXML TextField txtAgencia;
	@FXML TextField txtCorrentista;
	@FXML TextField txtSaldo;
	//@FXML TextField txtFiltro;
	@FXML CheckBox ckInativar;
	@FXML Button btAcao;
	@FXML Button btCancelar;
	@FXML TableView<Conta> tblConta;
	@FXML TableColumn<Conta, Integer> colId;
	@FXML TableColumn<Conta, String> colAgencia;
	@FXML TableColumn<Conta, String> colCorrentista;
	@FXML TableColumn<Conta, Double> colSaldo;
	
	private int id;
	
	private ArrayList<Conta> lista;
	
	private ContaDAO dao = new ContaDAO();
	
	@FXML
	public void btAcao() {
		Conta c = tela4Conta();
		System.out.println(" - " + c.getId());
		if (acao != ACAO_ATUALIZAR) {
			dao.inserir(c);
		} else {
			dao.atualizar(c);
			btCancelar.setDisable(true);
		}
		limpaTela();
		lista = dao.listaTudo();
		tblConta.setItems(FXCollections.observableArrayList(lista));
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
	
	private Conta tela4Conta() {
		Conta c = new Conta();
		c.setAgencia(txtAgencia.getText());
		c.setCorrentista(txtCorrentista.getText());
		c.setSaldo(Double.parseDouble(txtSaldo.getText()));
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
		colAgencia.setCellValueFactory(cellData -> cellData.getValue().agenciaProperty());
		colCorrentista.setCellValueFactory(cellData -> cellData.getValue().correntistaProperty());
		colSaldo.setCellValueFactory(cellData -> cellData.getValue().saldoProperty().asObject());
		lista = dao.listaTudo();
		tblConta.setItems(FXCollections.observableArrayList(lista));
	}

	private void limpaTela() {
		txtAgencia.setText("");
		txtCorrentista.setText("");
		txtSaldo.setText("");
		txtAgencia.requestFocus();
		ckInativar.setDisable(true);
		btAcao.setText("Novo");
		ckInativar.setSelected(false);
	}
	
	@FXML
	public void clickLinha(MouseEvent event) throws IOException {
		btAcao.setText("Atualizar");
		@SuppressWarnings("unchecked")
		Conta c = ((TableView<Conta>) event.getSource()).getSelectionModel().getSelectedItem();
		id = c.getId();
		System.out.println(" - " + c.getId());
		System.out.println(" - " + c.getAgencia());
        txtAgencia.setText(c.getAgencia());
		txtCorrentista.setText(c.getCorrentista());
		txtSaldo.setText(c.getSaldo() + "");
        acao = ACAO_ATUALIZAR;
        ckInativar.setDisable(false);
        btCancelar.setDisable(false);
    }


}
