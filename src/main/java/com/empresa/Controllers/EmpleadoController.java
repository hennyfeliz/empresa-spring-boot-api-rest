package com.empresa.Controllers;

import com.empresa.Exceptions.ResourceNotFoundException;
import com.empresa.Models.Empleado;
import com.empresa.Repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

    @Autowired
    EmpleadoRepository empleadoRepository;

    @GetMapping("/")
    public List<Empleado> getAllEmpleados(){
        return empleadoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Empleado getOneEmpleado(@PathVariable(value = "id_empleado") Long id){
        return empleadoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Empleado", "id_empleado", id));
    }

    @PostMapping("/")
    public HttpStatus createEmpleado(@Valid @RequestBody Empleado empleado){
        empleadoRepository.save(empleado);
        return HttpStatus.ACCEPTED;
    }

    @PutMapping("/{id}")
    public HttpStatus updateEmpleado(@PathVariable(value = "id_empleado") Long id,
                                @Valid @RequestBody Empleado empleadoDetails){

        Empleado empleado = empleadoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Empleado", "id_empleado", id));

        empleado.setId(empleadoDetails.getId());
        empleado.setPuesto(empleadoDetails.getPuesto());
        empleado.setNombreEmpleado(empleadoDetails.getNombreEmpleado());
        empleado.setDireccionEmpleado(empleadoDetails.getDireccionEmpleado());
        empleado.setEmpresa(empleadoDetails.getEmpresa());
        empleado.setTelefonoEmpleado(empleadoDetails.getTelefonoEmpleado());
        empleadoRepository.save(empleado);
        return HttpStatus.OK;
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteEmpleado(@PathVariable(value = "id_empleado") Long id){
        Empleado empleado = empleadoRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Empleado", "id_empleado", id));

        empleadoRepository.delete(empleado);
        return HttpStatus.ACCEPTED;
    }

}
