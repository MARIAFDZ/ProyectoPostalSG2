package com.co.sg.proyectopostal.servicios;

import com.co.sg.proyectopostal.entidades.Archivo;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:4200")
@Service
public interface ArchivoService {

    public void guardarInfoArchivo(Archivo archivo) throws Exception;
}
