package com.co.sg.proyectopostal.entidades;


import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "TIPODOCUMENTO")
public class TipoDocumento {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "NOMBRE")
    private String nombre;

    //@OneToMany(mappedBy = "tipoDocumento")
    //private List<Usuario> usuarios;

    public TipoDocumento() {
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

    //public List<Usuario> getUsuarios() {
    //return usuarios;
    //}

    //public void setUsuarios(List<Usuario> usuarios) {
    //this.usuarios = usuarios;
    //}
}
