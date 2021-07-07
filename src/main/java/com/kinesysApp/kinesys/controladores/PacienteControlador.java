package com.kinesysApp.kinesys.controladores;

import com.kinesysApp.kinesys.entidades.Paciente;
import com.kinesysApp.kinesys.entidades.Usuario;
import com.kinesysApp.kinesys.excepciones.ExcepcionKinesysPaciente;
import com.kinesysApp.kinesys.servicios.PacienteServicio;
import com.kinesysApp.kinesys.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;

@Controller
@RequestMapping("/pacientes")
public class PacienteControlador {

    @Autowired
    private PacienteServicio pacienteServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    private final String ETIQUETA_ERROR = "error";

    @GetMapping()
    public ModelAndView mostrarPacientes() {  //ModelAndView busca un HTML
        ModelAndView mav = new ModelAndView("paciente");
        mav.addObject("ListaPacientes", pacienteServicio.buscarTodos());
        return mav;
    }

    @GetMapping("/crear")
    public ModelAndView crearPaciente() {
        ModelAndView mav = new ModelAndView("paciente-form");
        mav.addObject("paciente", new Paciente());
        mav.addObject("usuario", new Usuario());
        mav.addObject("titulo", "Nuevo Paciente");
        mav.addObject("action", "guardar");
        return mav;
    }

    @PostMapping("/guardar")
    public String guardarPaciente(@Valid Paciente paciente, BindingResult resultPaciente,
                                  @Valid Usuario usuario,BindingResult resultUsuario,
                                  Model model) {

        if(resultPaciente.hasErrors() || resultUsuario.hasErrors()){
            model.addAttribute("titulo", "Nuevo Paciente");
            return "paciente-form";
        }
        try {
            pacienteServicio.crear(paciente.getDni(),
                    paciente.getNombre(),
                    paciente.getApellido(),
                    paciente.getTelefono(),
                    paciente.getEmail(),
                    usuario.getNombreU(),
                    usuario.getClave());
            return "redirect:/";
        } catch (ExcepcionKinesysPaciente ex) {

                model.addAttribute(ETIQUETA_ERROR, ex.getMessage());
                model.addAttribute("paciente", paciente);
                //model.addAttribute("usuario", usuario);
                model.addAttribute("action", "guardar");

            return "paciente-form";
        }
    }
    @PostMapping("/eliminar/{idPaciente}")
    public String eliminarPaciente(@PathVariable String idPaciente, Model model) {
        try {
            pacienteServicio.eliminarPaciente(idPaciente);
            return "redirect:/pacientes";
        } catch (ExcepcionKinesysPaciente ex) {
            model.addAttribute(ETIQUETA_ERROR, ex.getMessage());
            return "redirect: /pacientes";
        }
    }

    @GetMapping("/editar/{idPaciente}")
    public ModelAndView editarPaciente(@PathVariable(value ="idPaciente") String idPaciente){
        ModelAndView mav = new ModelAndView("paciente-form");
        Paciente paciente=pacienteServicio.buscarPorId(idPaciente);
        mav.addObject("paciente",paciente);
        mav.addObject("usuario", paciente.getUsuarioPaciente());
        mav.addObject("titulo", "editar Paciente");
        mav.addObject("action", "modificar");
        return mav;

    }
    @PostMapping("/modificar")
    public RedirectView modificarPaciente(@ModelAttribute("paciente") Paciente paciente, Usuario usuario,Model model){
        try {
            pacienteServicio.modificar(
                    paciente.getIdPaciente(),
                    paciente.getDni(),
                    paciente.getNombre(),
                    paciente.getApellido(),
                    paciente.getTelefono(),
                    paciente.getEmail());
            return new RedirectView("/pacientes");
        }catch (ExcepcionKinesysPaciente ex){

            model.addAttribute(ETIQUETA_ERROR, ex.getMessage());
            model.addAttribute("paciente", paciente);
            //model.addAttribute("usuario", usuario);
            model.addAttribute("action", "guardar");

            return new RedirectView("/");
        }
    }
   @GetMapping("/buscarPaciente")
    public ModelAndView buscarPacientePorDni(@RequestParam(required = false) Long dni) {   //ModelAndView busca un HTml
       ModelAndView mav = new ModelAndView("paciente");
        try {
            mav.addObject("ListaPacientes", pacienteServicio.buscarPacientePorDni(dni));
            return mav;
        } catch (ExcepcionKinesysPaciente ex) {

            mav.addObject("error", ex.getMessage());
            return mav;

        }
    }
    @GetMapping("/buscarPacientePorNombre")
    public ModelAndView buscarPacientePorNombre(@RequestParam(required = false) String nombre) {   //ModelAndView busca un HTML

        ModelAndView mav = new ModelAndView("paciente");
        if(nombre.isEmpty()){
            mav.addObject("ListaPacientes", pacienteServicio.buscarTodos());
            return mav;
        }
        try {
            mav.addObject("ListaPacientes", pacienteServicio.buscarPacientePorNombre(nombre));
            return mav;
        } catch (ExcepcionKinesysPaciente ex) {

            mav.addObject("error", ex.getMessage());

            return mav;

        }
    }

