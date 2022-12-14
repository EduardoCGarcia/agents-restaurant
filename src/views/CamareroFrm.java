/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import MiniChatMulPC.Cliente;
import MiniChatMulPC.Server;
import Utilerias.FondoImagen;
import jade.core.AID;
import jade.lang.acl.ACLMessage;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import models.Producto;
import tools.GUITools;

/**
 *
 * @author eduar
 */
public class CamareroFrm extends javax.swing.JFrame implements Observer {

    /**
     * Creates new form Camarero
     */
    private Menu m = new Menu();
    public static boolean s = false;
    public static ArrayList<Producto> productos = new ArrayList<Producto>();

    public CamareroFrm() {
        initComponents();
        m.setVisible(true);
        this.getRootPane().setDefaultButton(this.btnTerminarPedido);
        Server s = new Server(5000);
        s.addObserver(this);
        Thread t = new Thread(s);
        t.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new FondoImagen("camarero.jpg");
        jScrollPane1 = new javax.swing.JScrollPane();
        txtNota = new javax.swing.JTextArea();
        btnTerminarPedido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 303, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        txtNota.setColumns(20);
        txtNota.setRows(5);
        jScrollPane1.setViewportView(txtNota);

        btnTerminarPedido.setText("Terminar Pedido");
        btnTerminarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTerminarPedidoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnTerminarPedido, javax.swing.GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTerminarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTerminarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTerminarPedidoActionPerformed
        Cliente c = new Cliente("192.168.100.4", 5000, Menu.mensajeProductos());
        Thread t = new Thread(c);
        s = true;
        t.start();
    }//GEN-LAST:event_btnTerminarPedidoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CamareroFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CamareroFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CamareroFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CamareroFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CamareroFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTerminarPedido;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTextArea txtNota;
    // End of variables declaration//GEN-END:variables
    @Override
    public void update(Observable o, Object arg) {
        this.txtNota.append("\n-----------------------\n");
        this.txtNota.append("Tu orden esta lista\nSe te hace entrega\nde lo siguiente: \n");
        this.txtNota.append((String) arg);

        switch ((String) arg) {
            case "Hamburgesa 1" -> {
                Entrega n = new Entrega(this, true);
                GUITools.panelIntoPanel(n.pnlImg, new FondoImagen("h1.jpeg"));
                n.setVisible(true);
            }
            case "Hamburgesa 2" -> {
                Entrega n = new Entrega(this, true);
                GUITools.panelIntoPanel(n.pnlImg, new FondoImagen("h2.jpg"));
                n.setVisible(true);
            }
            case "Hamburgesa 3" -> {
                Entrega n = new Entrega(this, true);
                GUITools.panelIntoPanel(n.pnlImg, new FondoImagen("h3.jpg"));
                n.setVisible(true);
            }
            case "Pizza 1" -> {
                Entrega n = new Entrega(this, true);
                GUITools.panelIntoPanel(n.pnlImg, new FondoImagen("p1.jpg"));
                n.setVisible(true);
            }
            case "Pizza 2" -> {
                Entrega n = new Entrega(this, true);
                GUITools.panelIntoPanel(n.pnlImg, new FondoImagen("p2.jpg"));
                n.setVisible(true);
            }
            case "Pizza 3" -> {
                Entrega n = new Entrega(this, true);
                GUITools.panelIntoPanel(n.pnlImg, new FondoImagen("p3.jpg"));
                n.setVisible(true);
            }
            case "Malteada 1" -> {
                Entrega n = new Entrega(this, true);
                GUITools.panelIntoPanel(n.pnlImg, new FondoImagen("b1.jpg"));
                n.setVisible(true);
            }
            case "Malteada 2" -> {
                Entrega n = new Entrega(this, true);
                GUITools.panelIntoPanel(n.pnlImg, new FondoImagen("b2.jpg"));
                n.setVisible(true);
            }
        }
    }

}
