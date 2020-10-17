/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tienda.facturacion.services;
import java.util.Optional;
import org.una.tienda.facturacion.entities.ProductoExistencia;
/**
 *
 * @author Jeffry
 */
public interface IProductoExistenciaService {
    public Optional<ProductoExistencia> findById(Long id);

    public ProductoExistencia create(ProductoExistencia ProductoExistencia);

    public Optional<ProductoExistencia> update(ProductoExistencia productoExistencia, Long id);
}