    // FUNCIONALIDAD PARA PERFIL

    @GetMapping("/perfil/{idPaciente}")
    public ModelAndView mostrarPerfil(@PathVariable(value ="idPaciente") String idPaciente){
        ModelAndView mav = new ModelAndView("paciente-perfil");
        Paciente paciente=pacienteServicio.buscarPorId(idPaciente);
        mav.addObject("paciente", paciente);
        return mav;
    }

    @PostMapping("/perfil/{idPaciente}/nombre")
    public RedirectView actualizarNombre(@PathVariable(value ="idPaciente") String idPaciente, Paciente paciente){
        pacienteServicio.actualizarNombre(idPaciente, paciente.getNombre());
        return new RedirectView("/pacientes/perfil/{idPaciente}");
    }

    @PostMapping("/perfil/{idPaciente}/apellido")
    public RedirectView actualizarApellido(@PathVariable(value ="idPaciente") String idPaciente, Paciente paciente){
        pacienteServicio.actualizarApellido(idPaciente, paciente.getApellido());
        return new RedirectView("/pacientes/perfil/{idPaciente}");
    }

    @PostMapping("/perfil/{idPaciente}/dni")
    public RedirectView actualizarDni(@PathVariable(value ="idPaciente") String idPaciente, Paciente paciente){
        pacienteServicio.actualizarDni(idPaciente, paciente.getDni());
        return new RedirectView("/pacientes/perfil/{idPaciente}");
    }

    @PostMapping("/perfil/{idPaciente}/telefono")
    public RedirectView actualizarTelefono(@PathVariable(value ="idPaciente") String idPaciente, Paciente paciente){
        pacienteServicio.actualizarTelefono(idPaciente, paciente.getTelefono());
        return new RedirectView("/pacientes/perfil/{idPaciente}");
    }

    @PostMapping("/perfil/{idPaciente}/email")
    public RedirectView actualizarEmail(@PathVariable(value ="idPaciente") String idPaciente, Paciente paciente){
        pacienteServicio.actualizarEmail(idPaciente, paciente.getEmail());
        return new RedirectView("/pacientes/perfil/{idPaciente}");
    }

    @PostMapping("/perfil/{idPaciente}/usuario")
    public RedirectView actualizarUsuario(@PathVariable(value ="idPaciente") String idPaciente, Paciente paciente){
        pacienteServicio.actualizarUsuario(idPaciente, paciente.getUsuarioPaciente().getNombreU());
        return new RedirectView("/pacientes/perfil/{idPaciente}");
    }

    @PostMapping("/perfil/{idPaciente}/clave")
    public RedirectView actualizarClave(@PathVariable(value ="idPaciente") String idPaciente, Paciente paciente){
        pacienteServicio.actualizarClave(idPaciente, paciente.getUsuarioPaciente().getClave());
        return new RedirectView("/pacientes/perfil/{idPaciente}");
    }

}
