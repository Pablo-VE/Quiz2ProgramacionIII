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
import org.una.tienda.facturacion.dto.ProductoExistenciaDTO;

/**
 *
 * @author Luis
 */
@SpringBootTest
public class ProductoExistenciaServiceImplementationTests {

    @Autowired
    private IProductoExistenciaService productoExistenciaService;

    ProductoExistenciaDTO productoExistenciaEjemplo;

    @BeforeEach
    public void setup() {
        productoExistenciaEjemplo = new ProductoExistenciaDTO() {
            {
                setCantidad(10);
            }
        };
    }

    @Test
    public void sePuedeCrearUnProductoExistenciaCorrectamente() {
 
        productoExistenciaEjemplo = productoExistenciaService.create(productoExistenciaEjemplo);

        Optional<ProductoExistenciaDTO> productoExistenciaEncontrado = productoExistenciaService.findById(productoExistenciaEjemplo.getId());

        if (productoExistenciaEncontrado.isPresent()) {
            ProductoExistenciaDTO productoExistencia = productoExistenciaEncontrado.get();
            assertEquals(productoExistenciaEjemplo.getId(), productoExistencia.getId());

        } else {
            fail("No se encontro la información en la BD");
        } 
    }
    @Test
    public void sePuedeModificarUnProductoCorrectamente() {
        productoExistenciaEjemplo = productoExistenciaService.create(productoExistenciaEjemplo);
        
        Optional<ProductoExistenciaDTO>productoExistenciaEncontrado = productoExistenciaService.findById(productoExistenciaEjemplo.getId());
        
        productoExistenciaService.update(productoExistenciaEjemplo, productoExistenciaEjemplo.getId());
        
        
        
        if (productoExistenciaEncontrado.isPresent()) {
            ProductoExistenciaDTO productoExistencia = productoExistenciaEncontrado.get();
            assertEquals(productoExistenciaEjemplo.getId(), productoExistencia.getId());
        } else {
            fail("No se encontro la información en la BD");
        } 
    }
    @Test
    public void sePuedeEliminarUnProductoCorrectamente() {
        productoExistenciaEjemplo = productoExistenciaService.create(productoExistenciaEjemplo);
        
        Optional<ProductoExistenciaDTO>productoEncontrado = productoExistenciaService.delete(productoExistenciaEjemplo.getId());
        
        if (productoEncontrado.isPresent()) {
            ProductoExistenciaDTO producto = productoEncontrado.get();
            assertEquals(productoExistenciaEjemplo.getId(), producto.getId());
        }else{
            fail("No se ha eliminado");
        }
        
    }
    @AfterEach
    public void tearDown() {
        if (productoExistenciaEjemplo != null) {
            productoExistenciaService.delete(productoExistenciaEjemplo.getId());
            productoExistenciaEjemplo = null;
        }

    }

}
