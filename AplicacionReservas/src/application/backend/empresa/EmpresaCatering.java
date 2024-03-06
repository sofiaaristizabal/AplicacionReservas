package application.backend.empresa;

public class EmpresaCatering extends EmpresaPrestadoraServicio {
    private String[] menusDsiponibles;
    private String[] especialidadesCulinarias;
    private int disponibilidadPersonal;

    // Constructor
    public EmpresaCatering(String nombre, String codigo,double basico, double premium, double deluxe, String[] menusDsiponibles, String[] especialidadesCulinarias, int disponibilidadPersonal) {
        super(nombre, codigo, basico, premium, deluxe);
        this.menusDsiponibles = menusDsiponibles;
        this.especialidadesCulinarias = especialidadesCulinarias;
        this.disponibilidadPersonal = disponibilidadPersonal;
    }
    
}
