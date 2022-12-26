package com.co.sg.proyectopostal.repositorios;

import com.co.sg.proyectopostal.entidades.TipoDocumento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TipoDocumentoRepository extends CrudRepository<TipoDocumento, Integer> {
    Optional<TipoDocumento> findByNombre(String nombre);

}
