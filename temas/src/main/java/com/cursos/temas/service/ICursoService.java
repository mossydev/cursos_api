/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cursos.temas.service;

import com.cursos.temas.model.Curso;
import java.util.List;

/**
 *
 * @author moss_
 */
public interface ICursoService {
    public List<Curso>getCursos();
    //metodo para dar de alta una persona
    public void saveCurso(Curso curse);
    //metodo para borrar una persona
    public void deleteCurso(Long id);
    //metodo para encontrar una persona
    public Curso findCurso(Long id);
    //
    public List<Curso> getCursosJava();
    //metodo editar
    public void editCurso(Long id_original,Long idNueva,String nuevoNombre,String nuevaModalidad, int nuevaFecha_Final);
    //public void editCurso(Long id_original,Long idNueva,String nuevoNombre,String nuevoApellido, int nuevaEdad);
    public void editCurso(Curso curse);
}
