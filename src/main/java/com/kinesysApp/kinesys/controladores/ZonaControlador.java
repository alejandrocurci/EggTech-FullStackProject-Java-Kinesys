package com.kinesysApp.kinesys.controladores;

import com.kinesysApp.kinesys.entidades.Profesional;
import com.kinesysApp.kinesys.entidades.Zona;
import com.kinesysApp.kinesys.enumeraciones.Provincia;
import com.kinesysApp.kinesys.enumeraciones.Sexo;
import com.kinesysApp.kinesys.servicios.ProfesionalServicio;
import com.kinesysApp.kinesys.servicios.ZonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/zonas")
public class ZonaControlador {

    @Autowired
    private ZonaServicio zonaServicio;

    @Autowired
    private ProfesionalServicio profesionalServicio;

    @GetMapping("/crear")
    @PreAuthorize("hasRole('ADMIN')")
    public ModelAndView crearZona() {
        ModelAndView mav = new ModelAndView("zona-form");  // asi deberia llamarse el nombre del formulario HTML.
        mav.addObject("zona", new Zona());
        mav.addObject("profesional",new Profesional());
        mav.addObject("ListaProvincias", Provincia.values());// "values()" me devuelve un array con todos los valores d la enumeracion
        mav.addObject("sexos", Sexo.values());
        mav.addObject("title", "Formulario Zona");
        mav.addObject("action", "guardar");

        return mav;
    }

    @PostMapping("/guardar")
    @PreAuthorize("hasRole('ADMIN')")
    public RedirectView guardarZona(Zona zona) {
        //try {
            zonaServicio.crear(zona);
            return new RedirectView("/");
           // } catch (Exception ex) {
          //  Logger.getLogger(ZonaControlador.class.getName()).log(Level.SEVERE, null, ex);

        //}

       // return new RedirectView("/clientes/crear");
    }

}


   /* @PostMapping("/guardar")
    public void guardar(User user) {
        try {
            service.guardar(user);
        } catch (MethodArgumentNotValidException e) {
            StringBuilder sb = new StringBuilder();
            for (ObjectError error : e.getAllErrors()) {
                sb.append(error.toString()).append("\n");
            }
            mav.addObjet("error", sb.toString());
        }
    }*/
