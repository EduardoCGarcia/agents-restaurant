/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiniChatMulPC;

import TCP.client;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eduar
 */
public class Cliente implements Runnable{
    private String host;
    private int puerto;
    private String mensaje;

    public Cliente(String host, int puerto, String mensaje) {
        this.host = host;
        this.puerto = puerto;
        this.mensaje = mensaje;
    }

    
    
    @Override
    public void run() {
        DataOutputStream out;
        try {
            Socket sc = new Socket(host, puerto);
            
            out = new DataOutputStream(sc.getOutputStream());
            
            //Envio un mensaje al cliente
            out.writeUTF(mensaje);
            
            sc.close();
            
        } catch (IOException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
