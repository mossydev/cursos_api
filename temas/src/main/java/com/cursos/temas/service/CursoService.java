/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cursos.temas.service;

import com.cursos.temas.model.Curso;
import com.cursos.temas.repository.ICursoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author moss_
 */
@Service
public class CursoService implements ICursoService{
    @Autowired
    private ICursoRepository repoCurso;
    
    //Aquí se invocan las operaciones CRUD
    //traer
    @Override
    public List<Curso> getCursos() {
        List<Curso>listaCursos= repoCurso.findAll();//accede a la BD 
        
        return listaCursos;
    }
    //crear
    @Override
    public void saveCurso(Curso curse) {
        repoCurso.save(curse);
    }
    //borrar
    @Override
    public void deleteCurso(Long id) {
        repoCurso.deleteById(id);
    }
    //traer uno
    @Override
    public Curso findCurso(Long id) {
        Curso curse = repoCurso.findById(id).orElse(null);
        
        return curse;
    }      
    //traer todos los cursos que contengan la palabra JAVA
    @Override
    public List<Curso> getCursosJava() {
        List<Curso>listaCursos = repoCurso.findAll();//accede a la BD para obtener todos los cursos
        List<Curso>listaCursosJava = new ArrayList<>(); 
        
        String nombre;
        
        for(Curso curse : listaCursos){
            nombre = curse.getNombre();
            if(nombre.contains("Java")){
                listaCursosJava.add(curse);
            }
        }
        return listaCursosJava;
    }
    //modificar
    @Override
    public void editCurso(Long id_original, Long idNueva, String nuevoNombre, String nuevaModalidad, int nuevaFecha_Final) {
        Curso curse = this.findCurso(id_original);
        
        //proceso de modificación a nivel lógico
        curse.setId_curso(idNueva);
        curse.setNombre(nuevoNombre);
        curse.setModalidad(nuevaModalidad);
        curse.setFecha_finalizacion(nuevaModalidad);
       
        this.saveCurso(curse);
    }
    
    @Override
    public void editCurso(Curso curse) {
        this.saveCurso(curse);
    }  
    
}
