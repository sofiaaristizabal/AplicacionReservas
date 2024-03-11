package application.backend.empresa;

public class EmpresaDecoradora extends EmpresaPrestadoraServicio {
    private String[] estiloDecoracion;
    private String especialidad; // interiores, exteriores, interior y exterior
    private String[] alquilerMobiliario; 
    private boolean utilizaPlantas;

    // Constructor
    public EmpresaDecoradora(String nombre, String codigo, boolean utilizaPlantas, double basico, double premium, double deluxe, String[] estiloDecoracion, String especialidad, String[] alquilerMobiliario) {
        super(nombre, codigo, basico, premium, deluxe);
        this.estiloDecoracion = estiloDecoracion;
        this.especialidad = especialidad;
        this.alquilerMobiliario = alquilerMobiliario;
        this.utilizaPlantas = utilizaPlantas;
    }

	public String[] getEstiloDecoracion() {
		return estiloDecoracion;
	}

	public void setEstiloDecoracion(String[] estiloDecoracion) {
		this.estiloDecoracion = estiloDecoracion;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public String[] getAlquilerMobiliario() {
		return alquilerMobiliario;
	}

	public void setAlquilerMobiliario(String[] alquilerMobiliario) {
		this.alquilerMobiliario = alquilerMobiliario;
	}

	public boolean isUtilizaPlantas() {
		return utilizaPlantas;
	}

	public void setUtilizaPlantas(boolean utilizaPlantas) {
		this.utilizaPlantas = utilizaPlantas;
	}
    
    
}