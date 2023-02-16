package es.hitoIndividualDiego.servicios;

import es.hitoIndividualDiego.jpa.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepositorio extends JpaRepository<Usuario, String> {

}
