package com.co.sg.proyectopostal.entidades;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class Terceros {

    @Id
    @Column(name = "NUMERO_GIRO")
    private String id;

    @Column(name = "TIPO_DOCUMENTO")
    private Integer idTipo;

    @Column(name = "NUMERO_IDENTIFICACION")
    private String cedula;

    @Column(name = "NOMBRE1")
    private String nombre1;

    @Column(name = "NOMBRE2")
    private String nombre2;

    @Column(name = "APELLIDO1")
    private String apellido1;

    @Column(name = "APELLIDO2")
    private String apellido2;

    @Column(name = "AGENCIA_DESTINO")
    private String agenciaDestino;

    @Column(name = "VALOR_GIRO")
    private String valorGiro;




}
