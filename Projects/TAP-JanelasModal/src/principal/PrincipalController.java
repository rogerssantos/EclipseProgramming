package principal;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class PrincipalController {

	@FXML
	ImageView img;
	
	@FXML
	TextField txtNome;

	@FXML
	public void abreJanela1() {
		try {
			Stage stageJanela1 = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Janela1.fxml"));
			Parent root = loader.load();
			stageJanela1.setScene(new Scene(root));
			stageJanela1.initOwner(img.getScene().getWindow());
			stageJanela1.initModality(Modality.WINDOW_MODAL);
			stageJanela1.initStyle(StageStyle.UNDECORATED);
			stageJanela1.setResizable(false);
			stageJanela1.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void abreJanela2() {
		try {
			Stage stageJanela1 = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Janela2.fxml"));
			Parent root = loader.load();
			Janela2Controller controller = loader.getController();
			controller.trocaNome(txtNome.getText());
			stageJanela1.setScene(new Scene(root));
			stageJanela1.initOwner(img.getScene().getWindow());
			stageJanela1.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
