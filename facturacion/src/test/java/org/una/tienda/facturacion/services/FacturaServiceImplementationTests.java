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
import org.una.tienda.facturacion.dto.FacturaDTO;

/**
 *
 * @author Luis
 */

@SpringBootTest
public class FacturaServiceImplementationTests {
    
    @Autowired
    private IFacturaService facturaService;

    FacturaDTO facturaEjemplo;

    @BeforeEach
    public void setup() {
        facturaEjemplo = new FacturaDTO() {
            {
                setCaja(5);
                setDescuentoGeneral(10);
            }
        };
    }

    @Test
    public void sePuedeCrearUnaFacturaCorrectamente() {
 
        facturaEjemplo = facturaService.create(facturaEjemplo);

        Optional<FacturaDTO> productoEncontrado = facturaService.findById(facturaEjemplo.getId());

        if (productoEncontrado.isPresent()) {
            FacturaDTO factura = productoEncontrado.get();
            assertEquals(facturaEjemplo.getId(), factura.getId());

        } else {
            fail("No se encontro la información en la BD");
        } 
    }
    @Test
    public void sePuedeModificarUnaFacturaCorrectamente() {
        facturaEjemplo = facturaService.create(facturaEjemplo);
        
        Optional<FacturaDTO>productoEncontrado = facturaService.findById(facturaEjemplo.getId());
        
        facturaService.update(facturaEjemplo, facturaEjemplo.getId());
        
        
        
        if (productoEncontrado.isPresent()) {
            FacturaDTO factura = productoEncontrado.get();
            assertEquals(facturaEjemplo.getId(), factura.getId());
        } else {
            fail("No se encontro la información en la BD");
        } 
    }
    @Test
    public void sePuedeEliminarUnaFacturaCorrectamente() {
        facturaEjemplo = facturaService.create(facturaEjemplo);
        
        Optional<FacturaDTO>facturaEncontrado = facturaService.delete(facturaEjemplo.getId());
        
        if (facturaEncontrado.isPresent()) {
            FacturaDTO factura = facturaEncontrado.get();
            assertEquals(facturaEjemplo.getId(), factura.getId());
        }else{
            fail("No se ha eliminado");
        }
        
    }
    @AfterEach
    public void tearDown() {
        if (facturaEjemplo != null) {
            facturaService.delete(facturaEjemplo.getId());
            facturaEjemplo = null;
        }

    }

}
