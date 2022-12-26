package com.co.sg.proyectopostal.repositorios;

import com.co.sg.proyectopostal.entidades.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin
@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String> {

    Optional<Usuario> findByCorreo (String correo);


    @CrossOrigin(origins = "http://localhost:4200")
    @Query(value = "select idrol from USUARIOS r where r.correo= :correos", nativeQuery = true)
    Long getAllByCorreo2(@Param("correos") String correos);












}
