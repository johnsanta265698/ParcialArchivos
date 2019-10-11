package modelo;
/**
 *
 * @author john
 */
public class Ciudad {
    String codigo;
    String nombre;
    String codigoPais;
    String rutaNombre;

    public Ciudad() {
        this.codigo = "";
        this.codigoPais = "";
        this.nombre = "";
        this.rutaNombre = "";
    }

    public Ciudad(String codigo, String nombre, String codigoPais, String rutaNombre) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.codigoPais = codigoPais;
        this.rutaNombre = rutaNombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public String getRutaNombre() {
        return rutaNombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRutaNombre(String rutaNombre) {
        this.rutaNombre = rutaNombre;
    }

    @Override
    public String toString() {
        return codigo + "," + nombre + "," + codigoPais + "," + rutaNombre;
    }
    
    
}
