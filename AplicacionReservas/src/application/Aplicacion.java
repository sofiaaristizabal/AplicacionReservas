package application;

import java.util.Date;

public class Aplicacion {
	
	private static Aplicacion app = new Aplicacion();
	
    private Usuario[] usuarios;
    private LugarDeEvento[] lugaresEventos;
    private EmpresaPrestadoraDeServicio[] empresasPrestadorasDeServicios;

    
    public static Aplicacion getAplicacion(){
    	return app;
    }
    
    // Constructeur
    private Aplicacion() {
        //TODO Initialiser les tableaux ou effectuer d'autres initialisations nécessaires
    }

    // Méthode pour ajouter un utilisateur
    public void agregarUsuario(String nombre, String apellido, String email, String telefono, String direccion, double latitud, double longitud) {
        //TODO Implémentation à faire
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
