package com.kinesysApp.kinesys.controladores;

import com.kinesysApp.kinesys.entidades.Paciente;
import com.kinesysApp.kinesys.entidades.Usuario;
import com.kinesysApp.kinesys.servicios.PacienteServicio;
import com.kinesysApp.kinesys.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/pacientes")
public class PacienteControlador {

    @Autowired
    private PacienteServicio pacienteServicio;

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/crear")
    public ModelAndView crear(){
        ModelAndView mav = new ModelAndView("paciente-form");
        mav.addObject("paciente",new Paciente());
        mav.addObject("usuario",new Usuario());
        mav.addObject("titulo","Nuevo Paciente");
        mav.addObject("action","guardar");
        return mav;
    }

    @PostMapping("/guardar")
    public RedirectView guardar(@ModelAttribute("paciente") Paciente paciente,
                                @ModelAttribute("usuario") Usuario usuario){

        pacienteServicio.crear(paciente.getDni(),
                paciente.getNombre(),
                paciente.getApellido(),
                paciente.getTelefono(),
                paciente.getEmail(),
                usuario.getNombreU(),
                usuario.getClave());


        return new RedirectView("/");
    }
}
