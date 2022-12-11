/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *  
 * @author eduar
 */
public class client {

    public static void main(String[] args) {
        final String HOST = "127.0.0.1";
        final int PORT = 5000;
        DataInputStream in;
        DataOutputStream out;
        try {
            Socket sc = new Socket(HOST, PORT);
            
            in = new DataInputStream(sc.getInputStream());
            
            out = new DataOutputStream(sc.getOutputStream());
            
            out.writeUTF("Hola mundo desde el cliente");// manda al servidor
            
            String mensaje =  in.readUTF();//recibe el mensaje que viene desde el servidor
            
            System.out.println(mensaje);//muestra el mensaje que manda el servidor
            sc.close();
            
        } catch (IOException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
