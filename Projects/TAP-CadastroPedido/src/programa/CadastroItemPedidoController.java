package programa;

import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.StageStyle;
import model.ItemPedido;

public class CadastroItemPedidoController {

	@FXML
	private TextField txtProduto;
	@FXML
	private TextField txtValor;
	@FXML
	private TextField txtQuantidade;
	@FXML
	private TableView<ItemPedido> tblItemPedido;
	@FXML
	private TableColumn<ItemPedido, String> colProduto;
	@FXML
	private TableColumn<ItemPedido, Number> colValor;
	@FXML
	private TableColumn<ItemPedido, Number> colQuantidade;
	@FXML
	private TableColumn<ItemPedido, Number> colValorTotalItemPedido;
	@FXML
	private TextField txtVlTotalPedido;
	
	private ArrayList<ItemPedido> lista = new ArrayList<ItemPedido>();
	
	@FXML
	public void initialize() {
		colProduto.setCellValueFactory(cellData -> cellData.getValue().produtoProperty());
		colValor.setCellValueFactory(cellData -> cellData.getValue().valorProperty());
		colQuantidade.setCellValueFactory(cellData -> cellData.getValue().quantidadeProperty());
		colValorTotalItemPedido.setCellValueFactory(cellData -> cellData.getValue().valorTotalItemPedidoProperty());
		//txtVlTotalPedido;
	}
	
	@FXML
	public void cadastra() {
		if (valida()){
			ItemPedido a = new ItemPedido();
			a.setProduto(txtProduto.getText());
			a.setValor(Double.parseDouble(txtValor.getText()));
			a.setQuantidade(Double.parseDouble(txtQuantidade.getText()));
			lista.add(a);
			limpaTela();
			tblItemPedido.setItems(FXCollections.observableArrayList(lista));
			txtVlTotalPedido.setText(Double.toString(vlTotalItens()));
		}
	}
	
	private void limpaTela() {
		txtProduto.setText("");
		txtValor.setText("");
		txtQuantidade.setText("");
		txtProduto.requestFocus();
	}
	
	private boolean valida() {
		if (txtProduto.getText().contentEquals("")) {
			mensagemErroValidacao("Produto");
			return false;
		}
		if (txtValor.getText().contentEquals("")) {
			mensagemErroValidacao("Valor");
			return false;
		}
		if (txtQuantidade.getText().contentEquals("")) {
			mensagemErroValidacao("Quantidade");
			return false;
		}
		return true;
	}
	
	// mensagem de erro campo não preenchido
	private void mensagemErroValidacao(String erro) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText("Erro de validação");
		alert.setContentText("Erro de validação no campo: " +erro+"\nPreenchimento obrigatório");
		alert.initStyle(StageStyle.UNDECORATED);
		alert.getDialogPane().setStyle("-fx-border-color: black; -fx-border-width: 3;");
		alert.show();
	}
	
	// soma valor total dos itens percorrendo a array
	public double vlTotalItens() {
		int i;
		double soma = 0;
		for(i = 0; i < lista.size(); i++)
			soma += lista.get(i).getValorTotalItemPedido();
		return soma;
	}
	
}
