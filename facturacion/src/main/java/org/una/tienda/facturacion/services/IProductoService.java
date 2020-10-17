/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tienda.facturacion.services;
import java.util.Optional;
import org.una.tienda.facturacion.entities.Producto;
/**
 *
 * @author Jeffry
 */
public interface IProductoService {
    public Optional<Producto> findById(Long id);

    public Producto create(Producto cliente);

    public Optional<Producto> update(Producto producto, Long id);
}
