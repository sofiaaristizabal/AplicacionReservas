package application.backend.empresa;

public class EmpresaCatering extends EmpresaPrestadoraServicio {
    private String[] menusDisponibles;
    private String[] especialidadesCulinarias;
    private int disponibilidadPersonal;

    // Constructor
    public EmpresaCatering(String nombre, String codigo,double basico, double premium, double deluxe, String[] menusDsiponibles, String[] especialidadesCulinarias, int disponibilidadPersonal) {
        super(nombre, codigo, basico, premium, deluxe);
        this.menusDisponibles = menusDsiponibles;
        this.especialidadesCulinarias = especialidadesCulinarias;
        this.disponibilidadPersonal = disponibilidadPersonal;
    }

	public String[] getMenusDisponibles() {
		return menusDisponibles;
	}

	public void setMenusDisponibles(String[] menusDisponibles) {
		this.menusDisponibles = menusDisponibles;
	}

	public String[] getEspecialidadesCulinarias() {
		return especialidadesCulinarias;
	}

	public void setEspecialidadesCulinarias(String[] especialidadesCulinarias) {
		this.especialidadesCulinarias = especialidadesCulinarias;
	}

	public int getDisponibilidadPersonal() {
		return disponibilidadPersonal;
	}

	public void setDisponibilidadPersonal(int disponibilidadPersonal) {
		this.disponibilidadPersonal = disponibilidadPersonal;
	}
    
    
    
}
