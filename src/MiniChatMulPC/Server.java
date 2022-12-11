/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MiniChatMulPC;

import TCP.server;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eduar
 */
public class Server extends Observable implements Runnable {
    private int port;

    public Server(int port) {
        this.port = port;
    }
    
    @Override
    public void run() {
        ServerSocket server = null;
        Socket sc = null;
        DataInputStream in;

        try {
            server = new ServerSocket(port);
            System.out.println("Servidor iniciado");
            while (true) {
                sc = server.accept();

                System.out.println("Cliente conectado");

                in = new DataInputStream(sc.getInputStream());
                
                String mensaje = in.readUTF();

                System.out.println(mensaje);
                
                this.setChanged();
                this.notifyObservers(mensaje);
                this.clearChanged();
                
                sc.close();
                System.out.println("Cliente desconectado");

            }
        } catch (IOException ex) {
            Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
