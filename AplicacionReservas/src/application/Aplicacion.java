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
	private static Usuario crearUsuario(String nombre, int cedula, int edad, String telefono, String correo, double presupuesto, double saldo) {
		return new Usuario(nombre, cedula, edad, telefono, correo, presupuesto, saldo);
	}
    

	//public methods
    public void agregarUsuario(String nombre, int cedula, int edad, String telefono, String correo, double presupuesto, double saldo) {
    	int len = this.getUsuarios().length + 1;
    	Usuario[] usuarios = Arrays.copyOf( this.getUsuarios(), len);;
    	usuarios[len] = crearUsuario(nombre, cedula, edad, telefono, correo, presupuesto, saldo);
    }

    // Méthode pour chercher un utilisateur
    public int buscarUsuario(String email) {
        //TODO Implémentation à faire
        return -1; // Valeur de retour par défaut, à ajuster selon l'implémentation
    }

    // Méthode pour supprimer un utilisateur
    public void eliminarUsuario() {
        // Implémentation à faire
    }

    // Méthode pour créer une réservation
    public Reserva crearReserva(Date fecha, int cantidadPersonas, Contrato[] contratos) {
        //TODO Implémentation à faire
        return null; // Valeur de retour par défaut, à ajuster selon l'implémentation
    }

    // Méthode pour ajouter un lieu d'événement
    public void agregarLugarEvento(String nombre, String direccion, double latitud, int capacidad, String tipo, String descripcion, boolean disponibilidad) {
        //TODO Implémentation à faire
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
