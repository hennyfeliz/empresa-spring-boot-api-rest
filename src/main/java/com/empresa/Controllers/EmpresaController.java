package com.empresa.Controllers;

import com.empresa.Exceptions.ResourceNotFoundException;
import com.empresa.Models.Empleado;
import com.empresa.Models.Empresa;
import com.empresa.Repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {

    @Autowired
    EmpresaRepository empresaRepository;

    @GetMapping("/")
    public List<Empresa> getAllEmpresas(){
        return empresaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Empresa getOneEmpresa(@PathVariable(value = "id_empresa") Long id){
        return empresaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Empresa", "id_empresa",id));
    }

    @PostMapping("/")
    public HttpStatus createEmpresa(@Valid @RequestBody Empresa empresa){
        empresaRepository.save(empresa);
        return HttpStatus.ACCEPTED;
    }

    @PutMapping("/{id}")
    public HttpStatus updateEmpresa(@PathVariable(value = "id_empresa") Long id,
                                    @Valid @RequestBody Empresa empresaDetails){
        Empresa empresa = empresaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Empresa", "id_empresa", id));

        empresa.setIdEmpresa(empresaDetails.getIdEmpresa());
        empresa.setNombreEmpresa(empresaDetails.getNombreEmpresa());
        empresa.setDireccionEmpresa(empresaDetails.getDireccionEmpresa());
        empresa.setTelefonoEmpresa(empresaDetails.getTelefonoEmpresa());
        empresaRepository.save(empresa);

        return HttpStatus.ACCEPTED;
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleteEmpresa(@PathVariable(value = "id_empresa") Long id){
        Empresa empresa = empresaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Empresa", "id_empresa",id));

        empresaRepository.delete(empresa);
        return HttpStatus.ACCEPTED;
    }

}
