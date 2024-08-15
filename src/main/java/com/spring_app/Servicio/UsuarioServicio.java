package com.spring_app.Servicio;


import com.spring_app.Entidad.Usuario;
import com.spring_app.Repositorio.UsuarioRepositorio;
import com.spring_app.Roles.Role;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UsuarioServicio  implements UserDetailsService {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Transactional
    public  void  guadarClientes(String nombre,String user, String email, String password){
        Usuario usuario = new Usuario();
        usuario.setNombre(nombre);
        usuario.setUser(user);
        usuario.setEmail(email);
        usuario.setPassword(new BCryptPasswordEncoder().encode(password));
        usuario.setRol(Role.USER);
        usuarioRepositorio.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.buscarUsuarioByEmail(email);
        if (usuario!=null){
            List<GrantedAuthority> permisos = new ArrayList<>();
            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_"+usuario.getRol().toString());
            permisos.add(p);
            return new User(usuario.getEmail(), usuario.getPassword(), permisos);
        }
        else {
            throw new UsernameNotFoundException("Usuario no encontrado con email: " + email);
        }

    }

    //Leer
    public List<Usuario> listarUsuarios(){
        return usuarioRepositorio.findAll();
    }

    public Optional<Usuario> buscarUsuario(Long id){
        return usuarioRepositorio.findById(id);
    }

    public void guardarUsuario(Usuario usuario){
        usuarioRepositorio.save(usuario);
    }

    public void eliminarUsuario(Long id){
        usuarioRepositorio.deleteById(id);
    }
}
