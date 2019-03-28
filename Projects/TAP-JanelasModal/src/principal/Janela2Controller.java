package principal;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Janela2Controller {

	@FXML
	Button btnFechar;
	
	@FXML
	Label lblNome;
	
	public void trocaNome(String n) {
		lblNome.setText(n);
	}
	
	@FXML
	public void fechaJanela() {
		Stage stage = (Stage) btnFechar.getScene().getWindow();
		stage.close();
	}
	
}
