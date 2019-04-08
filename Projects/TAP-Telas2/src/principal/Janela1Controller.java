package principal;

import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Janela1Controller {

	@FXML
	Button btnFechar;
	
	public void fechaJanela1() {
		Stage stage = (Stage) btnFechar.getScene().getWindow();
		stage.close();
	}
	
}
