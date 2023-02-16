package es.hitoIndividualDiego.jpa;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Table(name="roles")
public class Roles implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    private int id;

    private String rol;

    //bi-directional many-to-one association to Usuario
    @ManyToOne
    @JoinColumn(name="nif")
    private Usuario usuario;

    public Roles() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRol() {
        return this.rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}