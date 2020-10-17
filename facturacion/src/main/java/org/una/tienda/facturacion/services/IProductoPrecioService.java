/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tienda.facturacion.services;
import java.util.Optional;
import org.una.tienda.facturacion.entities.ProductoPrecio;
/**
 *
 * @author Jeffry
 */
public interface IProductoPrecioService {
    public Optional<ProductoPrecio> findById(Long id);

    public ProductoPrecio create(ProductoPrecio productoPrecio);

    public Optional<ProductoPrecio> update(ProductoPrecio productoPrecio, Long id);
}
