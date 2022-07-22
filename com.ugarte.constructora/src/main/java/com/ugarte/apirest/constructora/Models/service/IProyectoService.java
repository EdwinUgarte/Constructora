package com.ugarte.apirest.constructora.Models.service;

import java.util.List;

import com.ugarte.apirest.constructora.Models.entity.Proyecto;

public interface IProyectoService {
    
    public List<Proyecto> findAll();
    public Proyecto findById(Long id);
    public Proyecto save(Proyecto proyecto);
    public void delete(Long id);
}
