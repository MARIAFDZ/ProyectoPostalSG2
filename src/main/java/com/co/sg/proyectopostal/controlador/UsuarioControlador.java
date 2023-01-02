package com.co.sg.proyectopostal.controlador;

import com.co.sg.proyectopostal.Security.AuthenticationConfig;
import com.co.sg.proyectopostal.Security.JWTUtil;
import com.co.sg.proyectopostal.Security.UserDetailService;
import com.co.sg.proyectopostal.dto.AuthenticationRequest;
import com.co.sg.proyectopostal.dto.AuthenticationResponse;
import com.co.sg.proyectopostal.entidades.Archivo;
import com.co.sg.proyectopostal.entidades.Rol;
import com.co.sg.proyectopostal.entidades.Usuario;
import com.co.sg.proyectopostal.impl.ArchivoServiceImpl;
import com.co.sg.proyectopostal.impl.UsuarioServiceImpl;
import com.co.sg.proyectopostal.repositorios.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Set;

import static org.springframework.security.crypto.bcrypt.BCrypt.checkpw;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {

    @Autowired
    private ArchivoServiceImpl archivoServiceImpl;
    @Autowired
    private UsuarioServiceImpl usuarioServiceImpl;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private AuthenticationConfig authenticationManager;

    @Autowired
    private  BCryptPasswordEncoder bCryptPasswordEncoder;


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


            authenticationManager.authenticationManagerBean().authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword()));
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

        Long usuario = usuarioRepository.getAllByCorreo2(correo);


        return usuario;
    }

    @PostMapping("/cargarArchivo")
    public Boolean cargaArchivo(@RequestParam MultipartFile file, @RequestParam String correo) throws Exception{


        return usuarioServiceImpl.cargarArchivo(file, correo);
    }
    @GetMapping("/obtenerInfoArchivo")
    public List <Archivo> listar(){
        try {
            return archivoServiceImpl.listar();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}


