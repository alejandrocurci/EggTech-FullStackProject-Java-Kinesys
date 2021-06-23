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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@SessionAttributes("paciente")
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
        mav.addObject("ListaPacientes", pacienteServicio.buscarTodos());
        mav.addObject("usuario", new Usuario());
        mav.addObject("titulo", "Nuevo Paciente");
        mav.addObject("action", "guardar");
        return mav;
    }

    @PostMapping("/guardar")
    public String guardarPaciente(@Valid  Paciente paciente,
                                  Usuario usuario, Model model) {
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

                System.out.println(ex.getCause());
                ex.printStackTrace();
                model.addAttribute(ETIQUETA_ERROR, ex.getMessage());
                model.addAttribute("paciente", paciente);
                model.addAttribute("usuario", usuario);
                model.addAttribute("titulo", "Nuevo Paciente");
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

   @GetMapping("/buscarPaciente")
    public ModelAndView buscarPacientePorDni(@RequestParam(required = false) Long dni) {   //ModelAndView busca un HTML

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

    /*@GetMapping("/buscarPaciente")
    public String buscarPacientePorDni(@RequestParam(required = false) Long dni,
                                             Model model) {   //ModelAndView busca un HTML

        try {
            model.addAttribute("paciente", pacienteServicio.buscarPacientePorDni(dni));
            return "redirect: /pacientes";
        } catch (ExcepcionKinesysPaciente ex) {

            model.addAttribute("error", ex.getMessage());
            return "redirect: /pacientes";

        }
    }*/


}
