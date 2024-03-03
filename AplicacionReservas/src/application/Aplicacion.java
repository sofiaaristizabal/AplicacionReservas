package application;

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
        //TODO Initialiser les tableaux ou effectuer d'autres initialisations nécessaires
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
    

	//public methods
	
	//usuarios
    public void agregarUsuario(String nombre, String cedula, int edad, String telefono, String correo, double presupuesto, double saldo) {
    	int len = this.getUsuarios().length + 1;
    	Usuario[] usuarios = Arrays.copyOf( this.getUsuarios(), len);;
    	usuarios[len] = crearUsuario(nombre, cedula, edad, telefono, correo, presupuesto, saldo);
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
        int i =  this.buscarUsuario(cedula);
        //TODO remove this.getUsuarios()[i] from this.getUsuarios()
    }

    //reservas
    // Méthode pour créer une réservation
    public Reserva crearReserva(Date fecha, int cantidadPersonas, Contrato[] contratos) {
        //TODO Implémentation à faire
        return null; // Valeur de retour par défaut, à ajuster selon l'implémentation
    }

    //eventos
    public void agregarLugarEvento(String nombre, String ubicacion, double precioPorHora, int capacidad, String entorno, String descripcion, boolean incluyeSeguro) {
    	int len = this.getLugaresEventos().length + 1;
    	LugarDeEvento[] lugaresEventos = Arrays.copyOf( this.getLugaresEventos(), len);;
    	lugaresEventos[len] = crearLugareDeEvento(nombre, ubicacion, precioPorHora, capacidad, entorno, descripcion, incluyeSeguro);
    }


	// Méthode pour chercher un lieu d'événement
    public int buscarLugarEvento(String nombre) {
        // Implémentation à faire
        return -1; // Valeur de retour par défaut, à ajuster selon l'implémentation
    }

    // Méthode pour supprimer un lieu d'événement
    public void eliminarLugarEvento() {
        //TODO Implémentation à faire
    }

    // Méthode pour filtrer par budget
    public void filtrarPresupuesto() {
        //TODO Implémentation à faire
    }

}
