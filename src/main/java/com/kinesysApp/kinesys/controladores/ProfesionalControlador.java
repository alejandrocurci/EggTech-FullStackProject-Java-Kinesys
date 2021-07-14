package com.kinesysApp.kinesys.controladores;

import com.kinesysApp.kinesys.entidades.*;
import com.kinesysApp.kinesys.enumeraciones.Especialidad;
import com.kinesysApp.kinesys.enumeraciones.Provincia;
import com.kinesysApp.kinesys.enumeraciones.Sexo;
import com.kinesysApp.kinesys.excepciones.ExcepcionKinessysProfesional;
import com.kinesysApp.kinesys.excepciones.ExcepcionKinesysPaciente;
import com.kinesysApp.kinesys.modelos.busqueda.BusquedaProfesional;
import com.kinesysApp.kinesys.servicios.ObraSocialServicio;
import com.kinesysApp.kinesys.servicios.ProfesionalServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.ArrayList;
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
    @PreAuthorize("hasAnyRole('PROFESIONAL')")
    public ModelAndView mostrarProfesionales(@ModelAttribute BusquedaProfesional busqueda,
                                             Model model) throws ExcepcionKinessysProfesional {  //ModelAndView busca un HTML
        ModelAndView mav = new ModelAndView("profesional");
        List<Profesional> profesionales=null;
        try{
            profesionales=profesionalServicio.buscarPorFiltro(busqueda);

        }catch(ExcepcionKinessysProfesional ex){
            profesionales=new ArrayList<>();
            model.addAttribute("errorfiltro",ex.getMessage());
        }
        mav.addObject("ListaProfesionales", profesionales);
        mav.addObject("provincias", Provincia.values());
        mav.addObject("especialidades", Especialidad.values());
        mav.addObject("obrasSociales", obraSocialServicio.buscarTodasObrasSocial());
        mav.addObject("busqueda",busqueda );

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
        mav.addObject("especialidades", Especialidad.values());
        mav.addObject("obrasSociales", obraSocialServicio.buscarTodasObrasSocial());
        mav.addObject("titulo", "Formulario Profesionales");
        mav.addObject("action", "guardar");

        return mav;
    }

    @PostMapping("/guardar")
    public String guardarProfesional(@Valid Profesional profesional, BindingResult resultProfesional,
                                     @Valid Usuario usuario, BindingResult resultUsuario,
                                     @Valid Zona zona, BindingResult resultZona,
                                     Model model) {
        if (resultProfesional.hasErrors() || resultUsuario.hasErrors() || resultZona.hasErrors()) {
            model.addAttribute("profesional", profesional);
            model.addAttribute("usuario", usuario);
            model.addAttribute("zona", zona);
            model.addAttribute("sexos", Sexo.values());
            model.addAttribute("provincias", Provincia.values());
            model.addAttribute("especialidades", Especialidad.values());
            model.addAttribute("obrasSociales", obraSocialServicio.buscarTodasObrasSocial());
            model.addAttribute("titulo", "Nuevo Profesional");
            model.addAttribute("action", "guardar");
            return "profesional-form";
        }
        profesionalServicio.crear(
                profesional.getDni(),
                profesional.getNombre(),
                profesional.getApellido(),
                profesional.getEdad(),
                profesional.getTelefono(),
                profesional.getEmail(),
                profesional.getEspecialidad(),
                profesional.getMatricula(),
                profesional.getSexo(),
                zona,
                profesional.getObraSocialProfesionales().get(0),
                usuario);
        return "redirect:/";
    }

    @GetMapping("/editar/{idProfesional}")
    @PreAuthorize("hasAnyRole('ADMIN','PROFESIONAL')")
    public ModelAndView editarProfesional(@PathVariable(value = "idProfesional") String idProfesional) {
        ModelAndView mav = new ModelAndView("profesional-form");
        Profesional profesional = profesionalServicio.buscarPorId(idProfesional);
        mav.addObject("profesional", profesional);
        mav.addObject("usuario", profesional.getUsuarioProfesional());
        mav.addObject("zona", profesional.getZonaProfesionales().get(0));
        mav.addObject("provincias", Provincia.values());
        mav.addObject("especialidades", Especialidad.values());
        mav.addObject("sexos", Sexo.values());
        mav.addObject("obrasSociales", profesional.getObraSocialProfesionales());
        mav.addObject("titulo", "Editar Profesional");
        mav.addObject("action", "modificar");
        return mav;

    }

    @PostMapping("/modificar")
    @PreAuthorize("hasAnyRole('ADMIN','PROFESIONAL')")
    public RedirectView modificarProfesional(@ModelAttribute("profesional") Profesional profesional,
                                             Usuario usuario, Zona zona, Sexo sexo, Model model) {
        try {
            profesionalServicio.modificar(
                    profesional.getIdProfesional(),
                    profesional.getDni(),
                    profesional.getNombre(),
                    profesional.getApellido(),
                    profesional.getEdad(),
                    profesional.getEspecialidad(),
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
            model.addAttribute("obrasSociales", profesional.getObraSocialProfesionales());
            model.addAttribute("titulo", "Nuevo Profesional");
            model.addAttribute("action", "guardar");
            return new RedirectView ("/modificar");
        }
    }

    @PostMapping("/eliminar/{idProfesional}")
    @PreAuthorize("hasRole('ADMIN')")
    public String eliminarProfesional(@PathVariable String idProfesional, Model model) {
        try {
            profesionalServicio.eliminarProfesional(idProfesional);
            return "redirect:/profesionales";
        } catch (ExcepcionKinessysProfesional ex) {
            model.addAttribute(ETIQUETA_ERROR, ex.getMessage());
            return "redirect: /profesionales";
        }
    }

    // FUNCIONALIDAD PARA PERFIL

    @GetMapping("/perfil/{idProfesional}")
    @PreAuthorize("hasAnyRole('ADMIN','PROFESIONAL')")
    public ModelAndView mostrarPerfil(@PathVariable(value ="idProfesional") String idProfesional){
        ModelAndView mav = new ModelAndView("profesional-perfil");
        Profesional profesional=profesionalServicio.buscarPorId(idProfesional);
        mav.addObject("profesional", profesional);
        mav.addObject("zona", new Zona());
        mav.addObject("provincias", Provincia.values());
        mav.addObject("sexos", Sexo.values());
        mav.addObject("especialidades", Especialidad.values());
        mav.addObject("obrasSociales", obraSocialServicio.buscarTodasObrasSocial());
        return mav;
    }

    @PostMapping("/perfil/{idProfesional}/nombre")
    @PreAuthorize("hasAnyRole('ADMIN','PROFESIONAL')")
    public String actualizarNombre(@PathVariable(value ="idProfesional") String idProfesional,
                                   @Valid Profesional profesional, BindingResult result, Model model){
        if(result.hasErrors()){
            profesional = profesionalServicio.buscarPorId(idProfesional);
            model.addAttribute("profesional", profesional);
            model.addAttribute("zona", new Zona());
            model.addAttribute("provincias", Provincia.values());
            model.addAttribute("sexos", Sexo.values());
            model.addAttribute("especialidades", Especialidad.values());
            model.addAttribute("obrasSociales", obraSocialServicio.buscarTodasObrasSocial());
            model.addAttribute("errorNombre", "No se ha podido modificar el nombre");
            return "profesional-perfil";
        }
        profesionalServicio.actualizarNombre(idProfesional, profesional.getNombre());
        return "redirect:/profesionales/perfil/{idProfesional}";
    }

    @PostMapping("/perfil/{idProfesional}/apellido")
    @PreAuthorize("hasAnyRole('ADMIN','PROFESIONAL')")
    public String actualizarApellido(@PathVariable(value ="idProfesional") String idProfesional,
                                     @Valid Profesional profesional, BindingResult result, Model model){
        if(result.hasErrors()){
            profesional = profesionalServicio.buscarPorId(idProfesional);
            model.addAttribute("profesional", profesional);
            model.addAttribute("zona", new Zona());
            model.addAttribute("provincias", Provincia.values());
            model.addAttribute("sexos", Sexo.values());
            model.addAttribute("especialidades", Especialidad.values());
            model.addAttribute("obrasSociales", obraSocialServicio.buscarTodasObrasSocial());
            model.addAttribute("errorApellido", "No se ha podido modificar el apellido");
            return "profesional-perfil";
        }
        profesionalServicio.actualizarApellido(idProfesional, profesional.getApellido());
        return "redirect:/profesionales/perfil/{idProfesional}";
    }

    @PostMapping("/perfil/{idProfesional}/dni")
    @PreAuthorize("hasAnyRole('ADMIN','PROFESIONAL')")
    public String actualizarDni(@PathVariable(value ="idProfesional") String idProfesional,
                                @Valid Profesional profesional, BindingResult result, Model model){
        if(result.hasErrors()){
            profesional = profesionalServicio.buscarPorId(idProfesional);
            model.addAttribute("profesional", profesional);
            model.addAttribute("zona", new Zona());
            model.addAttribute("provincias", Provincia.values());
            model.addAttribute("sexos", Sexo.values());
            model.addAttribute("especialidades", Especialidad.values());
            model.addAttribute("obrasSociales", obraSocialServicio.buscarTodasObrasSocial());
            model.addAttribute("errorDni", "No se ha podido modificar el DNI");
            return "profesional-perfil";
        }
        profesionalServicio.actualizarDni(idProfesional, profesional.getDni());
        return "redirect:/profesionales/perfil/{idProfesional}";
    }

    @PostMapping("/perfil/{idProfesional}/telefono")
    @PreAuthorize("hasAnyRole('ADMIN','PROFESIONAL')")
    public String actualizarTelefono(@PathVariable(value ="idProfesional") String idProfesional,
                                     @Valid Profesional profesional, BindingResult result, Model model){
        if(result.hasErrors()){
            profesional = profesionalServicio.buscarPorId(idProfesional);
            model.addAttribute("profesional", profesional);
            model.addAttribute("zona", new Zona());
            model.addAttribute("provincias", Provincia.values());
            model.addAttribute("sexos", Sexo.values());
            model.addAttribute("especialidades", Especialidad.values());
            model.addAttribute("obrasSociales", obraSocialServicio.buscarTodasObrasSocial());
            model.addAttribute("errorTelefono", "No se ha podido modificar el telefono");
            return "profesional-perfil";
        }
        profesionalServicio.actualizarTelefono(idProfesional, profesional.getTelefono());
        return "redirect:/profesionales/perfil/{idProfesional}";
    }

    @PostMapping("/perfil/{idProfesional}/edad")
    @PreAuthorize("hasAnyRole('ADMIN','PROFESIONAL')")
    public String actualizarEdad(@PathVariable(value ="idProfesional") String idProfesional,
                                 @Valid Profesional profesional, BindingResult result, Model model){
        if(result.hasErrors()){
            profesional = profesionalServicio.buscarPorId(idProfesional);
            model.addAttribute("profesional", profesional);
            model.addAttribute("zona", new Zona());
            model.addAttribute("provincias", Provincia.values());
            model.addAttribute("sexos", Sexo.values());
            model.addAttribute("especialidades", Especialidad.values());
            model.addAttribute("obrasSociales", obraSocialServicio.buscarTodasObrasSocial());
            model.addAttribute("errorEdad", "No se ha podido modificar la edad");
            return "profesional-perfil";
        }
        profesionalServicio.actualizarEdad(idProfesional, profesional.getEdad());
        return "redirect:/profesionales/perfil/{idProfesional}";
    }

    @PostMapping("/perfil/{idProfesional}/sexo")
    @PreAuthorize("hasAnyRole('ADMIN','PROFESIONAL')")
    public String actualizarSexo(@PathVariable(value ="idProfesional") String idProfesional,
                                 @Valid Profesional profesional, BindingResult result, Model model){
        if(result.hasErrors()){
            profesional = profesionalServicio.buscarPorId(idProfesional);
            model.addAttribute("profesional", profesional);
            model.addAttribute("zona", new Zona());
            model.addAttribute("provincias", Provincia.values());
            model.addAttribute("sexos", Sexo.values());
            model.addAttribute("especialidades", Especialidad.values());
            model.addAttribute("obrasSociales", obraSocialServicio.buscarTodasObrasSocial());
            model.addAttribute("errorSexo", "No se ha podido modificar el sexo");
            return "profesional-perfil";
        }
        profesionalServicio.actualizarSexo(idProfesional, profesional.getSexo());
        return "redirect:/profesionales/perfil/{idProfesional}";
    }

    @PostMapping("/perfil/{idProfesional}/especialidad")
    @PreAuthorize("hasAnyRole('ADMIN','PROFESIONAL')")
    public String actualizarEspecialidad(@PathVariable(value ="idProfesional") String idProfesional,
                                         @Valid Profesional profesional, BindingResult result, Model model){
        if(result.hasErrors()){
            profesional = profesionalServicio.buscarPorId(idProfesional);
            model.addAttribute("profesional", profesional);
            model.addAttribute("zona", new Zona());
            model.addAttribute("provincias", Provincia.values());
            model.addAttribute("sexos", Sexo.values());
            model.addAttribute("especialidades", Especialidad.values());
            model.addAttribute("obrasSociales", obraSocialServicio.buscarTodasObrasSocial());
            model.addAttribute("errorEspecialidad", "No se ha podido modificar la especialidad");
            return "profesional-perfil";
        }
        profesionalServicio.actualizarEspecialidad(idProfesional, profesional.getEspecialidad());
        return "redirect:/profesionales/perfil/{idProfesional}";
    }

    @PostMapping("/perfil/{idProfesional}/email")
    @PreAuthorize("hasAnyRole('ADMIN','PROFESIONAL')")
    public String actualizarEmail(@PathVariable(value ="idProfesional") String idProfesional,
                                  @Valid Profesional profesional, BindingResult result, Model model){
        if(result.hasErrors()){
            profesional = profesionalServicio.buscarPorId(idProfesional);
            model.addAttribute("profesional", profesional);
            model.addAttribute("zona", new Zona());
            model.addAttribute("provincias", Provincia.values());
            model.addAttribute("sexos", Sexo.values());
            model.addAttribute("especialidades", Especialidad.values());
            model.addAttribute("obrasSociales", obraSocialServicio.buscarTodasObrasSocial());
            model.addAttribute("errorEmail", "No se ha podido modificar el email");
            return "profesional-perfil";
        }
        profesionalServicio.actualizarEmail(idProfesional, profesional.getEmail());
        return "redirect:/profesionales/perfil/{idProfesional}";
    }

    @PostMapping("/perfil/{idProfesional}/matricula")
    @PreAuthorize("hasAnyRole('ADMIN','PROFESIONAL')")
    public String actualizarMatricula(@PathVariable(value ="idProfesional") String idProfesional,
                                      @Valid Profesional profesional, BindingResult result, Model model){
        if(result.hasErrors()){
            profesional = profesionalServicio.buscarPorId(idProfesional);
            model.addAttribute("profesional", profesional);
            model.addAttribute("zona", new Zona());
            model.addAttribute("provincias", Provincia.values());
            model.addAttribute("sexos", Sexo.values());
            model.addAttribute("especialidades", Especialidad.values());
            model.addAttribute("obrasSociales", obraSocialServicio.buscarTodasObrasSocial());
            model.addAttribute("errorMatricula", "No se ha podido modificar la matricula");
            return "profesional-perfil";
        }
        profesionalServicio.actualizarMatricula(idProfesional, profesional.getMatricula());
        return "redirect:/profesionales/perfil/{idProfesional}";
    }

    // SESION
    @PostMapping("/perfil/{idProfesional}/usuario")
    @PreAuthorize("hasAnyRole('ADMIN','PROFESIONAL')")
    public String actualizarUsuario(@PathVariable(value ="idProfesional") String idProfesional,
                                    @Valid Profesional profesional, BindingResult result, Model model){
        if(result.hasErrors()){
            profesional = profesionalServicio.buscarPorId(idProfesional);
            model.addAttribute("profesional", profesional);
            model.addAttribute("zona", new Zona());
            model.addAttribute("provincias", Provincia.values());
            model.addAttribute("sexos", Sexo.values());
            model.addAttribute("especialidades", Especialidad.values());
            model.addAttribute("obrasSociales", obraSocialServicio.buscarTodasObrasSocial());
            model.addAttribute("errorUsuario", "No se ha podido modificar el nombre de usuario");
            return "profesional-perfil";
        }
        profesionalServicio.actualizarUsuario(idProfesional, profesional.getUsuarioProfesional().getNombreU());
        return "redirect:/profesionales/perfil/{idProfesional}";
    }

    @PostMapping("/perfil/{idProfesional}/clave")
    @PreAuthorize("hasAnyRole('ADMIN','PROFESIONAL')")
    public String actualizarClave(@PathVariable(value ="idProfesional") String idProfesional,
                                  @Valid Profesional profesional, BindingResult result, Model model){
        if(result.hasErrors()){
            profesional = profesionalServicio.buscarPorId(idProfesional);
            model.addAttribute("profesional", profesional);
            model.addAttribute("zona", new Zona());
            model.addAttribute("provincias", Provincia.values());
            model.addAttribute("sexos", Sexo.values());
            model.addAttribute("especialidades", Especialidad.values());
            model.addAttribute("obrasSociales", obraSocialServicio.buscarTodasObrasSocial());
            model.addAttribute("errorClave", "No se ha podido modificar la clave de usuario");
            return "profesional-perfil";
        }
        profesionalServicio.actualizarClave(idProfesional, profesional.getUsuarioProfesional().getClave());
        return "redirect:/profesionales/perfil/{idProfesional}";
    }

    // ZONAS
    @PostMapping("/perfil/{idProfesional}/zona/agregar")
    @PreAuthorize("hasAnyRole('ADMIN','PROFESIONAL')")
    public String actualizarZona(@PathVariable(value ="idProfesional") String idProfesional, Profesional profesional,
                                 @Valid Zona zonaNueva, BindingResult result, Model model){
        if(result.hasErrors()){
            profesional = profesionalServicio.buscarPorId(idProfesional);
            model.addAttribute("profesional", profesional);
            model.addAttribute("zona", new Zona());
            model.addAttribute("provincias", Provincia.values());
            model.addAttribute("sexos", Sexo.values());
            model.addAttribute("especialidades", Especialidad.values());
            model.addAttribute("obrasSociales", obraSocialServicio.buscarTodasObrasSocial());
            model.addAttribute("errorZona", "No se ha podido agregar la nueva zona");
            return "profesional-perfil";
        }
        profesionalServicio.agregarZona(idProfesional, zonaNueva);
        return "redirect:/profesionales/perfil/{idProfesional}";
    }

    @PostMapping("/perfil/{idProfesional}/zona/eliminar")
    @PreAuthorize("hasAnyRole('ADMIN','PROFESIONAL')")
    public RedirectView eliminarZona(@PathVariable(value ="idProfesional") String idProfesional,
                                     @RequestParam String idZona){
        profesionalServicio.eliminarZona(idProfesional, idZona);
        return new RedirectView("/profesionales/perfil/{idProfesional}");
    }

    // OBRAS SOCIALES
    @PostMapping("/perfil/{idProfesional}/obras/agregar")
    @PreAuthorize("hasAnyRole('ADMIN','PROFESIONAL')")
    public RedirectView actualizarObraSocial(@PathVariable(value ="idProfesional") String idProfesional,
                                             @RequestParam String idObraSocial){
        profesionalServicio.agregarObraSocial(idProfesional, idObraSocial);
        return new RedirectView("/profesionales/perfil/{idProfesional}");
    }

    @PostMapping("/perfil/{idProfesional}/obras/eliminar")
    @PreAuthorize("hasAnyRole('ADMIN','PROFESIONAL')")
    public RedirectView eliminarObraSocial(@PathVariable(value ="idProfesional") String idProfesional,
                                           @RequestParam String idObraSocial){
        profesionalServicio.eliminarObraSocial(idProfesional, idObraSocial);
        return new RedirectView("/profesionales/perfil/{idProfesional}");
    }

}
