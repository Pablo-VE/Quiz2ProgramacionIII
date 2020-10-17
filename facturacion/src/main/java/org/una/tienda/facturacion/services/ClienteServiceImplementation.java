/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tienda.facturacion.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.una.tienda.facturacion.dto.ClienteDTO;
import org.una.tienda.facturacion.entities.Cliente;
import org.una.tienda.facturacion.repositories.IClienteRepository;
import org.una.tienda.facturacion.utils.MapperUtils;

/**
 *
 * @author Luis
 */
@Service
public class ClienteServiceImplementation implements IClienteService{

    @Autowired
    private IClienteRepository clienteRepository;
        
    private Optional<ClienteDTO> oneToDto(Optional<Cliente> one) {
        if (one.isPresent()) {
            ClienteDTO ProductoDTO = MapperUtils.DtoFromEntity(one.get(),   ClienteDTO.class);
            return Optional.ofNullable(ProductoDTO);
        } else {
            return null;
        }
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<ClienteDTO> findById(Long id) {
        return oneToDto(clienteRepository.findById(id));

    }

    @Override
    @Transactional
    public ClienteDTO create(ClienteDTO ClienteDTO) {
        Cliente cliente = MapperUtils.EntityFromDto(ClienteDTO, Cliente.class);
        cliente = clienteRepository.save(cliente);
        return MapperUtils.DtoFromEntity(cliente, ClienteDTO.class);
    }

   @Override
    @Transactional
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }

    @Override
    public Optional<ClienteDTO> update(ClienteDTO cliente, Long id) {
        if(clienteRepository.findById(id).isPresent()){
            Cliente entidad = MapperUtils.EntityFromDto(cliente, Cliente.class);
            entidad = clienteRepository.save(entidad);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(entidad, ClienteDTO.class));
        }else{
            return null;
        }
    }


    
}
