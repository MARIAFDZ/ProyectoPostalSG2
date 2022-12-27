package com.co.sg.proyectopostal.impl;

import com.co.sg.proyectopostal.entidades.*;
import com.co.sg.proyectopostal.repositorios.RolRepository;
import com.co.sg.proyectopostal.repositorios.TercerosRepository;
import com.co.sg.proyectopostal.repositorios.TipoDocumentoRepository;
import com.co.sg.proyectopostal.repositorios.UsuarioRepository;
import com.co.sg.proyectopostal.servicios.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

@CrossOrigin(origins = "http://localhost:4200")
@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {


    private final UsuarioRepository usuarioRepository;
    private final RolRepository rolRepository;

    private final TercerosRepository tercerosRepository;

    private final TipoDocumentoRepository tipoDocumentoRepository;

    private final ArchivoServiceImpl archivoServiceimpl;



    @CrossOrigin(origins = "http://localhost:4200")
    @Override
    public Usuario guardarUsuario(Usuario usuario) throws Exception {

        Optional <Usuario> usuarioLocal = usuarioRepository.findByCorreo(usuario.getCorreo());

        if(usuarioLocal.isPresent()){
            System.out.println("El usuario ya existe");
            throw new Exception("El usuario ya está presente");
        }
        
        usuarioRepository.save(usuario);
        return usuario;



    }

    @CrossOrigin(origins = "http://localhost:4200")
    @Override
    public Boolean cargarArchivo(MultipartFile file, String correo) throws Exception {

            var archivo = file;
            String linea = "";
            String separador = "|";
            InputStream is = archivo.getInputStream();
            Archivo archivoEntity = Archivo.builder().build();

            int ID = 0;
            SimpleDateFormat formatter  = new SimpleDateFormat ("yyyy-MM-dd");


            try (var entrada = new BufferedReader(new InputStreamReader(is))) {

                while ((linea = entrada.readLine()) != null)
                {
                    Terceros terceros = obtenerEntidad(linea, separador);

                    if(Objects.nonNull(terceros)){

                        tercerosRepository.save(terceros);

                    }

                }

                Optional <Usuario> optionalUsuario  = usuarioRepository.findByCorreo(correo);
                Instant instant = Instant.now();
                Date date = Date.from(instant);

                if(optionalUsuario.isPresent()){
                    Integer idUser = optionalUsuario.get().getId();
                    Archivo archivoBuild = Archivo.builder()
                            .nombre(archivo.getName())
                            .idUsuario(String.valueOf(idUser))
                            .fechaActualizacion(date)
                            .build();
                    archivoServiceimpl.guardarInfoArchivo(archivoBuild);
                    return true;
                }





            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }




        return null;
    }

    public Terceros obtenerEntidad (String linea, String separador){

        String[] cliente = linea.split("\\|");

        Optional<TipoDocumento> optionalTipoDocumento = tipoDocumentoRepository.findByNombre(cliente[0]);
        Integer idTipoDocumento;
        if(optionalTipoDocumento.isPresent()){
            idTipoDocumento = optionalTipoDocumento.get().getId();
            String cedula = cliente[1];
            String nombre1 = cliente[2];
            String nombre2 = cliente [3];
            String apellido1 = cliente[4];
            String apellido2 = cliente [5];
            String agenciaDestino = cliente[6];
            String numeroGiro = cliente [7];
            String valorGiro = cliente [8];

            Terceros tercero = Terceros.builder()
                    .idTipo(idTipoDocumento)
                    .cedula(cedula)
                    .nombre1(nombre1)
                    .nombre2(nombre2)
                    .apellido1(apellido1)
                    .apellido2(apellido2)
                    .agenciaDestino(agenciaDestino)
                    .id(numeroGiro)
                    .valorGiro(valorGiro)
                    .build();


            return tercero;
        }else{
            return null;
        }

    }




}
