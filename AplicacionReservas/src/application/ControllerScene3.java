package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class ControllerScene3 implements Initializable{

	@FXML
	private Aplicacion app = Aplicacion.getAplicacion();
	
	private ListView<String> myListView;
	private Label capacidad;
	private Label ubicacion;
	private Label PrecioPorHora;
	
	private LugarDeEvento[] lugaresEventos = app.getLugaresEventos();
	private String[] nombres;
	
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
		
		myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				
				capacidad.setText(String.valueOf(app.buscarLugarDeEvento(myListView.getSelectionModel().getSelectedItem()).getCapacidad()));
				ubicacion.setText(app.buscarLugarDeEvento(myListView.getSelectionModel().getSelectedItem()).getUbicacion());
				PrecioPorHora.setText(String.valueOf(app.buscarLugarDeEvento(myListView.getSelectionModel().getSelectedItem()).getPrecioPorHora()));
				
			}
			
		});
	}
	
	
}
