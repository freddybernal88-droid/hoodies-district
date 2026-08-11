package hoodies_district_web.repository;

import hoodies_district_web.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Repositorio encargado de realizar las operaciones
 * de acceso a datos para la entidad Producto.
 */
public interface ProductoRepository extends JpaRepository<Producto, Long> {

}