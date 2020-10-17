/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.una.tienda.facturacion.services;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.una.tienda.facturacion.dto.ProductoExistenciaDTO;
import org.una.tienda.facturacion.entities.ProductoExistencia;
import org.una.tienda.facturacion.repositories.IProductoExistenciaRepository;
import org.una.tienda.facturacion.utils.MapperUtils;

/**
 *
 * @author Jeffry
 */
public class ProductoExistenciaServiceImplementation implements IProductoExistenciaService{

    @Autowired
    private IProductoExistenciaRepository productoExistenciaRepository;
    
     private Optional<ProductoExistenciaDTO> oneToDto(Optional<ProductoExistencia> one) {
        if (one.isPresent()) {
            ProductoExistenciaDTO ProductoExistenciaDTO = MapperUtils.DtoFromEntity(one.get(), ProductoExistenciaDTO.class);
            return Optional.ofNullable(ProductoExistenciaDTO);
        } else {
            return null;
        }
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<ProductoExistenciaDTO> findById(Long id) {
        return oneToDto(productoExistenciaRepository.findById(id));
    }

    @Override
    @Transactional
    public ProductoExistenciaDTO create(ProductoExistenciaDTO ProductoExistenciaDTO) {
        ProductoExistencia productoExistencia = MapperUtils.EntityFromDto(ProductoExistenciaDTO, ProductoExistencia.class);
        productoExistencia = productoExistenciaRepository.save(productoExistencia);
        return MapperUtils.DtoFromEntity(productoExistencia, ProductoExistenciaDTO.class);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        productoExistenciaRepository.deleteById(id);
    }
    
    @Override
    @Transactional
    public Optional<ProductoExistenciaDTO> update(ProductoExistenciaDTO productoExistencia, Long id) {
        if(productoExistenciaRepository.findById(id).isPresent()){
            ProductoExistencia entidad = MapperUtils.EntityFromDto(productoExistencia, ProductoExistencia.class);
            entidad = productoExistenciaRepository.save(entidad);
            return Optional.ofNullable(MapperUtils.DtoFromEntity(entidad, ProductoExistenciaDTO.class));
        }else{
            return null;
        }
    }
}
