package es.hitoIndividualDiego.jpa;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
public class Tarea implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private int id;

    private String descripcion;

    private byte estado;

    private String nombre;

    @ManyToOne
    @JoinColumn(name="NIF")
    private Usuario usuario;

    public Tarea() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public byte getEstado() {
        return this.estado;
    }

    public void setEstado(byte estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}