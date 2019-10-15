package control;
import java.util.Random;
import java.awt.Image;
import java.text.Normalizer;
import javax.swing.ImageIcon;
import modelo.Ciudad;
import modelo.Pais;
/**
 *
 * @author john
 */
public class controlJugar {
   
    /*Image img= new ImageIcon("/home/john/Imágenes/Secretos/1.png").getImage();
        ImageIcon img2=new ImageIcon(img.getScaledInstance(223, 124, Image.SCALE_SMOOTH));
        lblImagen.setIcon(img2);*/
    
    //Metodo funcionando
    public Ciudad saleccionarCiudad(){
        Ciudad objCiudad = null;
        Archivos objArchivos = new Archivos();
        Archivos objArchivos1 = new Archivos();
        objArchivos.abrirArchivoParaLectura("Ciudades.txt");
        long nLineas = objArchivos.contarLineas();
        objArchivos.cerrarArchivoParaLectura();
        objArchivos1.abrirArchivoParaLectura("Ciudades.txt");
        //generar aleatorio
        System.out.print(nLineas);
        int aleatorio = (int)(Math.random()*nLineas+1);
        int i = 1;
        while (i<=nLineas) {
            String linea = objArchivos1.leerUnaLineaTexto();
            String[] arrLinea = linea.split(",");
            if (i==aleatorio) {
                objCiudad = new Ciudad(arrLinea[0],arrLinea[1], arrLinea[2],arrLinea[3]);
                i = (int)nLineas+1;
            }
            i+=1;
        }
        objArchivos1.cerrarArchivoParaLectura();
        return objCiudad;
    }
    
    public boolean validarPais(Ciudad ciudad, String pais){
        Archivos objArchivos = new Archivos();
        Archivos objArchivos1 = new Archivos();
        objArchivos.abrirArchivoParaLectura("Paises.txt");
        objArchivos1.abrirArchivoParaLectura("Ciudades.txt");
        Pais objPais = buscarLinea("Paises.txt", pais);
        if (objPais!=null) {
            if (ciudad.getCodigo().equals(objPais.getCodigo())) {
                return true;
            }else{
                return false;
            }
        }else{
            return false;
        }
    }
    
    public Pais buscarLinea(String ruta, String pais){
        Pais objPais = null;
        pais = cleanString(pais);
        pais = pais.toUpperCase();
        Archivos objArchivos = new Archivos();
        objArchivos.abrirArchivoParaLectura("Paises.txt");
        long nLineas = objArchivos.contarLineas();
        objArchivos.cerrarArchivoParaLectura();
        objArchivos.abrirArchivoParaLectura("Paises.txt");
        
        int i = 1;
        while (i<=nLineas) {
            String linea = objArchivos.leerUnaLineaTexto();
            String[] arrLinea = linea.split(",");
            arrLinea[1] = cleanString(arrLinea[1]);
            if (pais.equals(arrLinea[1].toUpperCase())) {
                objPais = new Pais(arrLinea[0], arrLinea[1]);
                i = (int)nLineas+1;
            }
            i+=1;
        }
        objArchivos.cerrarArchivoParaLectura();
        return objPais;
    }
    
        public static String cleanString(String texto) {//QUITA CARACTERES ESPECIALES DE CUALQUIER TEXTO
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return texto;
    }   
    
}
