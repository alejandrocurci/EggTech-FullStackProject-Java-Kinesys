package com.kinesysApp.kinesys.controladores;

import com.kinesysApp.kinesys.entidades.ObraSocial;
import com.kinesysApp.kinesys.entidades.Profesional;
import com.kinesysApp.kinesys.entidades.Usuario;
import com.kinesysApp.kinesys.entidades.Zona;
import com.kinesysApp.kinesys.enumeraciones.Provincia;
import com.kinesysApp.kinesys.enumeraciones.Sexo;
import com.kinesysApp.kinesys.excepciones.ExcepcionKinessysProfesional;
import com.kinesysApp.kinesys.excepciones.ExcepcionKinesysPaciente;
import com.kinesysApp.kinesys.servicios.ObraSocialServicio;
import com.kinesysApp.kinesys.servicios.ProfesionalServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/profesionales")
public class ProfesionalControlador {

    private final String ETIQUETA_ERROR = "error";

    @Autowired
    private ProfesionalServicio profesionalServicio;

    @Autowired
    private ObraSocialServicio obraSocialServicio;

    @GetMapping(name ="/crear")
    public ModelAndView crearProfesional(){
        ModelAndView mav =new ModelAndView("profesional-form");
        mav.addObject("profesional",new Profesional());
        mav.addObject("usuario",new Usuario());
        mav.addObject("sexos", Sexo.values());
        mav.addObject("provincias", Provincia.values());
        mav.addObject("listObraS",obraSocialServicio.buscarTodasObrasSocial());
        mav.addObject("titulo","Formulario Profesionales");
        mav.addObject("action","guardar");

        return mav;
    }

    @PostMapping(name ="/guardar")
    public String guardarProfesional(Profesional profesional,
                                     List<ObraSocial> seleccionObrasSociales,
                                     Usuario usuario,
                                     Zona zona,
                                     Model model){
        try{
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
                    seleccionObrasSociales,
                    usuario);
            return "redirect:/";
        }catch(ExcepcionKinessysProfesional ex){

            System.out.println(ex.getCause());
            ex.printStackTrace();
            model.addAttribute(ETIQUETA_ERROR, ex.getMessage());
            model.addAttribute("profesional", profesional);
            model.addAttribute("usuario", usuario);
            model.addAttribute("zona",zona);
            model.addAttribute("titulo", "Nuevo Profesional");
            model.addAttribute("action", "guardar");

            return "profesional-form";

        }

    }
    @PostMapping("/eliminar/{idProfesional}")
    public String eliminarProfesional(@PathVariable String idProfesional, Model model) {
        try {
            profesionalServicio.eliminarProfesional(idProfesional);
            return "redirect:/pacientes";
        } catch (ExcepcionKinessysProfesional ex) {
            model.addAttribute(ETIQUETA_ERROR, ex.getMessage());
            return "redirect: /pacientes";
        }
    }

}
