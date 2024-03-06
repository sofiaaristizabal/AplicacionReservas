package application;
import  application.backend.*;
import application.backend.empresa.EmpresaPrestadoraServicio;
import application.exceptions.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

public class Aplicacion {

//attributes	
	private static Aplicacion app = new Aplicacion();
    private Usuario[] usuarios;
    private LugarDeEvento[] lugaresEventos;
    private EmpresaPrestadoraServicio[] empresaPrestadoraServicio;

//constructors
    public static Aplicacion getAplicacion(){
    	return app;
    }
    
    private Aplicacion() {
    	
    	usuarios = new Usuario[0];
    	lugaresEventos = new LugarDeEvento[0];
    	empresaPrestadoraServicio = new EmpresaPrestadoraServicio[0];
    }
 
//accessors
    public Usuario[] getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(Usuario[] usuarios) {
		this.usuarios = usuarios;
	}

	public LugarDeEvento[] getLugaresEventos() {
		return lugaresEventos;
	}
	public void setLugaresEventos(LugarDeEvento[] lugaresEventos) {
		this.lugaresEventos = lugaresEventos;
	}

	public EmpresaPrestadoraServicio[] getEmpresaPrestadoraServicio() {
		return empresaPrestadoraServicio;
	}
	public void setEmpresaPrestadoraServicio(EmpresaPrestadoraServicio[] empresaPrestadoraServicio) {
		this.empresaPrestadoraServicio = empresaPrestadoraServicio;
	}


//methods

	//private methods
	private static Usuario crearUsuario(String nombre, String cedula, int edad, String telefono, String correo, double presupuesto, double saldo) {
		return new Usuario(nombre, cedula, edad, telefono, correo, presupuesto, saldo);
	}
	
	private LugarDeEvento crearLugareDeEvento(String nombre, String ubicacion, double precioPorHora, int capacidad, String entorno, String descripcion, boolean incluyeSeguro) {
		return new LugarDeEvento(nombre, ubicacion, precioPorHora, capacidad, entorno, descripcion, incluyeSeguro);
	}
	private int buscarIndexLugarEvento(String nombre) throws LugarNotFoundException {
        LugarDeEvento[] lugaresEventos = this.getLugaresEventos();
        int i = 0;

        while (i < lugaresEventos.length && !lugaresEventos[i].getNombre().equals(nombre)) {
            i++;
        }

        if (i < lugaresEventos.length) {
			return i;
        }
		else {
			throw new LugarNotFoundException(nombre);
		}
    }
    

	//public methods
	
	//usuarios
    public void agregarUsuario(String nombre, String cedula, int edad, String telefono, String correo, double presupuesto, double saldo) {
    	int len = this.getUsuarios().length + 1;
    	Usuario[] usuarios = Arrays.copyOf( this.getUsuarios(), len);;
    	usuarios[len] = crearUsuario(nombre, cedula, edad, telefono, correo, presupuesto, saldo);
    	this.setUsuarios(usuarios);
    }
    public int buscarUsuario(String cedula) {
        Usuario[] usuarios = this.getUsuarios();
        int i = 0;

        while (i < usuarios.length && !usuarios[i].getCedula().equals(cedula)) {
            i++;
        }

        return (i < usuarios.length) ? i : -1;
    }
    public void eliminarUsuario(String cedula) {
        int index = this.buscarUsuario(cedula);

        if (index != -1) {
            Usuario[] usuarios = this.getUsuarios();
            // Create a new array without the user to be removed
            Usuario[] updatedUsuarios = new Usuario[usuarios.length - 1];
            System.arraycopy(usuarios, 0, updatedUsuarios, 0, index);
            System.arraycopy(usuarios, index + 1, updatedUsuarios, index, usuarios.length - index - 1);
            // Set the updated array to the class attribute
            this.setUsuarios(updatedUsuarios);
        } else {
            System.out.println("Usuario no encontrado");
        }
    }

    //reservas
    public void crearReservaLugar(String cedula, LugarDeEvento lugar, LocalDate fechaReserva, int cantidad) {

    	int i = buscarUsuario(cedula);
    	
    		usuarios[i].agregarReservaLugar(cantidad, lugar, fechaReserva);
    }
    
    public void crearReservaVisita(String cedula, LugarDeEvento lugar, LocalDate fechaReserva, String hora) {

    	int i = buscarUsuario(cedula);
    	
    		usuarios[i].agregarReservaVisita(hora, lugar, fechaReserva);
    }
    
    //eventos
    public void agregarLugarEvento(String nombre, String ubicacion, double precioPorHora, int capacidad, String entorno, String descripcion, boolean incluyeSeguro) {
    	int len = this.getLugaresEventos().length + 1;
    	LugarDeEvento[] lugaresEventos = Arrays.copyOf( this.getLugaresEventos(), len);;
    	lugaresEventos[len-1] = crearLugareDeEvento(nombre, ubicacion, precioPorHora, capacidad, entorno, descripcion, incluyeSeguro);
    	this.setLugaresEventos(lugaresEventos);
    }
    public LugarDeEvento buscarLugarEvento(String nombre) throws LugarNotFoundException {
    	int i = this.buscarIndexLugarEvento(nombre);
    	return this.getLugaresEventos()[i];
    }
    public void eliminarLugarEvento(String nombre) throws LugarNotFoundException {
        int index = this.buscarIndexLugarEvento(nombre);

        LugarDeEvento[] lugaresEventos = this.getLugaresEventos();
        // Create a new array without the location to be removed
        LugarDeEvento[] updatedLugaresEventos = new LugarDeEvento[lugaresEventos.length - 1];
        System.arraycopy(lugaresEventos, 0, updatedLugaresEventos, 0, index);
        System.arraycopy(lugaresEventos, index + 1, updatedLugaresEventos, index, lugaresEventos.length - index - 1);
        // Set the updated array to the class attribute
        this.setLugaresEventos(updatedLugaresEventos);
    }

    
    
    // Méthode pour filtrer par budget
    public void filtrarPresupuesto(String cedula, double nuevoP) {
    	
    	usuarios[buscarUsuario(cedula)].setPresupuesto(nuevoP);
    }

    

    
}
