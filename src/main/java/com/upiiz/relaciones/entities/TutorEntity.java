package com.upiiz.relaciones.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class TutorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String correo;
    private String escolaridad;

    //Un tutor tiene muchos estudiantes

    @OneToMany(targetEntity = EstudianteEntity.class, fetch = FetchType.LAZY, mappedBy = "tutor")
    private List<EstudianteEntity> estudiantes;

}
