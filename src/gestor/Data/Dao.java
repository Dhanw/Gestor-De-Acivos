/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Data;

import gestor.Logic.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Wizzard
 */
public class Dao {

    private RelDataBase db;

    public Dao() {
        db = new RelDataBase();
    }

    public Usuario usuarioGet(String id) throws Exception {
        String sql = "select * from Usuario where idUsuario='%s'";
        sql = String.format(sql, id);
        ResultSet rs = db.executeQuery(sql);
        if (rs.next()) {
            return usuario(rs);
        } else {
            throw new Exception("Usurio no Existe");
        }
    }

    private Usuario usuario(ResultSet rs) {
        try {
            Usuario u = new Usuario();
            u.setId(rs.getString("idUsuario"));
            u.setPssword(rs.getString("pssword"));
            u.setPuesto(rs.getString("puesto"));
            return u;
        } catch (SQLException ex) {
            return null;// esto es una prueba
        }
    }
    public  void close(){
    }
}
