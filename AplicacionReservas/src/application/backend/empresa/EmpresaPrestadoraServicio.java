package application.backend.empresa;


public class EmpresaPrestadoraServicio {
    protected String nombre;
    protected String codigo;
    protected double basico;
    protected double premium;
    protected double deluxe;
    


    public EmpresaPrestadoraServicio(String nombre, String codigo, double basico, double premium, double deluxe) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.basico = basico;
        this.premium= premium;
        this.deluxe = deluxe;

    }



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getCodigo() {
		return codigo;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public double getBasico() {
		return basico;
	}



	public void setBasico(double basico) {
		this.basico = basico;
	}



	public double getPremium() {
		return premium;
	}



	public void setPremium(double premium) {
		this.premium = premium;
	}



	public double getDeluxe() {
		return deluxe;
	}



	public void setDeluxe(double deluxe) {
		this.deluxe = deluxe;
	}
    
    
}
