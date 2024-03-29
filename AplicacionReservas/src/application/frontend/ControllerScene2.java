package application.frontend;

import java.io.IOException;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import application.backend.*;
import application.backend.empresa.*;
import application.backend.reserva.*;
import application.exceptions.*;

public class ControllerScene2 {

	@FXML
	
	
	private Label nameLabel;
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	private Aplicacion app = Aplicacion.getAplicacion();
	
	public void displayName(String username) {
		
		nameLabel.setText("Bienvenid@ " + username + " a TuEvento");
	}
	
	public void verLugares(ActionEvent event) throws IOException {
		
		
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("Scene3.fxml"));
		root = loader.load();

		Node node;
		node = (Node) event.getSource();
		stage = (Stage) node.getScene().getWindow(); 
		
		String css = this.getClass().getResource("application.css").toExternalForm();
		
		scene = new Scene(root);
		scene.getStylesheets().add(css);
		stage.setScene(scene);
		stage.show();
	}
	
	public void verEmpresasPrestadoresServicio(ActionEvent event) throws IOException{
		
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("Scene5.fxml"));
		root = loader.load();

		Node node;
		node = (Node) event.getSource();
		stage = (Stage) node.getScene().getWindow(); 
		
		String css = this.getClass().getResource("application.css").toExternalForm();
		
		scene = new Scene(root);
		scene.getStylesheets().add(css);
		stage.setScene(scene);
		stage.show();
	}
	
   public void cerrarAppConFicheros() {
		
		
		try {
			
			app.escribirEmpresas();
			app.escribirUsuarios();
			app.escribirLugares();
		} catch (ClassNotFoundException | IOException e) {
			
			e.printStackTrace();
		}
	} 
}
