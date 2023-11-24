/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cursos.temas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author moss_
 */
@Getter @Setter
@Entity
public class Tema {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id_tema;
    private String nombre;
    private String descripcion;
    @ManyToOne
    @JoinColumn(name="un_curso_id_curso")//donde este JoinColumn esta la foreing key
    @JsonIgnore
    private Curso unCurso;

    public Tema() {
    }

    public Tema(Long id_tema, String nombre, String descripcion) {
        this.id_tema = id_tema;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }    
     
}
