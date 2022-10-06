package com.empresa.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "empresa")
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_empresa", nullable = false)
    private Long idEmpresa;

    @Column(name = "nombre_empresa")
    private String nombreEmpresa;

    @Column(name = "direccion_empresa")
    private String direccionEmpresa;

    @Column(name = "telefono_empresa")
    private String telefonoEmpresa;

}
