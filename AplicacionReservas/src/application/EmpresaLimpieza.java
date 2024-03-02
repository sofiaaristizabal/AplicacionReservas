package application;

public class EmpresaLimpieza extends EmpresaPrestadoraServicio {
	private String cuandoLimpia;
    public EmpresaLimpieza(String nombre,String cuandoLimpia, String codigo, TarifasOfrecidas tarifasOfrecidas) {
		super(nombre, codigo, tarifasOfrecidas);
		this.cuandoLimpia = cuandoLimpia;
	
    }       
}
