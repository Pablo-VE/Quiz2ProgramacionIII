/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tienda.facturacion.services;
import java.util.Optional;
import org.una.tienda.facturacion.entities.FacturaDetalle;
/**
 *
 * @author Jeffry
 */
public interface IFacturaDetalleService {
    public Optional<FacturaDetalle> findById(Long id);

    public FacturaDetalle create(FacturaDetalle facturaDetalle);

    public Optional<FacturaDetalle> update(FacturaDetalle facturaDetalle, Long id);
}
