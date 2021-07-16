package com.kinesysApp.kinesys.controladores;

import com.kinesysApp.kinesys.entidades.ObraSocial;
import com.kinesysApp.kinesys.servicios.ObraSocialServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping("/obraSocial")
public class ObraSocialControlador {

    @Autowired
    private ObraSocialServicio obraSocialServicio;

    private final String ETIQUETA_ERROR = "error";

    @GetMapping()
    //@PreAuthorize("hasRole('ADMIN')")
    public ModelAndView mostrarObbrasocial() {
        ModelAndView mav = new ModelAndView("oS");
        mav.addObject("ObrasSociales", obraSocialServicio.buscarTodas());
        return mav;
    }

    @GetMapping("/crear")
    //@PreAuthorize("hasRole('ADMIN')")
    public ModelAndView crearObraSocial(){
        ModelAndView mav= new ModelAndView("oS-form");
        mav.addObject("obraSoacial",new ObraSocial());
        return mav;
    }

    @PostMapping("/guardar")
    //@PreAuthorize("hasRole('ADMIN')")
    public RedirectView guardarObraSocial(@ModelAttribute("obraSocial") ObraSocial obraSocial){
        obraSocialServicio.crear(obraSocial);
        return new RedirectView("/obraSocial");
    }
    @PostMapping("/eliminar/{idObraSocial}")
   // @PreAuthorize("hasAnyRole('ADMIN')")
    public String eliminarObraSocial(@PathVariable String idObraSocial, Model model) {
        obraSocialServicio.eliminarObraSocial(idObraSocial);
        return "redirect:/obraSocial";
    }

}
