package application.frontend;

import java.io.IOException;

import java.net.URL;
import java.util.ResourceBundle;
import application.backend.Aplicacion;
import application.exceptions.EmpresaPrestadoraServicioNotFoundException;
import application.backend.empresa.EmpresaCatering;
import application.backend.empresa.EmpresaDecoradora;
import application.backend.empresa.EmpresaLimpieza;
import application.backend.empresa.EmpresaPrestadoraServicio;
import application.backend.empresa.EmpresaSonido;
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

public class ControllerScene5 implements Initializable{

	@FXML
	private ListView<String> myListView;
	
	
	private Aplicacion app = Aplicacion.getAplicacion();
	
	@FXML
	private Label basico;
	@FXML
	private Label premium;
	@FXML
	private Label deluxe;
	
	@FXML
	private Label variable1;
	
	@FXML
	private Label variable2;
	
	@FXML
	private Label variable3;
	
	private EmpresaPrestadoraServicio[] EmpresasPrestadorasDeServicios = app.getEmpresaPrestadoraServicio();
	private String[] empresas;
	private String currentBasico;
	private String currentPremium;
	private String currentDeluxe;
	private String var1;
	private String var2;
	private String var3;
	
	
	@FXML
	private Button inicio;
	@FXML
	private Button generarReserva;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
    public void obtenerNombres() {
		
		empresas = new String[EmpresasPrestadorasDeServicios.length];
		for(int i = 0; i < EmpresasPrestadorasDeServicios.length; i++) {
			empresas[i] = EmpresasPrestadorasDeServicios[i].getNombre();
		}
	}

    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
    	obtenerNombres();
    	
       myListView.getItems().addAll(empresas);
		
		
	   myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				
				
				
			try {
				currentBasico = String.valueOf(app.buscarEmpresaPrestadoraDeServicios(myListView.getSelectionModel().getSelectedItem()).getBasico());
				currentPremium = String.valueOf(app.buscarEmpresaPrestadoraDeServicios(myListView.getSelectionModel().getSelectedItem()).getPremium());
				currentDeluxe= String.valueOf(app.buscarEmpresaPrestadoraDeServicios(myListView.getSelectionModel().getSelectedItem()).getDeluxe());
				
				if(app.buscarEmpresaPrestadoraDeServicios(myListView.getSelectionModel().getSelectedItem()) instanceof EmpresaCatering) {
					
					EmpresaCatering e = (EmpresaCatering) app.buscarEmpresaPrestadoraDeServicios(myListView.getSelectionModel().getSelectedItem());
					
					var1 = "Menus disponibles: " + String.join(", ", e.getMenusDisponibles());
					var2 = "Especialidades culinarias: " + String.join(", ", e.getEspecialidadesCulinarias());
					var3 = "Disponibilidad de personal: " + String.valueOf(e.getDisponibilidadPersonal());
				} else if(app.buscarEmpresaPrestadoraDeServicios(myListView.getSelectionModel().getSelectedItem()) instanceof EmpresaDecoradora) {
					
					EmpresaDecoradora d = (EmpresaDecoradora) app.buscarEmpresaPrestadoraDeServicios(myListView.getSelectionModel().getSelectedItem());
					
					var1 = "Estilo decoracion: " + String.join(", ", d.getEstiloDecoracion());
					var2 = "Alquiler inmobiliario: " + String.join(", ", d.getAlquilerMobiliario());
					var3 = "Especialidad: " + d.getEspecialidad();
				} else if(app.buscarEmpresaPrestadoraDeServicios(myListView.getSelectionModel().getSelectedItem()) instanceof EmpresaLimpieza) {
					
					EmpresaLimpieza l = (EmpresaLimpieza) app.buscarEmpresaPrestadoraDeServicios(myListView.getSelectionModel().getSelectedItem());
					
					var1 = "Limpieza";
					var2 = "Momento en que limpian : " + l.getCuandoLimpia();
					var3 = " ";
				} else if(app.buscarEmpresaPrestadoraDeServicios(myListView.getSelectionModel().getSelectedItem()) instanceof EmpresaSonido) {
					
					EmpresaSonido s = (EmpresaSonido) app.buscarEmpresaPrestadoraDeServicios(myListView.getSelectionModel().getSelectedItem());
					
					var1 = "Generos de musica: " + String.join(", ", s.getTipoGenero());
					var2 = "Marcas del equipo: " + String.join(", ",s.getMarcaEquipo());
					var3 = " ";
				}
				
			} catch (EmpresaPrestadoraServicioNotFoundException e) {
				
				e.printStackTrace();
			}
			 
			basico.setText(currentBasico);
			premium.setText(currentPremium);
			deluxe.setText(currentDeluxe);
			variable1.setText(var1);
			variable2.setText(var2);
			variable3.setText(var3);
			
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
	
	//MAKE THE GENERAR CONTRATO METHOD 
	
    public void switchGenerarContrato(ActionEvent event) throws IOException {
		
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
