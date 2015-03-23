package es.art83.web.design.views.beans.persona;

import org.apache.logging.log4j.LogManager;

public class RolView {
    private String[] roles;

    private String rol;

    public RolView() {
    }

    public String[] getRoles() {
        return roles;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public void update() {
        LogManager.getLogger(RolView.class).debug(
                "Se accede a la capa de negocio para recuperar roles");
        this.roles = new String[] {"uno", "dos", "tres"};
    }

    public String process() {
        LogManager.getLogger(RolView.class).debug(
                "Se accede a la capa de negocio para registrar rol: " + rol);
        return "home";
    }

}
