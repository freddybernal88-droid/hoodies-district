package hoodies_district_web.service;

import hoodies_district_web.model.Usuario;
import hoodies_district_web.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Servicio encargado de la lógica de negocio
 * relacionada con el registro y autenticación de usuarios.
 */
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    /**
     * Constructor que recibe el repositorio de usuarios.
     *
     * @param usuarioRepository repositorio para acceder a la base de datos
     */
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Registra un nuevo usuario en la base de datos.
     *
     * @param usuario objeto que contiene usuario y contraseña
     * @return usuario registrado
     */
    public Usuario registrarUsuario(Usuario usuario) {

        // Verificamos que el nombre de usuario no esté registrado.
        Optional<Usuario> usuarioExistente =
                usuarioRepository.findByUsuario(usuario.getUsuario());

        if (usuarioExistente.isPresent()) {
            throw new RuntimeException("El usuario ya existe");
        }

        // Guardamos el nuevo usuario en la base de datos.
        return usuarioRepository.save(usuario);
    }

    /**
     * Realiza la autenticación de un usuario.
     *
     * @param usuario nombre de usuario
     * @param password contraseña ingresada
     * @return true si las credenciales son correctas,
     *         false en caso contrario
     */
    public boolean autenticar(String usuario, String password) {

        // Buscamos el usuario por su nombre.
        Optional<Usuario> usuarioEncontrado =
                usuarioRepository.findByUsuario(usuario);

        // Verificamos que exista y que la contraseña coincida.
        return usuarioEncontrado.isPresent()
                && usuarioEncontrado.get().getPassword().equals(password);
    }
}