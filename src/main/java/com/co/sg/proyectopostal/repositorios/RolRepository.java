package com.co.sg.proyectopostal.repositorios;

import com.co.sg.proyectopostal.entidades.Rol;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@Repository
public interface RolRepository extends CrudRepository<Rol, Long> {

    @CrossOrigin
    @Query(value = "select id from ROL r where r.nombre= :roles", nativeQuery = true)
    Long getIdByName2(@Param("roles") String roles);


}
