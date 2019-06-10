package principal;

import javafx.fxml.FXML;
import javafx.scene.control.Accordion;
import javafx.stage.Stage;

public class Janela1Controller {
	
	@FXML
	Accordion accordion;
	
	
	@FXML
	public void fechaJanela() {
		Stage stage = (Stage) accordion.getScene().getWindow();
		stage.close();
	}

}
