package hoodies_district_web.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

/**
 * Entidad que representa un usuario del sistema.
 *
 * Esta clase se relaciona con la tabla "usuario"
 * de la base de datos hoodies_district.
 */
@Entity
public class Usuario {

    /**
     * Identificador único del usuario.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Nombre de usuario utilizado para iniciar sesión.
     */
    private String usuario;

    /**
     * Contraseña utilizada para la autenticación.
     */
    private String password;

    /**
     * Constructor vacío requerido por JPA.
     */
    public Usuario() {
    }

    /**
     * Constructor para crear un usuario.
     *
     * @param usuario nombre del usuario
     * @param password contraseña del usuario
     */
    public Usuario(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }

    /**
     * Obtiene el identificador del usuario.
     */
    public Long getId() {
        return id;
    }

    /**
     * Establece el identificador del usuario.
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre de usuario.
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Establece el nombre de usuario.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * Obtiene la contraseña.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Establece la contraseña.
     */
    public void setPassword(String password) {
        this.password = password;
    }
}