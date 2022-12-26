package com.co.sg.proyectopostal.impl;


import com.co.sg.proyectopostal.entidades.Archivo;
import com.co.sg.proyectopostal.repositorios.ArchivoRepository;
import com.co.sg.proyectopostal.servicios.ArchivoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
@Service
public class ArchivoServiceImpl implements ArchivoService {


    private final ArchivoRepository archivoRepository;

    @Override
    public void guardarInfoArchivo(Archivo archivo) throws Exception {
        archivoRepository.save(archivo);

    }




}
