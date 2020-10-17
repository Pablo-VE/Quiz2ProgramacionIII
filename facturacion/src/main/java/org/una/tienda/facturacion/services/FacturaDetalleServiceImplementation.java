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
import org.una.tienda.facturacion.dto.FacturaDetalleDTO;
import org.una.tienda.facturacion.entities.FacturaDetalle;
import org.una.tienda.facturacion.repositories.IFacturaDetalleRepository;
import org.una.tienda.facturacion.utils.MapperUtils;

/**
 *
 * @author Luis
 */
@Service
public class FacturaDetalleServiceImplementation implements IFacturaDetalleService{

    @Autowired
    private IFacturaDetalleRepository facturaDetalleRepository;
      
    private Optional<FacturaDetalleDTO> oneToDto(Optional<FacturaDetalle> one) {
        if (one.isPresent()) {
            FacturaDetalleDTO FacturaDetalleDTO = MapperUtils.DtoFromEntity(one.get(),   FacturaDetalleDTO.class);
            return Optional.ofNullable(FacturaDetalleDTO);
        } else {
            return null;
        }
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<FacturaDetalleDTO> findById(Long id) {
        return oneToDto(facturaDetalleRepository.findById(id));

    }

    @Override
    @Transactional
    public FacturaDetalleDTO create(FacturaDetalleDTO FacturaDetalleDTO) {
        FacturaDetalle FacturaDetalle = MapperUtils.EntityFromDto(FacturaDetalleDTO, FacturaDetalle.class);
        FacturaDetalle = facturaDetalleRepository.save(FacturaDetalle);
        return MapperUtils.DtoFromEntity(FacturaDetalle, FacturaDetalleDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        facturaDetalleRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Optional<FacturaDetalleDTO> update(FacturaDetalleDTO facturaDetalle, Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
