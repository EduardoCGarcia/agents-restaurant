package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eduar
 */
public class server {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;
        
        /**
         * El minimo
         * El maximo es 650000
         */
        final int PORT = 5000;
        
        try {
            server = new ServerSocket(PORT);
            System.out.println("Servidor iniciado");
            while (true) {                
                sc = server.accept();
                
                System.out.println("Cliente conectado");
                
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());
                
                String mensaje = in.readUTF();
                
                System.out.println(mensaje);
                
                out.writeUTF("Hola mundo desde el servidor");// Esto aparecce en la terminal del cliente
                sc.close();
                System.out.println("Cliente desconectado");
                
                
                
            }
        } catch (IOException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
