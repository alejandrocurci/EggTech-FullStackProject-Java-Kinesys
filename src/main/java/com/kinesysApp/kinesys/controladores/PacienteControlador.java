package com.kinesysApp.kinesys.controladores;

import com.kinesysApp.kinesys.entidades.Paciente;
import com.kinesysApp.kinesys.entidades.Usuario;
import com.kinesysApp.kinesys.excepciones.ExcepcionKinesysPaciente;
import com.kinesysApp.kinesys.servicios.PacienteServicio;
import com.kinesysApp.kinesys.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyRole('PACIENTE')")
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
            model.addAttribute("paciente", paciente);
            model.addAttribute("usuario", usuario);
            model.addAttribute("titulo", "Nuevo Paciente");
            model.addAttribute("action", "guardar");
            return "paciente-form";
        }
        pacienteServicio.crear(paciente.getDni(),
                paciente.getNombre(),
                paciente.getApellido(),
                paciente.getTelefono(),
                paciente.getEmail(),
                usuario.getNombreU(),
                usuario.getClave());
        return "redirect:/";
    }

    @PostMapping("/eliminar/{idPaciente}")
    @PreAuthorize("hasAnyRole('ADMIN')")
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
    @PreAuthorize("hasAnyRole('ADMIN')")
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
    @PreAuthorize("hasAnyRole('ADMIN')")
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
   @PreAuthorize("hasAnyRole('ADMIN')")
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
    @PreAuthorize("hasAnyRole('ADMIN')")
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
    @PreAuthorize("hasAnyRole('ADMIN','PACIENTE')")
    public ModelAndView mostrarPerfil(@PathVariable(value ="idPaciente") String idPaciente){
        ModelAndView mav = new ModelAndView("paciente-perfil");
        Paciente paciente=pacienteServicio.buscarPorId(idPaciente);
        mav.addObject("paciente", paciente);
        return mav;
    }

    @PostMapping("/perfil/{idPaciente}/nombre")
    @PreAuthorize("hasAnyRole('ADMIN','PACIENTE')")
    public String actualizarNombre(@PathVariable(value ="idPaciente") String idPaciente,
                                         @Valid Paciente paciente, BindingResult result, Model model){
        if(result.hasErrors()){
            paciente = pacienteServicio.buscarPorId(idPaciente);
            model.addAttribute("paciente", paciente);
            model.addAttribute("errorNombre", "No se ha podido modificar el nombre");
            return "paciente-perfil";
        }
        pacienteServicio.actualizarNombre(idPaciente, paciente.getNombre());
        return "redirect:/pacientes/perfil/{idPaciente}";
    }

    @PostMapping("/perfil/{idPaciente}/apellido")
    @PreAuthorize("hasAnyRole('ADMIN','PACIENTE')")
    public String actualizarApellido(@PathVariable(value ="idPaciente") String idPaciente,
                                     @Valid Paciente paciente, BindingResult result, Model model){
        if(result.hasErrors()){
            paciente = pacienteServicio.buscarPorId(idPaciente);
            model.addAttribute("paciente", paciente);
            model.addAttribute("errorApellido", "No se ha podido modificar el apellido");
            return "paciente-perfil";
        }
        pacienteServicio.actualizarApellido(idPaciente, paciente.getApellido());
        return "redirect:/pacientes/perfil/{idPaciente}";
    }

    @PostMapping("/perfil/{idPaciente}/dni")
    @PreAuthorize("hasAnyRole('ADMIN','PACIENTE')")
    public String actualizarDni(@PathVariable(value ="idPaciente") String idPaciente,
                                @Valid Paciente paciente, BindingResult result, Model model){
        if(result.hasErrors()){
            paciente = pacienteServicio.buscarPorId(idPaciente);
            model.addAttribute("paciente", paciente);
            model.addAttribute("errorDni", "No se ha podido modificar el DNI");
            return "paciente-perfil";
        }
        pacienteServicio.actualizarDni(idPaciente, paciente.getDni());
        return "redirect:/pacientes/perfil/{idPaciente}";
    }

    @PostMapping("/perfil/{idPaciente}/telefono")
    @PreAuthorize("hasAnyRole('ADMIN','PACIENTE')")
    public String actualizarTelefono(@PathVariable(value ="idPaciente") String idPaciente,
                                     @Valid Paciente paciente, BindingResult result, Model model){
        if(result.hasErrors()){
            paciente = pacienteServicio.buscarPorId(idPaciente);
            model.addAttribute("paciente", paciente);
            model.addAttribute("errorTelefono", "No se ha podido modificar el telefono");
            return "paciente-perfil";
        }
        pacienteServicio.actualizarTelefono(idPaciente, paciente.getTelefono());
        return "redirect:/pacientes/perfil/{idPaciente}";
    }

    @PostMapping("/perfil/{idPaciente}/email")
    @PreAuthorize("hasAnyRole('ADMIN','PACIENTE')")
    public String actualizarEmail(@PathVariable(value ="idPaciente") String idPaciente,
                                  @Valid Paciente paciente, BindingResult result, Model model){
        if(result.hasErrors()){
            paciente = pacienteServicio.buscarPorId(idPaciente);
            model.addAttribute("paciente", paciente);
            model.addAttribute("errorEmail", "No se ha podido modificar el email");
            return "paciente-perfil";
        }
        pacienteServicio.actualizarEmail(idPaciente, paciente.getEmail());
        return "redirect:/pacientes/perfil/{idPaciente}";
    }

    @PostMapping("/perfil/{idPaciente}/usuario")
    @PreAuthorize("hasAnyRole('ADMIN','PACIENTE')")
    public String actualizarUsuario(@PathVariable(value ="idPaciente") String idPaciente,
                                    @Valid Paciente paciente, BindingResult result, Model model){
        if(result.hasErrors()){
            paciente = pacienteServicio.buscarPorId(idPaciente);
            model.addAttribute("paciente", paciente);
            model.addAttribute("errorUsuario", "No se ha podido modificar el nombre de usuario");
            return "paciente-perfil";
        }
        pacienteServicio.actualizarUsuario(idPaciente, paciente.getUsuarioPaciente().getNombreU());
        return "redirect:/pacientes/perfil/{idPaciente}";
    }

    @PostMapping("/perfil/{idPaciente}/clave")
    @PreAuthorize("hasAnyRole('ADMIN','PACIENTE')")
    public String actualizarClave(@PathVariable(value ="idPaciente") String idPaciente,
                                  @Valid Paciente paciente, BindingResult result, Model model){
        if(result.hasErrors()){
            paciente = pacienteServicio.buscarPorId(idPaciente);
            model.addAttribute("paciente", paciente);
            model.addAttribute("errorClave", "No se ha podido modificar la clave de usuario");
            return "paciente-perfil";
        }
        pacienteServicio.actualizarClave(idPaciente, paciente.getUsuarioPaciente().getClave());
        return "redirect:/pacientes/perfil/{idPaciente}";
    }

}
