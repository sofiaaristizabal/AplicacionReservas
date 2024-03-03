package application;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Contrato {
	
	private EmpresaPrestadoraServicio empresa;
	private String fechaGeneracion;
	private Date fechaEvento;
	private double tarifaPagar;
	
	
	public Contrato(EmpresaPrestadoraServicio empresa, Date fechaEvento, double tarifaPagar) {
		super();
		this.empresa = empresa;
		this.fechaEvento = fechaEvento;
		this.tarifaPagar = tarifaPagar;
		generarFechaGeneracion();
		
	}
	
	public void generarFechaGeneracion() {
		
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ssZ");
		
		Date dia = new Date();
		
		this.fechaGeneracion = simpleDateFormat.format(dia);
	}


	public EmpresaPrestadoraServicio getEmpresa() {
		return empresa;
	}


	public Date getFechaEvento() {
		return fechaEvento;
	}


	public void setFechaEvento(Date fechaEvento) {
		this.fechaEvento = fechaEvento;
	}


	public double getTarifaPagar() {
		return tarifaPagar;
	}


	public void setTarifaPagar(double tarifaPagar) {
		this.tarifaPagar = tarifaPagar;
	}
	
	
	

}
