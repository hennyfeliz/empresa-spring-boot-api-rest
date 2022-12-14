package com.empresa.Models;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="empleados")
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_empleado", nullable = false)
    private Long id;
    private String puesto;

    @Column(name = "nombre_empleado")
    private String nombreEmpleado;

    @Column(name = "telefono_empleado")
    private String telefonoEmpleado;

    @Column(name = "direccion_empleado")
    private String direccionEmpleado;

    //@JoinColumn(name = "id_empresa")
    @Column(name = "id_empresa")
    private Long empresa;


}
