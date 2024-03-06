package application.backend.empresa;

public class EmpresaDecoradora extends EmpresaPrestadoraServicio {
    private String[] estiloDecoracion;
    private String especialidad; // interiores, exteriores, interior y exterior
    private String[] alquilerMobiliario; 
    private boolean utilizaPlantas;

    // Constructor
    public EmpresaDecoradora(String nombre, String codigo, boolean utilizaPlantas, double basico, double premium, double deluxe, String[] estiloDecoracion, String especialidad, String[] alquilerMobiliario) {
        super(nombre, codigo, basico, premium, deluxe);
        this.estiloDecoracion = estiloDecoracion;
        this.especialidad = especialidad;
        this.alquilerMobiliario = alquilerMobiliario;
        this.utilizaPlantas = utilizaPlantas;
    }
}