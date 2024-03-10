package application.frontend;

import java.util.*;

import application.backend.Aplicacion;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			FXMLLoader loader = new FXMLLoader(this.getClass().getResource("Main.fxml"));
			Parent root = (Parent) loader.load();
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			String css = this.getClass().getResource("application.css").toExternalForm();
			scene.getStylesheets().add(css);
			primaryStage.setScene(scene);
			primaryStage.show();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
      Aplicacion app = Aplicacion.getAplicacion();
		
     
		
		
		//lugares de evento iniciales
		
		//ZonaE
	    app.agregarLugarEvento("Zona E","Del cruce del tablazo, 700 mt Via a Zona Franca, Rionegro, Antioquia ", 680000, 180, "carpa al aire libre",
	    		"Muy cerca de Medellín se encuentra ZonaE, un lugar capaz de convertir los sueños en experiencias perfectas, por qué enaltecemos cualquier ocasión que de por sí ya sea mágica,"
	    		+ " sacándola de lo racional y convirtiéndola en un hito inolvidable en la vida de los anfitriones e invitados. Tenemos 4 locaciones diferentes para celebrar nuestros eventos,"
	    		+ "Creamos escenarios donde la sensación del tiempo y el espacio se suspenden, para sumergirte en una dimensión única, donde cada detalle incita a la inspiración, y las experiencias se convierten en recuerdos para atesorar.\n"
	    		+ "Sin duda un sitio ideal para el mejor día de tu vida.", true);
	    //Riojana
	    app.agregarLugarEvento("Riojana", "054028, Marinilla, Antioquia", 380000, 100, "Casa campestre","Riojana es una hacienda en las inmediaciones del municipio de Marinilla, y es el escenario perfecto para la realización de un matrimonio en un ambiente campestre y relajado. "
	    		+ "Gracias a la belleza de sus instalaciones y a la atención de sus encargados, el día más esperado de su vida, será tal cual como lo soñaron", true);
	    
	    //Casa Llanoverde
	    app.agregarLugarEvento("Casa Llanoverde", "Vía Vda. Pontezuela, Llano Grande, Rionegro, Antioquia",1000000 , 120, "Carpa al aire libre","Casa Llano Verde es un espacio rodeado de naturaleza, donde podrán sentir un ambiente de tranquilidad, paz y armonía, para que esa fecha tan especial se convierta en una experiencia inolvidable."
	    		+ " Allí tendrán todas las facilidades y prestaciones para organizar, pero sobre todo, vivir una boda de ensueño y a la medida de todas sus ilusiones.", true);
	    //Casa prado
	    app.agregarLugarEvento("Casa prado", "Cra. 50 #64 00, La Candelaria, Medellín, La Candelaria, Medellín, Antioquia", 200000, 170 ,"Casa","Casa emblemática del barrio Prado Centro en la ciudad de Medellín, con más de 90 años de historia. Considerada patrimonio arquitectónico para la ciudad.\n"
	    		+ "\n"
	    		+ "Abre sus puertas para recibir visitantes, realizar eventos sociales como Bodas, Primeras comuniones, Fiestas de cumpleaños, etc. Además, de ser un espacio idóneo para la realización de videos musicales y sesiones fotográficas que quieran resaltar la arquitectura de las casas de principio de 1900’s ", false);
	    
	    //Eventos San Felipe
	    app.agregarLugarEvento("Eventos San Felipe ","Transv 39 B 72 - 63, Medellín, Antioquia ",350000, 150,"Salon social","Eventos San Felipe es una empresa que se encarga de organizar y desarrollar eventos sociales como el de su boda. Su equipo de trabajo se ocupará de crear un ambiente fantástico,"
	    		+ " para que su fiesta sea una bonita y agradable sensación y para que ese maravilloso evento se convierta en el mejor de sus vidas. No duden en conocer los servicios que esta empresa les ofrece.", true);
	    //Cielo alto
	    app.agregarLugarEvento("Cielo alto ","Carrera 9E #16ASur-104 – Medellín, Colombia" , 150000 , 100, "Salon social", "Cielo Alto es el lugar perfecto para la celebración de los quince que siempre has soñado. Adecuamos y decoramos el salón para que la celebración sea única y tus invitados la disfruten como ninguna otra.", true);

		System.out.println(app.getLugaresEventos().length);
	
		// empresas 	
		
		 String[] tipoSonido = {"Vallenato", "Electrónica", "Reggaeton"};
		 String [] marcaEquipo = {"Bose", "JBL", "Beats"};
		
	    app.agregarEmpSonido("Deluxe Sound","001",tipoSonido,1000000,2000000,3000000,marcaEquipo);
	    app.agregarEmpSonido("Surround Sound","002",new String[]{"Rock", "Tango", "Jazz"},500000,1500000,2500000,new String[]{"Sony", "Samsung", "LG"});
	
	    app.agregarEmpLimpieza("Los Limpiadores","Limipia Antes, Antes y Despues, Antes, Durante y Despues","103",100000,200000,300000);
	    app.agregarEmpLimpieza("Limpia +","Limipia Antes, Antes y Despues, Antes, Durante y Despues","104",500000,1500000,2500000);

	    app.agregarEmpCatering("Catering Fiestas","209",500000,1000000,2000000,new String[]{"Comida Japonesa", "Comida Arabe", "Comida Tipica"},new String[]{"Sushi, Baos", "Kebab, Baklavas", "Frijoles, Chicharron"},20);
	    app.agregarEmpCatering("Servicios Catering","210",1500000,2500000,3000000,new String[]{"Comida China", "Comida Argentina", "Comida Italiana"},new String[]{"Arrozes, Pato", "Carne, Chorizo", "Pasta, Pizza"},25);

	    app.agregarEmpDecoradora("Decoradores plus","458",true,80000,160000,300000,new String[]{"Estilo Hawaiano", "Estilo Matrimonio", "Despedida Soltero/a"},"Fiestas para todos",new String[]{"Muebles", "Sillas", "Carpas"});
	    app.agregarEmpDecoradora("Decora todo","459",true,1000000,2000000,3500000,new String[]{"Fiesta de 15s", "Bar Mitzvá", "Cumpleaños"},"FestiEventos",new String[]{"Mesas", "Mobiliario de bar", "Mobiliario de iluminación"});

    
	}
	
	public static void main(String[] args) {
		launch(args);
		
		
		
	}
}
