package es.hitoIndividualDiego.servicios;

import es.hitoIndividualDiego.jpa.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TareaRepositorio extends JpaRepository<Tarea, Integer> {

    //Contar tareas finalizadas (3 = tarea finalizada por el estado)
    @Query("select count(t) as finalizadas from Tarea t where t.estado = 3")
    public Integer finalizadas();

    //Encontrar tarea por estado introducido
    @Query("select count(t) as cuenta from Tarea t where t.estado = ?1")
    public Integer findByEstado(Integer estado);
}
