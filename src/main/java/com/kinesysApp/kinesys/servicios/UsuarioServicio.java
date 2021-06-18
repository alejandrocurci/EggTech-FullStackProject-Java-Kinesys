package com.kinesysApp.kinesys.servicios;

import com.kinesysApp.kinesys.entidades.Usuario;
import com.kinesysApp.kinesys.repositorios.UsuarioRepositorio;
import com.sun.xml.internal.fastinfoset.Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

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




    @Override
    public UserDetails loadUserByUsername(String nombreU) throws UsernameNotFoundException {

        Usuario usuario= usuarioRepositorio.buscarPorNombreDeUsuario(nombreU);
        if(nombreU == null || nombreU.isEmpty()){
            throw new UsernameNotFoundException("El hay ningu usuario con ese nombre "+ nombreU);
        }
        User user= new User(usuario.getNombreU(),usuario.getClave(), Collections.emptyList());
        return null;
    }
}
