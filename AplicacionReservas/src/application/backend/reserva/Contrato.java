package application.backend.reserva;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import application.backend.empresa.EmpresaPrestadoraServicio;

public class Contrato implements Serializable {
	
	private String codigo;
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
		generarCodigo();
		
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	
	

}
