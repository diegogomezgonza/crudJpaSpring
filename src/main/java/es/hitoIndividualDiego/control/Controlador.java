package es.hitoIndividualDiego.control;



import es.hitoIndividualDiego.jpa.Roles;
import es.hitoIndividualDiego.jpa.Tarea;
import es.hitoIndividualDiego.jpa.Usuario;
import es.hitoIndividualDiego.servicios.RolesServicio;
import es.hitoIndividualDiego.servicios.TareaService;
import es.hitoIndividualDiego.servicios.UsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class Controlador {
    @Autowired
    PasswordEncoder encoder;

    @Autowired
    UsuarioService usuarios;

    @Autowired
    RolesServicio roles;

    @Autowired
    TareaService tareas;

    //Atiende petición localhost:8083
    @RequestMapping("/")
    public ModelAndView peticionRaiz(Authentication aut) {
        ModelAndView mv = new ModelAndView();
        if(aut==null)
            mv.addObject("user", "No se ha iniciado sesión");
        else
            mv.addObject("user", aut.getName());


        mv.setViewName("index");

        String texto = "123";
        String encriptado = encoder.encode(texto);
        System.out.println("Texto original: "+texto);
        System.out.println("Texto emcriptado: "+encriptado);

        return mv;
    }

    //Login
    @RequestMapping("login")
    public ModelAndView peticionSesion(Authentication aut) {
        ModelAndView mv = new ModelAndView();
        if(aut==null)
            mv.addObject("user", "No se ha iniciado sesión");
        else
            mv.addObject("user", aut.getName());
        mv.setViewName("login");
        return mv;
    }

    //Usuario
    @RequestMapping("/user")
   public ModelAndView peticionPerfil(Authentication aut) {
        ModelAndView mv = new ModelAndView();
        Usuario user = null;

        if (aut == null)
            mv.addObject("user", "No se ha iniciado sesión");
        else{
            mv.addObject("user", aut.getName());

        Optional<Usuario> userOpcional = usuarios.buscarUsuario(aut.getName());

        if (userOpcional.isPresent()) {
            user = userOpcional.get();
        }
    }

        mv.addObject("usuario", user);

        mv.setViewName("usuario");
        return mv;
    }

    //Perfil de usuario
    @RequestMapping("/user/perfil")
    public ModelAndView peticionUsuario(Authentication aut) {
        ModelAndView mv = new ModelAndView();
        if(aut==null)
            mv.addObject("user", "No se ha iniciado sesión");
        else {
            mv.addObject("user", aut.getName());
            Optional<Usuario> uOpt = usuarios.buscarUsuario(aut.getName());
            Usuario u = uOpt.get();
            mv.addObject("usuario", u);
        }
        mv.setViewName("perfil");
        return mv;
    }

    //Dashboard
    @RequestMapping("/user/dash")
    public ModelAndView peticionUsuarioDar(Authentication aut) {
        ModelAndView mv = new ModelAndView();
        if(aut==null)
            mv.addObject("user", "No se ha iniciado sesión");
        else {
            mv.addObject("user", aut.getName());
            Optional<Usuario> uOpt = usuarios.buscarUsuario(aut.getName());
            Usuario u = uOpt.get();
            mv.addObject("usuario", u);
        }
        Long count= usuarios.contarUsuario();
        mv.addObject("countUsuarios", count);

        Long countTarea= tareas.contarTareas();
        mv.addObject("countTareas", countTarea);
        mv.setViewName("dashboard");
        return mv;
    }

    //Registrar nuevo usuario
    @RequestMapping("/admin/usuario/nuevo")
    public ModelAndView registro() {
        ModelAndView mv = new ModelAndView();
        Usuario c = new Usuario();
        mv.addObject("usuario", c);
        mv.setViewName("nuevousuario");
        return mv;
    }

    //Guardar usuario
    @RequestMapping("/guardar")
    public ModelAndView peticionGuardar(Usuario u, Authentication aut) {
        ModelAndView mv = new ModelAndView();
        System.out.println(u);
        String sinCifrar = u.getPw();
        String cifrado = encoder.encode(sinCifrar);
        u.setPw(cifrado);

        if(aut==null)
            mv.addObject("user", "No se ha iniciado sesión");
        else
            mv.addObject("user", aut.getName());

        Optional<Usuario> usuarioBuscado = usuarios.buscarUsuario(u.getNif());

        if (usuarioBuscado.isPresent()) {
            mv.addObject("sms", "El nif " + u.getNif() + " ya está utilizado");
        } else {

        usuarios.guardarUsuario(u);
        Roles rol = new Roles();
        rol.setUsuario(u);
        rol.setRol("USUARIO");
        roles.guardarRol(rol);

        mv.addObject("sms", "Usuario " + u.getNombre() + " registrado con éxito");

    }
        mv.setViewName("/informa");
        return mv;
    }


    //Listar tareas
    @RequestMapping("/user/tareas/listado")
    public ModelAndView peticioListdoTareas(Authentication aut) {
        ModelAndView mv = new ModelAndView();
        if(aut==null)
            mv.addObject("user", "No se ha iniciado sesión");
        else
            mv.addObject("user", aut.getName());

        List<Usuario> listaUsuarios = usuarios.listaUsuarios();
        mv.addObject("listaUsuarios", listaUsuarios);

        mv.setViewName("listadotareas");
        return mv;
    }


    //Administrador
    @RequestMapping("/admin")
    public ModelAndView peticionAdmin(Authentication aut) {
        ModelAndView mv = new ModelAndView();
        if(aut==null)
            mv.addObject("user", "No se ha iniciado sesión");
        else
            mv.addObject("user", aut.getName());

        List<Usuario> listaUsuarios = usuarios.listaUsuarios();
        mv.addObject("listaUsuarios", listaUsuarios);

        mv.setViewName("administrador");
        return mv;
    }

    //Petición denegada
    @RequestMapping("/denegado")
    public ModelAndView peticionDenegado(Authentication aut) {
        ModelAndView mv = new ModelAndView();
        if(aut==null)
            mv.addObject("user", "No se ha iniciado sesión");
        else
            mv.addObject("user", aut.getName());
        mv.setViewName("denegado");
        return mv;
    }

    //Dashboard
    @RequestMapping("/admin/dashboard")
    public ModelAndView peticioDashboard(Authentication aut) {
        ModelAndView mv = new ModelAndView();
        if(aut==null)
            mv.addObject("user", "No se ha iniciado sesión");
        else
            mv.addObject("user", aut.getName());
        mv.setViewName("dashboard");
        return mv;
    }

    //Editar usuarios
    @RequestMapping("/admin/usuario/editar")
    public ModelAndView peticioUsuariosEditar(Authentication aut, HttpServletRequest request) {
        String nif = request.getParameter("nif");
        Optional<Usuario> usuarioOpt = usuarios.buscarUsuario(nif);
        Usuario user = usuarioOpt.get();

        ModelAndView mv = new ModelAndView();
        if(aut==null)
            mv.addObject("user", "No se ha iniciado sesión");
        else
            mv.addObject("user", aut.getName());

        mv.addObject("usuario",user);

        mv.setViewName("editarusuarios");
        return mv;
    }


    //Borrar usuarios
    @RequestMapping("/admin/usuario/borrar")
    public ModelAndView peticioUsuariosBorrar(Authentication aut, HttpServletRequest request) {
        String nif = request.getParameter("nif");
        Optional<Usuario> usuarioOpt = usuarios.buscarUsuario(nif);
        Usuario user = usuarioOpt.get();

        ModelAndView mv = new ModelAndView();
        if(aut==null)
            mv.addObject("user", "No se ha iniciado sesión");
        else
            mv.addObject("user", aut.getName());

        mv.addObject("usuario",user);

        mv.setViewName("borrarusuarios");
        return mv;
    }

    //Actualizar
    @RequestMapping("/actualizar")
    public String peticionActualizar(Usuario u, Authentication aut){
        System.out.println("Password " + u.getPw());
        usuarios.guardarUsuario(u);
        return "redirect:/admin";
    }

    //Eliminar
    @RequestMapping("/borrar")
    public String peticionEliminar(Authentication aut, HttpServletRequest request) {
        String nif = request.getParameter("nif");
        Usuario u = usuarios.buscarUsuario(nif).get();

        if (!u.getRoles().isEmpty()){
            List<Roles> lr = u.getRoles();
            lr.forEach(rol -> roles.eliminarRol(rol.getId()));
        }
        if (!u.getTareas().isEmpty()){
            List<Tarea> lt = u.getTareas();
            lt.forEach(tarea -> tareas.eliminarTarea(tarea.getId()));
        }
        usuarios.eliminarUsuario(u.getNif());

        return "redirect:/admin";
    }
}
