package application.backend.empresa;

public class EmpresaLimpieza extends EmpresaPrestadoraServicio {
	private String cuandoLimpia;
    public EmpresaLimpieza(String nombre,String cuandoLimpia, String codigo, double basico, double premium, double deluxe) {
		super(nombre, codigo, basico, premium, deluxe);
		this.cuandoLimpia = cuandoLimpia;
	
    }
	public String getCuandoLimpia() {
		return cuandoLimpia;
	}
	public void setCuandoLimpia(String cuandoLimpia) {
		this.cuandoLimpia = cuandoLimpia;
	}     
    
    
}
