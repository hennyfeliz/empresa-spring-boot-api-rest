package com.empresa.Models;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
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

    @JoinColumn(name = "id_empresa")
    private Empresa empresa;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Empleado empleado = (Empleado) o;
        return id != null && Objects.equals(id, empleado.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
