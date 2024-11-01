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
public class EstudianteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "VARCHAR(50)")
    private String nombre;

    private String correo;
    private String matricula;

    //Un estudiante tiene un perfil
    //Traer la llave foranea
    @OneToOne(targetEntity = PerfilEntity.class)
    private PerfilEntity perfil;

    //Muchos estudiantes  estudiante tiene un tutor
    @ManyToOne(targetEntity = TutorEntity.class)
    private TutorEntity tutor;

    //Un estudiante tiene muchos cursos
    @ManyToMany(targetEntity = CursoEntity.class, fetch = FetchType.LAZY)
    private List<CursoEntity> cursos;
}
