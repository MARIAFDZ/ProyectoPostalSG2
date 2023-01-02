package com.co.sg.proyectopostal.Security;

import com.co.sg.proyectopostal.entidades.Usuario;
import com.co.sg.proyectopostal.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@Service
public class UserDetailService implements UserDetailsService {
    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {

        final Optional<Usuario> usuario = usuarioRepository.findByCorreo(correo);
        if (usuario.isEmpty()) {
            throw new UsernameNotFoundException(correo);
        }
        String usuario2 = usuario.get().getCorreo();
        String pass = usuario.get().getContrasenia();


        return new User(usuario2, pass, new ArrayList<>());
    }


}