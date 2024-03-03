package application;

public class EmpresaSonido extends EmpresaPrestadoraServicio {
    private String[] tipoGenero;
    private String[] marcaEquipo;

    // Constructor
    public EmpresaSonido(String nombre, String codigo, String[] tipoGenero, TarifasOfrecidas tarifasOfrecidas, String[] marcaEquipo) {
        super(nombre, codigo, tarifasOfrecidas);
        this.tipoGenero = tipoGenero;
        this.marcaEquipo = marcaEquipo;
    }
}