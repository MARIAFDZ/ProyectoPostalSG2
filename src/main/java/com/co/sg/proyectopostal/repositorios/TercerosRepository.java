package com.co.sg.proyectopostal.repositorios;

import com.co.sg.proyectopostal.entidades.Terceros;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TercerosRepository extends CrudRepository<Terceros, String > {

}
