/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tienda.facturacion.services;
import java.util.Optional;
import org.una.tienda.facturacion.entities.Cliente;
/**
 *
 * @author Jeffry
 */
public interface IClienteService {

    public Optional<Cliente> findById(Long id);

    public Cliente create(Cliente cliente);

    public Optional<Cliente> update(Cliente cliente, Long id);

}
