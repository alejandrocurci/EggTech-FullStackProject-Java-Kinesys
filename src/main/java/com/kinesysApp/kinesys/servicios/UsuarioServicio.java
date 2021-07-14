package com.kinesysApp.kinesys.servicios;

import com.kinesysApp.kinesys.entidades.Paciente;
import com.kinesysApp.kinesys.entidades.Profesional;
import com.kinesysApp.kinesys.entidades.Usuario;
import com.kinesysApp.kinesys.repositorios.PacienteRepositorio;
import com.kinesysApp.kinesys.repositorios.ProfesionalRepositorio;
import com.kinesysApp.kinesys.repositorios.UsuarioRepositorio;
import com.kinesysApp.kinesys.roles.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

@Service
public class UsuarioServicio implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private PacienteRepositorio pacienteRepositorio;

    @Autowired
    private ProfesionalRepositorio profesionalRepositorio;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public Usuario crear(String nombreU, String clave,Rol rol) {

        Usuario usuario= new Usuario();
        usuario.setRol(rol);
        usuario.setNombreU(nombreU);
        usuario.setClave(encoder.encode(clave));

        usuarioRepositorio.save(usuario);

        return usuario;
    }
    @Transactional
    public void elimiarUsuario(String idUsuario){
        usuarioRepositorio.deleteById(idUsuario);
    }



    public UserDetails loadUserByUsername(String nombreU) throws UsernameNotFoundException {

        Usuario usuario= usuarioRepositorio.findByNombreU(nombreU);
        if(nombreU == null || nombreU.isEmpty()){
            throw new UsernameNotFoundException("No hay ningun usuario con ese nombre "+ nombreU);
        }
        GrantedAuthority rol= new SimpleGrantedAuthority("ROLE_"+usuario.getRol().getNombre());

        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpSession session = attr.getRequest().getSession(true);
        session.setAttribute("usuariosession", usuario);

//        List<GrantedAuthority> roles= new ArrayList<>();      ESTO ES PARA AGRAGAR VARIOS ROLES A UN SOLO USUARIO
//        for (Rol rol : usuario.getRol() {
//
//            roles.add(new SimpleGrantedAuthority("ROLE_"+rol.getNombreRol()));
//        }
//
        // creamos un objeto "USER" tiene un construtor que recibe 3 parametros (useraname,passwordy una collection"roles") ;

        User user = new User(usuario.getNombreU(), usuario.getClave(), Collections.singletonList(rol));

               return user;
            }

    }
