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
import org.una.tienda.facturacion.dto.FacturaDetalleDTO;

/**
 *
 * @author Luis
 */

@SpringBootTest
public class FacturaDetalleServiceImplementationTests {

    @Autowired
    private IFacturaDetalleService facturaDetalleService;

    FacturaDetalleDTO facturaDetalleEjemplo;

    @BeforeEach
    public void setup() {
        facturaDetalleEjemplo = new FacturaDetalleDTO() {
            {
                setCantidad(5);
                setDescuentoFinal(1);
            }
        };
    }

    @Test
    public void sePuedeCrearUnaFacturaDetalleCorrectamente() {
 
        facturaDetalleEjemplo = facturaDetalleService.create(facturaDetalleEjemplo);

        Optional<FacturaDetalleDTO> facturaDetalleEncontrado = facturaDetalleService.findById(facturaDetalleEjemplo.getId());

        if (facturaDetalleEncontrado.isPresent()) {
            FacturaDetalleDTO facturaDetalle = facturaDetalleEncontrado.get();
            assertEquals(facturaDetalleEjemplo.getId(), facturaDetalle.getId());

        } else {
            fail("No se encontro la información en la BD");
        } 
    }
    
    
    @Test
    public void sePuedeModificarUnaFacturaDetalleCorrectamente() {
        facturaDetalleEjemplo = facturaDetalleService.create(facturaDetalleEjemplo);
        
        Optional<FacturaDetalleDTO>productoEncontrado = facturaDetalleService.findById(facturaDetalleEjemplo.getId());
        
        facturaDetalleService.update(facturaDetalleEjemplo, facturaDetalleEjemplo.getId());
        
        
        
        if (productoEncontrado.isPresent()) {
            FacturaDetalleDTO facturaDetalle = productoEncontrado.get();
            assertEquals(facturaDetalleEjemplo.getId(), facturaDetalle.getId());
        } else {
            fail("No se encontro la información en la BD");
        } 
    }
    
    
    @Test
    public void sePuedeEliminarUnaFacturaDetalleCorrectamente() {
        facturaDetalleEjemplo = facturaDetalleService.create(facturaDetalleEjemplo);
        
        Optional<FacturaDetalleDTO>facturaDetalleEncontrado = facturaDetalleService.delete(facturaDetalleEjemplo.getId());
        
        if (facturaDetalleEncontrado.isPresent()) {
            FacturaDetalleDTO facturaDetalle = facturaDetalleEncontrado.get();
            assertEquals(facturaDetalleEjemplo.getId(), facturaDetalle.getId());
        }else{
            fail("No se ha eliminado");
        }
        
    }
    
    
    @AfterEach
    public void tearDown() {
        if (facturaDetalleEjemplo != null) {
            facturaDetalleService.delete(facturaDetalleEjemplo.getId());
            facturaDetalleEjemplo = null;
        }

    }

}
