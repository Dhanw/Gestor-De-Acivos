/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Logic;

import gestor.Data.Dao;

/**
 *
 * @author Wizzard
 */
public class Model {

    private Dao dao;

    private static Model uniqueInstance;

    public static Model instance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Model();
        }
        return uniqueInstance;
    }

    private Model() {
        dao = new Dao();
    }

    public Usuario getUsuario(String id, String clave) throws Exception {
        Usuario u = dao.usuarioGet(id);
        if (u.getPssword().equals(clave)) {
            return u;
        } else {
            throw new Exception("Clave incorrecta");
        }
    }

    public void close() {
        dao.close();
    }
}
