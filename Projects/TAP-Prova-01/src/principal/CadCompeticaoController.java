package principal;

import java.util.ArrayList;

import domain.CadCompeticao;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.StageStyle;
import javafx.scene.input.MouseEvent;

public class CadCompeticaoController {
	
	@FXML
	private TextField txtNome;
	@FXML
	private TextField txtDistancia;
	@FXML
	private TextField txtData;
	@FXML
	private TextField txtColocacao;
	@FXML
	private TextField txtMelhorColocacao;
	@FXML
	private TableView<CadCompeticao> tblColocacao;
	@FXML
	private TableColumn<CadCompeticao, String> colNome;
	@FXML
	private TableColumn<CadCompeticao, String> colDistancia;
	@FXML
	private TableColumn<CadCompeticao, String> colData;
	@FXML
	private TableColumn<CadCompeticao, Number> colColocacao;
	
	private ArrayList<CadCompeticao> lista = new ArrayList<CadCompeticao>();
	
	@FXML
	public void initialize() {
		colNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		colDistancia.setCellValueFactory(cellData -> cellData.getValue().distanciaProperty());
		colData.setCellValueFactory(cellData -> cellData.getValue().dataProperty());
		colColocacao.setCellValueFactory(cellData -> cellData.getValue().colocacaoProperty());
	}
	
	@FXML
	public void clickGridCadCompeticao(MouseEvent event) throws IOException {
        
    }

	
	@FXML
	public void cadastra() {
		if (valida()){
			CadCompeticao a = new CadCompeticao();
			a.setNome(txtNome.getText());
			a.setDistancia(txtDistancia.getText());
			a.setData(txtData.getText());
			a.setColocacao(Double.parseDouble(txtColocacao.getText()));
			lista.add(a);
			limpaTela();
			tblColocacao.setItems(FXCollections.observableArrayList(lista));
			txtMelhorColocacao.setText(Double.toString(vlMelhorColocacao()));
		}
	}
	
	private void limpaTela() {
		txtNome.setText("");
		txtDistancia.setText("");
		txtData.setText("");
		txtColocacao.setText("");
		txtNome.requestFocus();
	}
	
	private boolean valida() {
		if (txtNome.getText().contentEquals("")) {
			mensagemErroValidacao("Nome");
			return false;
		}
		if (txtDistancia.getText().contentEquals("")) {
			mensagemErroValidacao("Distancia");
			return false;
		}
		if (txtData.getPromptText().contentEquals("")) {
			mensagemErroValidacao("Data");
			return false;
		}
		if (txtColocacao.getText().contentEquals("")) {
			mensagemErroValidacao("Colocação");
			return false;
		}
		return true;
	}
	
	private void mensagemErroValidacao(String erro) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText("Erro de valicação");
		alert.setContentText("Erro de valicação no campo: " +erro+"\nPreenchimento obrigatório");
		alert.initStyle(StageStyle.UNDECORATED);
		alert.getDialogPane().setStyle("-fx-border-color: black; -fx-border-width: 3;");
		alert.show();
	}
	
	public double vlMelhorColocacao() {
		int i;
		double melhorColocacao = 0;
		for(i = 0; i < lista.size(); i++) {
			if (i == 0) {
				melhorColocacao = lista.get(i).getColocacao();
			}
			if (lista.get(i).getColocacao() < melhorColocacao) {
				melhorColocacao = lista.get(i).getColocacao();
			}
		}
		return melhorColocacao;
	}
	
	// tentei fazer mas nao funcionou
	@FXML
    public void selecionaLinha() {
        TableView<CadCompeticao> table = new TableView<>();
        table.setRowFactory(tv -> {
            TableRow<CadCompeticao> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
            	if (event.getClickCount() == 2 && (! row.isEmpty()) ) {
            		CadCompeticao rowData = row.getItem();
                	for(int i = 0; i < lista.size(); i++) {
            			if (lista.get(i).getNome() == rowData.getNome()) {
            				lista.remove(i);
            			}
            		}
                }
            });
            return row;
        });
	
    }
	
	
}
