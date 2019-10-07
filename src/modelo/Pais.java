package modelo;
/**
 *
 * @author john
 */
public class Pais {
    String codigo;
    String nombre;

    public Pais() {
        this.codigo = "";
        this.nombre = "";
    }

    public Pais(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return codigo+","+nombre;
    }
    
    
}
