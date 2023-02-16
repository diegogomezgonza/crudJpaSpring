package es.hitoIndividualDiego.servicios;

import es.hitoIndividualDiego.jpa.Roles;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
public class RolesServicio {
        private RolesRepositorio roles;

        public RolesServicio(RolesRepositorio roles) {this.roles = roles;}

        public void guardarRol(Roles rol) {roles.save(rol);}


        public void eliminarRol(int id) {roles.deleteById(id);}
    }

