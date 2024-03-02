package application;


public class EmpresaPrestadoraServicio {
    protected String nombre;
    protected String codigo;
    protected TarifasOfrecidas tarifasOfrecidas;

    public EmpresaPrestadoraServicio(String nombre, String codigo,TarifasOfrecidas tarifasOfrecidas) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.tarifasOfrecidas = tarifasOfrecidas;
    }
}
