package programa;

import java.util.ArrayList;

import java.io.File;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.StageStyle;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.ItemPedido;

public class CadastroItemPedidoController {
	
	@FXML
	private ImageView img;
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
	
	//@FXML
	public void clickAbreItemPedido() {
		try {
			Stage stageAbreItemPedido = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AbreItemPedido.fxml"));
			Parent root = loader.load();
			AbreItemPedido controller = loader.getController();
			stageAbreItemPedido.setScene(new Scene(root));
			stageAbreItemPedido.initOwner(img.getScene().getWindow());
			stageAbreItemPedido.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void clickGridItemPedido(MouseEvent event) throws IOException {

			Stage stageAbreItemPedido = new Stage();

			FXMLLoader loader = new FXMLLoader(getClass().getResource("AbreItemPedido.fxml"));
			Parent root = loader.load();
			
            AbreItemPedido controller = loader.getController();
            ItemPedido i = ((TableView<ItemPedido>) event.getSource()).getSelectionModel().getSelectedItem(); 
            controller.setItemPedido(i);
            stageAbreItemPedido.setScene(new Scene(root));
            stageAbreItemPedido.initOwner(img.getScene().getWindow());
			stageAbreItemPedido.show();
			
            Parent p = loader.getRoot();
            Stage stage = new Stage();
            stage.setScene(new Scene(p));
            stage.show();
        
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


	@FXML
	public void abreImagem() {
		File f = selecionaImagem();
		if (f != null) {
			Image i = new Image(f.toURI().toString());
			img.setImage(i);
			img.setFitWidth(250);
			img.setFitHeight(250);
		}
	}

	private File selecionaImagem() {
		FileChooser dialogo = new FileChooser();
		dialogo.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imagens", "*.jpg", "*.JPG", "*.png", "*.PNG",
				"*.gif", "*.GIF", "*.bmp", "*.BMP"));
		dialogo.setInitialDirectory(new File("C:\\Users\\roger\\OneDrive\\Imagens\\Wallpapers"));
		return dialogo.showOpenDialog(null);
	}
	
	@FXML
    public void selecionaLinha() {
        TableView<ItemPedido> table = new TableView<>();
        table.setRowFactory(tv -> {
            TableRow<ItemPedido> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
                	ItemPedido rowData = row.getItem();
                    System.out.println("Double click on: "+rowData.getProduto());
                }
            });
            return row ;
        });
	
    }
	
	
}
