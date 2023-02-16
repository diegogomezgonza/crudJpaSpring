package es.hitoIndividualDiego.servicios;

import es.hitoIndividualDiego.jpa.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepositorio extends JpaRepository<Roles, Integer> {
}
