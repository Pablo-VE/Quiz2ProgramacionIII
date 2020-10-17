/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tienda.facturacion.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.una.tienda.facturacion.dto.ProductoPrecioDTO;
import org.una.tienda.facturacion.entities.ProductoPrecio;
import org.una.tienda.facturacion.repositories.IProductoPrecioRepository;
import org.una.tienda.facturacion.utils.MapperUtils;

/**
 *
 * @author Jeffry
 */
public class ProductoPrecioServiceImplementation implements IProductoPrecioService{

    @Autowired
    private IProductoPrecioRepository productoPrecioRepository;
      
   private Optional<ProductoPrecioDTO> oneToDto(Optional<ProductoPrecio> one) {
        if (one.isPresent()) {
            ProductoPrecioDTO ProductoPrecioDTO = MapperUtils.DtoFromEntity(one.get(),   ProductoPrecioDTO.class);
            return Optional.ofNullable(ProductoPrecioDTO);
        } else {
            return null;
        }
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<ProductoPrecioDTO> findById(Long id) {
        return oneToDto(productoPrecioRepository.findById(id));

    }

    @Override
    @Transactional
    public ProductoPrecioDTO create(ProductoPrecioDTO ProductoPrecioDTO) {
        ProductoPrecio productoPrecio = MapperUtils.EntityFromDto(ProductoPrecioDTO, ProductoPrecio.class);
        productoPrecio = productoPrecioRepository.save(productoPrecio);
        return MapperUtils.DtoFromEntity(productoPrecio, ProductoPrecioDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        productoPrecioRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Optional<ProductoPrecioDTO> update(ProductoPrecioDTO productoPrecio, Long id) {
        if(productoPrecioRepository.findById(id).isPresent()){
            ProductoPrecio entidad = MapperUtils.EntityFromDto(productoPrecio, ProductoPrecio.class);
            entidad = productoPrecioRepository.save(entidad);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(entidad, ProductoPrecioDTO.class));
        }else{
            return null;
        }
    }
    
}
