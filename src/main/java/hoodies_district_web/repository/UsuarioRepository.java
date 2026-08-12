package hoodies_district_web.repository;

import hoodies_district_web.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repositorio encargado de realizar las operaciones
 * de acceso a datos para la entidad Usuario.
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    /**
     * Busca un usuario por su nombre de usuario.
     *
     * @param usuario nombre de usuario que se desea buscar
     * @return usuario encontrado, si existe
     */
    Optional<Usuario> findByUsuario(String usuario);
}