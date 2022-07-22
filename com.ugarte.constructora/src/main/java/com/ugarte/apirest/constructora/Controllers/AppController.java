package com.ugarte.apirest.constructora.Controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ugarte.apirest.constructora.Models.entity.Empleado;
import com.ugarte.apirest.constructora.Models.entity.Proyecto;
import com.ugarte.apirest.constructora.Models.service.IEmpleadoService;
import com.ugarte.apirest.constructora.Models.service.IProyectoService;


@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class AppController {
    
    @Autowired
    private IEmpleadoService empleadoService;

    @Autowired
    private IProyectoService proyectoService;


    /* Controller EMPLEADOS */

    @GetMapping("/empleados")
    public List<Empleado> findAllEmpleados(){
        return empleadoService.findAll();
    }

    @GetMapping("/empleados/{id}")
    public Empleado findByIdEmpleado(@PathVariable Long id){
        return empleadoService.finById(id);
    }

    @PostMapping("/empleados")
    public Empleado createEmpleado(@RequestBody Empleado empleado){
        return empleadoService.save(empleado);
    }

    @PutMapping("/empleados/{id}")
    public Empleado updateEmpleado(@RequestBody Empleado empleado, @PathVariable Long id){
        Empleado empleadoActual = empleadoService.finById(id);
        Empleado empleadoUpdate = null;

        empleadoActual.setNombre(empleado.getNombre());
        empleadoActual.setApellido(empleado.getApellido());
        empleadoActual.setTelefono(empleado.getTelefono());
        empleadoActual.setColonia(empleado.getColonia());
        empleadoActual.setPuesto(empleado.getPuesto());

        empleadoUpdate = empleadoService.save(empleadoActual);
        
        return empleadoUpdate;
       
    }

    @DeleteMapping("/empleados/{id}")
    public void deleteEmpleado(@PathVariable Long id){
       empleadoService.delete(id);
    }


    /* Controller PROYECTOS */

    @GetMapping("/proyectos")
    public List<Proyecto> findAllProyectos(){
        return proyectoService.findAll();
    }

    @GetMapping("/proyectos/{id}")
    public Proyecto findByIdProyecto(@PathVariable Long id){
        return proyectoService.findById(id);
    }

    @PostMapping("/proyectos")
    public Proyecto creatProyecto(@RequestBody Proyecto proyecto){
        return proyectoService.save(proyecto);
    }

    @PutMapping("/proyectos/{id}")
    public Proyecto updateProyecto(@RequestBody Proyecto proyecto, @PathVariable Long id){
        Proyecto proyectoActual = proyectoService.findById(id); 
        Proyecto proyectoUpdate = null;

        proyectoActual.setTitulo(proyecto.getTitulo());
        proyectoActual.setDescripcion(proyecto.getDescripcion());
        proyectoActual.setCosto(proyecto.getCosto());
        proyectoActual.setTelefono(proyecto.getTelefono());
        proyectoActual.setFechaInicio(proyecto.getFechaInicio());
        proyectoActual.setFechaFin(proyecto.getFechaFin());
        proyectoUpdate = proyectoService.save(proyectoActual);

        return proyectoUpdate;
    }

    @DeleteMapping("/proyectos/{id}")
    public void deleteProyecto(@PathVariable Long id){
        proyectoService.delete(id);
    }

}
