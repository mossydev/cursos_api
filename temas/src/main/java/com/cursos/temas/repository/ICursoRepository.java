/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.cursos.temas.repository;

import com.cursos.temas.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author moss_
 */
@Repository
public interface ICursoRepository extends JpaRepository <Curso,Long>{
    //Aquí se realizan las operaciones CRUD.
}
