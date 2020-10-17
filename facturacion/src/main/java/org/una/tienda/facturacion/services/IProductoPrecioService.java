/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tienda.facturacion.services;
import java.util.Optional;
import org.una.tienda.facturacion.dto.ProductoPrecioDTO;
/**
 *
 * @author Jeffry
 */
public interface IProductoPrecioService {
    public Optional<ProductoPrecioDTO> findById(Long id);

    public ProductoPrecioDTO create(ProductoPrecioDTO productoPrecio);

    public Optional<ProductoPrecioDTO> update(ProductoPrecioDTO productoPrecio, Long id);
}
