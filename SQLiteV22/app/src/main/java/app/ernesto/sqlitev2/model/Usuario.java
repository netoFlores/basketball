package app.ernesto.sqlitev2.model;

import java.io.Serializable;

/**
 * Created by Neto on 10/11/2015.
 */
public class Usuario implements Serializable{
    private Integer id;
    private String nombre;
    private String apellido;
    private String correo;
    private String clave;

    public Usuario() {
    }

    public Usuario(Integer id, String nombre, String apellido, String correo, String clave) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.clave = clave;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
