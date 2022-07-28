package com.tenemea.app.springbootS3.repository;

import com.tenemea.app.springbootS3.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
