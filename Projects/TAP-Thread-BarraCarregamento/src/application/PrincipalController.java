package application;


import domain.Trabalhador;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class PrincipalController {
	
	@FXML
	TextField txtQt1;
	@FXML
	TextField txtTempo1;
	
	@FXML
	TextField txtQt2;
	@FXML
	TextField txtTempo2;
	
	@FXML
	ProgressBar prog1;
	
	@FXML
	ProgressBar prog2;
	
	private Trabalhador t1;
	private Trabalhador t2;
	
	@FXML
	public void iniciarSemThread() {
		instanciaObjs();
		t1.inicia();
		t2.inicia();
	}
	
	@FXML
	public void iniciarComThread() {
		instanciaObjs();
		new Thread(t1).start();
		new Thread(t2).start();
	}
	
	private void instanciaObjs() {
		t1 = new Trabalhador(Integer.parseInt(txtQt1.getText()),Long.parseLong(txtTempo1.getText()),prog1);
		t2 = new Trabalhador(Integer.parseInt(txtQt2.getText()),Long.parseLong(txtTempo2.getText()),prog2);
	}
}
