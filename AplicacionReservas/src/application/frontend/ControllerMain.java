package application.frontend;

import java.io.IOException;

import application.Aplicacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ControllerMain {

	@FXML
	
	TextField nameTextField;
	
	@FXML
	TextField cedula;
	
	@FXML
	TextField edad;
	
	@FXML
	TextField telefono;
	
	@FXML
	TextField correo;
	
	@FXML
	TextField presupuesto;
	
	@FXML
	TextField saldo;
	
	Aplicacion app = Aplicacion.getAplicacion();
	Button login;
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	public void login(ActionEvent event) throws IOException {
		
		String username = nameTextField.getText();
		
		
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("Scene2.fxml"));
		root = loader.load();
		
		ControllerScene2 controllerScene2 = loader.getController();
		controllerScene2.displayName(username);
		
		Node node;
		node = (Node) event.getSource();
		stage = (Stage) node.getScene().getWindow(); 
		
		String css = this.getClass().getResource("application.css").toExternalForm();
		
		scene = new Scene(root);
		scene.getStylesheets().add(css);
		stage.setScene(scene);
		stage.show();
		
		app.agregarUsuario(nameTextField.getText(),cedula.getText(), Integer.parseInt(edad.getText()), telefono.getText(), correo.getText(), Double.parseDouble(saldo.getText()),Double.parseDouble(presupuesto.getText())  );
	}
	
	public void displayImage() {
		
	}
}
