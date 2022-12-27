package com.co.sg.proyectopostal.servicios;

import com.co.sg.proyectopostal.entidades.Rol;
import com.co.sg.proyectopostal.entidades.Usuario;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200")
@Service
public interface UsuarioService {

    @CrossOrigin(origins = "http://localhost:4200")
    public Usuario guardarUsuario(Usuario usuario) throws Exception;


    public Boolean cargarArchivo(MultipartFile file, String correo) throws Exception;
}
