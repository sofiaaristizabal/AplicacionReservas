public class EmpresaCatering extends EmpresaPrestadoraServicio {
    private String[] menusDsiponibles;
    private String[] especialidadesCulinarias;
    private int disponibilidadPersonal;

    // Constructor
    public EmpresaCatering(String nombre, String codigo,TarifasOfrecidas tarifasOfrecidas, String[] menusDsiponibles, String[] especialidadesCulinarias, int disponibilidadPersonal) {
        super(nombre, codigo, tarifasOfrecidas);
        this.menusDsiponibles = menusDsiponibles;
        this.especialidadesCulinarias = especialidadesCulinarias;
        this.disponibilidadPersonal = disponibilidadPersonal;
    }
    
}
