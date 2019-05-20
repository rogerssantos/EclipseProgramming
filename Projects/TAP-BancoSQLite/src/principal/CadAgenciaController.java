package principal;

import dao.AgenciaDAO;
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
	@FXML TableView<Agencia> tbl;
	@FXML TableColumn<Agencia, String> colNumero;
	@FXML TableColumn<Agencia, String> colCidade;
	
	private AgenciaDAO dao = new AgenciaDAO();
	
	@FXML public void inserir() {
		Agencia a = tela4Agencia();
		dao.inserir(a);
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
	
}
