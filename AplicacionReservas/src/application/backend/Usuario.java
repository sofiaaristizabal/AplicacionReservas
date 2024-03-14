package application.backend;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

import application.backend.LugarDeEvento;
import application.backend.reserva.Reserva;
import application.backend.reserva.ReservaLugar;
import application.backend.reserva.ReservaVisita;
import application.exceptions.ReservaNotFoundException;

public class Usuario implements Serializable  {
	
//attributos
    private String nombre;
    private String cedula;
    private int edad;
    private String telefono;
    private String correo;
    private double presupuesto;
    private double saldo;
    private Reserva[] reservas = new Reserva[0];

    // Constructor
    public Usuario(String nombre, String cedula, int edad, String telefono, String correo, double presupuesto, double saldo) {
        validarNombre(nombre);
        validarCedula(cedula);
        validarEdad(edad);
        validarTelefono(telefono);
        validarCorreo(correo);
        validarPresupuesto(presupuesto);
        validarSaldo(saldo);

        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
        this.telefono = telefono;
        this.correo = correo;
        this.presupuesto = presupuesto;
        this.saldo = saldo;
    }

    private void validarNombre(String nombre) {
        if (nombre == null || nombre.isEmpty() || nombre.matches(".*\\d.*")) {
            throw new IllegalArgumentException("El nombre no es válido.");
        }
    }

    private void validarCedula(String cedula) {
        if (cedula == null || cedula.isEmpty() || !cedula.matches("\\d+")) {
            throw new IllegalArgumentException("La cédula no es válida.");
        }
    }

    private void validarEdad(int edad) {
        if (edad < 0 || edad > 150) {
            throw new IllegalArgumentException("La edad no es válida.");
        }
    }

    private void validarTelefono(String telefono) {
        if (telefono == null || telefono.isEmpty()) {
            throw new IllegalArgumentException("El teléfono no es válido.");
        }
    }

    private void validarCorreo(String correo) {
        if (correo == null || correo.isEmpty()) {
            throw new IllegalArgumentException("El correo no es válido.");
        }
    }

    private void validarPresupuesto(double presupuesto) {
        if (presupuesto < 0) {
            throw new IllegalArgumentException("El presupuesto no es válido.");
        }
    }

    private void validarSaldo(double saldo) {
        if (saldo < 0) {
            throw new IllegalArgumentException("El saldo no es válido.");
        }
    }

    // Métodos de acceso (getters y setters)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        validarNombre(nombre);
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        validarCedula(cedula);
        this.cedula = cedula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        validarEdad(edad);
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        validarTelefono(telefono);
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        validarCorreo(correo);
        this.correo = correo;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        validarPresupuesto(presupuesto);
        this.presupuesto = presupuesto;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        validarSaldo(saldo);
        this.saldo = saldo;
    }
	
    public Reserva[] getReservas() {
		return reservas;
	}

	public void setReservas(Reserva[] reservas) {
		this.reservas = reservas;
	}

	//methods
	
	
	public void agregarReservaLugar(int cantidad, LugarDeEvento e, LocalDate fecha)
	{
		Reserva nuevaReserva = new ReservaLugar(e, fecha, cantidad);
		
		reservas = Arrays.copyOf(reservas, reservas.length+1);
		reservas[reservas.length-1] = nuevaReserva;
		
		
	}
	
	public void agregarReservaVisita(String hora, LugarDeEvento e, LocalDate fecha)
	{
		Reserva nuevaReserva = new ReservaVisita(e, fecha, hora);
		
		reservas = Arrays.copyOf(reservas, reservas.length+1);
		reservas[reservas.length-1] = nuevaReserva;
	
	}
	
	public int buscarIndexReserva(String codigo) throws ReservaNotFoundException
	{
		
		
		int i = 0;
		while((i<reservas.length) && !((reservas[i].getCodigo()).toString().equals(codigo)) )
		{
			i++;
		}
		
		if(i<reservas.length)
		{
			return i;
		}else throw new ReservaNotFoundException(codigo);
		
	}
	
	
     public Reserva buscarReserva(String codigo) throws ReservaNotFoundException {
		
		int i = buscarIndexReserva(codigo);
		
		return reservas[i];
	}
	
     public double calcularCostoReserva(String codigo) throws ReservaNotFoundException {
    	 
    	 int i = buscarIndexReserva(codigo);
    	 double costoFinal = 0;
    	 
    	 ReservaLugar r = (ReservaLugar)reservas[i];
		 costoFinal+= r.getLugarEvento().getPrecioPorEvento();
    	 
    	 for(int j = 0; j < r.getContratos().length; j++) {
    		 	
    	 costoFinal+= r.getContratos()[j].getTarifaPagar();
          
    	 }
    	 return costoFinal;
	
	}
     
}



	
	

	
	
	
	
	


