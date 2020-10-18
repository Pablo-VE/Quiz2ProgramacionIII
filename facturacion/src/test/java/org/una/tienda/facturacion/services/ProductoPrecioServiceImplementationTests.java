/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tienda.facturacion.services;

import java.util.Optional;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.una.tienda.facturacion.dto.ProductoPrecioDTO;

/**
 *
 * @author Luis
 */
@SpringBootTest
public class ProductoPrecioServiceImplementationTests {

    @Autowired
    private IProductoPrecioService productoPrecioService;

    ProductoPrecioDTO productoPrecioEjemplo;

    @BeforeEach
    public void setup() {
        productoPrecioEjemplo = new ProductoPrecioDTO() {
            {
                setDescuentoMaximo(1);
                setDescuentoPromocional(0.2);
                setPrecioColones(10);
            }
        };
    }

    @Test
    public void sePuedeCrearUnProductoPrecioCorrectamente() {
 
        productoPrecioEjemplo = productoPrecioService.create(productoPrecioEjemplo);

        Optional<ProductoPrecioDTO> productoPrecioEncontrado = productoPrecioService.findById(productoPrecioEjemplo.getId());

        if (productoPrecioEncontrado.isPresent()) {
            ProductoPrecioDTO productoPrecio = productoPrecioEncontrado.get();
            assertEquals(productoPrecioEjemplo.getId(), productoPrecio.getId());

        } else {
            fail("No se encontro la información en la BD");
        } 
    }
    
    @Test
    public void sePuedeModificarUnProductoPrecioCorrectamente() {
        productoPrecioEjemplo = productoPrecioService.create(productoPrecioEjemplo);
        
        Optional<ProductoPrecioDTO>productoEncontrado = productoPrecioService.findById(productoPrecioEjemplo.getId());
        
        productoPrecioService.update(productoPrecioEjemplo, productoPrecioEjemplo.getId());
        
        
        
        if (productoEncontrado.isPresent()) {
            ProductoPrecioDTO productoPrecio = productoEncontrado.get();
            assertEquals(productoPrecioEjemplo.getId(), productoPrecio.getId());
        } else {
            fail("No se encontro la información en la BD");
        } 
    }
    @Test
    public void sePuedeEliminarUnProductoPrecioCorrectamente() {
        productoPrecioEjemplo = productoPrecioService.create(productoPrecioEjemplo);
        
        Optional<ProductoPrecioDTO>productoEncontrado = productoPrecioService.delete(productoPrecioEjemplo.getId());
        
        if (productoEncontrado.isPresent()) {
            ProductoPrecioDTO producto = productoEncontrado.get();
            assertEquals(productoPrecioEjemplo.getId(), producto.getId());
        }else{
            fail("No se ha eliminado");
        }
        
    }
    @AfterEach
    public void tearDown() {
        if (productoPrecioEjemplo != null) {
            productoPrecioService.delete(productoPrecioEjemplo.getId());
            productoPrecioEjemplo = null;
        }

    }

}
