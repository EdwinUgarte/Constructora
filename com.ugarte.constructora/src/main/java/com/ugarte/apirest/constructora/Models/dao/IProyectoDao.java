package com.ugarte.apirest.constructora.Models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ugarte.apirest.constructora.Models.entity.Proyecto;

public interface IProyectoDao extends CrudRepository<Proyecto, Long>{
    
}
