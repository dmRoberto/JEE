package es.art83.web.design.models.entities.persona;

public class Persona {
    private int id;

    private String nombre;

    private String rol;

    public Persona(int id, String nombre, String rol) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
    }

    public Persona() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return this.rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Persona[" + id + "," + nombre + "," + rol + "]";
    }

}
