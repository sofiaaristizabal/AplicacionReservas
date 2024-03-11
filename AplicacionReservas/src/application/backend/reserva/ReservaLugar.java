package application.backend.reserva;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

import application.backend.LugarDeEvento;
import application.backend.empresa.EmpresaPrestadoraServicio;
import application.exceptions.ContratoNotFoundException;

public class ReservaLugar extends Reserva {
	
	private int cantidadPersonas;
	private Contrato[] contratos;

	public ReservaLugar(LugarDeEvento lugarEvento, LocalDate fechaReserva,
			int cantidadPersonas) {
		super(lugarEvento, fechaReserva);
		this.cantidadPersonas = cantidadPersonas;
		contratos = new Contrato[0];
	}
	
	public void agregarContrato(EmpresaPrestadoraServicio empresa, Date fecha, double tarifa) {
		
		Contrato contrato = new Contrato(empresa, fecha, tarifa);
		
		contratos = Arrays.copyOf(contratos,contratos.length+1);
		contratos[contratos.length-1] = contrato;
		
		
	}
	
	public int buscarIndexContrato(String codigo) throws ContratoNotFoundException {
		
		int i = 0;
		
		while(!contratos[i].getCodigo().equals(codigo) && i<contratos.length) {
			
			i++;
		}
		
		if(i<contratos.length) {
			
			return i;
		} else throw new ContratoNotFoundException(codigo);
	}
	
   public Contrato buscarContrato(String codigo) throws ContratoNotFoundException {
		
		int i = buscarIndexContrato(codigo);
		
		return contratos[i];
	}
	
	public void eliminarContrato(String codigo) throws ContratoNotFoundException {
		
		int i = buscarIndexContrato(codigo);
		
		Contrato[] cTemp = new Contrato[contratos.length-1];
		
		if(i >0) {
			
			System.arraycopy(contratos, 0, cTemp, 0, i);
			System.arraycopy(contratos, i+1, cTemp, i, contratos.length-i-1);
		} else {
			System.arraycopy(contratos, 1, cTemp, 0, contratos.length-1);
		}
		
		contratos = cTemp;
	}
	
	

}
