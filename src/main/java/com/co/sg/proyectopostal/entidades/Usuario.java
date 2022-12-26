package com.co.sg.proyectopostal.entidades;

import org.springframework.data.repository.cdi.Eager;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "USUARIOS")
public class Usuario {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "IDROL")
    private Integer idRol;

    @Column(name = "IDTIPO")
    private Integer idTipo;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "APELLIDO")
    private String apellido;

    @Column(name = "CORREO")
    private String correo;

    @Column(name = "CONTRASENIA")
    private String contrasenia;

    @Column(name = "CEDULA")
    private String cedula;


    //@ManyToOne
    //@JoinColumn(name = "IDROL", insertable = false, updatable = false)
    //private Rol rol;

    //@ManyToOne
    //@JoinColumn(name = "IDTIPO", insertable = false, updatable = false)
    //private TipoDocumento tipoDocumento;

    //@OneToMany(mappedBy = "usuario")
    //private List<Archivo> archivos;

    public Usuario() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }

    public Integer getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(Integer idTipo) {
        this.idTipo = idTipo;
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

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    //public Rol getRol() {
    //return rol;
    //}

    // public void setRol(Rol rol) {
    //this.rol = rol;
    //}

    //public TipoDocumento getTipoDocumento() {
    //return tipoDocumento;
    //}

    //public void setTipoDocumento(TipoDocumento tipoDocumento) {
    //this.tipoDocumento = tipoDocumento;
    //}


}
