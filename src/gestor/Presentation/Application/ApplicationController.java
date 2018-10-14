/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestor.Presentation.Application;

import gestor.Application;
import gestor.Logic.Model;
import gestor.Logic.Usuario;
import gestor.Session;
import java.awt.Point;

/**
 *
 * @author Wizzard
 */
public class ApplicationController {

    private Model domainModel;
    private Session session;
    private ApplicationView view;
    private ApplicationModel model;

    public ApplicationController(ApplicationView view, ApplicationModel model, Model domainModel, Session session) {
        this.domainModel = domainModel;
        this.session = session;

        this.view = view;
        this.model = model;
        view.setController(this);
        view.setModel(model);
    }

    public void enter() {
        this.reset();
        this.show();
    }

    public void exit() {
        this.hide();
        Application.LOGIN_CONTROLLER.logout();
    }

    public void reset() {
        model.reset((Usuario) session.getAttribute(Application.USER_ATTRIBUTE));
    }

    public void show() {
        view.setVisible(true);
    }

    public void show(Point position) {
        view.setLocation(position);
        this.show();
    }

    public void hide() {
        view.setVisible(false);
    }
}
