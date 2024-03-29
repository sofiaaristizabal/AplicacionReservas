package application.frontend;

import java.net.URL;

import java.io.IOException;

import application.backend.LugarDeEvento;

import application.backend.reserva.*;
import application.backend.*;
import application.backend.empresa.*;
import application.backend.reserva.*;
import application.exceptions.*;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXMLLoader;
import application.backend.Aplicacion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ControllerScene4 implements Initializable{

	@FXML
	private Label variableLabel;
	
	@FXML
	private ChoiceBox<String> tipoReserva;
	
	@FXML
	private DatePicker seleccionarFecha;
	
	@FXML
	private Label fecha;
	
	@FXML
	private ChoiceBox<String> lugaresEventos;
	
    @FXML
	TextField nameTextField;
    
    @FXML
    private Button reservar;
    
    @FXML
    private Label code;
	
    UserData userData = UserData.getUserData();
    
    private Aplicacion app  = Aplicacion.getAplicacion();
    
	private LugarDeEvento [] lugares;
	private String [] nombres;
	private String cedula;
	private LocalDate myDate;
	private String[] tiposReservas = {"Reserva de lugar", "Reserva de visita"};
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
   

	public void generarReserva() throws NumberFormatException, LugarNotFoundException, UsuarioNotFoundException {
		
		cedula = userData.getCedula();
		
		try {
			if(tipoReserva.getValue().equals("Reserva de lugar")) {
				
			app.crearReservaLugar(this.cedula, app.buscarLugarEvento(lugaresEventos.getValue()), myDate, Integer.parseInt(nameTextField.getText()));
			} else {
				
			app.crearReservaVisita(this.cedula, app.buscarLugarEvento(lugaresEventos.getValue()), myDate, nameTextField.getText());
			}
		} catch (NumberFormatException | LugarNotFoundException | UsuarioNotFoundException e ) {
			System.out.println(e.getMessage());
		
		}
		
		code.setText("En ver reservas puede observar la creación de su reserva");
		
	}
	
	
    public void obtenerNombres() {
    	
	      lugares = app.getLugaresEventos();
		
		nombres = new String[lugares.length];
		for(int i = 0; i < lugares.length; i++) {
			nombres[i] = lugares[i].getNombre();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		initialize1();
		initialize2();
	}
	
	public void initialize1() {
		
        tipoReserva.getItems().addAll(tiposReservas);
		
		tipoReserva.setOnAction(this::getReserva);
	}
    public void initialize2() {
		obtenerNombres();
		lugaresEventos.getItems().addAll(nombres);
	}
	
	
	
	public void getReserva(ActionEvent event) {
		
		String reserva = tipoReserva.getValue();
		
		if(reserva.equals("Reserva de lugar")) {
			variableLabel.setText("Cantidad de personas para el evento");
		} else {
			variableLabel.setText("Hora de visita");
		}
	}
	
	public void getDate(ActionEvent event) {
		
	   myDate = seleccionarFecha.getValue();
		
		fecha.setText(myDate.toString());
	}
	
	 public void switchVerReservas(ActionEvent event) throws IOException {
			
	    	FXMLLoader loader = new FXMLLoader(this.getClass().getResource("Scene6.fxml"));
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
