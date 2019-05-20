package principal;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import util.ConexaoDb;
import util.Constants;

public class ProgramaController {
	
	@FXML
	private TabPane pane;
	
	@FXML
	public void initialize() {
		Constants.conn = ConexaoDb.conectaBd();
	}
	
	@FXML
	public void abreTelaCadAgencia() {
		abreTab("Cadastro de Agencia", "CadAgencia.fxml");
	}
	
	@FXML
	public void abreTelaCadCorrentista() {
		abreTab("Cadastro de Correntistas", "CadCorrentista.fxml");
	}
	
	@FXML
	public void abreTelaCadConta() {
		abreTab("Cadastro de Conta", "CadConta.fxml");
	}
	
	@FXML
	public void abreTelaCadOperacoes() {
		abreTab("Cadastro de Operações", "CadOperacoes.fxml");
	}
	
	private void abreTab(String titulo, String path) {
		try{
			Tab tab = tabAberta(titulo);
			if (tab==null) {
				tab = new Tab(titulo);
				tab.setClosable(true);
				pane.getTabs().add(tab);
				tab.setContent((Node) FXMLLoader.load(getClass().getResource(path)));
			}
			selecionaTab(tab);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private Tab tabAberta(String titulo) {
		for (Tab tb : pane.getTabs()) {
			if(tb.getText().equals(titulo)) 
				return tb;
		}
		return null;
	}
	
	private void selecionaTab(Tab tab) {
		pane.getSelectionModel().select(tab);
	}
	
	
}
