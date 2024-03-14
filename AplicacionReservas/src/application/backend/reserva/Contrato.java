package application.backend.reserva;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import application.backend.empresa.EmpresaPrestadoraServicio;

public class Contrato implements Serializable {
	
	private String codigo;
	private EmpresaPrestadoraServicio empresa;
	private String fechaGeneracion;
	private LocalDate fechaEvento;
	private String plan;
	private double tarifaPagar;
	
	
	public Contrato(EmpresaPrestadoraServicio empresa, LocalDate fechaEvento, String plan) {
		super();
		this.empresa = empresa;
		this.fechaEvento = fechaEvento;
		this.plan = plan;
		generarFechaGeneracion();
		generarCodigo();
		this.tarifaPagar = encontarTarifaPagar(plan);
		
		
	}
	
	public void generarFechaGeneracion() {
		
       SimpleDateFormat simpleDateFormat = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ssZ");
		
		Date dia = new Date();
		
		this.fechaGeneracion = simpleDateFormat.format(dia);
	}
	
	public void generarCodigo() {
		
		String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder code = new StringBuilder();
		
		for(int i= 0; i < 4; i++) {
			
			int indice = (int)(Math.random()*caracteres.length());
			code.append(caracteres.charAt(indice));
		}
		
		this.codigo = code.toString();
	}
	
	public double encontarTarifaPagar(String plan) {
		
		double tarifa = 0;
		
		if(plan.equalsIgnoreCase("Basico")) {
			tarifa = empresa.getBasico();
		} else if(plan.equalsIgnoreCase("Premium")) {
			tarifa = empresa.getPremium();
		} else if(plan.equalsIgnoreCase("Deluxe")) {
			tarifa = empresa.getDeluxe();
		}
		
		return tarifa;
	}
	
	public double getTarifaPagar() {
		return tarifaPagar;
	}


	public EmpresaPrestadoraServicio getEmpresa() {
		return empresa;
	}


	public LocalDate getFechaEvento() {
		return fechaEvento;
	}


	public void setFechaEvento(LocalDate fechaEvento) {
		this.fechaEvento = fechaEvento;
	}


	public void setTarifaPagar(double tarifaPagar) {
		this.tarifaPagar = tarifaPagar;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	

}
