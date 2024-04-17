/*
 */
package com.emergentes.modelo;
import java.util.Date;
/**
 *
 * @author Ramos
 */
public class Persona {
    private int id;
    private Date fecha;
    private String nombre;
    private String apellidos;
    private String turno;
    private String[] seminarios;

     public Persona() {
        this.id = 0;
        this.fecha = new Date();
        this.nombre = "";
        this.apellidos = "";
        this.turno = "";
        this.seminarios = new String[0];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String[] getSeminarios() {
        return seminarios;
    }

    public void setSeminarios(String[] seminarios) {
        this.seminarios = seminarios;
    }
}
