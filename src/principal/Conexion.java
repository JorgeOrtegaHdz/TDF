package principal;
import gnu.io.CommPortIdentifier;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.UnsupportedCommOperationException;
import java.io.OutputStream;
import java.io.InputStream;
import java.util.Enumeration;

public class Conexion {
    CommPortIdentifier cpi=null;
    Enumeration puertos=null;
    SerialPort puerto=null;
    OutputStream ops;
    InputStream ips;
    public void getConexion(){
        puertos=CommPortIdentifier.getPortIdentifiers();
        while(puertos.hasMoreElements()){
            cpi=(CommPortIdentifier) puertos.nextElement();
            int tipo=cpi.getPortType();
            System.out.println("Puerto activo: "+cpi.getName());
        }
    }
    
    public static void main(String[]args){
        Conexion c=new Conexion();
        c.getConexion();
        System.exit(0);
    }
}
