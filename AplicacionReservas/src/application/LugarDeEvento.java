package application;

public class LugarDeEvento {

	private String nombre;
	private String codigo;
	private String ubicacion;
	private double precioPorHora;
	private int capacidad;
	private String entorno;
	private String descripcion;
	private boolean incluyeSeguro;
	
	
	public LugarDeEvento(String nombre, String ubicacion, double precioPorHora, int capacidad,
			String entorno, String descripcion, boolean incluyeSeguro) {
		super();
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.precioPorHora = precioPorHora;
		this.capacidad = capacidad;
		this.entorno = entorno;
		this.descripcion = descripcion;
		this.incluyeSeguro = incluyeSeguro;
		generarCodigo();
	}
	
	// Este metodo genera un codigo en la variable code como una combinacional azar de los caracteres del String a, este string sera de 6 caracteres ya que el ciclo para concatenar se repite 6 veces 
	
	public void generarCodigo() {
		
		String a = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		
		String code = "";
		
		for(int i = 0; i < 6; i++) {
			
			char caracter = a.charAt((int) (Math.random()*a.length()));
			code.concat(Character.toString(caracter));
		}
		
		this.codigo = code;
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


	public String getUbicacion() {
		return ubicacion;
	}


	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}


	public double getPrecioPorHora() {
		return precioPorHora;
	}


	public void setPrecioPorHora(double precioPorHora) {
		this.precioPorHora = precioPorHora;
	}


	public int getCapacidad() {
		return capacidad;
	}


	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}


	public String getEntorno() {
		return entorno;
	}


	public void setEntorno(String entorno) {
		this.entorno = entorno;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public boolean isIncluyeSeguro() {
		return incluyeSeguro;
	}


	public void setIncluyeSeguro(boolean incluyeSeguro) {
		this.incluyeSeguro = incluyeSeguro;
	}
	
	
	
}
