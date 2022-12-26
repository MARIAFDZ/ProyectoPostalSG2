package com.co.sg.proyectopostal.repositorios;

import com.co.sg.proyectopostal.entidades.Archivo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArchivoRepository extends CrudRepository<Archivo, Integer> {


}
