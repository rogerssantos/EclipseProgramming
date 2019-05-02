package principal;


import domain.Atleta;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class AtletaController {
	
	@FXML
	TextField txtDistancia1;
	@FXML
	TextField txtTempo1;
	
	@FXML
	TextField txtDistancia2;
	@FXML
	TextField txtTempo2;
	
	@FXML
	ProgressBar prog1;
	
	@FXML
	ProgressBar prog2;
	
	private Atleta a1;
	private Atleta a2;
	
	@FXML
	public void iniciarComThread() {
		instanciaObjs();
		new Thread(a1).start();
		new Thread(a2).start();
	}
	
	private void instanciaObjs() {
		a1 = new Atleta(Integer.parseInt(txtDistancia1.getText()),Long.parseLong(txtTempo1.getText()),prog1);
		a2 = new Atleta(Integer.parseInt(txtDistancia2.getText()),Long.parseLong(txtTempo2.getText()),prog2);
	}
}
