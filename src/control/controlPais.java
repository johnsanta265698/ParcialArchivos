package control;
import modelo.Pais;
/**
 *
 * @author john
 */
public class controlPais {
    Pais objPais;
    
    public controlPais(Pais objPais){
        this.objPais = objPais;
    }
    
    public void guardar(){
        Archivos objArchivos = new Archivos();
        objArchivos.abrirArchivoParaEscritura("Paises.txt");
        String codigo = objPais.getCodigo();
        String nombre = objPais.getNombre();
        
        boolean sw=esta_no_esta();
        if(sw==false){
            String cadPais=codigo+","+nombre;
            objArchivos.escribirUnaLineaYDebajo(cadPais);
        }
        objArchivos.cerrarArchivoParaEscritura();
    }
    
    
    public boolean esta_no_esta(){
        String cad;
        String[] arrCad;
        String cod=objPais.getCodigo();
        Archivos objArchivos= new Archivos();
        objArchivos.abrirArchivoParaLectura("Paises.txt");
        int i=0;
        long n=objArchivos.contarLineas();
        objArchivos.cerrarArchivoParaLectura();
        boolean sw=false;
        objArchivos.abrirArchivoParaLectura("Paises.txt");
        while(i<n && sw==false){
            cad=objArchivos.leerUnaLineaTexto();
            arrCad=cad.split(",");
            if (arrCad[0].equals(cod))sw=true;
            i=i+1;
        }
        return sw;
    }
}
