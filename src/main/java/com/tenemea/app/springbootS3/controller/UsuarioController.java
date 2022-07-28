package com.tenemea.app.springbootS3.controller;

import com.tenemea.app.springbootS3.model.Usuario;
import com.tenemea.app.springbootS3.repository.UsuarioRepository;
import com.tenemea.app.springbootS3.service.S3Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private S3Service s3Service;

    @GetMapping
    List<Usuario> getAll(){
        return usuarioRepository.findAll()
                .stream()
                .peek(usuario -> usuario.setImagenUrl(s3Service.getObjetcURL(usuario.getImagenPath())))
                .collect(Collectors.toList());
    }

    @PostMapping("/create")
    Usuario create(@RequestBody Usuario usuario){
         usuarioRepository.save(usuario);
         usuario.setImagenUrl(s3Service.getObjetcURL(usuario.getImagenPath()));
         usuario.setPdfUrl((s3Service.getObjetcURL(usuario.getImagenPath())));
         return usuario;
    }
}
