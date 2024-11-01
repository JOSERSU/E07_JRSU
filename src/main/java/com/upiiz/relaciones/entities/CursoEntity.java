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
public class CursoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;

    //un curso tiene muchos estudiantes
    //@ManyToMany(targetEntity = EstudianteEntity.class, fetch = FetchType.LAZY)
    //private List<EstudianteEntity> estudiantes;

    //un curso tiene muchas lecciones
    @OneToMany(targetEntity = LeccionEntity.class, fetch = FetchType.LAZY, mappedBy = "curso")
    private List<LeccionEntity> lecciones;
}
