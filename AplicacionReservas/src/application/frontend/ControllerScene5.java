package application.frontend;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.backend.Aplicacion;
import application.backend.LugarDeEvento;
import application.backend.empresa.EmpresaPrestadoraServicio;
import application.exceptions.LugarNotFoundException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import javafx.fxml.Initializable;
import application.backend.*;
import application.backend.empresa.*;
import application.backend.reserva.*;
import application.exceptions.*;

public class ControllerScene5 implements Initializable{

	@FXML
	private ListView<String> myListView;
	
	@FXML
	private Aplicacion app = Aplicacion.getAplicacion();
	@FXML
	private Label basico;
	@FXML
	private Label premium;
	@FXML
	private Label deluxe;
	
	@FXML
	private Label info;
	
	private EmpresaPrestadoraServicio[] EmpresasPrestadorasDeServicios = app.getEmpresaPrestadoraServicio();
	private String[] nombres;
	private String currentBasico;
	private String currentPremium;
	private String currentDeluxe;
	private String currentInfo;
	
	@FXML
	private Button inicio;
	@FXML
	private Button generarReserva;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void obtenerNombres() {
		
		nombres = new String[EmpresasPrestadorasDeServicios.length];
		for(int i = 0; i < EmpresasPrestadorasDeServicios.length; i++) {
			nombres[i] = EmpresasPrestadorasDeServicios[i].getNombre();
		}
	}
	

	
	
	
	public void smithcInicio(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(this.getClass().getResource("Scene2.fxml"));
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
	
    public void switchGenerarReserva(ActionEvent event) throws IOException {
		
    	FXMLLoader loader = new FXMLLoader(this.getClass().getResource("Scene4.fxml"));
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





	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}



	
	
}
