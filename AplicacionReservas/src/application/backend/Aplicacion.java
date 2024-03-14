package application.backend;

import java.io.IOException;
import java.time.LocalDate;

import java.util.Arrays;
import java.util.Date;

import application.backend.empresa.EmpresaCatering;
import application.backend.empresa.EmpresaDecoradora;
import application.backend.empresa.EmpresaLimpieza;
import application.backend.empresa.EmpresaPrestadoraServicio;
import application.backend.empresa.EmpresaSonido;
import application.backend.reserva.Reserva;
import application.backend.reserva.ReservaLugar;
import application.exceptions.EmpresaPrestadoraServicioNotFoundException;
import application.exceptions.LugarNotFoundException;
import application.exceptions.ReservaNotFoundException;
import application.exceptions.UsuarioNotFoundException;

public class Aplicacion {

//attributes	
	private static Aplicacion app;
    private Usuario[] usuarios;
    private LugarDeEvento[] lugaresEventos;
    private EmpresaPrestadoraServicio[] empresaPrestadoraServicio;
    private Ficheros archivos = new Ficheros();

//constructors
    public static Aplicacion getAplicacion(){
    	if (app == null)
    		app = new Aplicacion();
    	return app;
    }
    
    //inicializarlo leyendo fichero 
    
    private Aplicacion()  {
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
	
	public LugarDeEvento buscarLugarEvento(String nombre) throws LugarNotFoundException {
    	int i = this.buscarIndexLugarEvento(nombre);
    	return this.getLugaresEventos()[i];
    }
	
	//usuarios
    public void agregarUsuario(String nombre, String cedula, int edad, String telefono, String correo, double presupuesto, double saldo) {
    	int len = this.getUsuarios().length + 1;
    	Usuario[] usuarios = Arrays.copyOf( this.getUsuarios(), len);;
    	usuarios[len-1] = crearUsuario(nombre, cedula, edad, telefono, correo, presupuesto, saldo);
    	this.setUsuarios(usuarios);
    }
    public int buscarUsuarioIndex(String cedula) throws UsuarioNotFoundException {
        Usuario[] usuarios = this.getUsuarios();
        int i = 0;

        while (i < usuarios.length && !usuarios[i].getCedula().equals(cedula)) {
            i++;
        }

        if (i < usuarios.length)
			return i;
		else
			throw new UsuarioNotFoundException(cedula);
    }
    public Usuario buscarUsuario(String cedula) throws UsuarioNotFoundException {
    	int i = this.buscarUsuarioIndex(cedula);
        return this.getUsuarios()[i];
    }
    public void eliminarUsuario(String cedula) throws UsuarioNotFoundException {
        int index = this.buscarUsuarioIndex(cedula);
        Usuario[] usuarios = this.getUsuarios();
        // Create a new array without the user to be removed
        Usuario[] updatedUsuarios = new Usuario[usuarios.length - 1];
        System.arraycopy(usuarios, 0, updatedUsuarios, 0, index);
        System.arraycopy(usuarios, index + 1, updatedUsuarios, index, usuarios.length - index - 1);
        // Set the updated array to the class attribute
        this.setUsuarios(updatedUsuarios);
    }
    
    
    public void crearReservaLugar(String cedula, LugarDeEvento lugar, LocalDate fechaReserva, int cantidad) throws UsuarioNotFoundException {

    	int i = buscarUsuarioIndex(cedula);
    	
    	usuarios[i].agregarReservaLugar(cantidad, lugar, fechaReserva);
    	
    
    
    }
    
    public void crearReservaVisita(String cedula, LugarDeEvento lugar, LocalDate fechaReserva, String hora) throws UsuarioNotFoundException {

    	int i = buscarUsuarioIndex(cedula);
    	
        usuarios[i].agregarReservaVisita(hora, lugar, fechaReserva);
    	
    	
    }
    
    //eventos
    public void agregarLugarEvento(String nombre, String ubicacion, double precioPorHora, int capacidad, String entorno, String descripcion, boolean incluyeSeguro) {
    	int len = this.getLugaresEventos().length + 1;
    	LugarDeEvento[] lugaresEventos = Arrays.copyOf( this.getLugaresEventos(), len);;
    	lugaresEventos[len-1] = crearLugareDeEvento(nombre, ubicacion, precioPorHora, capacidad, entorno, descripcion, incluyeSeguro);
    	this.setLugaresEventos(lugaresEventos);
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
    
    
    //empresas
    
	public int buscarEmpreaPrestadoraDeServiciosIndex(String nombre) throws EmpresaPrestadoraServicioNotFoundException {
       
    
        int i = 0;

        while (i < empresaPrestadoraServicio.length && !empresaPrestadoraServicio[i].getNombre().equals(nombre)) {
            i++;
        }

        if (i < empresaPrestadoraServicio.length)
			return i;
		else throw new EmpresaPrestadoraServicioNotFoundException(nombre);
    }
    public EmpresaPrestadoraServicio buscarEmpresaPrestadoraDeServicios(String nombre) throws EmpresaPrestadoraServicioNotFoundException {
    	int i = buscarEmpreaPrestadoraDeServiciosIndex(nombre);
        return empresaPrestadoraServicio[i];
    }
    
    public void agregarEmpSonido(String nombre, String codigo, String[] tipoGenero, double basico, double premium, double deluxe, String[] marcaEquipo)
    {

    int len = this.getEmpresaPrestadoraServicio().length + 1;
        	EmpresaPrestadoraServicio[] empresaPrestadoraServicio = Arrays.copyOf( this.getEmpresaPrestadoraServicio(), len);;
        	empresaPrestadoraServicio[len-1] = new EmpresaSonido(nombre, codigo, tipoGenero, basico, premium, deluxe, marcaEquipo);
        	this.setEmpresaPrestadoraServicio(empresaPrestadoraServicio);

    }

    public void agregarEmpLimpieza(String nombre,String cuandoLimpia, String codigo, double basico, double premium, double deluxe)
    {
    int len = this.getEmpresaPrestadoraServicio().length + 1;

        	EmpresaPrestadoraServicio[] empresaPrestadoraServicio = Arrays.copyOf( this.getEmpresaPrestadoraServicio(), len);;
        	empresaPrestadoraServicio[len-1] = new EmpresaLimpieza(nombre,cuandoLimpia, codigo, basico, premium, deluxe);
        	this.setEmpresaPrestadoraServicio(empresaPrestadoraServicio);


    }

    public void agregarEmpCatering(String nombre, String codigo,double basico, double premium, double deluxe, String[] menusDsiponibles, String[] especialidadesCulinarias, int disponibilidadPersonal)
    {
    int len = this.getEmpresaPrestadoraServicio().length + 1;

        	EmpresaPrestadoraServicio[] empresaPrestadoraServicio = Arrays.copyOf( this.getEmpresaPrestadoraServicio(), len);;
        	empresaPrestadoraServicio[len-1] = new EmpresaCatering(nombre, codigo, basico, premium, deluxe, menusDsiponibles, especialidadesCulinarias, disponibilidadPersonal);
        	this.setEmpresaPrestadoraServicio(empresaPrestadoraServicio);


    }

    public void agregarEmpDecoradora(String nombre, String codigo, boolean utilizaPlantas, double basico, double premium, double deluxe, String[] estiloDecoracion, String especialidad, String[] alquilerMobiliario)
    {
    int len = this.getEmpresaPrestadoraServicio().length + 1;

        	EmpresaPrestadoraServicio[] empresaPrestadoraServicio = Arrays.copyOf( this.getEmpresaPrestadoraServicio(), len);;
        	empresaPrestadoraServicio[len-1] = new EmpresaDecoradora(nombre, codigo, utilizaPlantas, basico, premium, deluxe, estiloDecoracion, especialidad, alquilerMobiliario);
        	this.setEmpresaPrestadoraServicio(empresaPrestadoraServicio);
    }
    
    //Metodo para hallar el costo final de una reserva
    
    public double calcularCostoFinal(String cedula, String codigo) throws ReservaNotFoundException, UsuarioNotFoundException {
    	
    	return buscarUsuario(cedula).calcularCostoReserva(codigo);
    	
    }
    
    //contratos
    
    //tirar error
    
    public void agregarContrato(String cedula, String codigo, EmpresaPrestadoraServicio empresa, LocalDate fechaEvento, String plan) throws UsuarioNotFoundException, ReservaNotFoundException {
    	
    	Usuario u = buscarUsuario(cedula);
    	Reserva e = u.buscarReserva(codigo);
    	
    	if(e instanceof ReservaLugar) {
    		
    		((ReservaLugar) e).agregarContrato(empresa, fechaEvento,plan);
    		
    	}
    }
    
//metodos de ficheros
    
    public void crearCarpeta() {
    	archivos.crearCarpeta();
    }
    
    //los metodos de cargar sobreescriben el array con lo que se tenga en los archivos
    public void cargarUsuarios() throws ClassNotFoundException, IOException {
    	usuarios = archivos.cargarUsuarios(usuarios);
    }
    
    public void cargarLugares() throws ClassNotFoundException, IOException {
    	lugaresEventos = archivos.cargarLugaresEvento(lugaresEventos);
    }
    
    public void cargarEmpresas() throws ClassNotFoundException, IOException {
    	empresaPrestadoraServicio = archivos.cargarEmpresasServicio(empresaPrestadoraServicio);
    }
    
    //los metodos de escribir guardan en el archivo
    public void escribirUsuarios() throws ClassNotFoundException, IOException {
    	archivos.escribirUsuarios(usuarios);
    }
    
    public void escribirLugares() throws ClassNotFoundException, IOException {
    	archivos.escribirLugaresEvento(lugaresEventos);
    }
    
    public void escribirEmpresas() throws ClassNotFoundException, IOException {
    	archivos.escribirEmpresasServicio(empresaPrestadoraServicio);
    }
    
    
}
