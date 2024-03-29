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
    
    public void modificar(){
        String linea;
        String[] arrLinea;
        Archivos objArchivos = new Archivos();
        objArchivos.abrirArchivoParaLectura("Paises.txt");
        long nLineas = objArchivos.contarLineas();
        objArchivos.cerrarArchivoParaLectura();
        
        Archivos objArchivos1 = new Archivos();
        objArchivos1.abrirArchivoParaEscritura("Paises.tmp");
        objArchivos.abrirArchivoParaLectura("Paises.txt");
        
        int i=1;
        while (i<=nLineas) {
            linea = objArchivos.leerUnaLineaTexto();
            arrLinea = linea.split(",");
            if(!arrLinea[0].equals(objPais.getCodigo()))
                objArchivos1.escribirUnaLineaYDebajo(linea);
            else{
                String codigo = objPais.getCodigo();
                String nombre = objPais.getNombre();
                String cadCliente = codigo+","+nombre;
                objArchivos1.escribirUnaLineaYDebajo(cadCliente);
            }
            i+=1;
        }
        objArchivos.cerrarArchivoParaLectura();
        objArchivos1.cerrarArchivoParaEscritura();
        
        Archivos objArchivos2 = new Archivos();
        objArchivos2.borrarUnArchivo("Paises.txt");
        objArchivos2.renombrarUnArchivo("Paises.tmp", "Paises.txt");
        objArchivos2.borrarUnArchivo("Paises.tmp");
    }
    
    public void borrar(){
        String linea;
        String[] arrLinea;
        Archivos objArchivos = new Archivos();
        objArchivos.abrirArchivoParaLectura("Paises.txt");
        long nLineas = objArchivos.contarLineas();
        objArchivos.cerrarArchivoParaLectura();
        
        Archivos objArchivos1 = new Archivos();
        objArchivos1.abrirArchivoParaEscritura("Paises.tmp");
        objArchivos.abrirArchivoParaLectura("Paises.txt");
        
        int i = 1;
        while (i<=nLineas) {
            linea = objArchivos.leerUnaLineaTexto();
            arrLinea = linea.split(",");
            if (!arrLinea[0].equals(objPais.getCodigo())) 
                objArchivos1.escribirUnaLineaYDebajo(linea);
            i+=1;
        }
        objArchivos.cerrarArchivoParaLectura();
        objArchivos1.cerrarArchivoParaEscritura();
        
        Archivos objArchivos2= new Archivos();
        objArchivos2.borrarUnArchivo("Paises.txt");
        objArchivos2.renombrarUnArchivo("Paises.tmp","Paises.txt");
        objArchivos2.borrarUnArchivo("Paises.tmp");
    }
    
    public Pais consultar(){
        String codigo = objPais.getCodigo();
        Archivos objArchivos = new Archivos();
        objArchivos.abrirArchivoParaLectura("Paises.txt");
        long nLineas = objArchivos.contarLineas();
        objArchivos.cerrarArchivoParaLectura();
        objArchivos.abrirArchivoParaLectura("Paises.txt");
        
        int i = 1;
        while (i<=nLineas) {
            String linea = objArchivos.leerUnaLineaTexto();
            String[] arrLinea = linea.split(",");
            if (codigo.equals(arrLinea[0])) {
                objPais.setNombre(arrLinea[1]);
                i = (int)nLineas+1;
            }
            i+=1;
        }
        objArchivos.cerrarArchivoParaLectura();
        return objPais;
    }
    
    public String[][] listar(){//mejorar este algoritmo en caso de que el archivo sea grande ya que la matriz no resiste muchso datos
        String[][] mat;
        String linea;
        String[] arrLinea;
        Archivos objArchivos= new Archivos();
        objArchivos.abrirArchivoParaLectura("Paises.txt");
        long n=objArchivos.contarLineas();
        mat = new String[(int)n][2];
        objArchivos.cerrarArchivoParaLectura();
        objArchivos.abrirArchivoParaLectura("Paises.txt");
        for (long i=0;i<n;i++){
            linea=objArchivos.leerUnaLineaTexto();
            arrLinea=linea.split(",");
            for(int j=0;j<2;j++) mat[(int)i][j]=arrLinea[j];
       }
       objArchivos.cerrarArchivoParaLectura();
       return mat;
    }
    
}
