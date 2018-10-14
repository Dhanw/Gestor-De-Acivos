/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Logic;

/**
 *
 * @author Wizzard
 */
public class Usuario {

    String id;
    String pssword;
    String puesto;

    public Usuario(String id, String clave, String rol) {
        this.id = id;
        this.pssword = clave;
        this.puesto = rol;
    }

    public Usuario() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPssword() {
        return pssword;
    }

    public void setPssword(String pssword) {
        this.pssword = pssword;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
}
