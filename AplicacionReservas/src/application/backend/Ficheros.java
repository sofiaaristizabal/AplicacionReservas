package application.backend;

import java.io.*;
import application.backend.empresa.EmpresaPrestadoraServicio;

public class Ficheros  {
	

	
	//direcciones en archivos
	private File carpeta = new File("C:\\ProyectoReserva\\Informacion");
	private String direccionUsuarios = "C:\\ProyectoReserva\\Informacion\\Usuarios.txt";
	private String direccionLugares = "C:\\ProyectoReserva\\Informacion\\Lugares.txt";
	private String direccionEmpresas = "C:\\ProyectoReserva\\Informacion\\Empresas.txt";
	
	//metodo para crear la carpeta en caso que no exista
	public void crearCarpeta() {
		if(!carpeta.exists()) {
		carpeta.mkdirs();
		System.out.println("se creo la carpeta");
		}
	}
	
	
	public Usuario[] cargarUsuarios(Usuario[] usuarios) throws ClassNotFoundException, IOException {
		Usuario lecturaU;
		Usuario[] temporalesU = new Usuario[usuarios.length];
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		fis = new FileInputStream(direccionUsuarios);
		ois = new ObjectInputStream(fis);
		
		for (int i = 0; i < usuarios.length ; i++) {
			lecturaU = (Usuario) ois.readObject();
			temporalesU[i] = lecturaU;
			
		}
		
		ois.close();
		fis.close();
		
		//devuelve un vector para sobreescribir el anterior
		return temporalesU;
		
		
	}
	
	public LugarDeEvento[] cargarLugaresEvento(LugarDeEvento[] lugaresEventos) throws ClassNotFoundException, IOException {
		LugarDeEvento lecturaL;
		LugarDeEvento[] temporalesL = new LugarDeEvento[lugaresEventos.length];
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		fis = new FileInputStream(direccionLugares);
		ois = new ObjectInputStream(fis);
		
		for (int i = 0; i < lugaresEventos.length ; i++) {
			lecturaL = (LugarDeEvento) ois.readObject();
			temporalesL[i] = lecturaL;
			
		}
		
		ois.close();
		fis.close();
		//devuelve un vector para sobreescribir el anterior
		return temporalesL;
	}
	
	public EmpresaPrestadoraServicio[] cargarEmpresasServicio(EmpresaPrestadoraServicio[] empresaPrestadoraServicio) throws ClassNotFoundException, IOException {
		EmpresaPrestadoraServicio lecturaE;
		EmpresaPrestadoraServicio[] temporalesE = new EmpresaPrestadoraServicio[empresaPrestadoraServicio.length];
		
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		
		fis = new FileInputStream(direccionEmpresas);
		ois = new ObjectInputStream(fis);
		
		for (int i = 0; i < empresaPrestadoraServicio.length ; i++) {
			
			lecturaE = (EmpresaPrestadoraServicio) ois.readObject();
			temporalesE[i] = lecturaE;
			
		}
		
		ois.close();
		fis.close();
		//devuelve un vector para sobreescribir el anterior
		return temporalesE;
	}
	
	
	public void escribirUsuarios(Usuario[] usuarios) throws ClassNotFoundException, IOException {
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		fos = new FileOutputStream(direccionUsuarios);
		oos = new ObjectOutputStream(fos);

		for (int i = 0; i < usuarios.length ; i++) {
			oos.writeObject(usuarios[i]);
		}
		
		fos.close();
		oos.close();
		
	}
	
	public void escribirLugaresEvento(LugarDeEvento[] lugaresEventos) throws ClassNotFoundException, IOException {
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		fos = new FileOutputStream(direccionLugares);
		oos = new ObjectOutputStream(fos);

		for (int i = 0; i < lugaresEventos.length ; i++) {
			oos.writeObject(lugaresEventos[i]);
		}
		
		fos.close();
		oos.close();
	}
	
	public void escribirEmpresasServicio(EmpresaPrestadoraServicio[] empresaPrestadoraServicio) throws ClassNotFoundException, IOException {
		
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		
		fos = new FileOutputStream(direccionEmpresas);
		oos = new ObjectOutputStream(fos);

		for (int i = 0; i < empresaPrestadoraServicio.length ; i++) {
			oos.writeObject(empresaPrestadoraServicio[i]);
		}
		
		fos.close();
		oos.close();
		
	}


	public void setDireccionUsuarios(String direccionUsuarios) {
		this.direccionUsuarios = direccionUsuarios;
	}


	public void setDireccionLugares(String direccionLugares) {
		this.direccionLugares = direccionLugares;
	}


	public void setDireccionEmpresas(String direccionEmpresas) {
		this.direccionEmpresas = direccionEmpresas;
	}
	
	
	
	

}
