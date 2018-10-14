/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor;

import gestor.Logic.Model;
import gestor.Presentation.Application.ApplicationController;
import gestor.Presentation.Application.ApplicationModel;
import gestor.Presentation.Application.ApplicationView;
import gestor.Presentation.Login.LoginController;
import gestor.Presentation.Login.LoginModel;
import gestor.Presentation.Login.LoginView;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

/**
 *
 * @author Wizzard
 */
public class Application {

    public static void main(String[] argv) {
        Model domainModel = Model.instance();
        Session session = new Session();

        ApplicationModel applicationModel = new ApplicationModel();
        ApplicationView applicationView = new ApplicationView();
        ApplicationController applicationController = new ApplicationController(applicationView, applicationModel, domainModel, session);
        APPLICATION_CONTROLLER = applicationController;

        LoginModel loginModel = new LoginModel();
        LoginView loginView = new LoginView();
        LoginController logincontroller = new LoginController(loginView, loginModel, domainModel, session);
        LOGIN_CONTROLLER = logincontroller;
        loginView.setVisible(true);

    }
    public static ApplicationController APPLICATION_CONTROLLER; 
    public static LoginController LOGIN_CONTROLLER;

    public static final int MODO_AGREGAR = 0;
    public static final int MODO_EDITAR = 1;
    public static final int MODO_CONSULTAR = 2;

    public static Border BORDER_ERROR = BorderFactory.createLineBorder(Color.red);
    public static Border BORDER_NOBORDER = BorderFactory.createLineBorder(Color.red);

    public static final String USER_ATTRIBUTE = "User";

    public static final String ROL_MANAGER = "Gerencia";
    public static final String ROL_SUPERVISOR = "Supervisor";
    public static final String ROL_CLERK = "Oficinista";

    public static final String ROL_NOTAUTHORIZED = "No Autorizado!";

    public static final Color COLOR_ERROR = Color.red;
    public static final Color COLOR_OK = Color.black;
}
