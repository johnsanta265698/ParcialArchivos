package control;
import modelo.Ciudad;
/**
 *
 * @author john
 */
public class controlCiudad {
    Ciudad objCiudad;
    
    public  controlCiudad(Ciudad objCiudad){
        this.objCiudad = objCiudad;
    }
    
    public void guardar(){
        Archivos objArchivos = new Archivos();
        objArchivos.abrirArchivoParaEscritura("Ciudades.txt");
        String codigo = objCiudad.getCodigo();
        String nombre = objCiudad.getNombre();
        String codigoPais = objCiudad.getCodigoPais();
        String rutaNombre = objCiudad.getRutaNombre();
        
        
        boolean sw=esta_no_esta();
        if(sw==false){
            String cadenaCiudad=codigo+","+nombre+","+codigoPais+","+rutaNombre;
            objArchivos.escribirUnaLineaYDebajo(cadenaCiudad);
        }
        objArchivos.cerrarArchivoParaEscritura();
    }
    
    public boolean esta_no_esta(){
        String cad;
        String[] arrCad;
        String cod=objCiudad.getCodigo();
        Archivos objArchivos= new Archivos();
        objArchivos.abrirArchivoParaLectura("Ciudades.txt");
        int i=0;
        long n=objArchivos.contarLineas();
        objArchivos.cerrarArchivoParaLectura();
        boolean sw=false;
        objArchivos.abrirArchivoParaLectura("Ciudades.txt");
        while(i<n && sw==false){
            cad=objArchivos.leerUnaLineaTexto();
            arrCad=cad.split(",");
            if (arrCad[0].equals(cod))sw=true;
            i=i+1;
        }
        return sw;
    }
    
    public void modificar(){
        String linea;
        String[] arrLinea;
        Archivos objArchivos = new Archivos();
        objArchivos.abrirArchivoParaLectura("Ciudades.txt");
        long nLineas = objArchivos.contarLineas();
        objArchivos.cerrarArchivoParaLectura();
        
        Archivos objArchivos1 = new Archivos();
        objArchivos1.abrirArchivoParaEscritura("Ciudades.tmp");
        objArchivos.abrirArchivoParaLectura("Ciudades.txt");
        
        int i=1;
        while (i<=nLineas) {
            linea = objArchivos.leerUnaLineaTexto();
            arrLinea = linea.split(",");
            if(!arrLinea[0].equals(objCiudad.getCodigo()))
                objArchivos1.escribirUnaLineaYDebajo(linea);
            else{
                String codigo = objCiudad.getCodigo();
                String nombre = objCiudad.getNombre();
                String cadCliente = codigo+","+nombre;
                objArchivos1.escribirUnaLineaYDebajo(cadCliente);
            }
            i+=1;
        }
        objArchivos.cerrarArchivoParaLectura();
        objArchivos1.cerrarArchivoParaEscritura();
        
        Archivos objArchivos2 = new Archivos();
        objArchivos2.borrarUnArchivo("Ciudades.txt");
        objArchivos2.renombrarUnArchivo("Ciudades.tmp", "Ciudades.txt");
        objArchivos2.borrarUnArchivo("Ciudades.tmp");
    }
    
    public void borrar(){
        String linea;
        String[] arrLinea;
        Archivos objArchivos = new Archivos();
        objArchivos.abrirArchivoParaLectura("Ciudades.txt");
        long nLineas = objArchivos.contarLineas();
        objArchivos.cerrarArchivoParaLectura();
        
        Archivos objArchivos1 = new Archivos();
        objArchivos1.abrirArchivoParaEscritura("Ciudades.tmp");
        objArchivos.abrirArchivoParaLectura("Ciudades.txt");
        
        int i = 1;
        while (i<=nLineas) {
            linea = objArchivos.leerUnaLineaTexto();
            arrLinea = linea.split(",");
            if (!arrLinea[0].equals(objCiudad.getCodigo())) 
                objArchivos1.escribirUnaLineaYDebajo(linea);
            i+=1;
        }
        objArchivos.cerrarArchivoParaLectura();
        objArchivos1.cerrarArchivoParaEscritura();
        
        Archivos objArchivos2= new Archivos();
        objArchivos2.borrarUnArchivo("Ciudades.txt");
        objArchivos2.renombrarUnArchivo("Ciudades.tmp","Ciudades.txt");
        objArchivos2.borrarUnArchivo("Ciudades.tmp");
    }
    
    public Ciudad consultar(){
        String codigo = objCiudad.getCodigo();
        Archivos objArchivos = new Archivos();
        objArchivos.abrirArchivoParaLectura("Ciudades.txt");
        long nLineas = objArchivos.contarLineas();
        objArchivos.cerrarArchivoParaLectura();
        objArchivos.abrirArchivoParaLectura("Ciudades.txt");
        
        int i = 1;
        while (i<=nLineas) {
            String linea = objArchivos.leerUnaLineaTexto();
            String[] arrLinea = linea.split(",");
            if (codigo.equals(arrLinea[0])) {
                objCiudad.setNombre(arrLinea[1]);
                i = (int)nLineas+1;
            }
            i+=1;
        }
        objArchivos.cerrarArchivoParaLectura();
        return objCiudad;
    }
    
    public String[][] listar(){//mejorar este algoritmo en caso de que el archivo sea grande ya que la matriz no resiste muchso datos
        String[][] mat;
        String linea;
        String[] arrLinea;
        Archivos objArchivos= new Archivos();
        objArchivos.abrirArchivoParaLectura("Ciudades.txt");
        long n=objArchivos.contarLineas();
        mat = new String[(int)n][4];
        objArchivos.cerrarArchivoParaLectura();
        objArchivos.abrirArchivoParaLectura("Ciudades.txt");
        for (long i=0;i<n;i++){
            linea=objArchivos.leerUnaLineaTexto();
            arrLinea=linea.split(",");
            for(int j=0;j<4;j++) mat[(int)i][j]=arrLinea[j];
       }
       objArchivos.cerrarArchivoParaLectura();
       return mat;
    }
}
