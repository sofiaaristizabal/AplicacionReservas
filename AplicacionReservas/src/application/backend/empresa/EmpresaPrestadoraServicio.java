package application.backend.empresa;


public class EmpresaPrestadoraServicio {
    protected String nombre;
    protected String codigo;
    protected double basico;
    protected double premium;
    protected double deluxe;
    


    public EmpresaPrestadoraServicio(String nombre, String codigo, double basico, double premium, double deluxe) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.basico = basico;
        this.premium= premium;
        this.deluxe = deluxe;

    }
}
