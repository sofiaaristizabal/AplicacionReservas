package application.frontend;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import application.backend.*;
import application.backend.reserva.*;
import application.backend.empresa.*;
import application.backend.LugarDeEvento;
import application.exceptions.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

public class ControllerScene7 implements Initializable{

	@FXML
	private Label variableLabel;
	
	@FXML
	private ChoiceBox<String> empresa;

	@FXML
	private ChoiceBox<String> tipoPlan;
	
	@FXML
	private DatePicker seleccionarFecha;
	
	@FXML
	private Label fecha;
	
	@FXML
	private TextField codigo;
	
    
    @FXML
    private Button generarContrato;
	
    UserData userData = UserData.getUserData();
    
    private Aplicacion app  = Aplicacion.getAplicacion();
    
	private EmpresaPrestadoraServicio [] empresas;
	private String [] nombres;
	private String cedula;
	private LocalDate myDate;
	private String[] tiposDePlan = {"Basico", "Premium", "Deluxe"};
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
   

	public void generarContrato() throws NumberFormatException, LugarNotFoundException, UsuarioNotFoundException {
		
		cedula = userData.getCedula();
		
		try {
			
			app.agregarContrato(cedula, codigo.getText(), app.buscarEmpresaPrestadoraDeServicios(empresa.getValue()) , myDate, tipoPlan.getValue());
			
		} catch (NumberFormatException | UsuarioNotFoundException | ReservaNotFoundException | EmpresaPrestadoraServicioNotFoundException e ) {
			System.out.println(e.getMessage());
		
		}
		
	    variableLabel.setText("Vuelva a reservas para confirmar que el contrato ha sido generado");
	}
	
	
    public void obtenerNombres() {
    	
	     empresas = app.getEmpresaPrestadoraServicio();
		
		nombres = new String[empresas.length];
		for(int i = 0; i < empresas.length; i++) {
			nombres[i] = empresas[i].getNombre();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		initialize1();
		initialize2();
	}
	
	public void initialize1() {
		
        tipoPlan.getItems().addAll(tiposDePlan);
		
		//tipoPlan.setOnAction(this::getReserva);
	}
    public void initialize2() {
		obtenerNombres();
		empresa.getItems().addAll(nombres);
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
	 
	 public void smithcVerInfoEmpresas(ActionEvent event) throws IOException {
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


}
