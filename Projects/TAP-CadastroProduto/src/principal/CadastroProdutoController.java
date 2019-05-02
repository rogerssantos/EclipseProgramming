package principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.StageStyle;
import model.Produto;
import model.Unidade;

public class CadastroProdutoController {
	
	@FXML
	private TextField txtProduto;
	@FXML
	private TextField txtValor;
	@FXML
	private TextField txtEstoque;
	@FXML
	private ComboBox<Unidade> cbUnidade;
	@FXML
	private TableView<Produto> tblProduto;
	@FXML
	private TableColumn<Produto, String> colProduto;
	@FXML
	private TableColumn<Produto, Number> colValor;
	@FXML
	private TableColumn<Produto, Number> colEstoque;
	@FXML
	private TableColumn<Produto, String> colUnidade;
	
	private ArrayList<Produto> lista = new ArrayList<Produto>();
	
	private List<Unidade> unidades = new ArrayList<Unidade>();
	
	@FXML
	public void initialize() {
		colProduto.setCellValueFactory(cellData -> cellData.getValue().produtoProperty());
		colValor.setCellValueFactory(cellData -> cellData.getValue().valorProperty());
		colEstoque.setCellValueFactory(cellData -> cellData.getValue().estoqueProperty());
		colUnidade.setCellValueFactory(cellData -> cellData.getValue().unidadeProperty());
		loadUnidades();
		leArquivoProduto();
	}
	
	@FXML
	public void cadastra() {
		if (valida()){
			Produto p = new Produto();
			p.setProduto(txtProduto.getText());
			p.setValor(Double.parseDouble(txtValor.getText()));
			p.setEstoque(Double.parseDouble(txtEstoque.getText()));
			p.setUnidade(cbUnidade.getSelectionModel().getSelectedItem().toString());
			lista.add(p);
			gravaProduto(txtProduto.getText(), txtValor.getText(), txtEstoque.getText(), cbUnidade.getSelectionModel().getSelectedItem().toString());
			limpaTela();
			tblProduto.setItems(FXCollections.observableArrayList(lista));
		}
	}
	
	private void limpaTela() {
		txtProduto.setText("");
		txtValor.setText("");
		txtEstoque.setText("");
		//txtUnidade.setText("");
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
		if (txtEstoque.getText().contentEquals("")) {
			mensagemErroValidacao("Estoque");
			return false;
		}
		return true;
	}
	
	private void mensagemErroValidacao(String erro) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText("Erro de validacao");
		alert.setContentText("Erro de validacao no campo: " +erro+"\nPreenchimento obrigatorio");
		alert.initStyle(StageStyle.UNDECORATED);
		alert.getDialogPane().setStyle("-fx-border-color: black; -fx-border-width: 3;");
		alert.show();
	}
	
	public void loadUnidades() {
		
		BufferedReader uni = null;
		try {
			uni = new BufferedReader(new FileReader(".\\src\\src\\Unidade.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		String line;
		
		try {
			while((line = uni.readLine()) != null) {
				Unidade unidade1 = new Unidade(line);
				unidades.add(unidade1);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			uni.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		cbUnidade.setItems(FXCollections.observableArrayList(unidades));
		
	}
	
	public void gravaProduto(String produto, String valor, String estoque, String unidade) {
		try{
			FileWriter fw = new FileWriter(".\\\\src\\\\src\\\\Produto.txt", true);
			BufferedWriter bf = new BufferedWriter(fw);
			bf.append(produto + ";" + valor + ";" + estoque + ";" + unidade + "\n");
			bf.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void resetCadastroProduto() {
		try{
			FileWriter fw = new FileWriter(".\\\\src\\\\src\\\\Produto.txt", false);
			BufferedWriter bf = new BufferedWriter(fw);
			fw.write("");
			bf.close();
		}catch (Exception e) {
			e.printStackTrace();
		}
		limpaTela();
		tblProduto.setItems(FXCollections.observableArrayList());
		tblProduto.getItems().clear();
	}
	
	@FXML
	public void leArquivoProduto() {
		
		BufferedReader produtos = null;
		try {
			produtos = new BufferedReader(new FileReader(".\\\\src\\\\src\\\\Produto.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		String line;
		
		try {
			while((line = produtos.readLine()) != null) {

				String string = line;
				String[] parts = string.split(";");
				String part1 = parts[0];
				String part2 = parts[1];
				String part3 = parts[2];
				String part4 = parts[3];
				
				Produto p = new Produto();
				p.setProduto(part1);
				p.setValor(Double.parseDouble(part2));
				p.setEstoque(Double.parseDouble(part3));
				p.setUnidade(part4);
				lista.add(p);
				tblProduto.setItems(FXCollections.observableArrayList(lista));
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			produtos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
	
}
