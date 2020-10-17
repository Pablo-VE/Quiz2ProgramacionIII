/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tienda.facturacion.services;

import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;
import org.una.tienda.facturacion.entities.ProductoPrecio;

/**
 *
 * @author Jeffry
 */
public class ProductoPrecioServiceImplementation implements IProductoPrecioService{

    @Override
    @Transactional(readOnly = true)
    public Optional<ProductoPrecio> findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public ProductoPrecio create(ProductoPrecio productoPrecio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public Optional<ProductoPrecio> update(ProductoPrecio productoPrecio, Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
