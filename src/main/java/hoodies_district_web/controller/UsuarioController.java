package hoodies_district_web.controller;

import hoodies_district_web.model.Usuario;
import hoodies_district_web.service.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Controlador REST encargado de gestionar
 * el registro y el inicio de sesión de usuarios.
 */
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    /**
     * Constructor que recibe el servicio de usuarios.
     *
     * @param usuarioService servicio encargado de la lógica
     *                        de registro y autenticación
     */
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    /**
     * Servicio web para registrar un nuevo usuario.
     *
     * Endpoint:
     * POST /api/usuarios/registro
     *
     * @param usuario datos del usuario recibidos en formato JSON
     * @return respuesta indicando si el registro fue exitoso
     */
    @PostMapping("/registro")
    public ResponseEntity<Map<String, String>> registrar(
            @RequestBody Usuario usuario) {

        Map<String, String> respuesta = new HashMap<>();

        try {

            // Registramos el usuario utilizando el servicio.
            usuarioService.registrarUsuario(usuario);

            respuesta.put("mensaje", "Usuario registrado correctamente");

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(respuesta);

        } catch (RuntimeException e) {

            // Si el usuario ya existe, devolvemos un mensaje de error.
            respuesta.put("mensaje", e.getMessage());

            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(respuesta);
        }
    }

    /**
     * Servicio web para iniciar sesión.
     *
     * Endpoint:
     * POST /api/usuarios/login
     *
     * @param usuario datos de usuario y contraseña recibidos en JSON
     * @return mensaje indicando si la autenticación fue correcta
     */
    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(
            @RequestBody Usuario usuario) {

        Map<String, String> respuesta = new HashMap<>();

        // Comprobamos las credenciales utilizando el servicio.
        boolean autenticado = usuarioService.autenticar(
                usuario.getUsuario(),
                usuario.getPassword()
        );

        if (autenticado) {

            // Credenciales correctas.
            respuesta.put(
                    "mensaje",
                    "Autenticación satisfactoria"
            );

            return ResponseEntity.ok(respuesta);

        } else {

            // Credenciales incorrectas.
            respuesta.put(
                    "mensaje",
                    "Error en la autenticación"
            );

            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body(respuesta);
        }
    }
}