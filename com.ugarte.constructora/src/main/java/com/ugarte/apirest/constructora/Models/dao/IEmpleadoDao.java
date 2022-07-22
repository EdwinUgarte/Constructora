package com.ugarte.apirest.constructora.Models.dao;

import org.springframework.data.repository.CrudRepository;

import com.ugarte.apirest.constructora.Models.entity.Empleado;


public interface IEmpleadoDao extends CrudRepository<Empleado, Long>{
    
}
