/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cursos.temas.dto;

import com.cursos.temas.model.Curso;
import com.cursos.temas.model.Tema;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author moss_
 */
@Getter @Setter
public class CursoDTO {
    private Long id_curso;
    private String nombreCurso;
    private List<Tema> listaTemas;   //se guarda aquí la lista de temas extraido de curso en el endpoint 

    public CursoDTO() {
    }

    public CursoDTO(Long id_curso, String nombreCurso, List<Tema> listaTemas) {
        this.id_curso = id_curso;
        this.nombreCurso = nombreCurso;
        this.listaTemas = listaTemas;
    }   
}
