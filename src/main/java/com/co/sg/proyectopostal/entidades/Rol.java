package com.co.sg.proyectopostal.entidades;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ROL")
public class Rol {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOMBRE")
    private String nombre;

    //@OneToMany(mappedBy = "rol")
    //private List<Usuario> usuarios;

    public Rol() {
    }

    public Integer getId() {
        return id;
    }

    public void setidRolL(Integer IDROL) {
        this.id = IDROL;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
