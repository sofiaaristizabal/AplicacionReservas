package application.frontend;

import java.io.IOException;


import java.net.URL;
import java.util.ResourceBundle;

import application.backend.Aplicacion;
import application.backend.LugarDeEvento;
import application.exceptions.LugarNotFoundException;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import application.backend.*;
import application.backend.empresa.*;
import application.backend.reserva.*;
import application.exceptions.*;

public class ControllerScene3 implements Initializable{

	@FXML
	private ListView<String> myListView;
	
	@FXML
	private Label capacidad;
	@FXML
	private Label ubicacion;
	@FXML
	private Label PrecioPorHora;
	
	private Aplicacion app = Aplicacion.getAplicacion();
	private LugarDeEvento[] lugaresEventos = app.getLugaresEventos();
	private String[] nombres;
	private String currentCapacidad;
	private String currentUbicacion;
	private String currentPrecioPorHora;
	
	@FXML
	private Button inicio;
	@FXML
	private Button generarReserva;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public void obtenerNombres() {
		
		nombres = new String[lugaresEventos.length];
		for(int i = 0; i < lugaresEventos.length; i++) {
			nombres[i] = lugaresEventos[i].getNombre();
		}
	}
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		obtenerNombres();
		
		myListView.getItems().addAll(nombres);
		
		System.out.println(app.getLugaresEventos().length);
		
		
		myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				
				
				
				try {
					
					currentCapacidad = String.valueOf(app.buscarLugarEvento(myListView.getSelectionModel().getSelectedItem()).getCapacidad());
					currentUbicacion = app.buscarLugarEvento(myListView.getSelectionModel().getSelectedItem()).getUbicacion();
					currentPrecioPorHora = String.valueOf(app.buscarLugarEvento(myListView.getSelectionModel().getSelectedItem()).getPrecioPorHora());
				} catch (LugarNotFoundException e) {
					
					e.printStackTrace();
				}
				
				capacidad.setText("Capacidad: " + currentCapacidad);
				ubicacion.setText(currentUbicacion);
				PrecioPorHora.setText("Precio por hora: "+ currentPrecioPorHora);
				
			}
			
			
		});
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
	
}
