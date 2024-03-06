package application.backend.empresa;

public class EmpresaSonido extends EmpresaPrestadoraServicio {
    private String[] tipoGenero;
    private String[] marcaEquipo;

    // Constructor
    public EmpresaSonido(String nombre, String codigo, String[] tipoGenero, double basico, double premium, double deluxe, String[] marcaEquipo) {
        super(nombre, codigo, basico, premium, deluxe);
        this.tipoGenero = tipoGenero;
        this.marcaEquipo = marcaEquipo;
    }
}