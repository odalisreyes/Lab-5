import javafx.application.Application;
/* import javafx.fxml.FXML; */
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * PROPÓSITO: Es el main del programa. Por medio de esta clase se activa el GUI.
 * 
 * @author Javier Anleu 17149
 * @author Odalis Reyes 17032
 * @version 1.0
 * @since November 5th, 2017.
 */
public class Execute extends Application{

	/*@FXML
	ComboBox<String> opcionTipo; */
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage Stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("GUI.fxml"));
		Scene scene = new Scene(root);
		Stage.setScene(scene);
		Stage.show();
		
		/*
		opcionTipo = new ComboBox<>();
		opcionTipo.getItems().addAll("Secundaria", "Bachillerato");
		*/
		
	}

}
