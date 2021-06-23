package com.kinesysApp.kinesys.controladores;

import com.kinesysApp.kinesys.entidades.ObraSocial;
import com.kinesysApp.kinesys.entidades.Profesional;
import com.kinesysApp.kinesys.servicios.ObraSocialServicio;
import com.kinesysApp.kinesys.servicios.ProfesionalServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/profesionales")
public class ProfesionalControlador {

    @Autowired
    private ProfesionalServicio profesionalServicio;

    @Autowired
    private ObraSocialServicio obraSocialServicio;

    public ModelAndView crearProfesional(){
        ModelAndView mav =new ModelAndView("profesional-form");
        mav.addObject("profesional",new Profesional());
        mav.addObject("obraSocial",new ObraSocial());
        mav.addObject("listObraS",obraSocialServicio.buscarTodasObrasSocial());
        mav.addObject("titulo","Formulario Profesional");
        mav.addObject("action","guardar");

        return mav;
    }

}
