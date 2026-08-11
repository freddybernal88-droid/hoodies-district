package hoodies_district_web.service;

import hoodies_district_web.model.Producto;
import hoodies_district_web.repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Servicio encargado de la lógica de negocio
 * relacionada con los productos.
 */
@Service
public class ProductoService {

    private final ProductoRepository productoRepository;

    /**
     * Constructor del servicio.
     *
     * @param productoRepository repositorio de productos
     */
    public ProductoService(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    /**
     * Obtiene todos los productos registrados.
     *
     * @return lista de productos
     */
    public List<Producto> listarProductos() {
        return productoRepository.findAll();
    }

    /**
     * Guarda un producto en la base de datos.
     *
     * @param producto producto que se desea guardar
     * @return producto guardado
     */
    public Producto guardarProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    /**
     * Busca un producto por su identificador.
     *
     * @param id identificador del producto
     * @return producto encontrado, si existe
     */
    public Optional<Producto> obtenerProducto(Long id) {
        return productoRepository.findById(id);
    }

    /**
     * Elimina un producto por su identificador.
     *
     * @param id identificador del producto
     */
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}