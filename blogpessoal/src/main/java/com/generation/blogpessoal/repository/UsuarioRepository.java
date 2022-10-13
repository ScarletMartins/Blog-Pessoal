package com.generation.blogpessoal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.blogpessoal.model.Usuario;

//alem de utilizar todos os metodos padrão do jpa, permite criar novos metodos
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

			//busca um usuario especifico
	public Optional<Usuario> findByUsuario(String usuario);
}
