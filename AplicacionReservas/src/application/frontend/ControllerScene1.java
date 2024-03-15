package application.frontend;

import java.io.IOException;

import application.backend.*;
import application.backend.empresa.*;
import application.backend.reserva.*;
import application.exceptions.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerScene1 {

	
	@FXML 
	private TextField usuario;
	
	@FXML 
	private TextField cedula;
	
	@FXML 
	private Button login;
	
	@FXML
	private Label variable;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	private UserData userData = UserData.getUserData();
	private Aplicacion app = Aplicacion.getAplicacion();
	
	
	public void iniciarSesion(ActionEvent event) throws IOException{
		
		String ID = cedula.getText();
		
		try {
			userData.setCedula(app.buscarUsuario(ID).getCedula());
			userData.setNombre(app.buscarUsuario(ID).getNombre());
			userData.setEdad(app.buscarUsuario(ID).getEdad());
			userData.setTelefono(app.buscarUsuario(ID).getTelefono());
			userData.setCorreo(app.buscarUsuario(ID).getCorreo());
			userData.setSaldo(app.buscarUsuario(ID).getSaldo());
			userData.setPresupuesto(app.buscarUsuario(ID).getPresupuesto());
		} catch (UsuarioNotFoundException e1) {
			
			e1.printStackTrace();
		}
		
		try {
			app.buscarUsuario(ID);
			
			FXMLLoader loader = new FXMLLoader(this.getClass().getResource("Scene2.fxml"));
			root = loader.load();
			ControllerScene2 controllerScene2 = loader.getController();	
			
			Node node;
			node = (Node) event.getSource();
			stage = (Stage) node.getScene().getWindow(); 
			
			String css = this.getClass().getResource("application.css").toExternalForm();
			
			scene = new Scene(root);
			scene.getStylesheets().add(css);
			stage.setScene(scene);
			stage.show();
			
		} catch (UsuarioNotFoundException e) {
			e.printStackTrace();
			variable.setText("Usuario con cedula: " + ID + " no existe");
		}
		
	}
	
	public void registrarme(ActionEvent event) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("Main.fxml"));
		root = loader.load();
		ControllerMain controllerMain = loader.getController();	
		
		Node node;
		node = (Node) event.getSource();
		stage = (Stage) node.getScene().getWindow(); 
		
		String css = this.getClass().getResource("application.css").toExternalForm();
		
		scene = new Scene(root);
		scene.getStylesheets().add(css);
		stage.setScene(scene);
		stage.show();
		
	}
	
}
