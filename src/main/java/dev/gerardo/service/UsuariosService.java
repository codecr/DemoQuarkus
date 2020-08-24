package dev.gerardo.service;

import dev.gerardo.model.Usuarios;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.util.List;

@ApplicationScoped
@Transactional
public class UsuariosService {

    public Usuarios add(Usuarios u) {
        u.persist();

        return u;
    }

    public List<Usuarios> getAll() {
        return Usuarios.listAll();
    }

    public Usuarios getbyId(Integer pk) {
        return Usuarios.findById(pk);
    }
}
