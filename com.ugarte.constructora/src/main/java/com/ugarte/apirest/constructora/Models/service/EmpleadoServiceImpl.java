package com.ugarte.apirest.constructora.Models.service;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ugarte.apirest.constructora.Models.dao.IEmpleadoDao;
import com.ugarte.apirest.constructora.Models.entity.Empleado;



@Service
public class EmpleadoServiceImpl implements IEmpleadoService {

    @Autowired
    private IEmpleadoDao empleadoDao; 
   

    @Override
    @Transactional(readOnly = true)
    public List<Empleado> findAll() {
        return (List<Empleado>) empleadoDao.findAll();
    }


    @Override
    @Transactional
    public Empleado save(Empleado empleado) {
        return empleadoDao.save(empleado);
    }


    @Override
    @Transactional(readOnly = true)
    public Empleado finById(Long id) {
    return  empleadoDao.findById(id).orElse(null);
    }


    @Override
    @Transactional
    public void delete(Long id) {
       empleadoDao.deleteById(id);
        
    }


}
