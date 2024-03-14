package application.frontend;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ResourceBundle;

import application.backend.Aplicacion;
import application.backend.reserva.Reserva;
import application.backend.reserva.ReservaLugar;
import application.backend.reserva.ReservaVisita;
import application.backend.LugarDeEvento;
import application.exceptions.LugarNotFoundException;
import application.exceptions.ReservaNotFoundException;
import application.exceptions.UsuarioNotFoundException;
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

public class ControllerScene6 implements Initializable{

	@FXML
	private ListView<String> myListView;
	
	@FXML
	private Label lugarEvento;
	@FXML
	private Label fechaGeneracion;
	@FXML
	private Label fechaReserva;
	@FXML
	private Label variable;
	
	
	private Reserva[] reservas;
	private String[] codigos;
	private String currentLugarEvento;
	private String currentFechaGeneracion;
	private String currentFechaReserva;
	private String currentVariable;
	private UserData userData = UserData.getUserData();
	
	@FXML
	private Button inicio;
	@FXML
	private Button generarReserva;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	private Aplicacion app = Aplicacion.getAplicacion();
	
	public void obtenerCodigos() {
		
		
	    try {
			reservas = app.buscarUsuario(userData.getCedula()).getReservas();
		} catch (UsuarioNotFoundException e) {
			e.printStackTrace();
		} 
	      
		codigos = new String[reservas.length];
		for(int i = 0; i < reservas.length; i++) {
			codigos[i] = reservas[i].getCodigo().toString();
		}
	}
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		obtenerCodigos();
		
		myListView.getItems().addAll(codigos);
		
		
		myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				
				
				
		
				try {
					
					currentLugarEvento = app.buscarUsuario(userData.getCedula()).buscarReserva(myListView.getSelectionModel().getSelectedItem()).getLugarEvento().getNombre();
					
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					currentFechaGeneracion = sdf.format(app.buscarUsuario(userData.getCedula()).buscarReserva(myListView.getSelectionModel().getSelectedItem()).getFechaGeneracion());
					LocalDate ld = app.buscarUsuario(userData.getCedula()).buscarReserva(myListView.getSelectionModel().getSelectedItem()).getFechaReserva();
					currentFechaReserva = ld.toString();
					if (app.buscarUsuario(userData.getCedula()).buscarReserva(myListView.getSelectionModel().getSelectedItem()) instanceof ReservaLugar) {
					 
						ReservaLugar e = (ReservaLugar) app.buscarUsuario(userData.getCedula()).buscarReserva(myListView.getSelectionModel().getSelectedItem());
						currentVariable = String.valueOf(e.getCantidadPersonas());
						variable.setText("Cantidad de personas ppara el evento" + currentVariable);
						
					} else {
						
						ReservaVisita e = (ReservaVisita)app.buscarUsuario(userData.getCedula()).buscarReserva(myListView.getSelectionModel().getSelectedItem());
						currentVariable = String.valueOf(e.getHora());
						variable.setText("Hora de la visita " + currentVariable);
					}
				} catch (UsuarioNotFoundException | ReservaNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				lugarEvento.setText("Lugar del evento: " + currentLugarEvento);
				fechaGeneracion.setText("Fecha generacion reserva: " + currentFechaGeneracion);
				fechaReserva.setText("Fecha del evento: "+ currentFechaReserva);
				
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
