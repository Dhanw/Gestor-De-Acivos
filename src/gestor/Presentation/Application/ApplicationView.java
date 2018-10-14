/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Presentation.Application;

import java.util.Observable;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Wizzard
 */
public class ApplicationView extends javax.swing.JFrame implements java.util.Observer {

    private ApplicationController controller;
    private ApplicationModel model;

    public void setController(ApplicationController controller) {
        this.controller = controller;
    }

    public ApplicationController getController() {
        return controller;
    }

    public void setModel(ApplicationModel model) {
        this.model = model;
        model.addObserver(this);
    }

    public ApplicationModel getModel() {
        return model;
    }

    @Override
    public void update(java.util.Observable updatedModel, Object parametros) {
        if (model.getCurrent() != null) {
            this.setTitle("Usuarios (" + model.getCurrent().getId() + ")");
        } else {
            this.setTitle("Usuarios ");
        }
    }

    public void addInternalFrame(JInternalFrame f) {
        //this.desktopPane.add(f);
    }

    /**
     * Creates new form ApplicationView
     */
    public ApplicationView() {
        initComponents();
        this.setSize(this.getMaximumSize());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        AyudaMenu = new javax.swing.JMenu();
        AboutMenu = new javax.swing.JMenuItem();
        SalirMenu = new javax.swing.JMenu();
        LogoutMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        AyudaMenu.setText("ayuda");

        AboutMenu.setText("About");
        AboutMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AboutMenuActionPerformed(evt);
            }
        });
        AyudaMenu.add(AboutMenu);

        jMenuBar1.add(AyudaMenu);

        SalirMenu.setText("salir");

        LogoutMenu.setText("Logout");
        LogoutMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutMenuActionPerformed(evt);
            }
        });
        SalirMenu.add(LogoutMenu);

        jMenuBar1.add(SalirMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LogoutMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutMenuActionPerformed
        controller.exit();
    }//GEN-LAST:event_LogoutMenuActionPerformed

    private void AboutMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AboutMenuActionPerformed
        JOptionPane.showMessageDialog(this, "Sistema de activos \n Version 1.0", "Acerca de..", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_AboutMenuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem AboutMenu;
    private javax.swing.JMenu AyudaMenu;
    private javax.swing.JMenuItem LogoutMenu;
    private javax.swing.JMenu SalirMenu;
    private javax.swing.JMenuBar jMenuBar1;
    // End of variables declaration//GEN-END:variables
}
