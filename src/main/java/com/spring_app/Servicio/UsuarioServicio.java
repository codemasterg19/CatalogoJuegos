package com.spring_app.Servicio;


import com.spring_app.Entidad.Usuario;
import com.spring_app.Repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class UsuarioServicio {
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    public  void  guadarClientes(Usuario usuario){
        usuarioRepositorio.save(usuario);
    }


}
