package com.kinesysApp.kinesys.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrincipalControlador {

    @GetMapping("/")
    public ModelAndView inicio(){
        return new ModelAndView("home");
    }

    @GetMapping("/login")     //
    public ModelAndView loginUsuario(@RequestParam(required = false) String error, ModelAndView mav) {
        mav.setViewName("login");
        return mav;  // asi deberia llamarse el nombre del formulario HTML.
    }
}
