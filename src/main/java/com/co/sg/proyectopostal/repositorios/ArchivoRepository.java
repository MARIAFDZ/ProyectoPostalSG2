package com.co.sg.proyectopostal.repositorios;

import com.co.sg.proyectopostal.entidades.Archivo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArchivoRepository extends CrudRepository<Archivo, Integer> {
    List<Archivo> findAll();
}
