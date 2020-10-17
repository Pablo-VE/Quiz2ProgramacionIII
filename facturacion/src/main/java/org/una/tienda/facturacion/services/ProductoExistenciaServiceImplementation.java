/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tienda.facturacion.services;

import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;
import org.una.tienda.facturacion.dto.ProductoExistenciaDTO;

/**
 *
 * @author Jeffry
 */
public class ProductoExistenciaServiceImplementation implements IProductoExistenciaService{

    @Override
    @Transactional(readOnly = true)
    public Optional<ProductoExistenciaDTO> findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public ProductoExistenciaDTO create(ProductoExistenciaDTO productoExistencia) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    @Transactional
    public Optional<ProductoExistenciaDTO> update(ProductoExistenciaDTO productoExistencia, Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
