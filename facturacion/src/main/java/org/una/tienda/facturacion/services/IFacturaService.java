/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tienda.facturacion.services;
import java.util.Optional;
import org.una.tienda.facturacion.entities.Factura;
/**
 *
 * @author Jeffry
 */
public interface IFacturaService {
    public Optional<Factura> findById(Long id);

    public Factura create(Factura factura);

    public Optional<Factura> update(Factura factura, Long id);
}
