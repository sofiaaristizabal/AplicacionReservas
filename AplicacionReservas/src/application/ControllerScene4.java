package application;

import java.net.URL;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
	
	private Aplicacion app = Aplicacion.getAplicacion();
	private LugarDeEvento [] lugares = app.getLugaresEventos();
	private String [] nombres;
	private String cedula = "123456789";
	private LocalDate myDate;
	
	public void generarReserva() throws NumberFormatException, LugarNotFoundException {
		
		if(tipoReserva.getValue().equals("Reserva de lugar")) {
			
			
			app.crearReservaLugar(cedula, app.buscarLugarEvento(lugaresEventos.getValue()), myDate, Integer.parseInt(nameTextField.getText()));
		} else {
			
			app.crearReservaVisita(cedula, app.buscarLugarEvento(lugaresEventos.getValue()), myDate, nameTextField.getText());
		}
		
	}
	
	private String[] tiposReservas = {"Reserva de lugar", "Reserva de visita"};
	
    public void obtenerNombres() {
		
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
	
}
