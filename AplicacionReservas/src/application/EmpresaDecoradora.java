package application;

public class EmpresaDecoradora extends EmpresaPrestadoraServicio {
    private String[] estiloDecoracion;
    private String especialidad; // interiores, exteriores, interior y exterior
    private String[] alquilerMobiliario; 
    private boolean utilizaPlantas;

    // Constructor
    public EmpresaDecoradora(String nombre, String codigo, boolean utilizaPlantas,TarifasOfrecidas tarifasOfrecidas, String[] estiloDecoracion, String especialidad, String[] alquilerMobiliario) {
        super(nombre, codigo, tarifasOfrecidas);
        this.estiloDecoracion = estiloDecoracion;
        this.especialidad = especialidad;
        this.alquilerMobiliario = alquilerMobiliario;
        this.utilizaPlantas = utilizaPlantas;
    }
}