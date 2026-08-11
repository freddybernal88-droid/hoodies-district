package hoodies_district_web.controller;

import hoodies_district_web.model.Producto;
import hoodies_district_web.service.ProductoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador encargado de gestionar las solicitudes
 * relacionadas con los productos.
 */
@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoService productoService;

    /**
     * Constructor del controlador.
     *
     * @param productoService servicio de productos
     */
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    /**
     * Muestra la lista de productos registrados.
     *
     * @param model modelo utilizado para enviar información a la vista
     * @return vista productos.html
     */
    @GetMapping
    public String listarProductos(Model model) {
        model.addAttribute("productos", productoService.listarProductos());
        return "productos";
    }

    /**
     * Muestra el formulario para registrar un producto.
     *
     * @param model modelo utilizado para enviar el objeto Producto
     * @return vista formulario.html
     */
    @GetMapping("/nuevo")
    public String nuevoProducto(Model model) {
        model.addAttribute("producto", new Producto());
        return "formulario";
    }

    /**
     * Guarda un nuevo producto.
     *
     * @param producto producto recibido desde el formulario
     * @return redirección hacia la lista de productos
     */
    @PostMapping("/guardar")
    public String guardarProducto(@ModelAttribute Producto producto) {
        productoService.guardarProducto(producto);
        return "redirect:/productos";
    }

    /**
     * Elimina un producto.
     *
     * @param id identificador del producto
     * @return redirección hacia la lista de productos
     */
    @GetMapping("/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return "redirect:/productos";
    }
}