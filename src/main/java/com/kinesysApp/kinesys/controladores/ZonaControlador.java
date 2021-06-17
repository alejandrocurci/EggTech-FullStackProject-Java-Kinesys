package com.kinesysApp.kinesys.controladores;

import com.kinesysApp.kinesys.entidades.Zona;
import com.kinesysApp.kinesys.enumeraciones.Provincia;
import com.kinesysApp.kinesys.servicios.ZonaServicio;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/crear")
    //@PreAuthorize("hasRole('ADMIN')")
    public ModelAndView crearZona() {
        ModelAndView mav = new ModelAndView("zona-form");  // asi deberia llamarse el nombre del formulario HTML.
        mav.addObject("zona", new Zona());
        mav.addObject("ListaProvincias", Provincia.values());// "values()" me devuelve un array con todos los valores d la enumeracion
        mav.addObject("title", "Formulario Zona");
        mav.addObject("action", "guardar");

        return mav;
    }

    @PostMapping("/guardar")
    //@PreAuthorize("hasRole('ADMIN')")
    public RedirectView guardarZona(@RequestParam(name = "provincia") Provincia provincia,
                                    @RequestParam(name = "localidad") String localidad,
                                    @RequestParam(name = "direccion") String direccion) {
        //try {

            zonaServicio.crear( provincia,localidad,direccion);

            return new RedirectView("/");

       // } catch (Exception ex) {

          //  Logger.getLogger(ZonaControlador.class.getName()).log(Level.SEVERE, null, ex);

        //}

       // return new RedirectView("/clientes/crear");
    }

}
