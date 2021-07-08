package com.kinesysApp.kinesys.servicios;

import com.kinesysApp.kinesys.entidades.Usuario;
import com.kinesysApp.kinesys.repositorios.UsuarioRepositorio;
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

@Service
public class UsuarioServicio implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public Usuario crear(String nombreU, String clave) {

        Usuario usuario= new Usuario();
        usuario.setNombreU(nombreU);
        usuario.setClave(encoder.encode(clave));

        //usuarioRepositorio.save(usuario);

        return usuario;
    }
    @Transactional
    public void elimiarUsuario(String idUsuario){
        usuarioRepositorio.deleteById(idUsuario);
    }



    @Override
    public UserDetails loadUserByUsername(String nombreU) throws UsernameNotFoundException {

        Usuario usuario= usuarioRepositorio.buscarPorNombreDeUsuario(nombreU);
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
        // creamos un objeto "USER" tiene un construtor que recibe 3 parametros (useraname,password y una collection"roles") ;
        User user = new User(usuario.getNombreU(), usuario.getClave(), Collections.singletonList(rol));

        return user;
    }
}
