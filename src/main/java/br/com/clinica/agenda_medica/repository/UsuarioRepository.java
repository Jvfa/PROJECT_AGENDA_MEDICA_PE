package br.com.clinica.agenda_medica.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clinica.agenda_medica.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
    
    Optional<Usuario> findByLoginUsuario(String loginUsuario);

}

