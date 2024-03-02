
public class EmpresaSonido extends EmpresaPrestadoraServicio {
    private String[] tipoGenero;
    private String[] marcaEquipo;

    // Constructor
    public EmpresaSonido(String nombre, String codigo, String[] tipoGenero,double presupuesto, String[] marcaEquipo) {
        super(nombre, codigo, presupuesto);
        this.tipoGenero = tipoGenero;
        this.marcaEquipo = marcaEquipo;
    }
}