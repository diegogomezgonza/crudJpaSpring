package es.hitoIndividualDiego.servicios;

import es.hitoIndividualDiego.jpa.Tarea;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;


import java.util.List;
@Service
@ApplicationScope
public class TareaService {

    private TareaRepositorio tareas;

    public TareaService(TareaRepositorio tareas)
    {this.tareas = tareas;}

    public long contarTareas(){
        return tareas.count();
    }
    public void eliminarTarea(int id){
        tareas.deleteById(id);
    }

}
