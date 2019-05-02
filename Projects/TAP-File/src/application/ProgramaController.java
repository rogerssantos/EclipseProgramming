package application;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.DirectoryChooser;
import model.Arquivo;

public class ProgramaController {
	
	@FXML
	TextField txtCaminho;
	
	@FXML
	private TableView<Arquivo> tblArquivo;
	@FXML
	private TableColumn<Arquivo, String> colNome;
	@FXML
	private TableColumn<Arquivo, String> colTamanho;
	@FXML
	private TableColumn<Arquivo, String> colDtModificacao;
	
	@FXML
	public void initialize() {
		configuraTabela();
	}
	
	public File[] files;
	private File diretorio;
	
	private void configuraTabela() {
		colNome.setCellValueFactory(cellData -> cellData.getValue().nomeProperty());
		colTamanho.setCellValueFactory(cellData -> cellData.getValue().tamanhoProperty());
		colDtModificacao.setCellValueFactory(cellData -> cellData.getValue().dtModificacaoProperty());
	}
	
	private ArrayList<Arquivo> lista = new ArrayList<Arquivo>();
	
	@FXML
	public void abreDiretorio() {
		DirectoryChooser directoryChooser = new DirectoryChooser();
		directoryChooser.setTitle("Seleciona um diretório");
		File file = directoryChooser.showDialog(null);
		if (file!=null) {
			txtCaminho.setText(file.getPath());
			diretorio = new File(txtCaminho.getText());
			if(diretorio.exists() && diretorio.isDirectory()) {
				files = diretorio.listFiles();
				compoeTabela(files);
			}
		}
				
	}
	
	private void compoeTabela(File[] files) {
		lista.clear();
		DateFormat ds = new SimpleDateFormat("dd/MM/yyyy");
		for(File f : files) {
			Arquivo a = new Arquivo();
			a.setNome(f.getName());
			a.setTamanho( f.length()/1024.0/1024.0+"");
			a.setDtModificacao(ds.format(f.lastModified()));
			lista.add(a);
		}
		tblArquivo.setItems(FXCollections.observableArrayList(lista));
	}
	
	@FXML
	public void apagaSelecionado() {
		int indice = tblArquivo.getSelectionModel().getSelectedIndex();
		files[indice].delete();
		files = diretorio.listFiles();
		compoeTabela(files);
	}
	
	public void apagaTodos() {
		for(File f : files) {
			f.delete();
		}
		files = new File[0]; 
		compoeTabela(files);
	}
}
