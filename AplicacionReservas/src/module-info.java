module AplicacionReservas {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	requires javafx.base;
	
	//opens application to javafx.graphics, javafx.fxml;
	
	
	opens application.frontend to javafx.graphics, javafx.fxml;
	    
	
}
