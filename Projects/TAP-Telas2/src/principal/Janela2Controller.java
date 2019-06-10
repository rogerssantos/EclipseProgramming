package principal;

import javafx.fxml.FXML;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Janela2Controller {

	@FXML
	Pane panel;
	
	@FXML
	ColorPicker cp;
	
	@FXML
	Label lblNome;
	
	public void trocaNome(String n) {
		lblNome.setText(n);
	}
	
	@FXML
	public void trocaCor() {
		Color c = cp.getValue();
		panel.setStyle("-fx-background-color: rgb("+
		c.getRed()*255+","+
		c.getGreen()*255+","+
		c.getBlue()*255+")");
	}
	
	@FXML
	public void fechaJanela() {
		Stage stage = (Stage) cp.getScene().getWindow();
		stage.close();
	}
}
