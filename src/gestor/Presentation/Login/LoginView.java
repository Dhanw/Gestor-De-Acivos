/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Presentation.Login;

import gestor.Application;
import gestor.Logic.Usuario;
import javax.swing.JOptionPane;

/**
 *
 * @author Wizzard
 */
public class LoginView extends javax.swing.JFrame implements java.util.Observer {

    private LoginController controller;
    private LoginModel model;

    /**
     * Creates new form LoginView
     */
    public LoginView() {
        initComponents();
        this.getRootPane().setDefaultButton(BotonIngresar);
    }

    public void setController(LoginController controller) {
        this.controller = controller;
    }

    public LoginController getController() {
        return controller;
    }

    public void setModel(LoginModel model) {
        this.model = model;
        model.addObserver(this);
    }

    public LoginModel getModel() {
        return model;
    }

    @Override
    public void update(java.util.Observable updatedModel, Object parametros) {
        this.limpiarErrores();
        Usuario current = model.getCurrent();
        this.fromUsuario(current);
    }

    Usuario toUsuario() {
        Usuario result = new Usuario();
        result.setId(idFld.getText());
        result.setPssword(new String(this.claveFld.getPassword()));
        return result;
    }

    public void fromUsuario(Usuario current) {
        idFld.setText(current.getId());
        claveFld.setText(current.getPssword());
    }

    public void limpiarErrores() {
        this.idLbl.setForeground(Application.COLOR_OK);
        this.claveLbl.setForeground(Application.COLOR_OK);
    }

    boolean validar() {
        boolean error = false;

        this.idLbl.setForeground(Application.COLOR_OK);
        if (this.idFld.getText().isEmpty()) {
            this.idLbl.setForeground(Application.COLOR_ERROR);
            error = true;
        }

        this.claveLbl.setForeground(Application.COLOR_OK);
        if ((new String(this.claveFld.getPassword())).isEmpty()) {
            this.claveLbl.setForeground(Application.COLOR_ERROR);
            error = true;
        }
//
        return !error;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        idLbl = new javax.swing.JLabel();
        idFld = new javax.swing.JTextField();
        claveLbl = new javax.swing.JLabel();
        claveFld = new javax.swing.JPasswordField();
        BotonIngresar = new javax.swing.JButton();
        BotonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        idLbl.setText("ID : ");

        idFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idFldActionPerformed(evt);
            }
        });

        claveLbl.setText("Password:");

        BotonIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/gestor/Presentation/icons/general/login.png"))); // NOI18N
        BotonIngresar.setText("LogIn");
        BotonIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonIngresarActionPerformed(evt);
            }
        });

        BotonSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/src/gestor/Presentation/icons/general/exit.png"))); // NOI18N
        BotonSalir.setText("Cancel");
        BotonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(idLbl)
                            .addComponent(claveLbl))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(idFld)
                            .addComponent(claveFld, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(BotonIngresar)
                        .addGap(60, 60, 60)
                        .addComponent(BotonSalir)))
                .addContainerGap(86, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idLbl)
                    .addComponent(idFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(claveLbl)
                    .addComponent(claveFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonIngresar)
                    .addComponent(BotonSalir))
                .addGap(63, 63, 63))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idFldActionPerformed
        //
    }//GEN-LAST:event_idFldActionPerformed

    private void BotonIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonIngresarActionPerformed
         if(this.validar()){
            try {
                this.controller.login(this.toUsuario());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE); 
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "Error en datos", "ERROR", JOptionPane.ERROR_MESSAGE);
        } 
    }//GEN-LAST:event_BotonIngresarActionPerformed

    private void BotonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSalirActionPerformed
         this.controller.exit();
    }//GEN-LAST:event_BotonSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonIngresar;
    private javax.swing.JButton BotonSalir;
    private javax.swing.JPasswordField claveFld;
    private javax.swing.JLabel claveLbl;
    private javax.swing.JTextField idFld;
    private javax.swing.JLabel idLbl;
    // End of variables declaration//GEN-END:variables
}
