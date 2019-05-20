package principal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.StageStyle;
import model.Aluno;

public class PrincipalController {

	public static String configInstituicao;
	public static String configMediaA;
	public static String configMediaR;

	public static void lerConfig() {
		Properties properties = new Properties();
		try {
			FileReader fis = new FileReader("conf.properties");
			properties.load(fis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		configInstituicao = properties.getProperty("nome");
		configMediaA = properties.getProperty("mediaA");
		configMediaR = properties.getProperty("mediaR");
	}

	@FXML
	private TextField txtNome;
	@FXML
	private TextField txtDisciplina;
	@FXML
	private TextField txtNota1;
	@FXML
	private TextField txtNota2;
	@FXML
	private TextField txtNota3;
	@FXML
	private TableView<Aluno> tblAluno;
	@FXML
	private TableColumn<Aluno, String> colNome;
	@FXML
	private TableColumn<Aluno, String> colDisciplina;
	@FXML
	private TableColumn<Aluno, Number> colMedia;
	@FXML
	private TableColumn<Aluno, String> colSituacao;
	@FXML
	private Label lbInstituicao;
	@FXML
	private Label lbMediaR;
	@FXML
	private Label lbMediaA;

	private ArrayList<Aluno> lista = new ArrayList<Aluno>();

	@FXML
	public void initialize() {
		lerConfig();
		lbInstituicao.setText(configInstituicao);
		lbMediaR.setText(configMediaR);
		lbMediaA.setText(configMediaA);
		colNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		colDisciplina.setCellValueFactory(cellData -> cellData.getValue().disciplinaProperty());
		colMedia.setCellValueFactory(cellData -> cellData.getValue().mediaProperty());
		colSituacao.setCellValueFactory(cellData -> cellData.getValue().situacaoProperty());
		leArquivoAluno();
	}

	@FXML
	public void cadastra() {
		if (valida()) {
			Aluno a = new Aluno();
			a.setNome(txtNome.getText());
			a.setDisciplina(txtDisciplina.getText());
			a.setNota1(Double.parseDouble(txtNota1.getText()));
			a.setNota2(Double.parseDouble(txtNota2.getText()));
			a.setNota3(Double.parseDouble(txtNota3.getText()));
			lista.add(a);
			gravaAluno(txtNome.getText(), txtDisciplina.getText(), txtNota1.getText(), txtNota2.getText(),
					txtNota3.getText());
			limpaTela();
			tblAluno.setItems(FXCollections.observableArrayList(lista));
		}
	}

	public void gravaAluno(String nome, String disciplina, String nota1, String nota2, String nota3) {
		try {
			FileWriter fw = new FileWriter("dados.txt", true);
			BufferedWriter bf = new BufferedWriter(fw);
			bf.append(nome + "," + disciplina + "," + nota1 + "," + nota2 + "," + nota3 + "\n");
			bf.close();
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void limpaTela() {
		txtNome.setText("");
		txtDisciplina.setText("");
		txtNota1.setText("");
		txtNota2.setText("");
		txtNota3.setText("");
		txtNome.requestFocus();
	}

	private boolean valida() {
		if (txtNome.getText().contentEquals("")) {
			mensagemErroValidacao("Nome");
			return false;
		}
		if (txtDisciplina.getText().contentEquals("")) {
			mensagemErroValidacao("Disciplina");
			return false;
		}
		if (txtNota1.getText().contentEquals("")) {
			mensagemErroValidacao("Nota 1");
			return false;
		}
		if (txtNota1.getText().contains(",")) {
			mensagemErroValidacaoCaractere("Nota 1");
			return false;
		}
		if (Double.parseDouble(txtNota1.getText()) < 0) {
			mensagemErroValidacaoValorNegativo("Nota 1");
			return false;
		}
		if (txtNota2.getText().contentEquals("")) {
			mensagemErroValidacao("Nota 2");
			return false;
		}
		if (txtNota2.getText().contains(",")) {
			mensagemErroValidacaoCaractere("Nota 2");
			return false;
		}
		if (Double.parseDouble(txtNota2.getText()) < 0) {
			mensagemErroValidacaoValorNegativo("Nota 2");
			return false;
		}
		if (txtNota3.getText().contentEquals("")) {
			mensagemErroValidacao("Nota 3");
			return false;
		}
		if (txtNota3.getText().contains(",")) {
			mensagemErroValidacaoCaractere("Nota 3");
			return false;
		}
		if (Double.parseDouble(txtNota3.getText()) < 0) {
			mensagemErroValidacaoValorNegativo("Nota 3");
			return false;
		}
		return true;
	}

	private void mensagemErroValidacao(String erro) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText("Erro de validacao");
		alert.setContentText("Erro de validacao no campo: " + erro + "\nPreenchimento obrigatorio");
		alert.initStyle(StageStyle.UNDECORATED);
		alert.getDialogPane().setStyle("-fx-border-color: black; -fx-border-width: 3;");
		alert.show();
	}

	private void mensagemErroValidacaoCaractere(String erro) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText("Erro de validacao");
		alert.setContentText(
				"Erro de validacao no campo: " + erro + "\nCaractere ',' não permitido, use '.' para separar decimal.");
		alert.initStyle(StageStyle.UNDECORATED);
		alert.getDialogPane().setStyle("-fx-border-color: black; -fx-border-width: 3;");
		alert.show();
	}

	private void mensagemErroValidacaoValorNegativo(String erro) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setHeaderText("Erro de validacao");
		alert.setContentText("Erro de validacao no campo: " + erro + "\nValor negativo nao permitido.");
		alert.initStyle(StageStyle.UNDECORATED);
		alert.getDialogPane().setStyle("-fx-border-color: black; -fx-border-width: 3;");
		alert.show();
	}

	@FXML
	public void leArquivoAluno() {

		BufferedReader alunos = null;
		try {
			alunos = new BufferedReader(new FileReader("dados.txt"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String line;

		try {
			while ((line = alunos.readLine()) != null) {

				String string = line;
				String[] parts = string.split(",");
				String part1 = parts[0];
				String part2 = parts[1];
				String part3 = parts[2];
				String part4 = parts[3];
				String part5 = parts[4];

				Aluno a = new Aluno();
				a.setNome(part1);
				a.setDisciplina(part2);
				a.setNota1(Double.parseDouble(part3));
				a.setNota2(Double.parseDouble(part4));
				a.setNota3(Double.parseDouble(part5));
				lista.add(a);
				tblAluno.setItems(FXCollections.observableArrayList(lista));

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			alunos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}