package com.hoodiesdistrict.repository;

import com.hoodiesdistrict.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

}