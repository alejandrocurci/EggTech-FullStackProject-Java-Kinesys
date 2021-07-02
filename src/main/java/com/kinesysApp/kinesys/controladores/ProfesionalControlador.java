package com.kinesysApp.kinesys.controladores;

import com.kinesysApp.kinesys.entidades.*;
import com.kinesysApp.kinesys.enumeraciones.Provincia;
import com.kinesysApp.kinesys.enumeraciones.Sexo;
import com.kinesysApp.kinesys.excepciones.ExcepcionKinessysProfesional;
import com.kinesysApp.kinesys.excepciones.ExcepcionKinesysPaciente;
import com.kinesysApp.kinesys.servicios.ObraSocialServicio;
import com.kinesysApp.kinesys.servicios.ProfesionalServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping("/profesionales")
public class ProfesionalControlador {

    private final String ETIQUETA_ERROR = "error";

    @Autowired
    private ProfesionalServicio profesionalServicio;

    @Autowired
    private ObraSocialServicio obraSocialServicio;

    @GetMapping()
    public ModelAndView mostrarProfesionales() {  //ModelAndView busca un HTML
        ModelAndView mav = new ModelAndView("profesional");
        mav.addObject("ListaProfesionales", profesionalServicio.buscarTodos());
        return mav;
    }

    @GetMapping("/crear")
    public ModelAndView crearProfesional() {
        ModelAndView mav = new ModelAndView("profesional-form");
        mav.addObject("profesional", new Profesional());
        mav.addObject("usuario", new Usuario());
        mav.addObject("zona", new Zona());
        mav.addObject("sexos", Sexo.values());
        mav.addObject("provincias", Provincia.values());
        mav.addObject("obrasSociales", obraSocialServicio.buscarTodasObrasSocial());
        mav.addObject("titulo", "Formulario Profesionales");
        mav.addObject("action", "guardar");

        return mav;
    }

    @PostMapping("/guardar")
    public String guardarProfesional(Profesional profesional,
                                     //@RequestParam String idObraSocial,
                                     Usuario usuario,
                                     Zona zona,
                                     Model model) {
        try {
            profesionalServicio.crear(
                    profesional.getDni(),
                    profesional.getNombre(),
                    profesional.getApellido(),
                    profesional.getEdad(),
                    profesional.getTelefono(),
                    profesional.getEmail(),
                    profesional.getMatricula(),
                    profesional.getSexo(),
                    zona,
                    //obraSocialServicio.buscarPorId(idObraSocial),
                    profesional.getObraSocialProfesionales().get(0),
                    usuario);
            return "redirect:/profesionales";
        } catch (ExcepcionKinessysProfesional ex) {

            // ex.printStackTrace();
            model.addAttribute(ETIQUETA_ERROR, ex.getMessage());
            model.addAttribute("profesional", profesional);
            model.addAttribute("usuario", usuario);
            model.addAttribute("zona", zona);
            model.addAttribute("sexos", Sexo.values());
            model.addAttribute("provincias", Provincia.values());
            model.addAttribute("titulo", "Nuevo Profesional");
            model.addAttribute("action", "guardar");

            return "profesional-form";

        }

    }

    @GetMapping("/editar/{idProfesional}")
    public ModelAndView editarProfesional(@PathVariable(value = "idProfesional") String idProfesional) {
        ModelAndView mav = new ModelAndView("profesional-form");
        Profesional profesional = profesionalServicio.buscarPorId(idProfesional);
        mav.addObject("profesional", profesional);
        mav.addObject("usuario", profesional.getUsuarioProfesional());
        mav.addObject("zona", profesional.getZonaProfesionales().get(0));
        mav.addObject("provincias", Provincia.values());
        mav.addObject("sexos", Sexo.values());
        mav.addObject("obrasSociales", profesional.getObraSocialProfesionales());
        mav.addObject("titulo", "Editar Profesional");
        mav.addObject("action", "modificar");
        return mav;

    }

    @PostMapping("/modificar")
    public RedirectView modificarProfesional(@ModelAttribute("profesional") Profesional profesional,
                                             Usuario usuario, Zona zona, Sexo sexo, Model model) {
        System.out.println(profesional.toString());
        System.out.println("");
        System.out.println(zona.toString());
        try {
            profesionalServicio.modificar(
                    profesional.getIdProfesional(),
                    profesional.getDni(),
                    profesional.getNombre(),
                    profesional.getApellido(),
                    profesional.getEdad(),
                    profesional.getTelefono(),
                    profesional.getEmail(),
                    profesional.getMatricula(),
                    profesional.getSexo());
            return new RedirectView("/profesionales");
        } catch (ExcepcionKinesysPaciente ex) {

            ex.printStackTrace();
            model.addAttribute(ETIQUETA_ERROR, ex.getMessage());
            model.addAttribute("profesional", profesional);
            model.addAttribute("usuario", usuario);
            model.addAttribute("zona", zona);
            model.addAttribute("sexos", Sexo.values());
            model.addAttribute("provincias", Provincia.values());
            model.addAttribute("titulo", "Nuevo Profesional");
            model.addAttribute("action", "guardar");
            return new RedirectView ("/modificar");
        }
    }

    @PostMapping("/eliminar/{idProfesional}")
    public String eliminarProfesional(@PathVariable String idProfesional, Model model) {
        try {
            profesionalServicio.eliminarProfesional(idProfesional);
            return "redirect:/profesionales";
        } catch (ExcepcionKinessysProfesional ex) {
            model.addAttribute(ETIQUETA_ERROR, ex.getMessage());
            return "redirect: /profesionales";
        }
    }

}
