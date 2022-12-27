package com.co.sg.proyectopostal.controlador;

import com.co.sg.proyectopostal.Security.AuthenticationConfig;
import com.co.sg.proyectopostal.Security.JWTUtil;
import com.co.sg.proyectopostal.Security.UserDetailService;
import com.co.sg.proyectopostal.dto.AuthenticationRequest;
import com.co.sg.proyectopostal.dto.AuthenticationResponse;
import com.co.sg.proyectopostal.entidades.Rol;
import com.co.sg.proyectopostal.entidades.Usuario;
import com.co.sg.proyectopostal.impl.UsuarioServiceImpl;
import com.co.sg.proyectopostal.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Set;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {

    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private AuthenticationConfig authenticationManager;
    @Autowired
    UserDetailService userDetailService;

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/registroUsuario")
    public void registro(@RequestBody Usuario usuario) throws Exception {
        usuarioServiceImpl.guardarUsuario(usuario);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> createToken(@RequestBody AuthenticationRequest request) throws AuthenticationException, Exception {
        try {
            authenticationManager.authenticationManagerBean().authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            UserDetails userDetails = userDetailService.loadUserByUsername(request.getUsername());
            String jwt = jwtUtil.generateToken(userDetails);

            return new ResponseEntity<>(new AuthenticationResponse(jwt), HttpStatus.OK);
        } catch (BadCredentialsException e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }


    }

    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/obtenerRolUser")
    public Long encontrarUsuario(@RequestParam String correo){
        System.out.println(correo);

        Long usuario = usuarioRepository.getAllByCorreo2(correo);
        System.out.println(usuario);


        return usuario;
    }

    @PostMapping("/cargarArchivo")
    public Boolean cargaArchivo(@RequestParam MultipartFile file, @RequestParam String correo) throws Exception{
        System.out.println(file);

        return usuarioServiceImpl.cargarArchivo(file, correo);
    }


}


