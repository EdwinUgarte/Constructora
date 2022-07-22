package com.ugarte.apirest.constructora.Models.service;

import java.util.List;

import com.ugarte.apirest.constructora.Models.entity.Empleado;

public interface IEmpleadoService {

    public List<Empleado> findAll();
    public Empleado finById(Long id);
    public Empleado save(Empleado empleado);
    public void delete(Long id);
    
}
